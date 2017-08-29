package com.hdsx.hmglyh.login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.login.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
/*@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@Transactional  // 配置事物
*/@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class LoginServiceTest {
	
	private static Logger log = LoggerFactory.getLogger(LoginServiceTest.class);
	
	@Autowired
	LoginService loginService;
	
	/**
	 * 登陆 级联查询 权限信息 查询 
	 */
	@Test
	public void loginTest(){
		LoginUser user = new LoginUser();
		user.setUsername("admin");
		user.setPw("123");
		user = loginService.login(user);
		System.out.println(user);
	}
	
}
