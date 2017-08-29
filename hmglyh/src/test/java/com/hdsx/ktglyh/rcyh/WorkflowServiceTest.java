package com.hdsx.hmglyh.rcyh;

import java.util.HashMap;

import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdsx.hmglyh.rcyh.service.WorkFlowService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
/*@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@Transactional  // 配置事物
*/@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class WorkflowServiceTest {
	
	private static Logger log = LoggerFactory.getLogger(WorkflowServiceTest.class);
	
	
	@Autowired
	WorkFlowService wfService;
	
	@Test
	public void completeTaskTest(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("bhsbzt", 2);
		map.put("bmcode", "01010105");
		wfService.completeTask("BHID1435631559102_77026",map);
	}
	@Test
	public void getTaskTest(){
		Task name = wfService.queryTaskByBkeyAndTkey("BHID1436790840778_85673", "binghaipaigong");
		System.out.println(name);
	}
}
