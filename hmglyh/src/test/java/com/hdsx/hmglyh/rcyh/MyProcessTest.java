package com.hdsx.hmglyh.rcyh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.rcyh.dao.RcyhRwdjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhWxzyjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.service.BhService;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
/**@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@Transactional  **/ // 配置事物
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class MyProcessTest {
	
	private static Logger log = LoggerFactory.getLogger(MyProcessTest.class);
	
	@Autowired
	RepositoryService repositoryService;
	@Autowired
	RuntimeService runtimeService;
	@Autowired
	TaskService taskService;
	@Autowired
	ManagementService managementService;
	@Autowired
	BhService bhService;
	@Autowired
	WorkFlowService wfService;
	@Autowired
	RcyhRwdjlbMapper rwdMapper;
	@Autowired
	RcyhWxzyjlbMapper wxzyMapper;
	
	/**
	 *  根据病害编码 启动流程 并完成 “病害添加” 节点，“病害上报” 被分配给 病害记录人 的 所在 部门
	 */
	@Test
	public void bhlist(){
		RcyhBhjlb bh = new RcyhBhjlb();
		bh.setPage(1);
		bh.setRows(1000);
		List<RcyhBhjlb> bhList = bhService.listBh(bh);
	//	System.out.println(bhList);
		for( RcyhBhjlb b : bhList) {
			HashMap<String,Object> var = new HashMap<String,Object>();
			var.put("bmcode", b.getBmcode());
			// 启动流程 ,并完成流程第一步，记录病害
			wfService.startProcess(b.getBhjlid(), var); 
			wfService.completeTask(b.getBhjlid(), var);
		}
		
		for( RcyhBhjlb b : bhList){
			// 完成病害上报任务 (已上报，和 取消上报，未上报的不管)
			if((!"0".equals(b.getBhsbzt())) &&  StringUtils.isNotBlank(b.getSbbmcode())){
				HashMap<String,Object> bhMap = new HashMap<String,Object>();
				bhMap.put("bhjl",b);
				bhMap.put("bhsbzt", b.getBhsbzt());
				wfService.completeTask(b.getBhjlid(), bhMap);
			}
		}
		
		for( RcyhBhjlb b : bhList ) {
			// 完成 完成病害流程
			if( "1".equals(b.getPgzt()) || "3".equals(b.getPgzt())){ // 结束病害流程
				HashMap<String,Object> bhMap = new HashMap<String,Object>();
				bhMap.put("bhjl",b);
				bhMap.put("pgzt", b.getPgzt());
				wfService.completeTask(b.getBhjlid(), bhMap);
			}
			if("2".equals(b.getPgzt())) { // 延迟派工
				//TODO 延迟派工处理
			}
		}
	}
	
	
	// 启动任务单流程
	@Test
	public void rwdList(){
		RcyhRwdjlb rwd = new RcyhRwdjlb();
		rwd.setPage(1);
		rwd.setRows(1000);
		List<RcyhRwdjlb> list = rwdMapper.listRwdForYdjh(rwd);
		
		// 完成维修作业
		for( RcyhRwdjlb r : list ) {
			HashMap<String,Object> variable = new HashMap<String,Object>();
			variable.put("rwd", r);
			// 启动维修作业流程
			if("0902".equals(r.getRwdlx()) && "0".equals(r.getRwdzt())) {
				wfService.startProcess("wxProcess", r.getRwdid(), variable);
			}
		}
	
		
	}
	
	@Test
	public void wxzyList(){
		RcyhWxzyjlb wx = new RcyhWxzyjlb();
		wx.setPage(1);
		wx.setRows(1000);
		List<RcyhWxzyjlb> wxzyList = wxzyMapper.listWxzy(wx);
		// 启动流程
		for( RcyhWxzyjlb r : wxzyList ) {
			HashMap<String,Object> variable = new HashMap<String,Object>();
			RcyhRwdjlb rwd = new RcyhRwdjlb();
			rwd.setBmcode(r.getBmcode());
			variable.put("rwd", rwd);
			variable.put("wxzy", r);
			// 启动维修作业流程
			if( r.getRwdid() != null ) {
					/*String name = wfService.getTaskName(r.getRwdid());
					
					if( name == null ) {
						wfService.startProcess("wxProcess", r.getRwdid(), variable);
						wfService.completeTask(r.getRwdid(), variable); // 记录维修作业
						
						if("1".equals(r.getZysbzt())){
							wfService.completeTask(r.getRwdid(), variable); // 记录维修作业
						}
						
						if("2".equals(r.getZysbzt())){
							wfService.deleteProcessInstance(r.getRwdid());
						}
						
					}else{
						if("weixiuzuoye".equals(name) && "1".equals(r.getZysbzt())){
							wfService.completeTask(r.getRwdid(),variable);
						}
						
						if("2".equals(r.getZysbzt())){
							wfService.deleteProcessInstance(r.getRwdid());
						}
					}*/
					
					// 验收
					
					if("1".equals(r.getYszt())){
						HashMap<String,Object> map = new HashMap<String,Object>();
						map.put("zyyszt", "1");
						wfService.completeTask(r.getRwdid(),map);
					}
			}
			
		}
		// 完成作业上报任务
	/*	for(RcyhWxzyjlb wxzy : wxzyList){
			if("1".equals(wxzy.getZysbzt())){  //作业 已经上报了 继续往下走
				HashMap<String,Object> map = new HashMap<String,Object>();
				RcyhRwdjlb rwdjlb = new RcyhRwdjlb();
				rwdjlb.setBmcode(wxzy.getBmcode());
				map.put("wxzy", wxzy);
				wfService.completeTask(wxzy.getRwdid(),map);
			}
			
			if( "2".equals(wxzy.getZysbzt())) { // 取消上报 ， 删除 对应的流程
				wfService.deleteProcessInstance(wxzy.getRwdid());
			}
		}*/
		
		// 完成作业验收的任务
		/*		for(RcyhWxzyjlb wxzy : wxzyList){
			if("1".equals(wxzy.getYszt())){  //作业已经验收
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("wxzy", wxzy);
				map.put("zyyszt", "1");
				wfService.completeTask(wxzy.getRwdid(),map);
			}
		}*/
	}
	
	
	// 通过 业务键获取业务节点 
	@Test
	public void getTaskNameTest(){
		String name = wfService.getTaskName("RWDID1439955641872_51426");
		System.out.println(name);
	}
	
	// 配置文件方式
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		repositoryService.createDeployment()
		  .addClasspathResource("diagrams/VacationRequest.bpmn")
		  .deploy();

		log.info("流程定义数量: " + repositoryService.createProcessDefinitionQuery().count());
	}
	
	/**
	 * 测试 activity 资源的自动部署
	 */
	@Test
	public void autoDeployTest(){
		/*
		 * SpringAutoDeployment 
		 * 自动部署生成的 名称
		 * 
		 * 经过测试 可以证明 ， 除非 资源名称发生改变 ， 否则 多次重启 服务器 不会 重新 部署
		 * 
		 */
	}
	
	/**
	 * 查看 流程图 
	 */
	@Test
	public void getProcessPicTest(){
		
		 String procDefId = "richangyhProcess:3:135004";
		 ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery().processDefinitionId(procDefId).singleResult();  
         String diagramResourceName = procDef.getDiagramResourceName();  
         InputStream imageStream = repositoryService.getResourceAsStream(  
                 procDef.getDeploymentId(), diagramResourceName);  
         
         File file = new File("d:/process.png");
         try {
        	 FileOutputStream fos = new FileOutputStream(file);
        	
        	 
        	 byte [] buf = new byte[1000];
        	 int len;
        	 while( (len = imageStream.read(buf)) != -1 ){
        		 fos.write(buf,0,len);
        	 }
        	 fos.close();
        	 log.info("生成流程图成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 流程跟踪信息
	 */
	@Test
	public void getProcessMap(){
		
		 ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().latestVersion().singleResult();
		
		  ProcessDefinitionImpl pdImpl = (ProcessDefinitionImpl) processDefinition;  
          String processDefinitionId = pdImpl.getId();// 流程标识  

          ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)  
                  .getDeployedProcessDefinition(processDefinitionId); 
		 
		ExecutionEntity execution = (ExecutionEntity) runtimeService  
                .createExecutionQuery().processInstanceBusinessKey("BHID1435421931298_33597").singleResult();
		String activitiId = execution.getActivityId();// 当前实例的执行到哪个节点 
						
        List<ActivityImpl> activitiList = def.getActivities();// 获得当前任务的所有节点  
        ActivityImpl actImpl = null;  
        for (ActivityImpl activityImpl : activitiList) {  
	        String id = activityImpl.getId();  
	        if (id.equals(activitiId)) {// 获得执行到那个节点  
	            actImpl = activityImpl;  
	            break;  
	        }
        }
        System.out.println(actImpl);
    }  
	// spring 注入 方式 
	/**
	 * 发布一个流程 
	 */
	@Test
	public void DeployProessTest(){
		repositoryService.createDeployment()
		.addClasspathResource("activiti/Binghai3.bpmn")
		.deploy();
		log.info("流程定义部署成功");
	}
	
	/**
	 * 使用输入流 部署 流程定义
	 * @throws IOException 
	 */
	@Test
	public void deplayProcessByInputStream() {
		InputStream in;
		try {
			in = new FileInputStream(new File("D:/binghai3.zip"));
				ZipInputStream zipInputStream = new ZipInputStream(in);
				repositoryService.createDeployment().addZipInputStream(zipInputStream).deploy();
		    in.close();
		    log.info("流程定义数量: " + repositoryService.createProcessDefinitionQuery().count());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 查询流程定义
	 */
	@Test
	public void queryProcessDefinition(){
		ProcessDefinitionQuery pdq = repositoryService.createProcessDefinitionQuery();
		List<ProcessDefinition> list = pdq.list();
		log.info("流程定义数量：" + repositoryService.createProcessDefinitionQuery().count());
		int i = 0;
		for( ProcessDefinition p : list ) {
			log.info("\n");
			
			log.info("第" + (++i) + "个流程定义");
			log.info("流程定义ID：" + p.getId());
			log.info("流程定义Key：" + p.getKey());
			log.info("流程定义部署ID：" + p.getDeploymentId());
			log.info("流程定义资源名称：" + p.getDiagramResourceName());
			log.info("流程定义名称：" + p.getName());
			log.info("流程定义版本：" + p.getVersion());
			log.info("流程定义描述：" + p.getDescription());
		}
	}
	
	/**
	 * 删除所有的部署的流程定义
	 */
	@Test
	public void deleteProcessDefinition(){
		ProcessDefinitionQuery pdq = repositoryService.createProcessDefinitionQuery();
		List<ProcessDefinition> list = pdq.list();
		for( ProcessDefinition p : list ) {
			repositoryService.deleteDeployment(p.getDeploymentId());
			System.out.println("删除流程定义："+p.getDeploymentId()+"成功");
		}
	}
	
	/**
	 * 启动一个流程
	 */
	@Test
	public void startProcessTest(){
		/*repositoryService.createDeployment()
		.addClasspathResource("activity/binghai2.bpmn")
		.deploy();*/
		log.info("流程定义数量" + repositoryService.createProcessDefinitionQuery().count());
		
		/*Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("employeeName", "Kermit");
		variables.put("numberOfDays", new Integer(4));
		variables.put("vacationMotivation", "I'm really tired!");*/
		HashMap<String,Object> variables = new HashMap<String,Object>();
	//	variables.put("inputUser", "zhangsan");
		// 经过测试  活动开始后  选择的 是 近的 一个版本的 流程定义
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess",variables);

		// Verify that we started a new process instance
		log.info("流程实例的数量是: " + runtimeService.createProcessInstanceQuery().count());
	}
	
	/**
	 * 查询一个 用户 现在 有多少 活动 （task）
	 */
	@Test
	public void queryExecutionTest(){
		List<Execution> list = runtimeService.createExecutionQuery().list();
		int i = 0;
		for( Execution e : list ) {
			
			log.info("\n");
			log.info("第" + (++i) + "个活动" );
			log.info("Execution ID（执行ID） ： " + e.getId());
			log.info("ActivityID （活动ID）: " + e.getActivityId());
			log.info("ParentID (父ID) : " + e.getParentId());
			log.info("ProcessInstanceId （流程实例） ： " + e.getProcessInstanceId());
			log.info("isSuspended （是否挂起） ： " + e.isSuspended());
			log.info("isEnded （是否结束） " + e.isEnded());
			log.info("TenantId （不知道做什么用）" + e.getTenantId());
		}
	}
	
	/**
	 * 查询 可执行的 任务 
	 */
	@Test
	public void queryTaskTest(){
		String bussinessKey = "BHID1436790840778_85673";
		String tkey = "binghaipaigong";
		Task tasks = taskService.createTaskQuery().processInstanceBusinessKey(bussinessKey).taskDefinitionKey(tkey).singleResult();
		int i = 0;
		System.out.println(tasks);
		/*for( Task t : tasks ) {
			log.info("\n");
			
			log.info("第" + (++i) + "个任务");
			log.info("任务ID：" + t.getId());
			log.info("任务名称Name：" + t.getName());
			log.info("getAssignee(指定的用户): " + t.getAssignee());
			log.info("Description(活动描述)" + t.getDescription());
			log.info("ExecutionId(任务ID)" + t.getExecutionId());
			log.info("FormKey 表单 Key" + t.getFormKey());
			log.info("Owner(任务拥有者)："+t.getOwner());
			log.info("ParentTaskId(父任务ID):" + t.getParentTaskId());
			log.info("CreateTime(创建时间):" + t.getCreateTime());
			log.info("Priority(优先级):" + t.getPriority());
			log.info("ProcessDefinitionId(流程定义ID):" + t.getProcessDefinitionId());
			log.info("ProcessInstanceId(流程实例ID):" + t.getProcessInstanceId());
			log.info("TaskDefinitionKey(任务定义ID):" + t.getTaskDefinitionKey());
			log.info("DelegationState:" + t.getDelegationState());
			log.info("DueDate(持续时间):" + t.getDueDate());
			log.info("TaskLocalVariables(任务局部变量)" + t.getTaskLocalVariables());
		}*/
		
	}
	
	/**
	 * 根据业务ID 查询 任务
	 */
	@Test
	public void queryTaskTest2(){
		//List<Task> tasks = repositoryService.createProcessDefinitionQuery().
		//根据业务键获取流程实例和任务
		Task task = taskService.createTaskQuery().processInstanceBusinessKey("BHID1436172309604_46276").singleResult();
	//	taskService.complete(task.getId());
		log.info(task.getName() + "任务完成");
	}
	
	
	/**
	 * 查询 一个用户的 所有 可执行的 任务 
	 */
	@Test
	public void queryTaskByUser(){
	//	List<Task> tasks = taskService.createTaskQuery().taskAssignee("zhangsan").list();
	//	List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("zhangsan").list();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateOrAssigned("0307").list();
		for( Task t : tasks ) {
			log.info("任务名称：" + t.getName() + "-任务ID ：" + t.getId());
		}
	}
	
	@Test
	public void QueryGroupByUser(){
		
	}
	
	/**
	 * 完成任务
	 */
	@Test
	public void completeTask(){
		//Task task = taskService.createTaskQuery().list().get(0);
		HashMap<String,Object> variables = new HashMap<String,Object>();
		
		//List<Task> listTask = taskService.createTaskQuery().taskCandidateOrAssigned("0101").list();
		List<Task> listTask = taskService.createTaskQuery().list();
		for( Task t : listTask ) {
			variables.put("bhsbzt", 2);
			variables.put("pgzt", 3);
			variables.put("bhwxzt", 1);
			variables.put("zyyszt", 1);
			LoginUser user = new LoginUser();
		//	user.setUsername("zhangsan");
		//	variables.put("myObj",user);
			taskService.complete(t.getId(),variables);
		}
		// 病害 上报 状态  1  上报 ， 2 取消 上报 
	//	variables.put("bhsbzt", 2);
		// 病害审核状态  1 审核通过 
		
	}
	
	/**
	 * 认领任务 然后 在完成任务
	 */
	@Test
	public void completeGroupTask(){
		List<Task> tasks = taskService.createTaskQuery().taskCandidateOrAssigned("sunqi").list();
		for( Task t : tasks ) {
			log.info("任务名称：" + t.getName() + "-任务ID ：" + t.getId());
			taskService.claim(t.getId(),"sunqi");
			HashMap<String,Object> variables = new HashMap<String,Object>();
			variables.put("bhwxzt", 1);
			taskService.complete(t.getId(),variables);
		}
	}
	
	/**
	 * 删除 所有的 任务 
	 * 如果 有正在 活动的任务 ， 次方法 无法 删除  任务
	 */
	@Test
	public void deleteTaskTest(){
		List<Task> tasks = taskService.createTaskQuery().list();
		
		for( Task t : tasks ) {
			taskService.deleteTask(t.getId(),true);
			log.info("删除 " + t.getId() + "成功");
		}
		
	}
	
	
	/**
	 * 挂起 激活 流程定义
	 * 挂起流程定义的时候 ， 将不能再创建 新的 流程 
	 */
	@Test
	public void suspendProcessDefinition(){
		repositoryService.createDeployment()
		.addClasspathResource("diagrams/VacationRequest.bpmn")
		.deploy();
		log.info("流程定义数量" + repositoryService.createProcessDefinitionQuery().count());
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("employeeName", "Kermit");
		variables.put("numberOfDays", new Integer(4));
		variables.put("vacationMotivation", "I'm really tired!");
		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest", variables);

		// Verify that we started a new process instance
		log.info("流程实例的数量是: " + runtimeService.createProcessInstanceQuery().count());
		
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		for (Task task : tasks) {
		  log.info("可用的任务: " + task.getName());
		}
		
		Task task = tasks.get(0);

		Map<String, Object> taskVariables = new HashMap<String, Object>();
		taskVariables.put("vacationApproved", "false");
		taskVariables.put("managerMotivation", "We have a tight deadline!");
		taskService.complete(task.getId(), taskVariables);
		
		repositoryService.suspendProcessDefinitionByKey("vacationRequest");
		
		try {
		  runtimeService.startProcessInstanceByKey("vacationRequest");
		} catch (ActivitiException e) {
		  e.printStackTrace();
		}
		
	}
	
	/**
	 * 终止 一个 流程实例
	 */
	@Test
	public void suspendProInsTest(){
		Execution ec= runtimeService.createExecutionQuery().processInstanceBusinessKey("BHID1437318754153_97805").singleResult();
		String pi = ec.getProcessInstanceId();
		runtimeService.deleteProcessInstance(pi, null);
		// 挂起一个流程
	//	runtimeService.suspendProcessInstanceById(pi); 
	//	runtimeService.activateProcessInstanceById(pi);
	}
	
	
	
	
}
