package com.hdsx.hmglyh.gis.jichusj.yanxianss;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Fuwuqu;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Guanlijg;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jianchazhan;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jiaoanss;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jiaotongbz;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jiaotonglianggcz;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Luxiandmtd;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Shoufeizhan;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Tianqiao;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Yanxianfwss;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.service.YanxianssService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
//@Transactional   // 配置事物
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class YanxianssServiceTest {
	
	@Autowired
	private YanxianssService yanxianssService;
	
	/**
	 * 交安设施列表 测试
	 */
	@Test
	public void jiaoanssRowsTest(){
		
		Jiaoanss jass = new Jiaoanss();
		jass.setRoadcode("G217");
		jass.setPage(1);
		jass.setRows(10);
		List<Jiaoanss> list = yanxianssService.jiaoanssRows(jass);
		int total = yanxianssService.jiaoanssCount(jass);
		for( Jiaoanss ja : list ) {
			System.out.println(ja);
		}
		System.out.println("交安设施总数:"+total);
		
	}
	
	/**
	 * 交通标志列表
	 */
	@Test
	public void jiaotongbzRowsTest(){
		Jiaotongbz jtbz = new Jiaotongbz();
		
		jtbz.setRoadcode("G217");
		jtbz.setPage(1);
		jtbz.setRows(10);
		
		List<Jiaotongbz> list = yanxianssService.jiaotongbzRows(jtbz);
		int total = yanxianssService.jiaotongbzCount(jtbz);
		for( Jiaotongbz jt : list ) {
			System.out.println(jt);
		}
		System.out.println("交通标志总数 ： " + total);
		
	}
	
	/**
	 * 测试天桥 列表 总数
	 */
	@Test
	public void tianqiaoRowsTest(){
		Tianqiao tq = new Tianqiao();
		tq.setRoadcode("G217");
		tq.setPage(1);
		tq.setRows(10);
		List<Tianqiao> list = yanxianssService.tianqiaoRows(tq);
		int total = yanxianssService.tianqiaoCount(tq);
		for( Tianqiao t : list ) {
			System.out.println(t);
		}
		System.out.println("天桥总数："+total);
	}
	
	/**
	 * 检查站 列表  总数 
	 */
	@Test
	public void jianchazhanRowsTest(){
		
		Jianchazhan jcz = new Jianchazhan();
		jcz.setRoadcode("G217");
		jcz.setPage(1);
		jcz.setRows(10);
		List<Jianchazhan> list = yanxianssService.jianchazhanRows(jcz);
		int total = yanxianssService.jianchazhanCount(jcz);
		for( int i = 0 ; i < list.size(); i ++ ) {
			System.out.println(list.get(i));
		}
		
		System.out.println("检查站总数："+total);
		
	}
	
	
	@Test
	public void jiaotonglianggczRows(){
		Jiaotonglianggcz gcz = new Jiaotonglianggcz();
		gcz.setRoadcode("G217");
		gcz.setPage(1);
		gcz.setRows(10);
		List<Jiaotonglianggcz> list = yanxianssService.jiaotonglianggczRows(gcz);
		int total  = yanxianssService.jiaotonglainggczCount(gcz);
		for( Jiaotonglianggcz g : list ) {
			System.out.println(g);
		}
		System.out.println("交通量观测站总数："+ total);
	}
	
	/**
	 * 路线多媒体点  列表 测试 
	 */
	@Test
	public void luxiandmtdRowTest(){
		Luxiandmtd dmt = new Luxiandmtd();
		dmt.setRoadcode("G217");
		dmt.setPage(1);
		dmt.setRows(10);
		List<Luxiandmtd> list = yanxianssService.luxiandmtdRows(dmt);
		int total = yanxianssService.luxiandmtCount(dmt);
		
		for( Luxiandmtd d : list ) {
			System.out.println(d);
		}
		
		System.out.println("路线多媒体点 ：" + total);
	}
	
	/**
	 *  服务区  列表 测试
	 */
	@Test
	public  void fuwuquRows(){
		Fuwuqu fwq = new Fuwuqu();
		fwq.setRoadcode("G217");
		fwq.setPage(1);
		fwq.setRows(10);
		
		List<Fuwuqu> list = yanxianssService.fuwuquRows(fwq);
		int total = yanxianssService.fuwuquCount(fwq);
		
		for( Fuwuqu f : list ) {
			System.out.println(f);
		}
		
		System.out.println("服务区总数：" + total);
		
	}
	
	/**
	 * 沿线服务设施 列表
	 */
	@Test
	public void yanxianfwssRowsTest(){
		Yanxianfwss fwss = new Yanxianfwss();
		fwss.setRoadcode("G217");
		fwss.setPage(1);
		fwss.setRows(10);
		
		List<Yanxianfwss> list = yanxianssService.yanxianfwssRows(fwss);
		int total = yanxianssService.yanxianfwssCount(fwss);
		
		for( Yanxianfwss fw : list ) {
			System.out.println(fw);
		}
		
		System.out.println("沿线服务设施 总数 ： " + total);
	}
	
	/**
	 * 收费站 列表 测试 
	 */
	@Test
	public void shoufeizhanRowsTest(){
		Shoufeizhan sfz = new Shoufeizhan();
		sfz.setRoadcode("G217");
		sfz.setPage(1);
		sfz.setRows(10);
		
		List<Shoufeizhan> list = yanxianssService.shoufeizhanRows(sfz);
		int total = yanxianssService.shoufeizhanCount(sfz);
		
		for( Shoufeizhan s : list ) {
			System.out.println(s);
		}
		
		System.out.println("收费站 总数  ： " + total);
	}
	
	/**
	 * 管理机构 测试 列表
	 */
	@Test
	public void guanlijgRowsTest(){
		Guanlijg gljg = new Guanlijg();
		gljg.setPage(1);
		gljg.setRows(10);
		
		List<Guanlijg> list = yanxianssService.guanlijgRows(gljg);
		int total = yanxianssService.guanlijgCount(gljg);
		
		for( Guanlijg g : list ) {
			System.out.println(g);
		}
		
		System.out.println("管理机构 总数 ： " + total);
	}
	
	// TODO 养护工区 测试 
	
}
