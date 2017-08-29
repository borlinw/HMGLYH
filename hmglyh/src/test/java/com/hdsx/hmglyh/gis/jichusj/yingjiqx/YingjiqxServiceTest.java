package com.hdsx.hmglyh.gis.jichusj.yingjiqx;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Dizhizhd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Wuziku;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Yingjibzd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Zaihaiyfld;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.service.YingjiqxService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
//@Transactional   // 配置事物
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class YingjiqxServiceTest {
	
	@Autowired
	private YingjiqxService yingjiqxService; 
	
	/**
	 * 地质灾害点 列表 测试
	 */
	@Test
	public void dizhizhdRowsTest(){
		Dizhizhd dzzhd = new Dizhizhd();
		dzzhd.setRoadcode("G217");
		dzzhd.setPage(1);
		dzzhd.setRows(10);
		
		List<Dizhizhd> rows = yingjiqxService.dizhizhdRows(dzzhd);
		int total = yingjiqxService.dizhizhdCount(dzzhd);
		
		for( Dizhizhd d : rows ) {
			System.out.println(d);
		}
		
		System.out.println("地质灾害点总数：" + total);
	}
	
	/**
	 * 灾害易发路段
	 */
	@Test
	public void zaihaiyfldRowsTest(){
		
		Zaihaiyfld zhyfld = new Zaihaiyfld();
		zhyfld.setPage(1);
		zhyfld.setRows(10);
		zhyfld.setRoadcode("G217");
		
		List<Zaihaiyfld> rows = yingjiqxService.zaihaiyfldRows(zhyfld);
		int total = yingjiqxService.zaihaiyfldCount(zhyfld);
		
		for( Zaihaiyfld zh : rows ) {
			System.out.println(zh);
		}
		
		System.out.println("灾害易发路段 总数 ： total " + total );
		
	}
	
	/**
	 * 应急保障点 列表 测试
	 */
	@Test
	public void yingjibbdRowsTest(){
		
		Yingjibzd yjbzd = new Yingjibzd();
		yjbzd.setRoadcode("G217");
		yjbzd.setPage(1);
		yjbzd.setRows(10);
		
		List<Yingjibzd> rows = yingjiqxService.yingjibzdRows(yjbzd);
		int total = yingjiqxService.yingjibzdCount(yjbzd);
		for( Yingjibzd yj : rows ) {
			System.out.println(yj);
		}
		
		System.out.println("应急保障点  总数 ： " + total);
	}
	
	@Test
	public void wuzikuRowsTest(){
		Wuziku wzk = new Wuziku();
		wzk.setPage(1);
		wzk.setRows(10);
		
		List<Wuziku> rows = yingjiqxService.wuzikuRows(wzk);
		int total = yingjiqxService.wuzikuCount(wzk);
		
		for( Wuziku w : rows ) {
			System.out.println(w);
		}
		
		System.out.println("物资库总数 ： " + total);
		
	}
	
}
