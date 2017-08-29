package com.hdsx.hmglyh.rcyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.service.BhService;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;
import com.hdsx.hmglyh.util.HDFreeMarker;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
/*@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@Transactional  // 配置事物
*/@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class BhServiceTest {
	
	private static Logger log = LoggerFactory.getLogger(BhServiceTest.class);
	
	@Autowired
	BhService bhService;
	@Autowired
	WorkFlowService wfService;
	
	/**
	 * 通过病害记录ID 查询病害
	 */
	@Test
	public void queryBhByKeyTest(){
		RcyhBhjlb bh = bhService.queryBhByKey("BHID1437898854546_91133");
		System.out.println(bh);
	}

	/**
	 * 级联自关联 查询 病害类型
	 */
	@Test
	public void selectBhlxsTest(){
		List<HtglBhlx> list = bhService.selectBhlxs();
		System.out.println(list);
	}
	
	@Test
	public void createBhlxsTreeTest(){
		List<HtglBhlx> list = bhService.selectBhlxs();
	//	System.out.println(list);
		HashMap<String,Object> root = new HashMap<String,Object>();
		root.put("list", list);
		HDFreeMarker fm = new HDFreeMarker("template/");
		fm.createJsonFile(root, "bhlxtree.ftl", "bhlxtree.json");
	}
	
	public static void main(String[] args) {
		List<HtglBhlx> list = new ArrayList<HtglBhlx>();
		HDFreeMarker fm = new HDFreeMarker("template/");
	//	fm.createBhlxJsonFile(list, "test.ftl", "bhlxtree.json");
	}
	
	/**
	 * 病害列表 测试
	 */
	@Test
	public void listBhTest(){
		RcyhBhjlb bhjl = new RcyhBhjlb();
		bhjl.setBmcode("0101");
		bhjl.setPage(1);
		bhjl.setRows(10);
		bhjl.setBhsbzt("0");
		List<RcyhBhjlb> list = bhService.listBh(bhjl);
		int total = bhService.listBhCount(bhjl);
		log.info("成功！");
	}
	
	
	
}
