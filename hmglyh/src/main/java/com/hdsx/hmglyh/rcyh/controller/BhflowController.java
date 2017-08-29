package com.hdsx.hmglyh.rcyh.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhYdjhshb;
import com.hdsx.hmglyh.rcyh.service.BhflowService;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;
import com.hdsx.hmglyh.rcyh.service.WxzyService;
import com.hdsx.hmglyh.rcyh.service.YdjhshService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Constants;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="request")
public class BhflowController extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1332424025287574221L;

	
	private String definitionKey; // 流程定义Key
	
	@Autowired
	private BhflowService bhflowService;
	@Autowired
	private WxzyService wxzyService;
	@Autowired
	private WorkFlowService wfService;
	@Autowired
	private YdjhshService ydshService;
	
	
	public String getDefinitionKey() {
		return definitionKey;
	}

	public void setDefinitionKey(String definitionKey) {
		this.definitionKey = definitionKey;
	}
	
	/**
	 * 得到 流程图片 ， 默认得到 最新版本
	 */
	public void getProcessPic(){
		try {
			InputStream is = wfService.getProcessPic(definitionKey);
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("image/png");
			OutputStream os = resp.getOutputStream();
			RcyhUtils.writePic(is, os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	public String showProcess(){
		ActivityImpl ai = wfService.getProcessMap(getBhjl().getBhjlid(),definitionKey);
		if(ai != null) {
			getGmap().put(Constants.ISSUCCESS,true);
			getGmap().put("x", ai.getX());
			getGmap().put("y", ai.getY());
			getGmap().put("width", ai.getWidth());
			getGmap().put("height", ai.getHeight());
		}else{
			getGmap().put(Constants.ISSUCCESS,false);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 保存 病害 
	 * 成功返回到了病害列表的页面
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@AnnotationAuth(mkid="010101")
	public void saveBh() throws IOException, Exception{
		
		int c= bhflowService.saveBh(getBhjl());	
		if( c ==  1 ) {
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.BACK, true);
			gmap.put(Constants.INFO,"保存病害成功");
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO,"保存病害失败");
		}
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	
	/**
	 * 确认上报病害
	 * @throws Exception 
	 * @throws IOException 
	 */
	@AnnotationAuth(mkid="010102")
	public void sbBH() throws IOException, Exception{
		
		for( RcyhBhjlb bh: getBhjls() ) {
			bh.setSbbmcode(getBhjl().getSbbmcode());
			bh.setBhsbzt(getBhjl().getBhsbzt());
			bh.setSbusername(getUser().getUsername());
			bhflowService.shangbaoBh(bh);
		}
		String info = "";
		if("1".equals(getBhjl().getBhsbzt())){
			info = "确认上报操作成功";
		}else{
			info = "您已取消上报";
		}
		
		getGmap().put(Constants.ISSUCCESS, true);
		getGmap().put(Constants.INFO,info);
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	/**
	 * 病害上报页面
	 * @return
	 */
	@AnnotationAuth(mkid="010102")
	public String shangbao(){
		getBhjl().setSbtime(RcyhUtils.getDateTimeStr());
		return SUCCESS;
	}
	
	/**
	 * 任务派工首页
	 */
	@AnnotationAuth(mkid="010103")
	public String addRwd(){
		
		rwd.setCjusername(getUser().getUsername()); // 回显创建用户名
		rwd.setCjryname(getUser().getRyname()); // 回显创建人员名称
		rwd.setRwdlx(Constants.XundaoRwd);
		rwd.setRwdlxname("巡道");
		rwd.setRwdztname("未维修");
		rwd.setRwdzt(Constants.RwdWwx);
		
		if(isPg2th) {
			gmap.put("continue",true);
		}
		RcyhUtils.initRwd(rwd,gmap,bhjls);
		
		// 如果是admin 默认的 受委派部门应该是 交安设施
		if( getUser().getBmcode().length() == 4 ) {
			rwd.setBmcode("010105");
		}
		
		setAdd(true);
		return SUCCESS;
	}
	
	/**
	 * 修改任务单
	 * @return
	 */
	public String editRwd(){
		rwd = wxzyService.selectByPrimaryKeyWithClxh(rwd.getRwdid());
		rwd.setCjryname(RcyhUtils.usernameToString(rwd.getCjusername()));
		String rwdlxname = RcyhUtils.mjlxConvert(Constants.rwdlx, rwd.getRwdlx());
		rwd.setRwdlxname(rwdlxname);
		rwd.setRwdztname(RcyhUtils.ztConvert("rwdzt", rwd.getRwdzt()));
		rwd.setYhlxname(RcyhUtils.getYhlxName(rwd.getYhid()));
		rwd.setDejs(RcyhUtils.getDejs(rwd.getYhid()));
		rwd.setRgdj(RcyhUtils.getRgfdj(rwd.getBmcode()));
		// 如果是admin 默认的 受委派部门应该是 交安设施
		if( getUser().getBmcode().length() == 4 ) {
			rwd.setBmcode("010105");
		}
		setResultpage("addRwd");
		setUpdate(true);
		return SUCCESS;
	}
	
	public void saveEditRwd() throws IOException, Exception{
		int c = bhflowService.saveEditRwd(rwd);
		if( c > 0 ) {
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.INFO, "任务单已经修改成功");
			JsonUtils.write(gmap, getResponse().getWriter());
		}
	}
	
	/**
	 * 任务派工首页
	 */
	@AnnotationAuth(mkid="010103")
	public String addBfysRwd(){
		
			getRwd().setCjryname(getUser().getRyname()); // 创建人
			getRwd().setCjusername(getUser().getUsername()); //创建用户名
			getRwd().setCjtime(RcyhUtils.getDateTimeStr()); // 创建时间
			getRwd().setSsny(RcyhUtils.getSsny(1)); // 获取下一个月的所属年月
			if( getUser().getBmcode().length() == 4 ) {
				rwd.setBmcode("010105");
			}else{
				rwd.setBmcode(zyys.getBmcode());
			}
			// 设置桩号范围
			//String zhStr = getZyys().getLdzh();
			/*if(zhStr != null ) {
				String [] zhStrs = zhStr.split("-");
				Double[] zhDoubles =new  Double[2];
				for( int  i = 0 ; i < zhDoubles.length ; i++) {
					Double.c
					zhDoubles[i] = Double.parseDouble(zhStrs[i]);
				}
				getRwd().setSzhhkm(zhDoubles[0].intValue());
				getRwd().setSzhhm((int)((zhDoubles[0] - Math.floor(zhDoubles[0])) * 1000));
				getRwd().setEzhhkm(zhDoubles[1].intValue());
				getRwd().setEzhhm((int)((zhDoubles[1] - Math.floor(zhDoubles[1])) * 1000));
			}*/
			
		/*	getRwd().setSzhhkm(zyys.getSzhhkm());
			getRwd().setSzhhm(zyys.getSzhhm());
			getRwd().setEzhhkm(zyys.getEzhhkm());
			getRwd().setEzhhm(zyys.getEzhhm());*/
			
			getRwd().setLdname(RcyhUtils.getLdname(getZyys().getLdcode()));
			getRwd().setLdcode(getZyys().getLdcode());
			getRwd().setYhid(getZyys().getYhid());
			getRwd().setRwdzt("0");
			getRwd().setRwdlx(Constants.BuchongRwd);
			getRwd().setDejs(RcyhUtils.getDejs(zyys.getYhid()));
			getRwd().setRgdj(RcyhUtils.getRgfdj(zyys.getBmcode()));
			getRwd().setGrde(RcyhUtils.getGrde(zyys.getYhid(),zyys.getBmcode()));
			getRwd().setRwdlxname("补充");
			getRwd().setSl(zyys.getYssl() - zyys.getHgsl());
			// 如果是admin 默认的 受委派部门应该是 交安设施
			if( getUser().getBmcode().length() == 4 ) {
				rwd.setBmcode("010105");
			}
			setResultpage("addRwd");
			setAdd(true);
			return SUCCESS;
	}
	
	/*@Test
	public void mytest(){
		Double a = 333.55;
		System.out.println((int)((a - Math.floor(a)) * 1000));
	}*/
	
	@AnnotationAuth(mkid="0102")
	public String addYdjhRwd(){
			getRwd().setCjryname(getUser().getRyname()); // 创建人
			getRwd().setCjusername(getUser().getUsername()); //创建用户名
			getRwd().setCjtime(RcyhUtils.getDateTimeStr()); // 创建时间
			getRwd().setSsny(RcyhUtils.getSsny()); // 获取下一个月的所属年月
			getRwd().setLdcode(getZyys().getLdcode());
			getRwd().setYhid(getZyys().getYhid());
			getRwd().setRwdzt(Constants.RwdWwx);
			getRwd().setRwdlx(Constants.JihuaRwd);
			getRwd().setRwdztname("未维修");
			getRwd().setRwdlxname("计划");
			// 如果是admin 默认的 受委派部门应该是 交安设施
			if( getUser().getBmcode().length() == 4 ) {
				rwd.setBmcode("010105");
			}
			setFromYdjh(true);
			setAdd(true);
			setResultpage("addRwd");
			return SUCCESS;
	}
	
	/**
	 * 显示任务单
	 * @return
	 */
	public String showRwd(){
		setShow(true);
		setResultpage("addRwd");
		rwd = wxzyService.selectByPrimaryKeyWithClxh(rwd.getRwdid());
		rwd.setCjryname(RcyhUtils.usernameToString(rwd.getCjusername())); // 回显创建人用户名
		rwd.setBmname(RcyhUtils.getBmname(rwd.getBmcode())); //回显受委派部门名称
		rwd.setYhlxname(RcyhUtils.getYhlxName(rwd.getYhid())); //回显养护类型名称
		rwd.setTq(RcyhUtils.mjlxConvert(Constants.fangxiang, rwd.getTq())); // 回显天气
		rwd.setLdname(RcyhUtils.getLdname(rwd.getLdcode())); // 回显 路段
		rwd.setBhid(RcyhUtils.bhlxConvert(rwd.getBhid()));
		String rwdlxname = RcyhUtils.mjlxConvert(Constants.rwdlx, rwd.getRwdlx());
		rwd.setRwdlxname(rwdlxname);
		rwd.setRwdztname(RcyhUtils.ztConvert("rwdzt", rwd.getRwdzt()));
		return SUCCESS;
	}
	
	/**
	 * 保存 派工的 结果
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void saveRwd() throws IOException, Exception{
	
		// 月度计划
		if(rwd.isFromYdjh()) {
					if(StringUtils.isNotBlank(rwd.getBmcode())
					  && StringUtils.isNotBlank(rwd.getLdcode())
					  && StringUtils.isNotBlank(rwd.getSsny())
					){
				
				// 判断是否是打回修改的
				RcyhYdjhshb yd = ydshService.queryYhjhshByCondition(rwd.getBmcode(), rwd.getLdcode(), rwd.getSsny());
				
				if(yd != null && yd.getShzt() == 1 ) { // 
					gmap.put(Constants.ISSUCCESS, false);
					gmap.put(Constants.INFO, rwd.getSsny() + "在"+RcyhUtils.getLdname(rwd.getLdcode())+"上已提交过审核申请,且已经通过");
					JsonUtils.write(gmap, getResponse().getWriter());
					return;
				}
				if(yd != null && yd.getShzt() == 0 ) {
					gmap.put(Constants.ISSUCCESS, false);
					gmap.put(Constants.INFO, rwd.getSsny() + "在"+RcyhUtils.getLdname(rwd.getLdcode())+"已提交过审核申请,正在审核中");
					JsonUtils.write(gmap, getResponse().getWriter());
					return;
				}
			}else{
				gmap.put(Constants.ISSUCCESS, false);
				gmap.put(Constants.INFO, "参数错误");
				JsonUtils.write(gmap, getResponse().getWriter());
			}
		}
		
		/*
		 * 	当病害上报后，后分局人员或养护管理科对病害进行派工操作，
		 *  派工的结果分为任务派工、取消派工、延期派工、打回修改等，
		 *  可选择多条病害进行批量操作
		 */
		getRwd().setBhjls(getBhjls());

		if(StringUtils.isBlank(rwd.getRwbh())) {
			rwd.setRwbh(RcyhUtils.createRWDBH());
		}
		
		int res = bhflowService.savepg(getRwd());
		gmap.clear();
		gmap.put(Constants.ISSUCCESS, true);
		if( res == 1 ) {
			gmap.put("rwd", true);
			gmap.put(Constants.INFO, "派工成功");
			gmap.put("rwbh", rwd.getRwbh());
			if(bufenYs){
				gmap.put("bufenYs", true);
			}
			if(fromYdjh){
				gmap.put("fromYdjh", true);
				gmap.put(Constants.INFO, "添加成功");
			}
		}else if( res == 2 ) {
			gmap.put(Constants.INFO, "延期派工成功");
		}else if( res == 3 ) {
			gmap.put(Constants.INFO, "取消派工成功");
		}else if( res == 4 ) {
			gmap.put(Constants.INFO, "打回修改操作成功");
		}else{
			gmap.put(Constants.INFO, "未知原因");
		}
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	
	
	public void delRwd() throws IOException, Exception{
		
		int c = bhflowService.delRwd(rwd.getRwdid());
		
		if( c == 0 ) {
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO, "该任务已经完成无法删除");
		}else if( c == 1 ){
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.INFO,"任务单删除成功");
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO, "删除失败，原因：未知原因");
		}
		
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	@Deprecated
	public String savepg2(){
		getRwd().setBhjls(getBhjls());
		int res = bhflowService.savepg(getRwd());
		if( res == 1  ) {
			setResultpage("renwupg");
			RcyhUtils.initRwd(getRwd(),getGmap(),getBhjls());
			getGmap().put(Constants.INFO, "派工成功");
			getGmap().put("rPageName", "继续派工");
			getGmap().put("stayPage",null);
			return SUCCESS;
		}else if( res == 2){
			getGmap().put(Constants.INFO, "延期派工操作成功");
			return succ;
		}else if( res == 3 ) {
			getGmap().put(Constants.INFO, "取消派工操作成功");
			return succ;
		}else if( res == 4 ) {
			getGmap().put(Constants.INFO, "打回修改操作成功");
			return succ;
		}else {
			getGmap().put(Constants.INFO, "未知原因异常");
			return exception;
		}
	
	}
}
