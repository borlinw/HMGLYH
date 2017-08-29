package com.hdsx.hmglyh.rcyh;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdsx.hmglyh.rcyh.dao.model.HtglYhb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhGlxcsjb;
import com.hdsx.hmglyh.rcyh.service.XdjlService;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
/*@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@Transactional  // 配置事物
*/@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class XdjlServiceTest {
	
	private static Logger log = LoggerFactory.getLogger(XdjlServiceTest.class);
	
	
	
	
	@Autowired
	XdjlService xdjlService;
	
	
	/**
	 * 根据 xcid 查询 巡查数据表 关联 了 部门表
	 */
	@Test
	public void selectGlxcsjb(){
		RcyhGlxcsjb xcsj = new RcyhGlxcsjb();
		xcsj.setXcid("A15C6D4D23D54E568AC5FABD704EFD02");
		
		
		xcsj = xdjlService.selectGlxcsjb(xcsj);
		
		System.out.println(xcsj);
		
		
	}
	
	/**
	 * 保存 巡查记录表
	 */
	@Test
	public void saveXcjlTest(){
		RcyhGlxcsjb xcsj = new RcyhGlxcsjb();
		xcsj.setBmcode("010101");
		xcsj.setBz("测试");
		xcsj.setUsername("zhangsan");
		xcsj.setJlr("zhangsan");
		xcsj.setFzr("zhangsan");
		xdjlService.saveXdjl(xcsj);
	}
	
	/**
	 *  首页巡查记录列表  
	 */
	@Test
	public void xcjlRowsTest(){
		RcyhGlxcsjb glxcsjb = new RcyhGlxcsjb();
		glxcsjb.setPage(1);
		glxcsjb.setRows(5);
	//	glxcsjb.setUsername("zhangsan");
		glxcsjb.setMkid("010101");
		List<RcyhGlxcsjb> list =  xdjlService.listXdsj(glxcsjb);
		int total = xdjlService.listXdsjCount(glxcsjb);
		log.info("共有" + list.size() + "条数据");
		log.info("count 的值是" + total);
		for( RcyhGlxcsjb sjb : list ) {
			System.out.println(sjb);
		}
	}
	
	/**
	 * 测试 通过 巡查id 删除 一条 寻道记录
	 */
	@Test
	public void delXdjlTest(){
		RcyhGlxcsjb xcsj = new RcyhGlxcsjb();
		xcsj.setXcid("1");
		try {
			xdjlService.delXdjl(xcsj);
			log.info(xcsj.getXcid() + " 寻道 记录删除成功");
		} catch (Exception e) {
			log.info(xcsj.getXcid() + " 寻道 记录删除失败");
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void canDelXdsjTest(){
		RcyhGlxcsjb xcsj = new RcyhGlxcsjb();
		xcsj.setXcid("72D739FDB62741FDA0AA98CEE1A60496");
		xdjlService.canDelXdjl(xcsj);
	}
	
	/**
	 * 测试 通过 用户名 查询 巡视 记录表 
	 * 级联查询 用户 以及部门下 管辖 路段
	 */
	@Test
	public void selectGlxcsjbByUsernameTest(){
		RcyhGlxcsjb sjb = xdjlService.queryglxcsjbByUsername("admin");
		System.out.println(sjb);
	}
	
	/**
	 * 测试 通过巡查日志的 可以查询  巡查日志表
	 */
	@Test
	public void selectByKeyTest(){
		RcyhGlxcsjb xcsj = new RcyhGlxcsjb();
		xcsj.setXcid("CE98553E50A743468C5822FFA3BDB277");
		xcsj.setUsername("zhangsan");
		xcsj.setBmcode("01010105");
		RcyhGlxcsjb sjb = xdjlService.queryXdsjByKey(xcsj);
		System.out.println(sjb);
	}
	
	
	
	/**
	 * 根据用户名查询 用户 
	 */
	/*@Test
	public void queryYhbTest(){
		HtglYhb yh = new HtglYhb();
		yh.setUsername("zhangsan");
		HtglYhb newYh = xdjlService.queryYhb(yh);
		System.out.println(newYh);
	}
	
	@Test
	public void queryYhbsTest(){
		HtglYhb yh = new HtglYhb();
		yh.setBmcode("01010105");
		List<HtglYhb> list = xdjlService.queryYhbs(yh);
		System.out.println(list);
	}*/

}
