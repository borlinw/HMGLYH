package com.hdsx.hmglyh.rcyh;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.service.WxzyService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
/*@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@Transactional  // 配置事物
*/@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class WxzyServiceTest {
	
	private static Logger log = LoggerFactory.getLogger(WxzyServiceTest.class);
	
	@Autowired
	WxzyService wxzyService;
	
	/**
	 * 任务单 列表 测试
	 */
	@Test
	public void listRwd(){
		RcyhRwdjlb rwd = new RcyhRwdjlb();
		rwd.setRwdzt("0");
		rwd.setBmcode("01010106");
		rwd.setPage(1);
		rwd.setRows(10);
		List<RcyhRwdjlb> list = wxzyService.listRwd(rwd);
		int total = wxzyService.listRwdCount(rwd);
		log.info("查询任务单 列表 查询 成功  总数:" + total);
		System.out.println(list);
	}
	
	/**
	 * 通过任务单 ID 级联查询 任务单 和 材料消耗 测试 加 本部门人员
	 */
	@Test
	public void selectRwdAndClxhTest(){
		String rwdid = "RWDID1436446841833_90811";
		RcyhRwdjlb rwd = wxzyService.queryRwdByKey(rwdid);
		System.out.println(rwd);
	}
	
	/**
	 *  通过键 查询 维修作业单
	 */
	@Test
	public void queryWxzyByKeyTest(){
		String zyid = "WXZY1436925752640_85918";
		RcyhWxzyjlb wxzy = wxzyService.queryWxzyByKey(zyid);
		System.out.println(wxzy);
	}
	
	/**
	 * 通过键之 查询 任务单
	 */
	@Test
	public void queryRwdjlbByKeyTest(){
		RcyhRwdjlb rwd = wxzyService.queryRwdByKey("RWDID1436938074783_96646");
		System.out.println(rwd);
	}
	
}
