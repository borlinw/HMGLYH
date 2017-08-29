package com.hdsx.hmglyh.rcyh.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.gis.util.EasyUIPage;
import com.hdsx.hmglyh.gis.util.GisUtil;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx;
import com.hdsx.hmglyh.rcyh.dao.model.HtglMjlx;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhGlxcsjb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.ZP;
import com.hdsx.hmglyh.rcyh.service.BhService;
import com.hdsx.hmglyh.rcyh.service.WxzyService;
import com.hdsx.hmglyh.rcyh.service.XdjlService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Constants;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="request")
public class BhController extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<String> bhjlids;
	
	@Autowired
	private BhService bhService;
	@Autowired
	private XdjlService xdjlService;
	@Autowired
	private WxzyService wxService;
	



	public ArrayList<String> getBhjlids() {
		return bhjlids;
	}



	public void setBhjlids(ArrayList<String> bhjlids) {
		this.bhjlids = bhjlids;
	}
		
	public void getUserInfo(){
		try {
			JsonUtils.write(getUser(), getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  根据病害类型获取默认的修复实现
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void getXfsx() throws IOException, Exception{
		String wxsx = RcyhUtils.getWxsx(bhjl.getBhid());
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("result", wxsx);
		JsonUtils.write(result, getResponse().getWriter());
	}
	/**
	 * 方向列表
	 */
	public void fxList(){
		try {
			List<HtglMjlx> list = RcyhUtils.fxList();
			if(selectFirst){
				list.get(0).setSelected(true);
			}
			JsonUtils.write(list, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 上报状态列表
	 */
	public void sbztCombobox(){
		try {
			List<Combobox> list = RcyhUtils.sbCombobox();
			JsonUtils.write(list, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void pgztCombobox(){
		try {
			List<Combobox> list = RcyhUtils.pgCombobox();
			JsonUtils.write(list, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 上报对象  json 输出
	 */
	public void getSbdxs(){
		try {
			List<HtglBmb> list = RcyhUtils.getSbdx(getBhjl().getBmcode());
			JsonUtils.write(list, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取 派工对象 
	 */
	public void getPgdxs(){
		try {
			List<HtglBmb> list = RcyhUtils.getPgdx(getUser().getBmcode());
			JsonUtils.write(list, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加一条病害
	 * @return
	 */
	@AnnotationAuth(mkid="010101")
	public String addBh(){
		setAdd(true);
		// 回写 巡查数据单 相关数据
	//	bhjl.setJltime(RcyhUtils.getDateTimeStr()); // 记录时间
		
		// 获取巡查记录的日期
		xcsj.setXcid(bhjl.getXcid());
		RcyhGlxcsjb rg = xdjlService.queryXdsjByKey(xcsj);
		
		System.out.println(rg.getXsld() + "==========================================");
		
		if( rg != null ) {
			String date = rg.getStime();
			String [] ds = date.split(" ");
			String time = RcyhUtils.getDateTimeStr();
			String [] ts = time.split(" ");
			bhjl.setJltime(ds[0] + " " + ts[1]);
		}
	
		if(bhjl.getLdcode() == null || bhjl.getLdcode().equals("")){
			bhjl.setLdname(rg.getXsld());
		}
		
		
		bhjl.setXcid(getBhjl().getXcid()); // 巡查ID
		bhjl.setJlusername(getUser().getUsername()); // 记录人用户名
		bhjl.setJlryname(getUser().getRyname());
		bhjl.setBmcode(getUser().getBmcode()); // 记录人所在部门
		bhjl.setBmname(getUser().getBmname());
		bhjl.setBhsbzt("0"); //病害上报状态
		bhjl.setBhsbztname(RcyhUtils.ztConvert("bhsbzt","0")); // 回显病害上报状态
		
		return SUCCESS; 
	}
	
	
	public String showBh(){
		bhjl = bhService.queryBhByKey(bhjl.getBhjlid());
		
		bhjl.setJlryname(RcyhUtils.usernameToString(bhjl.getJlusername())); // 设置显示的用户名
		bhjl.setBmname(RcyhUtils.getBmname(bhjl.getBmcode())); //设置用于显示的部门名称
		bhjl.setBhlxname(RcyhUtils.bhlxConvert(bhjl.getBhid())); // 回显病害名称
		bhjl.setBhsbztname(RcyhUtils.ztConvert("bhsbzt", bhjl.getBhsbzt())); // 回显病害上报状态
		bhjl.setLdcode(RcyhUtils.getLdname(bhjl.getLdcode())); // 回显 路段名称
		bhjl.setPos(bhjl.getSzhhkm().intValue() + bhjl.getSzhhm().intValue() / 1000);
		bhjl.setTq(RcyhUtils.mjlxConvert(Constants.fangxiang, bhjl.getTq()));
		
		if(StringUtils.isNotBlank(bhjl.getQlcode())) { // 显示桥梁名称
			bhjl.setQlname(GisUtil.getQlname(bhjl.getQlcode()));
		}
		
		if(StringUtils.isNotBlank(bhjl.getSdcode())) { // 显示隧道名称
			bhjl.setSdname(GisUtil.getSdname(bhjl.getSdcode()));
		}
		
		if(StringUtils.isNotBlank(bhjl.getHdcode())) { // 显示涵洞名称
			bhjl.setHdname(GisUtil.getHdname(bhjl.getHdcode()));
		}
		
		List<ZP> zps = bhjl.getZps();
		if( zps != null ) {
			for( ZP z : zps ) {
				z.setPicUrl(Constants.PicUrl);
			}
		}
		setShow(true);
		setResultpage("addBh");
		return SUCCESS;
	}
	
	/**
	 * 更新病害
	 * @return
	 */
	@AnnotationAuth(mkid="010101")
	public String updateBh(){
		setUpdate(true);
		RcyhBhjlb bh = bhService.queryBhByKey(getBhjl().getBhjlid());
		bh.setBmname(RcyhUtils.getBmname(bh.getBmcode()));
		bh.setJlryname(RcyhUtils.usernameToString(bh.getJlusername()));
		bh.setBhsbztname(RcyhUtils.ztConvert("bhsbzt", bh.getBhsbzt())); // 回显病害上报状态
		
		List<ZP> zps = bh.getZps();
		if( zps != null ) {
			for( ZP zp : zps ) {
				zp.setPicUrl(Constants.PicUrl);
			}
		}
		setBhjl(bh);
		setResultpage("addBh");
		return SUCCESS;
	}
	
	/**
	 * 病害类型combotree
	 */
	public void bhlxCombotree(){
		List<HtglBhlx> bhlxs = bhService.selectBhlxs();
		try {
			JsonUtils.write(bhlxs, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过 bhid 查询 病害的修复时限
	 */
	public void getWxsx(){
		try {
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("wxsx", RcyhUtils.getWxsx(getBhjl().getBhid()));
			JsonUtils.write(map, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 病害记录页面首页
	 * @return
	 */
	public String index(){
		return SUCCESS;
	}
	
	/**
	 * 病害列表
	 */
	public void listBh(){
		try {
			getBhjl().setPage(getPage());
			getBhjl().setRows(getRows());
			List<RcyhBhjlb> rows = null;
			int total = 0;		
			if(isFromPg()) { // 派工页面病害列表
				getBhjl().setSbbmcode(getUser().getBmcode());
				rows =  bhService.listBh(getBhjl());
				total = bhService.listBhCount(getBhjl());
			}
			
			if(isFromXd() || isFromSb() ) { // 从巡道 或者是派工的页面过来的
				getBhjl().setBmcode(getUser().getBmcode());
				rows =  bhService.listBh(getBhjl());
				total = bhService.listBhCount(getBhjl());
			}
			
			if( isFromWx()) { // 从维修详情 的 页面查询病害 
				RcyhWxzyjlb wx = wxService.queryWxzyByKeySimple(getWxzy().getZyid());
				rows =  bhService.listBhByRwdIdWithPage(getPage(),getRows(),wx.getRwdid());
				total = bhService.listBhByRwdIdWithPageCount(wx.getRwdid());
			}
			
			
			for( RcyhBhjlb bh:rows) {
				bh.setBhsbzt(RcyhUtils.ztConvert("bhsbzt", bh.getBhsbzt()));
				bh.setBhwxzt(RcyhUtils.ztConvert("bhwxzt", bh.getBhwxzt()));
				bh.setPgzt(RcyhUtils.ztConvert("pgzt", bh.getPgzt()));
				bh.setBhlxname(RcyhUtils.bhlxConvert(bh.getBhid()));
				bh.setJlusername(RcyhUtils.usernameToString(bh.getJlusername()));
				bh.setPgusename(RcyhUtils.usernameToString(bh.getPgusename()));
				bh.setSbusername(RcyhUtils.usernameToString(bh.getSbusername()));
				bh.setBmcode(RcyhUtils.getBmname(bh.getBmcode()));
				bh.setTq(RcyhUtils.mjlxConvert("03", bh.getTq()));
				bh.setLdname(RcyhUtils.getLdname(bh.getLdcode()));
				bh.setDw(RcyhUtils.getDwByBhid(bh.getBhid()));
				if(bh.getSbbmcode() != null ) {
					bh.setSbbmname(RcyhUtils.getBmname(bh.getSbbmcode()));
				}
			}
			
			EasyUIPage<RcyhBhjlb> epage = new EasyUIPage<RcyhBhjlb>();
			epage.setRows(rows);
			epage.setTotal(total);
			JsonUtils.write(epage, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 病害查询中的病害列表
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void bhcxList() throws IOException, Exception{
		bhjl.setPage(page);
		bhjl.setRows(rows);
		List<RcyhBhjlb> listBh = bhService.bhcxList(bhjl);
		

		for( RcyhBhjlb bh:listBh) {
			bh.setBhsbzt(RcyhUtils.ztConvert("bhsbzt", bh.getBhsbzt()));
			bh.setBhwxzt(RcyhUtils.ztConvert("bhwxzt", bh.getBhwxzt()));
			bh.setPgzt(RcyhUtils.ztConvert("pgzt", bh.getPgzt()));
			bh.setBhlxname(RcyhUtils.bhlxConvert(bh.getBhid()));
			bh.setJlusername(RcyhUtils.usernameToString(bh.getJlusername()));
			bh.setPgusename(RcyhUtils.usernameToString(bh.getPgusename()));
			bh.setSbusername(RcyhUtils.usernameToString(bh.getSbusername()));
			bh.setBmcode(RcyhUtils.getBmname(bh.getBmcode()));
			bh.setTq(RcyhUtils.mjlxConvert("03", bh.getTq()));
			bh.setLdname(RcyhUtils.getLdname(bh.getLdcode()));
			bh.setDw(RcyhUtils.getDwByBhid(bh.getBhid()));
			if( bh.getSbbmcode() != null ) {
				bh.setSbbmname(RcyhUtils.getBmname(bh.getSbbmcode()));
			}
			
		}
		
		int count = bhService.bhcxListCount(bhjl);
		EasyUIPage<RcyhBhjlb> epage = new EasyUIPage<RcyhBhjlb>();
		epage.setRows(listBh);
		epage.setTotal(count);
		JsonUtils.write(epage,getResponse().getWriter());
	}
	
	/**
	 * 删除病害 
	 * 是否可以同时删除多条病害
	 * @return
	 */
	@AnnotationAuth(mkid="010101")
	public void delBh(){
		try {
		  int re = bhService.delBh(getBhjl());
		  if(re > 0 ) {
			  getGmap().put(Constants.ISSUCCESS, true);
			  JsonUtils.write(getGmap(), getResponse().getWriter());
		  }else{
			  getGmap().put(Constants.ISSUCCESS, false);
			  getGmap().put(Constants.INFO, "未知");
			  JsonUtils.write(getGmap(), getResponse().getWriter());
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 保存更新的病害
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@AnnotationAuth(mkid="010101")
	public void saveUpdateBh() throws IOException, Exception{
		int c = bhService.updateBh(getBhjl());
		if( c ==  1 ) {
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.BACK, true);
			gmap.put(Constants.INFO,"更新病害成功");
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO,"更新病害失败");
		}
		JsonUtils.write(gmap, getResponse().getWriter());
		
	}
	
	/**
	 * 删除服务器上 保存的照片
	 */
	public void delPic(){
		try {
			RcyhUtils.removePicFromServer(zp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 病害照片s
	 * @return
	 */
	public String bhzps(){
		RcyhBhjlb bh = bhService.queryBhByKey(getBhjl().getBhjlid());
		List<ZP> bhzps = bh.getZps();
		if( bhzps != null ) {
			for(ZP z:bhzps) {
				z.setPicUrl(Constants.PicUrl);
			}
		}
		setBhjl(bh);
		return SUCCESS;
	}
	
	/**
	 * 病害查询页面
	 * @return
	 */
	public String bhcx(){
		return SUCCESS;
	}

}
