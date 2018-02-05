package com.hdsx.hmglyh.rcyh.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.HtglBmbMapper;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.htgl.bean.HtglRyb;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.controller.dto.Dedto;
import com.hdsx.hmglyh.rcyh.dao.HtglMjlxMapper;
import com.hdsx.hmglyh.rcyh.dao.model.HtglGljlxb;
import com.hdsx.hmglyh.rcyh.dao.model.HtglMjlx;
import com.hdsx.hmglyh.rcyh.dao.model.HtglYhlxb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRyzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhYdjhshb;
import com.hdsx.hmglyh.rcyh.dao.model.ZP;
import com.hdsx.hmglyh.rcyh.service.BhflowService;
import com.hdsx.hmglyh.rcyh.service.WxzyService;
import com.hdsx.hmglyh.rcyh.service.YdjhshService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Constants;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.SpringContextUtil;

@Controller
@Scope(value = "request")
public class WxzyController extends BaseAction {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bmcode; // 部门编码
	private List<String> ids; // 接收各种类型的ID 数组
	private String yhlxid; // 养护类型ID
	
	
	@Autowired
	private WxzyService wxzyService;
	@Autowired
	private BhflowService bhflowService;
	@Autowired
	private YdjhshService ydjhshService;
	
	
	
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	

	public String getYhlxid() {
		return yhlxid;
	}

	public void setYhlxid(String yhlxid) {
		this.yhlxid = yhlxid;
	}

