package com.hdsx.hmglyh.gis.jichusj.luxian;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLdb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLxb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Luduan;
import com.hdsx.hmglyh.gis.jichusj.luxian.service.LuxianService;
import com.hdsx.hmglyh.gis.util.Combobox;


@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
//@Transactional   // 配置事物
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class LuxianServiceTest {
	
	@Autowired
	LuxianService luxianService;
	
	// 测试路线框
	@Test
	public void luxianComboboxTest(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("q", "G2");
		List<Combobox> list = luxianService.luxianCombobox(map);
		for( Combobox combobox : list ) {
			System.out.println(combobox);
		}
	}
	
	/**
	 * 部门表 路线 测试 
	 */
	@Test
	public void luxianComboboxForBmTest(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("bmcode", "01010301");
		List<Combobox> list = luxianService.luxianComboboxForBm(map);
		for( Combobox combobox : list ) {
			System.out.println(combobox);
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void zhuanghaoByLxcodeAndBmcodeTest(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("bmcode", "010101");
		map.put("lxcode","G217");
		HashMap<String,Object> zh = luxianService.zhuanghaoByLxcodeAndBmcode(map);
		System.out.println(zh);
	}
	
	// 测试路线datagrid
	@Test
	public void luxianRowsTest(){
		HtglLxb lxb = new HtglLxb();
		lxb.setPage(1);
		lxb.setRows(6);
		List<HtglLxb> list = luxianService.luxianRows(lxb);
		for( HtglLxb hll: list ) {
			System.out.println(hll);
		}
	}
	
	/**
	 * 互通管理 路段表
	 */
	@Test
	public void htglLdRowsTest(){
		HtglLdb ldb = new HtglLdb();
		ldb.setPage(1);
		ldb.setRows(10);
		ldb.setBmcode("010101");
		
		List<HtglLdb> list = luxianService.htglLdRows(ldb);
		List<HtglLdb> list2 = luxianService.htglLdRows(ldb);
		
		int total = luxianService.htglLdCount(ldb);
		
		for( HtglLdb ld : list ) {
			System.out.println(ld);
		}
		
		System.out.println("htglldb 总数是：" + total);
		
	}
	
	// 测试路段datagrid
	@Test
	public void luduanRowTest(){
		Luduan ldb = new Luduan();
		ldb.setPage(1);
		ldb.setRows(6);
		ldb.setRoadcode("G217");
		ldb.setStartzh("542.026");
		ldb.setEndzh("543");

		List<Luduan> list = luxianService.luduanRows(ldb);
		for( Luduan ld : list ) {
			System.out.println(ld);
		}
	}
}
