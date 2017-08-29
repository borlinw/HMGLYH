package com.hdsx.hmglyh.gis.jichusj.gouzaowu;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Handong;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Lujifh;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qiaoliang;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Suidao;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.service.GouzaowuService;
import com.hdsx.hmglyh.gis.util.Combobox;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
//@Transactional   // 配置事物
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class GouzaowuServiceTest {

	@Autowired
	private GouzaowuService gzwService;
	
	/**
	 * 	测试 桥梁列表
	 */
	@Test
	public void qiaoliangRowsTest(){
		Qiaoliang ql = new Qiaoliang();
		ql.setRoadcode("G217");
		ql.setStartzh(543.000);
		ql.setEndzh(722.000);
		ql.setPage(1);
		ql.setRows(5);
		List<Qiaoliang> list = gzwService.qiaoliangRows(ql);
		int total = gzwService.qiaoliangCount(ql);
		
		for( Qiaoliang q : list ) {
			System.out.println(q);
		}
		
		System.out.println("总数"+total);
	}
	
	/**
	 * 测试隧道列表
	 */
	@Test
	public void sudiaoRowsTest(){
		Suidao sd = new Suidao();
		sd.setRoadcode("G217");
		sd.setPage(1);
		sd.setRows(10);
		List<Suidao> list = gzwService.suidaoRows(sd);
		int count = gzwService.suidaoCount(sd);
		for( Suidao s : list ) {
			System.out.println(s);
		}
		System.out.println("总数 ： " + count);
	}
	
	@Test
	public void handongRowsTest(){
		Handong hd = new Handong();
		hd.setRoadcode("G217");
		hd.setPage(1);
		hd.setRows(5);
		
		List<Handong> list = gzwService.handongRows(hd);
		int count = gzwService.handongCount(hd);
		for( Handong h: list ) {
			System.out.println(hd);
		}
		System.out.println("总数："+count);
	}
	
	/**
	 * 路基防护列表 测试
	 */
	@Test
	public void lujifhRowsTest(){
		Lujifh lj = new Lujifh();
		lj.setRoadcode("G217");
		List<Lujifh> list = gzwService.LujifhRows(lj);
		int total = gzwService.LujifhCount(lj);

		for( Lujifh l : list ) {
			System.out.println(l);
		}
			
		System.out.println("总数："+total);
	}
	
	
	/**
	 * 桥梁跨径分类 chart 统计 测试
	 */
	@Test
	public void qlkjflChartTest(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		List<HashMap<String,Object>> list = gzwService.qlkjflChart(param);
		
		for(HashMap<String,Object> hm : list ) {
			System.out.println(hm);
		}
	}
	
	/**
	 * 桥梁技术等级 chart 统计 测试
	 */
	@Test
	public void qljsdjChartTest(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		List<HashMap<String,Object>> list = gzwService.qljsdjChart(param);
		
		for(HashMap<String,Object> hm : list ) {
			System.out.println(hm);
		}
	}
	
	/**
	 * 桥梁 按 桥梁性质 测试
	 */
	@Test
	public void qlxzChartTest(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		List<HashMap<String,Object>> list = gzwService.qlxzChart(param);
		
		for(HashMap<String,Object> hm : list ) {
			System.out.println(hm);
		}
	}
	
	/**
	 * 隧道按 技术等级 评定等级
	 */
	@Test
	public void sdjsdjChartTest(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		List<HashMap<String,Object>> list = gzwService.sdjsdjChart(param);
		for(HashMap<String,Object> hm : list ) {
			System.out.println(hm);
		}
	}
	
	/**
	 * 隧道 按 隧道分类 统计
	 */
	@Test
	public void sjflChartTest(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		List<HashMap<String,Object>> list = gzwService.sdflChart(param);
		for(HashMap<String,Object> hm : list ) {
			System.out.println(hm);
		}
	}
	
	/**
	 * 涵洞按 涵洞类型统计
	 */
	@Test
	public void hdlxChartTest(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		List<HashMap<String,Object>> list = gzwService.hdflChart(param);
		for(HashMap<String,Object> hm : list ) {
			System.out.println(hm);
		}
	}
	
	/**
	 * 涵洞 按 跨径分类型
	 */
	@Test
	public void hdkjflChartTest(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		List<HashMap<String,Object>> list = gzwService.hdkjflChart(param);
		for(HashMap<String,Object> hm : list ) {
			System.out.println(hm);
		}
	}
	
	/**
	 * 涵洞 按 防护类型 统计
	 */
	@Test
	public void ljfhlxChartTest(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		List<HashMap<String,Object>> list = gzwService.ljfhlxChart(param);
		for(HashMap<String,Object> hm : list ) {
			System.out.println(hm);
		}
	}
	
	/**
	 * 桥梁combobox 测试
	 */
	@Test
	public void qlComboboxTest(){
		List<Combobox> list = gzwService.qlCombobox("");
		System.err.println(list);
	}
	
	@Test
	public void sdComboboxTest(){
		List<Combobox> list = gzwService.sdCombobox("");
		System.out.println(list);
	}
	
	@Test
	public void hdComboboxTest(){
		List<Combobox> list = gzwService.hdCombobox("");
		System.out.println(list);
	}
	
}
