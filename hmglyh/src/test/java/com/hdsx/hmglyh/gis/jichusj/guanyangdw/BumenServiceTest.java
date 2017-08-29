package com.hdsx.hmglyh.gis.jichusj.guanyangdw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.HtglBmbMapper;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.service.impl.BumenServiceImpl;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.SpringContextUtil;


@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
//@Transactional   // 配置事物
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class BumenServiceTest {
	
	@Autowired
	BumenServiceImpl bmService;
	
	@Autowired
	HtglBmbMapper bmMapper;
	
	/**
	 * 测试 部门查询  
	 */
	@Test
	public void bumenRowsTest(){
		HtglBmb bm = new HtglBmb();
		bm.setBmcode("0101");
		HtglBmb hb = bmService.bumenRows(bm);
		System.out.println(hb);
	}
	
	
	@Test
	public void bmTreeTest(){
		Combotree tree = bmMapper.selectBmCombotree("010101");
		System.out.println(bmMapper);
		System.out.println(tree);
	}
	@Test
	public void bmTreeTest2(){
		HtglBmbMapper bmMapper = (HtglBmbMapper) SpringContextUtil.getBean("bumenMapper");
		Combotree tree = bmMapper.selectBmCombotree("0101");
		System.out.println(tree);
	}
	
	
	/**
	 * 测试 部门二级缓存
	 */
	@Test
	public void bumenRowsWithCatchTest(){
		HtglBmb bm = new HtglBmb();
		bm.setBmcode("0101");
		HtglBmb hb = bmService.bumenRows(bm);
		HtglBmb hb2 = bmService.bumenRows(bm);
		System.out.println(hb);
		System.out.println(hb2);
	}
}
