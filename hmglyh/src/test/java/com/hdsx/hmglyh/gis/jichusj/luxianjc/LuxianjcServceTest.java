package com.hdsx.hmglyh.gis.jichusj.luxianjc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Gaosucrk;
import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Pingjiaodk;
import com.hdsx.hmglyh.gis.jichusj.luxianjc.service.LuxianjcService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
//@Transactional   // 配置事物
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class LuxianjcServceTest {
	
	
	@Autowired
	private LuxianjcService luxianjcService;
	
	/**
	 *	 高速出入口 列表 测试
	 */
	@Test
	public void gaosucrkRowsTest(){
		Gaosucrk crk = new Gaosucrk();
		crk.setRoadcode("G217");
		crk.setPage(1);
		crk.setRows(10);
		
		List<Gaosucrk> rows = luxianjcService.gaosucrkRows(crk);
		int total = luxianjcService.gaosucrkCount(crk);
		
		for( Gaosucrk c : rows ) {
			System.out.println(c);
		}
		
		System.out.println("高速出入口总数：" + total);
		
	}
	
	/**
	 * 平交道口列表
	 */
	@Test
	public void pingjiaodkRowsTest(){
		Pingjiaodk pjdk = new Pingjiaodk();
		pjdk.setPage(1);
		pjdk.setRows(10);
		
		List<Pingjiaodk> rows = luxianjcService.pingjiaodkRows(pjdk);
		int total = luxianjcService.pingjiaodkCount(pjdk);
		
		for( Pingjiaodk dk : rows ) {
			System.out.println(dk);
		}
		
		System.out.println("平交道口总数：" + total);
		
	}
}
