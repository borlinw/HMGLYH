package com.hdsx.hmglyh.rcyh.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.rcyh.service.WorkFlowService;

@Service
public class WorkFlowServiceImpl implements WorkFlowService{

	@Autowired
	RepositoryService repositoryService;
	@Autowired
	RuntimeService runtimeService;
	@Autowired
	TaskService taskService;
	
	private static Logger log = LoggerFactory.getLogger(WorkFlowServiceImpl.class);
	
	@Override
	public void startProcess(String bussinessKey,HashMap<String,Object> variables) {
		runtimeService.startProcessInstanceByKey("bhProcess",bussinessKey,variables);
		log.info("启动了 流程实例 ，业务键：" + bussinessKey + ",流程变量:" + variables);
	}
	
	@Override
	public void startProcess(String deplymentKey, String bussinessKey,
			HashMap<String,Object> variables) {
		runtimeService.startProcessInstanceByKey(deplymentKey,bussinessKey,variables);
		log.info("启动了 流程实例 ，业务键：" + bussinessKey+",流程变量:" + variables);
	}
	

	@Override
	public void completeTask(String businessKey) {
		Task task = taskService.createTaskQuery().processInstanceBusinessKey(businessKey).singleResult();
		if(task != null ) {
			taskService.complete(task.getId());
			log.info(businessKey + ":" + task.getName() + "任务完成");
		}
	}
	
	@Override
	public void completeTask(String businessKey,HashMap<String,Object> variables) {
		Task task = taskService.createTaskQuery().processInstanceBusinessKey(businessKey).singleResult();
		if( task != null ) {
			taskService.complete(task.getId(),variables);
			log.info(businessKey + ":" + task.getName() + "任务完成");
		}
	}
	

	@Override
	public List<Task> queryTaskUser(String username) {
		return taskService.createTaskQuery().taskCandidateOrAssigned(username).list();
	}

	@Override
	@Deprecated
	public InputStream getProcessPic() {
		 ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery().latestVersion().singleResult();  
         String diagramResourceName = procDef.getDiagramResourceName();  
         InputStream imageStream = repositoryService.getResourceAsStream(  
                 procDef.getDeploymentId(), diagramResourceName);  
         return imageStream;
	}

	@Override
	public InputStream getProcessPic(String definitionKey) {
		 ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery().processDefinitionKey(definitionKey).latestVersion().singleResult();  
         String diagramResourceName = procDef.getDiagramResourceName();  
         InputStream imageStream = repositoryService.getResourceAsStream(  
                 procDef.getDeploymentId(), diagramResourceName);  
         return imageStream;
	}
	
	@Override
	@Deprecated
	public ActivityImpl getProcessMap(String bhjlid) {
		 ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().latestVersion().singleResult();
			
		  ProcessDefinitionImpl pdImpl = (ProcessDefinitionImpl) processDefinition;  
         String processDefinitionId = pdImpl.getId();// 流程标识  

         ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)  
                 .getDeployedProcessDefinition(processDefinitionId); 
		 
		ExecutionEntity execution = (ExecutionEntity) runtimeService  
               .createExecutionQuery().processInstanceBusinessKey(bhjlid).singleResult();
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
       return actImpl;
	}
	
	@Override
	public ActivityImpl getProcessMap(String bhjlid,String definitionKey) {
		 ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(definitionKey).latestVersion().singleResult();
			
		 ProcessDefinitionImpl pdImpl = (ProcessDefinitionImpl) processDefinition;  
         String processDefinitionId = pdImpl.getId();// 流程标识  

         ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)  
                 .getDeployedProcessDefinition(processDefinitionId); 
		 
		ExecutionEntity execution = (ExecutionEntity) runtimeService  
               .createExecutionQuery().processInstanceBusinessKey(bhjlid).singleResult();
		
		if(execution == null ) {
			return null;
		}
		
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
       return actImpl;
	}

	@Override
	public Task queryTaskByBkeyAndTkey(String bkey, String tkey) {
		return taskService.createTaskQuery().processInstanceBusinessKey(bkey).taskDefinitionKey(tkey).singleResult();
	}

	@Override
	public void deleteProcessInstance(String businessKey) {
		Execution ec= runtimeService.createExecutionQuery().processInstanceBusinessKey(businessKey).singleResult();
		if( ec != null ) {
			String pi = ec.getProcessInstanceId();
			runtimeService.deleteProcessInstance(pi, null);
		}
	}

	@Override
	public String getTaskName(String businessKey) {
	
		Task task = taskService.createTaskQuery().processInstanceBusinessKey(businessKey).singleResult();
	
		if(task != null ) {
			String key =  task.getTaskDefinitionKey();
			return key;
		}
		
		return null;
	}

	
}
