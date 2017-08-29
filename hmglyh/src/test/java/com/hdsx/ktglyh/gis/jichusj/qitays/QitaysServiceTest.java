package com.hdsx.hmglyh.gis.jichusj.qitays;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Bixiancd;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Guoshuilm;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Jianzhicun;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Jumindian;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Lvhua;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Lvyoujd;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Qitalxd;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Tingchedao;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Xiangzhen;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Xuexiao;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Zirancun;
import com.hdsx.hmglyh.gis.jichusj.qitays.service.QitaysService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
//@Transactional   // 配置事物
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class QitaysServiceTest {
	
	@Autowired
	private QitaysService qitaysService;
	
	/**
	 *   地质灾害点 列表 测试
	 */
	/*@Test
	public void dizhizhdRowsTest(){
		Dizhizhd dzzhd = new Dizhizhd();
		dzzhd.setRoadcode("G217");
		dzzhd.setPage(1);
		dzzhd.setRows(10);
		
		List<Dizhizhd> list = qitaysService.
		
	}*/
	
	/**
	 * 建制村 列表测试
	 */
	
	@Test
	public void jianzhicunRowsTest(){
		Jianzhicun jzc = new Jianzhicun();
		jzc.setPage(1);
		jzc.setRows(10);
		
		List<Jianzhicun> list = qitaysService.jianzhicunRows(jzc);
		int total = qitaysService.jianzhicunCount(jzc);
		
		for( Jianzhicun j : list ) {
			System.out.println(j);
		}
		
		System.out.println("建制村 总数 ： " + total);
		
	}
	
	@Test
	public void jumindianRowsTest(){
		Jumindian jmd = new Jumindian();
		jmd.setPage(1);
		jmd.setRows(10);
		
		List<Jumindian> list = qitaysService.jumindianRows(jmd);
		int total = qitaysService.jumindianCount(jmd);
		
		for( Jumindian j : list ) {
			System.out.println(j);
		}
		System.out.println("居民点总数："+total);
	}
	
	@Test
	public void xiangzhenRowsTest(){
		Xiangzhen xz = new Xiangzhen();
		xz.setPage(1);
		xz.setRows(10);
		
		List<Xiangzhen> list = qitaysService.xiangzhenRows(xz);
		int total = qitaysService.xiangzhenCount(xz);
		
		for( Xiangzhen x : list ) {
			System.out.println(x);
		}
		
		System.out.println("乡镇的总数:"+ total);
	}
	
	@Test
	public void zirancunRowsTest(){
		
		Zirancun zrc = new Zirancun();
		zrc.setPage(1);
		zrc.setRows(10);
		
		List<Zirancun> list = qitaysService.zirancunRows(zrc);
		int total = qitaysService.zirancunCount(zrc);
		for( Zirancun z : list ) {
			System.out.println(z);
		}
		
		System.out.println("自然村总数：" + total);
		
	}
	
	/**
	 * 旅游景点列表测试
	 */
	@Test
	public void lvyoujdRowsTest(){
		
		Lvyoujd lyjd = new Lvyoujd();
		lyjd.setPage(1);
		lyjd.setRows(10);
		
		List<Lvyoujd> rows = qitaysService.lvyoujdRows(lyjd);
		int total = qitaysService.lvyoujdCount(lyjd);
		
		for( Lvyoujd l : rows ) {
			System.out.println(l);
		}
		
		System.out.println("旅游景点 总数 ： " + total);
	}
	
	/**
	 * 学校列表 测试
	 */
	@Test
	public void xuexiaoRowsTest(){
		Xuexiao xx = new Xuexiao();
		xx.setPage(1);
		xx.setRows(10);
		List<Xuexiao> rows = qitaysService.xuexiaoRows(xx);
		int total = qitaysService.xuexiaoCount(xx);
		
		for( Xuexiao x : rows ) {
			System.out.println(x);
		}
		
		System.out.println("学校总数:" + total);
	}
	
	/**
	 * 其他类型点 列表 测试
	 */
	@Test
	public void qitalxdRowsTest(){
		Qitalxd qtlxd = new Qitalxd();
		qtlxd.setPage(1);
		qtlxd.setRows(10);
		
		List<Qitalxd> rows = qitaysService.qitalxdRows(qtlxd);
		int total = qitaysService.qitalxdCount(qtlxd);
		for( Qitalxd q: rows) {
			System.out.println(q);
		}
		System.out.println("其他类型点总数：" + total);
	}
	
	/**
	 * 过水路面
	 */
	@Test
	public void guoshuilmRowsTest(){
		Guoshuilm gslm = new Guoshuilm();
		gslm.setRoadcode("G217");
		gslm.setPage(1);
		gslm.setRows(10);
		
		List<Guoshuilm> rows = qitaysService.guoshuilmRows(gslm);
		int total = qitaysService.guoshuilmCount(gslm);
		
		for( Guoshuilm g : rows ) {
			System.out.println(g);
		}
		
		System.out.println("过水路面总数:" + total);
	}
	
	/**
	 * 避险车道
	 */
	@Test
	public void bixiancdRowsTest(){
	
		Bixiancd bxcd = new Bixiancd();
		bxcd.setPage(1);
		bxcd.setRows(10);
		
		List<Bixiancd> rows = qitaysService.bixiancdRows(bxcd);
		int total = qitaysService.bixiancdCount(bxcd);
		
		for( Bixiancd b : rows ) {
			System.out.println(b);
		}
		
		System.out.println("避险车道总数：" + total);
		
	}
	
	// TODO 无表
	/**
	 * 停车道
	 */
	@Test
	public void tingchedaoRowsTest(){
		
		Tingchedao tcd = new Tingchedao();
		tcd.setPage(1);
		tcd.setRows(10);
		tcd.setRoadcode("G217");
		
		List<Tingchedao> rows = qitaysService.tingchedaoRows(tcd);
		int total = qitaysService.tingchedaoCount(tcd);
		
		for( Tingchedao t : rows ) {
			System.out.println(t);
		}
		
		System.out.println("停车道总数：" + total);
		
	}
	
	/**
	 * 绿化列表 测试
	 */
	@Test
	public void lvhuaRowsTest(){
		
		Lvhua lh = new Lvhua();
		lh.setRoadcode("G217");
		lh.setPage(1);
		lh.setRows(10);
		
		List<Lvhua> rows = qitaysService.lvhuaRows(lh);
		int total = qitaysService.lvhuaCount(lh);
		
		for( Lvhua l : rows ) {
			System.out.println(l);
		}
		
		System.out.println("绿化总数:" + total);
	}
	
	/**
	 * 穿城路段 
	 */
	public void ChuanchengldRowsTest(){
		// TODO 穿城路段
	}
}
