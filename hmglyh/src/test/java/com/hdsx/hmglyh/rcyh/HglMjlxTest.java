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
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.rcyh.dao.HtglMjlxMapper;
import com.hdsx.hmglyh.rcyh.dao.HtglYhbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.HtglGljlxb;
import com.hdsx.hmglyh.rcyh.dao.model.HtglLuduan;
import com.hdsx.hmglyh.rcyh.dao.model.HtglMjlx;
import com.hdsx.hmglyh.rcyh.dao.model.HtglYhlxb;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.SpringContextUtil;

 @RunWith(SpringJUnit4ClassRunner.class)
 @TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
 @Transactional // 配置事物
 @ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class HglMjlxTest {

	private static Logger log = LoggerFactory.getLogger(HglMjlxTest.class);

	@Autowired
	HtglMjlxMapper mjlxMapper;

	@Autowired
	HtglYhbMapper yhbMapper;

	/**
	 * 
	 * 
	 * 天气列表
	 */

	@Test
	public void tqListTest() {

		HtglMjlx mjlx = new HtglMjlx();

		mjlx.setType("天气");

		List<HtglMjlx> list = mjlxMapper.selectTq(mjlx);

		System.out.println(list);

	}
	
	
	@Test
	public void sayTest(){
		List<HtglGljlxb> gjjs = mjlxMapper.selectGljclTree();
		System.out.println(gjjs);
	}

	/**
	 * 
	 * 
	 * 病害类型 转换
	 */

	@Test
	public void bhlxConvertTest() {

		String name = mjlxMapper.bhlxConvert("0101");

		System.out.println(name);

	}

	/**
	 * 
	 * 
	 * 查找 派工人员列表
	 */

	@Test
	public void pgrysListTest() {

	//	List<HtglYhb> list = RcyhUtils.pgryList();

	//	System.out.println(list);

	}

	/**
	 * 
	 * 
	 * 根据 部门 编码 查询 路段
	 */

	@Test
	public void luduansListTest() {

		List<HtglLuduan> list = RcyhUtils.luduanList("0101");

		System.out.println(list);

	}

	/**
	 * 
	 * 
	 * 获取真实 名称
	 */

	@Test
	public void getRealNameTest() {

		String name = yhbMapper.getRealName("admin");

		System.out.println(name);

	}

	/**
	 * 
	 * 
	 * 状态转换字段测试
	 */

	@Test
	public void ztConvertTest() {

		String name = RcyhUtils.ztConvert("zysbzt", "0");

		System.out.println(name);

	}

	/**
	 * 
	 * 
	 * 获取 上级 部门 测试
	 */

	@Test
	public void bumenParentTest() {

		List<HtglBmb> list = RcyhUtils.getSbdx("010101");

		System.out.println(list);

	}

	/**
	 * 
	 * 
	 * 获取 养护类型 树 测试
	 */

	@Test
	public void yhlxbTreeTest() {

		List<HtglYhlxb> list = RcyhUtils.getYhlxTree();

		System.out.println(list);

	}

	/**
	 * 
	 * 
	 * 根据 部门 获取 当前人工费用 测试
	 */

	@Test
	public void getRgfdj() {

		Double d = RcyhUtils.getRgfdj("01010301");

		System.out.println(d);

	}

	/**
	 * 
	 * 
	 * 工料机材料 树测试
	 */

	@Test
	public void getGljclTree() {

		List<HtglGljlxb> glj = RcyhUtils.getGljclTree();

		System.out.println(glj);

	}

	/**
	 * 
	 * 
	 * 工料机机械树 测试
	 */

	@Test
	public void getGljjxTree() {

		List<HtglGljlxb> glj = RcyhUtils.getGljjxTree();

		System.out.println(glj);

	}
	
	/**
	 * 根据部门编码 和 工料机类型id 查询 价格 
	 */
	@Test
	public void getGljjgsTest(){
		List<String> ids = new ArrayList<String>();
		ids.add("0201");
		ids.add("0203");
		ids.add("0204");
		List<HashMap<String,Object>> list = RcyhUtils.getGljdj(ids, "01010106","010110");
		System.out.println(list);
	}
	/**
	 * 测试 从定额表中查询 工料机 树立nag
	 */
	@Test
	public void getGljslTest(){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		HashMap<String,Object> variables = new HashMap<String,Object>();
		variables.put("yhid", "010110");
		variables.put("lxid", "02021");
		System.out.println("工料机数量"+mjlxMapper.getGljsl(variables));
	}
	
	/**
	 * 根据当前登录用户 查询 应该 派工 对象 
	 */
	@Test
	public void getPgdxTest(){
		//String bmcode = "0101";
		//String bmcode = "010101";
		String bmcode = "01010101";
		
		List<HtglBmb> bmbs = RcyhUtils.getPgdx(bmcode);
		System.out.println(bmbs);
		
	}
	
	/**
	 * 根据 当前 系统时间 获取 所属 年月
	 */
	@Test
	public void getSsnyTest(){
		String n = RcyhUtils.getSsny(1);
		System.out.println(n);
	}
	
	/**
	 * 获取 开始 时间 与 结束 时间 测试
	 */
	@Test
	public void getStimeAndEtime(){
		HashMap<String,Object> map = RcyhUtils.getStimeAndEtime();
		System.out.println(map);
	}
	
	/**
	 * 获取所有分局下面的 养护站
	 */
	@Test
	public void getYhzs(){
		List<HtglBmb> list = RcyhUtils.getYhzs("010101");
		System.out.println(list);
	}
	
}
