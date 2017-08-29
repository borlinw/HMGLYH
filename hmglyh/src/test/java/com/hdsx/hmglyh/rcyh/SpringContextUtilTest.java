package com.hdsx.hmglyh.rcyh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdsx.hmglyh.rcyh.service.BhService;
import com.hdsx.hmglyh.util.SpringContextUtil;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
/*@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@Transactional  // 配置事物
*/@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class SpringContextUtilTest {
	
	private static Logger log = LoggerFactory.getLogger(SpringContextUtilTest.class);
	
	@Test
	public void getBhServiceTest(){
		BhService bhservice = (BhService) SpringContextUtil.getBean("bhServiceImpl");
		System.out.println(bhservice);
	}
	
}
