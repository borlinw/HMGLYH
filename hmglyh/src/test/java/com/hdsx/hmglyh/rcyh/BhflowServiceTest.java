package com.hdsx.hmglyh.rcyh;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.service.BhflowService;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
/*@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@Transactional  // 配置事物
*/@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class BhflowServiceTest {
	
	private static Logger log = LoggerFactory.getLogger(BhflowServiceTest.class);
	
	
	
	@Autowired
	BhflowService bhflowService;
	@Autowired
	WorkFlowService wfService;
	
	/**
	 * 启动流程实例
	 */
	@Test
	public void saveBhTest(){
		RcyhBhjlb bhjl = new RcyhBhjlb();
		LoginUser user = new LoginUser();
		user.setUsername("0103");
		user.setBmcode("01010105");
		bhjl.setUser(user);
		bhjl.setLdcode("0101");
		bhjl.setSbbmcode("01010101");
		bhjl.setXcid("XCID1436838787183_59082");
		bhflowService.saveBh(bhjl);
	}
	
	/**
	 *  测试 取消上报 与 确认上报
	 */
	@Test
	public void querensbTest(){
		RcyhBhjlb bhjl = new RcyhBhjlb();
		LoginUser user = new LoginUser();
	//	user.setUsername("0103");
	//	bhjl.setUser(user);
		bhjl.setXcid("XCID1436757544327_91500");
		bhjl.setBhjlid("BHID1436771206196_58497");
		bhjl.setBhsbzt("1");
		bhflowService.shangbaoBh(bhjl);
	}
	
	@Test
	public void completeTaskTest(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("bhsbzt", 1);
		map.put("bmcode", "01010105");
		wfService.completeTask("BHID1436771206196_58497",map);
	}
	

	/**
	 * 病害派工测试
	 */
	@Test
	public void bhpgTest(){
		RcyhBhjlb bhjlb = new RcyhBhjlb();
		bhjlb.setPgzt("1");
		LoginUser user = new LoginUser();
		user.setUsername("admin");
		ArrayList<String> bhjlids = new ArrayList<String>();
		bhjlids.add("BHID1436771206196_58497");
		//bhflowService.savepg(bhjlb, user, bhjlids);
	}
	
}
