package com.hdsx.hmglyh.rcyh;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
/*@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@Transactional  // 配置事物
*/@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class BhjlControllerTest {
	
	private static Logger log = LoggerFactory.getLogger(BhjlControllerTest.class);
	
	
	
	/*@Autowired
	BinghaijlController bhjlController;
	
	*//**
	 * 删除寻道记录测试
	 *//*
	
	
	@Test
	public void saveBhTest(){
		bhjlController.saveBh();
	}*/
}