	public String getBmcode() {
		return bmcode;
	}

	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}

	public List<String> getIds() {
		return ids;
	}

	/**
	 * 根据 部门编码 和 工料机 类型 ID 获取 工料机的 单价
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void getGljdj() throws IOException, Exception {
		List<HashMap<String, Object>> djs = RcyhUtils.getGljdj(ids, bmcode,yhlxid);
		JsonUtils.write(djs, getResponse().getWriter());
	}

	/**
	 * 
	 * 
	 * 养护类型树
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void getYhlxTree() throws IOException, Exception {
		List<HtglYhlxb> list = RcyhUtils.getYhlxTree();
		JsonUtils.write(list, getResponse().getWriter());
	}

	/**
	 * 材料类型树
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void getGljclTree() throws IOException, Exception {
		List<HtglGljlxb> list = RcyhUtils.getGljclTree();
		JsonUtils.write(list, getResponse().getWriter());
	}
	
	/**
	 * 工料机 机械类型树
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void getGljjxTree() throws IOException, Exception {
		List<HtglGljlxb> list = RcyhUtils.getGljjxTree();
		JsonUtils.write(list, getResponse().getWriter());
	}

	/**
	 * 根据部门编码 获取 人工费
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void getRgf() throws IOException, Exception {
		Double rgf = RcyhUtils.getRgfdj(getWxzy().getBmcode());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("res", (double) rgf);
		JsonUtils.write(map, getResponse().getWriter());
	}
	
	/**
	 * 分局 的所管辖的所有的 养护站
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void getYhzs() throws IOException, Exception{
		List<HtglBmb> list = RcyhUtils.getYhzs(bmcode);
		list.get(0).setSelected(true);
		JsonUtils.write(list, getResponse().getWriter());
	}
	
	public void rwdCalculate() throws IOException, Exception{
		
	//	HashMap<String,Object> map = RcyhUtils.getYhlx(getRwd().getYhid()); // 工日定额
	//	map.put("rgdj",RcyhUtils.getRgfdj(getUser().getBmcode()));  //人工单价
		
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		String bmcode = rwd.getBmcode();
		if( bmcode.length() == 8 ) {
			bmcode = bmcode.substring(0,bmcode.length() - 2 ) ;
		}
		Dedto dedto = mjlxMapper.getDedto(rwd.getYhid(),bmcode);
		
		List<HtglGljlxb> cls = mjlxMapper.getDeCls(rwd.getYhid(), bmcode);
		List<HtglGljlxb> jxs = mjlxMapper.getDeJxs(rwd.getYhid(), bmcode);
	
		Double clfTotal = new Double(0);
		Double jxfTotal = new Double(0);
		
		for( HtglGljlxb glj : cls ) {
			clfTotal += glj.getSl() * glj.getDj();
		}
		
		for( HtglGljlxb glj : jxs ) {
			jxfTotal += glj.getSl() * glj.getDj();
		}
		
		dedto.setClfTotal(clfTotal);
		dedto.setJxfTotal(jxfTotal);
		dedto.setCls(cls);
		dedto.setJxs(jxs);
		
		JsonUtils.write(dedto, getResponse().getWriter());
	}
	
	/**
	 * 任务单状态 combobox
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void rwdztCombobox() throws IOException, Exception{
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("ztcode", "rwdzt");
		map.put("ztname", "任务单状态");
		List<Combobox> comboboxs = RcyhUtils.ztCombobox(map);
		JsonUtils.write(comboboxs, getResponse().getWriter());
	}
	
	/**
	 * 任务单状态combobox
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void rwdlxCombobox() throws IOException, Exception{
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		HtglMjlx mjlx = new HtglMjlx();
		mjlx.setType("任务单类型");
		List<HtglMjlx> list = mjlxMapper.selectTq(mjlx);
		JsonUtils.write(list, getResponse().getWriter());
	}
	
	/**
	 * 任务单查看状态combobox
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void rwdckztCombobox() throws IOException, Exception{
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("ztcode", "rwdckzt");
		map.put("ztname", "任务单查看状态");
		List<Combobox> comboboxs = RcyhUtils.ztCombobox(map);
		JsonUtils.write(comboboxs, getResponse().getWriter());
	}
	
	/**
	 * 维修验收状态 combobox
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void wxysztCombobox() throws IOException, Exception{
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("ztcode", "yszt");
		map.put("ztname","验收状态");
		List<Combobox> comboboxs = RcyhUtils.ztCombobox(map);
		JsonUtils.write(comboboxs, getResponse().getWriter());
	}
	
	/**
	 * 维修上报状态 combobox
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void zysbztCombobox() throws IOException, Exception{
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("ztcode", "zysbzt");
		map.put("ztname", "作业上报状态");
		List<Combobox> comboboxs = RcyhUtils.ztCombobox(map);
		JsonUtils.write(comboboxs, getResponse().getWriter());
	}
	
	/**
	 * 获取人员 treeGrid 数据
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void getRyTreeGrid() throws IOException, Exception{
		JsonUtils.write(RcyhUtils.getRyTreeGrid(getUser().getBmcode()), getResponse().getWriter());
	}
	
	public String addRys(){
		return SUCCESS;
	}
	
	/**
	 * 任务单 列表
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void listRwd() throws IOException, Exception{
		getRwd().setPage(getPage());
		getRwd().setRows(getRows());
		List<RcyhRwdjlb> rows = wxzyService.listRwd(getRwd());
		for( RcyhRwdjlb rw : rows) {
			rw.setCjusername(RcyhUtils.usernameToString(rw.getCjusername()));
			rw.setBmcode(RcyhUtils.getBmname(rw.getBmcode()));
			rw.setYhid(RcyhUtils.getYhlxName(rw.getYhid()));
			rw.setRwdzt(RcyhUtils.ztConvert(Constants.rwdzt, rw.getRwdzt()));
			rw.setRwdlx(RcyhUtils.mjlxConvert(Constants.rwdlx, rw.getRwdlx()));
			rw.setRwdckzt(RcyhUtils.ztConvert(Constants.rwdckzt, rw.getRwdckzt()));
			rw.setLdname(RcyhUtils.getLdname(rw.getLdcode()));
			rw.setTq(RcyhUtils.mjlxConvert(Constants.fangxiang, rw.getTq()));
			rw.setBhid(RcyhUtils.bhlxConvert(rw.getBhid()));
			rw.setDw(RcyhUtils.getDwByYhid(rw.getYhid()));
		}
		int count = wxzyService.listRwdCount(getRwd());
		EasyUIPage<RcyhRwdjlb> epage = new EasyUIPage<RcyhRwdjlb>();
		epage.setRows(rows);
		epage.setTotal(count);
		JsonUtils.write(epage, getResponse().getWriter());
	}
	
	public String ydjh(){
		return SUCCESS;
	}
	
	/**
	 * 任务单 列表
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void listRwdcx() throws IOException, Exception{
		rwd.setPage(page);
		rwd.setRows(rows);
		List<RcyhRwdjlb> rows = wxzyService.listRwdcx(rwd);
		for( RcyhRwdjlb rw : rows) {
			rw.setCjusername(RcyhUtils.usernameToString(rw.getCjusername()));
			rw.setDw(RcyhUtils.getDwByYhid(rw.getYhid()));
			rw.setBmcode(RcyhUtils.getBmname(rw.getBmcode()));
			rw.setYhid(RcyhUtils.getYhlxName(rw.getYhid()));
			rw.setRwdzt(RcyhUtils.ztConvert(Constants.rwdzt, rw.getRwdzt()));
			rw.setRwdlx(RcyhUtils.mjlxConvert(Constants.rwdlx, rw.getRwdlx()));
			rw.setRwdckzt(RcyhUtils.ztConvert(Constants.rwdckzt, rw.getRwdckzt()));
			rw.setLdname(RcyhUtils.getLdname(rw.getLdcode()));
			rw.setTq(RcyhUtils.mjlxConvert(Constants.fangxiang, rw.getTq()));
			rw.setBhid(RcyhUtils.bhlxConvert(rw.getBhid()));
		
		}
		int count = wxzyService.listRwdcxCount(getRwd());
		EasyUIPage<RcyhRwdjlb> epage = new EasyUIPage<RcyhRwdjlb>();
		epage.setRows(rows);
		epage.setTotal(count);
		JsonUtils.write(epage, getResponse().getWriter());
	}
	

	/**
	 * 任务单 列表
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void listRwdForYdjh() throws IOException, Exception{
		rwd.setPage(page);
		rwd.setRows(rows);
		List<RcyhRwdjlb> rows = wxzyService.listRwdForYdjh(rwd);
		for( RcyhRwdjlb rw : rows) {
			rw.setCjusername(RcyhUtils.usernameToString(rw.getCjusername()));
		//	rw.setBmcode(RcyhUtils.getBmname(rw.getBmcode()));
			rw.setBmname(RcyhUtils.getBmname(rw.getBmcode()));
			rw.setDw(RcyhUtils.getDwByYhid(rw.getYhid()));
			rw.setYhid(RcyhUtils.getYhlxName(rw.getYhid()));
			rw.setRwdzt(RcyhUtils.ztConvert(Constants.rwdzt, rw.getRwdzt()));
			rw.setRwdlx(RcyhUtils.mjlxConvert(Constants.rwdlx, rw.getRwdlx()));
			rw.setRwdckzt(RcyhUtils.mjlxConvert(Constants.rwdckzt, rw.getRwdckzt()));
			rw.setLdname(RcyhUtils.getLdname(rw.getLdcode()));
			rw.setTq(RcyhUtils.mjlxConvert(Constants.fangxiang, rw.getTq()));
			rw.setBhid(RcyhUtils.bhlxConvert(rw.getBhid()));
		}
		int count = wxzyService.listRwdForYdjhCount(getRwd());
		EasyUIPage<RcyhRwdjlb> epage = new EasyUIPage<RcyhRwdjlb>();
		
		// 计划任务单 判断 其审核状态 
		if( Constants.JihuaRwd.equals(rwd.getRwdlx()) ) {
			
			if(    StringUtils.isNotBlank(rwd.getBmcode()) 
				&& StringUtils.isNoneBlank(rwd.getLdcode())
				&& StringUtils.isNotBlank(rwd.getSsny())
					){
				
				RcyhYdjhshb ydjhsh = ydjhshService.queryYhjhshByCondition(rwd.getBmcode(),
											rwd.getLdcode(), rwd.getSsny());
				
				if( ydjhsh == null ) {
					epage.setShzt("未提交");
				}else if( ydjhsh.getShzt() == 0 ) {
					epage.setShzt("审核中");
				}else if( ydjhsh.getShzt() == 1 ) {
					epage.setShzt("审核通过");
				}else if( ydjhsh.getShzt() == 2 ) {
					epage.setShzt("打回修改");
				}
				
				if( count == 0 ) {
					epage.setShzt("--");
				}
			}else{
				epage.setShzt("参数有误");
			}
			
		}
		
		
		epage.setRows(rows);
		epage.setTotal(count);
		JsonUtils.write(epage, getResponse().getWriter());
	}
	
	/**
	 * 维修作业 列表
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void listWxzy() throws IOException, Exception{
		getWxzy().setPage(getPage());
		getWxzy().setRows(getRows());
		if(getWxzy().isFromYs()) {
			HashMap<String,Object> map  = RcyhUtils.getStimeAndEtime();
			getWxzy().setStime((Date)map.get("STIME"));
			getWxzy().setEtime((Date)map.get("ETIME"));
		}
		
		List<RcyhWxzyjlb> rows = wxzyService.listWxzy(getWxzy());
		int total = wxzyService.listWxzyCount(getWxzy());
		
		for(RcyhWxzyjlb wxzyjlb : rows) {
			wxzyjlb.setJlusername(RcyhUtils.usernameToString(wxzyjlb.getJlusername()));
			wxzyjlb.setBmcode(RcyhUtils.getBmname(wxzyjlb.getBmcode()));
			wxzyjlb.setYhname(RcyhUtils.getYhlxName(wxzyjlb.getYhid()));
			wxzyjlb.setZysbzt(RcyhUtils.ztConvert("zysbzt", wxzyjlb.getZysbzt()));
			wxzyjlb.setYszt(RcyhUtils.ztConvert("yszt", wxzyjlb.getYszt()));
			wxzyjlb.setSbusername(RcyhUtils.usernameToString(wxzyjlb.getSbusername()));
			wxzyjlb.setYhname(RcyhUtils.getYhlxName(wxzyjlb.getYhid()));
			wxzyjlb.setTq(RcyhUtils.mjlxConvert(Constants.fangxiang,wxzyjlb.getTq()));
			wxzyjlb.setLdname(RcyhUtils.getLdname(wxzyjlb.getLdcode()));
			wxzyjlb.setDw(RcyhUtils.getDwByYhid(wxzyjlb.getYhid()));
		}
		 
		EasyUIPage<RcyhWxzyjlb> epage = new EasyUIPage<RcyhWxzyjlb>();
		epage.setRows(rows);
		epage.setTotal(total);
		JsonUtils.write(epage, getResponse().getWriter());
	}
	
	public void listWxzycx() throws IOException, Exception{
		wxzy.setPage(page);
		wxzy.setRows(rows);

		List<RcyhWxzyjlb> rows = wxzyService.listWxzycx(wxzy);
		int total = wxzyService.listWxzycxCount(wxzy);
		
		for(RcyhWxzyjlb wxzyjlb : rows) {
			wxzyjlb.setJlusername(RcyhUtils.usernameToString(wxzyjlb.getJlusername()));
			wxzyjlb.setBmcode(RcyhUtils.getBmname(wxzyjlb.getBmcode()));
			wxzyjlb.setYhname(RcyhUtils.getYhlxName(wxzyjlb.getYhid()));
			wxzyjlb.setZysbzt(RcyhUtils.ztConvert("zysbzt", wxzyjlb.getZysbzt()));
			wxzyjlb.setYszt(RcyhUtils.ztConvert("yszt", wxzyjlb.getYszt()));
			wxzyjlb.setSbusername(RcyhUtils.usernameToString(wxzyjlb.getSbusername()));
			wxzyjlb.setYhname(RcyhUtils.getYhlxName(wxzyjlb.getYhid()));
			wxzyjlb.setTq(RcyhUtils.mjlxConvert(Constants.fangxiang,wxzyjlb.getTq()));
			wxzyjlb.setLdname(RcyhUtils.getLdname(wxzyjlb.getLdcode()));
			wxzyjlb.setDw(RcyhUtils.getDwByYhid(wxzyjlb.getYhid()));
		}
		 
		EasyUIPage<RcyhWxzyjlb> epage = new EasyUIPage<RcyhWxzyjlb>();
		epage.setRows(rows);
		epage.setTotal(total);
		JsonUtils.write(epage, getResponse().getWriter());
	}
	
	
	/**
	 * 维修作业汇总的列表
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void listWxzyHz() throws IOException, Exception{
		/*
		 * 相同验收作业汇总成一条，以作业位置为主要条件，作业单位为次要条件，进行汇总
		 */
		wxzy.setPage(page);
		wxzy.setRows(rows);
		HashMap<String,Object> map = RcyhUtils.getStimeAndEtime();
		getWxzy().setStarttime((String) map.get("starttime"));
		getWxzy().setEndtime((String) map.get("endtime"));
		
		if(StringUtils.isNoneBlank(getWxzy().getSsny())){
			HashMap<String,Object> map2  = RcyhUtils.getStimeAndEtime(getWxzy().getSsny());
			getWxzy().setStarttime((String) map2.get("starttime"));
			getWxzy().setEndtime((String) map2.get("endtime"));
		}
		
		List<RcyhWxzyjlb> list = wxzyService.listWxzyHz(getWxzy());
		
		for(RcyhWxzyjlb wx : list ) {
			wx.setBmname(RcyhUtils.getBmname(wx.getBmcode()));
			wx.setYhname(RcyhUtils.getYhlxName(wx.getYhid()));
			wx.setDw(RcyhUtils.getDwByYhid(wx.getYhid()));
		}
		
		int total = wxzyService.listWxzyHzCount(getWxzy());
		EasyUIPage<RcyhWxzyjlb> epage = new EasyUIPage<RcyhWxzyjlb>();
		epage.setRows(list);
		epage.setTotal(total);
		JsonUtils.write(epage, getResponse().getWriter());
	}
	
	/**
	 * 添加维修作业 
	 */
	@AnnotationAuth(mkid="010104")
	public String addWxzy(){
		if(StringUtils.isNotBlank(rwd.getRwdid())) {
			RcyhRwdjlb rwdjlb = wxzyService.queryRwdByKey(getRwd().getRwdid());
			RcyhWxzyjlb wx = new RcyhWxzyjlb();
			wx.setRwdid(rwdjlb.getRwdid()); // 任务单ID
			wx.setJlusername(getUser().getUsername()); // 维修作业记录人
			wx.setJlryname(getUser().getRyname());
			wx.setYhid(rwdjlb.getYhid()); // 维修养护ID
			wx.setBmcode(getUser().getBmcode()); // 维修部门
			wx.setWgtime(RcyhUtils.getDateTimeStr()); // 完工时间
			wx.setBmname(getUser().getBmname()); // 部门名称
			wx.setYhname(RcyhUtils.getYhlxName(rwdjlb.getYhid())); //养护类型名称
			wx.setSl(rwdjlb.getSl()); // 作业数量
			wx.setLdcode(rwdjlb.getLdcode()); // 路段编码 
			wx.setTq(rwdjlb.getTq()); // 方向
			wx.setYszt("0");
			wx.setZysbzt("0");
			wx.setYsztname(RcyhUtils.ztConvert("yszt", wx.getYszt())); //验收状态
			wx.setZysbztname(RcyhUtils.ztConvert("zysbzt", wx.getZysbzt())); // 作业上报状态
			wx.setLdname(RcyhUtils.getLdname(wx.getLdcode())); //路段名称
			wx.setDw(RcyhUtils.getDwByYhid(rwdjlb.getYhid()));
			List<RcyhRyzyjlb> ryzyList = new ArrayList<RcyhRyzyjlb>();
			wx.setDejs(RcyhUtils.getDejs(rwdjlb.getYhid()));
			wx.setDj(RcyhUtils.getYhlxDj(rwdjlb.getYhid()));
			// 人员作业
			for(HtglRyb ry : rwdjlb.getRys() ) {
				RcyhRyzyjlb ryzy = new RcyhRyzyjlb();
				ryzy.setRyid(ry.getRyid());
				ryzy.setWcgcl( rwdjlb.getSl() / rwdjlb.getRys().size());
				ryzy.setWcgr( rwdjlb.getSl() * rwdjlb.getGrde() / rwdjlb.getRys().size());
				ryzy.setRyname(ry.getRyname());
				ryzyList.add(ryzy);
			}
			wx.setRyzys(ryzyList);
			wx.setGrde(rwdjlb.getGrde()); // 工日定额
			wx.setJhgr(rwdjlb.getJhgr()); // 计划工日
			wx.setRgf(rwdjlb.getRgf()); // 人工费
			wx.setYszt("0"); // 验收状态
			wx.setZysbzt("0"); // 作业上报状态
			wx.setCljxxhs(rwdjlb.getCljxxhs()); // 工料机消耗
			wx.setJxf(rwdjlb.getJxf()); // 机械费
			wx.setClf(rwdjlb.getClf()); // 材料费
		
			wx.setSzhhkm(rwdjlb.getSzhhkm()); // 起点桩号千米
			wx.setSzhhm(rwdjlb.getSzhhm()); // 起点桩号米
			wx.setEzhhkm(rwdjlb.getEzhhkm()); // 止点桩号千米
			wx.setEzhhm(rwdjlb.getEzhhm()); // 止点桩号米
			
			wx.setCls(rwd.getCls());
			wx.setJxs(rwd.getJxs());
			
			Double rgf = RcyhUtils.getRgfdj(getUser().getBmcode());
			
			if( rgf == null ) {
				rgf = (double) 0;
			}
			
			wx.setRgdj(rgf); // 人工单价
			
			if(StringUtils.isNotBlank(rwdjlb.getQlcode())) {
				wx.setQlcode(rwdjlb.getQlcode());
				wx.setQlname(rwdjlb.getQlname());
			}
			
			if(StringUtils.isNoneBlank(rwdjlb.getSdcode())) {
				wx.setSdcode(rwdjlb.getSdcode());
				wx.setSdname(rwdjlb.getSdname());
			}
			
			if( StringUtils.isNoneBlank(rwdjlb.getHdcode())){
				wx.setHdcode(rwdjlb.getHdcode());
				wx.setHdname(rwdjlb.getHdname());
			}
			
			setAdd(true);
			setWxzy(wx);
		}else{
			wxzy.setJlusername(getUser().getUsername()); // 维修作业记录人
			wxzy.setJlryname(getUser().getRyname());
			wxzy.setBmcode(getUser().getBmcode()); // 维修部门
			wxzy.setWgtime(RcyhUtils.getDateTimeStr()); // 完工时间
			wxzy.setBmname(getUser().getBmname()); // 部门名称
			List<RcyhRyzyjlb> ryzyList = new ArrayList<RcyhRyzyjlb>();
			// 人员作业
			for(HashMap<String,Object> ry : RcyhUtils.getRysByBmcode(getUser().getBmcode()) ) {
				RcyhRyzyjlb ryzy = new RcyhRyzyjlb();
				ryzy.setRyid(((BigDecimal)ry.get("ryid")).toString());
				ryzy.setRyname((String)ry.get("ryname"));
				ryzyList.add(ryzy);
			}
			wxzy.setRyzys(ryzyList);
			wxzy.setYsztname("未验收"); //验收状态
			wxzy.setZysbztname("未上报"); // 作业上报状态
			wxzy.setYszt("0"); // 验收状态
			wxzy.setZysbzt("0"); // 作业上报状态
			Double rgf = RcyhUtils.getRgfdj(getUser().getBmcode());
			
			if( rgf == null ) {
				rgf = (double) 0;
			}
			wxzy.setRgdj(rgf); // 人工单价
			setDdWxzy(true);
			setAdd(true);
		}
		return SUCCESS;
	}
	
	/**
	 * 显示维修作业详情
	 * @return
	 */
	public String wxzyXq(){
		RcyhWxzyjlb wx = wxzyService.queryWxzyByKey(getWxzy().getZyid());
		wx.setBmname(RcyhUtils.getBmname(wx.getBmcode())); // 部门名称
		wx.setYhname(RcyhUtils.getYhlxName(wx.getYhid())); //养护类型名称
		wx.setRgdj(RcyhUtils.getRgfdj(wx.getBmcode()));  //人工费单价
		wx.setJlryname(RcyhUtils.usernameToString(wx.getJlusername())); //会写记录用人员名称
		wx.setYsztname(RcyhUtils.ztConvert("yszt", wx.getYszt())); // 显示验收状态
		wx.setZysbztname(RcyhUtils.ztConvert("zysbzt", wx.getZysbzt())); // 显示作业上报状态
		wx.setLdname(RcyhUtils.getLdname(wx.getLdcode())); // 回显路段名称
		wx.setTq(RcyhUtils.mjlxConvert("03", wx.getTq())); // 回显方向
		setWxzy(wx);
		setResultpage("addWxzy");
		setShow(true);
		return SUCCESS;
	}
	
	/**
	 * 病害照片s
	 * @return
	 */
	public String wxzyzps(){
		RcyhWxzyjlb wxzy = wxzyService.queryWxzyByKeyWithZps(getWxzy().getZyid());
		List<ZP> wxzps = wxzy.getZps();
		if( wxzps != null ) {
			for(ZP z:wxzps) {
				z.setPicUrl(Constants.PicUrl);
			}
		}
		setWxzy(wxzy);
		return SUCCESS;
	}
	
	
	/**
	 * 维修作业首页
	 */
	public String index() {
		return SUCCESS;
	}
	
	public String wxzy(){
		return SUCCESS;
	}
	
	/**
	 * 保存维修作业信息
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@AnnotationAuth(mkid="010104")
	public void saveWxzy() throws IOException, Exception{
		
		int c = wxzyService.saveWxzy(wxzy);
		if( c ==  1 ) {
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.INFO,"保存维修作业成功");
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO,"保存维修作业失败");
		}
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	
	/**
	 * 保存维修作业信息 无任务单信息
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@AnnotationAuth(mkid="010104")
	public void saveDdWxzy() throws IOException, Exception{
		int c = wxzyService.saveWxzyWithoutRwd(wxzy);
		if( c ==  1 ) {
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.INFO,"保存维修作业成功");
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO,"保存维修作业失败");
		}
		gmap.put("doNothing", true);
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	
	/**
	 * 更新维修作业 首页
	 * @return
	 */
	@AnnotationAuth(mkid="010104")
	public String updateWxzy(){
		RcyhWxzyjlb wx = wxzyService.queryWxzyByKey(wxzy.getZyid());
		wx.setBmname(RcyhUtils.getBmname(wx.getBmcode())); // 部门名称
		wx.setYhname(RcyhUtils.getYhlxName(wx.getYhid())); //养护类型名称
		wx.setRgdj(RcyhUtils.getRgfdj(wx.getBmcode()));  //人工费单价
		wx.setJlryname(RcyhUtils.usernameToString(wx.getJlusername())); //会写记录用人员名称
		wx.setYsztname(RcyhUtils.ztConvert("yszt", wx.getYszt())); // 显示验收状态
		wx.setZysbztname(RcyhUtils.ztConvert("zysbzt", wx.getZysbzt())); // 显示作业上报状态
		wx.setLdname(RcyhUtils.getLdname(wx.getLdcode())); // 回显路段名称
		//wx.setTq(RcyhUtils.mjlxConvert("03", wx.getTq())); // 回显方向
		wx.setDejs(RcyhUtils.getDejs(wx.getYhid()));
		wx.setDj(RcyhUtils.getYhlxDj(wx.getYhid()));
		List<ZP> zps = wx.getZps();
		for( ZP zp : zps) {
			zp.setPicUrl(Constants.PicUrl);
		}
		setWxzy(wx);
		setResultpage("addWxzy");
		setUpdate(true);
		return SUCCESS;
	}

	/**
	 * 保存病害维修的更新
	 * @throws Exception 
	 * @throws IOException 
	 */
	@AnnotationAuth(mkid="010104")
	public void saveWxzyUpdate() throws IOException, Exception{
		int c = wxzyService.saveWxzyUpdate(wxzy);
		if( c > 0 ) {
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.INFO, "维修作业更新成功");
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO, "未知错误");
		}
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	
	@AnnotationAuth(mkid="010104")
	public void delWxzy() throws IOException, Exception{
		RcyhWxzyjlb wx = wxzyService.queryWxzyByKey(getWxzy().getZyid());
		int c = wxzyService.delWxzy(wx);
		if( c == 1 ) {
			gmap.put("isSuccess", true);
			gmap.put("info", "维修作业删除成功");
			JsonUtils.write(gmap, getResponse().getWriter());
		}else if( c == 2 ){
			gmap.put("isSuccess", false);
			gmap.put("info", "删除失败，因为维修作业已经上报");
			JsonUtils.write(gmap, getResponse().getWriter());
		}else{
			gmap.put("isSuccess", false);
			gmap.put("info", "删除失败，其他原因");
			JsonUtils.write(gmap, getResponse().getWriter());
		}
	}
	
	/**
	 * 作业上报首页
	 */
	@AnnotationAuth(mkid="010105")
	public String zysb() {
		// 上报时间
		getWxzy().setSbtime(RcyhUtils.getDateStr());
		return SUCCESS;
	}
	
	/**
	 * 保存作业上报
	 * @throws Exception 
	 * @throws IOException 
	 */
	@AnnotationAuth(mkid="010105")
	public void saveZysb() throws IOException, Exception{
		
		// 检查维修作业是否可以是上报
		List<RcyhWxzyjlb> wxs = new ArrayList<RcyhWxzyjlb>();
		List<RcyhWxzyjlb> wxs2 = new ArrayList<RcyhWxzyjlb>();
		if(wxzy.getZysbzt().equals("1")) { // 确认上报
			for( RcyhWxzyjlb wx  : getWxzys() ) {
				wx = wxzyService.queryWxzyByKeySimple(wx.getZyid());
				String bmcode = wx.getBmcode();
				/*if(bmcode.length() == 8 ) {
					bmcode = bmcode.substring(0,bmcode.length()-2);
				}
				*/
				String ssny =RcyhUtils.getSsnyByDateTime(wx.getWgtime());
				if(RcyhUtils.canYs(wx.getYhid(), wx.getLdcode(),bmcode,ssny)){ // 根据 维修的完工时间 判断 所在月 是否已经验收过同类型项目
					wx.setZysbzt(getWxzy().getZysbzt());
					wx.setBmcode(getUser().getBmcode());
					wx.setSbusername(getUser().getUsername());
					wx.setSbtime(RcyhUtils.getDateTimeStr());
					wxs.add(wx);
				}else{
					wxs2.add(wx);
				}
			}
			if( wxs.size() > 0 && wxs2.size() == 0 ) {
				int c = bhflowService.saveSb(wxs);
				if( c > 0 ) {
					gmap.put(Constants.ISSUCCESS, true);
					gmap.put(Constants.INFO,"作业上报成功");
				}
			}
			if( wxs.size() > 0 && wxs2.size() > 0 ) {
				int c = bhflowService.saveSb(wxs);
				if( c > 0 ) {
					gmap.put(Constants.ISSUCCESS, true);
					String info = "部分上报成功,";
					for( RcyhWxzyjlb wx : wxs2 ) {
						info += RcyhUtils.getYhlxName(wx.getYhid()) + ",";
					}
					info += "类型作业本月已经验收";
					gmap.put(Constants.INFO,info);
				}
			}
			if(wxs.size() == 0 ){
				gmap.put(Constants.ISSUCCESS, false);
				gmap.put(Constants.INFO,"未找到符合验收条件的维修记录");
			}
		}
		
		if( wxzy.getZysbzt().equals("2")) {     // 取消上报
			
			for( RcyhWxzyjlb wx  : getWxzys() ) {
				wx = wxzyService.queryWxzyByKeySimple(wx.getZyid());
				wx.setZysbzt(getWxzy().getZysbzt());
				wx.setBmcode(getUser().getBmcode());
				wx.setSbusername(getUser().getUsername());
				wx.setSbtime(RcyhUtils.getDateTimeStr());
				wxs.add(wx);
			}
			
			int c = bhflowService.saveSb(wxs);
			if( c > 0 ) {
				gmap.put(Constants.ISSUCCESS, true);
				gmap.put(Constants.INFO,"作业取消上报成功");
			}
		}
		
		JsonUtils.write(gmap, getResponse().getWriter());
	}

	/**
	 * 维修验收首页
	 */
	public String weixiuys() {
		return SUCCESS;
	}

	
	/**
	 * 验收
	 * @throws UnsupportedEncodingException 
	 */
	public String ys() throws UnsupportedEncodingException{
		getZyys().setYstime(RcyhUtils.getDateTimeStr()); // 回写 验收 时间
		if(StringUtils.isBlank(zyys.getSsny())) {
			getZyys().setSsny(RcyhUtils.getSsny()); // 回写 所属 年月
		}else{
			getZyys().setSsny(new String(getZyys().getSsny().getBytes("ISO-8859-1"),"UTF-8"));
		}
		getZyys().setYhname(RcyhUtils.getYhlxName(getZyys().getYhid())); // 回写养护名称
		getZyys().setLdname(RcyhUtils.getLdname(getZyys().getLdcode())); // 回写养护站路段		
		getZyys().setDw(RcyhUtils.getDwByYhid(getZyys().getYhid()));
		getZyys().setBmname(RcyhUtils.getBmname(zyys.getBmcode()));
		getZyys().setDejs(RcyhUtils.getDejs(zyys.getYhid()));
		
		HtglBmbMapper bmMapper = (HtglBmbMapper) SpringContextUtil.getBean("htglBmbMapper");
		HtglBmb bm = bmMapper.selectBmbByBmcode(zyys.getBmcode());
		
		if(bm.getSftsbm() == 0 ) {
			
		}else{
			setResultpage("tsbmYs");
		}
		return SUCCESS;
	}
	
	/**
	 * 打回返工
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@AnnotationAuth(mkid="010106")
	public void saveYs() throws IOException, Exception{
		if( StringUtils.isNoneBlank(zyys.getSsny())){
		}else{
			getZyys().setSsny(RcyhUtils.getSsny());
		}
		
		String ssny = zyys.getSsny();
		ssny = URLDecoder.decode(ssny, "UTF-8");
		
		zyys.setSsny(ssny);
		
		int c = wxzyService.saveYs(getZyys());
		if( c == 1 ) {
			getGmap().put(Constants.ISSUCCESS, true);
			if(bufenYs) {
				getGmap().put("bufenYs", bufenYs);
				getGmap().put(Constants.INFO, "验收成功,请继续派工");
			}else{
				getGmap().put("bufenYs", bufenYs);
				getGmap().put(Constants.INFO, "操作成功");
			}
		}else if( c == 2 ) {
			getGmap().put(Constants.ISSUCCESS, false);
			getGmap().put(Constants.INFO, "在" + RcyhUtils.getLdname(getZyys().getLdcode()) + "已经验收过" + RcyhUtils.getYhlxName(getZyys().getYhid()) + "类型的项目");
		}
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	
	
	/**
	 * 特殊部门的验收
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void  saveTsbmys() throws IOException, Exception{
		
		if( wxzy.getZyid() != null ) {
			RcyhWxzyjlb wx = wxzyService.selectByPrimaryKeySimple(wxzy.getZyid());
			wx.setHgsl(wxzy.getHgsl());
			wx.setYszt(wxzy.getYszt());
			if(wxzy != null ) {
				int c = wxzyService.saveTsbmys(wx);
				if( c > 0 ) {
					getGmap().put(Constants.ISSUCCESS, true);
					getGmap().put(Constants.INFO,"操作成功");
					JsonUtils.write(gmap, getResponse().getWriter());
				}else{
					getGmap().put(Constants.ISSUCCESS, false);
					getGmap().put(Constants.INFO,"服务器内部出了些问题");
					JsonUtils.write(gmap, getResponse().getWriter());
				}
			}else{
				getGmap().put(Constants.ISSUCCESS, false);
				getGmap().put(Constants.INFO,"根据作业ID 获取维修作业为null");
				JsonUtils.write(gmap, getResponse().getWriter());
			}
		}else{
			getGmap().put(Constants.ISSUCCESS, false);
			getGmap().put(Constants.INFO,"获取作业ID失败");
			JsonUtils.write(gmap, getResponse().getWriter());
		}
	}
	
	/**
	 * 任务单查询页面
	 * @return
	 */
	public String rwdcx(){
		return SUCCESS;
	}
	
	/**
	 * 维修作业查询 
	 * @return
	 */
	public String wxzycx(){
		return SUCCESS;
	}
	
	
}
