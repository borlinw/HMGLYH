package com.hdsx.hmglyh.rcyh.controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhYdjhshb;
import com.hdsx.hmglyh.rcyh.service.YdjhshService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.Constants;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="request")
public class YdjhshController extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RcyhYdjhshb ydjhsh = new RcyhYdjhshb();
	
	@Autowired
	YdjhshService ydshService;
	
	public RcyhYdjhshb getYdjhsh() {
		return ydjhsh;
	}

	public void setYdjhsh(RcyhYdjhshb ydjhsh) {
		this.ydjhsh = ydjhsh;
	}



	/**
	 * 提交审核申请
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void tijiaoShenhe() throws IOException, Exception{
		
		ydjhsh.setSsny(new String(ydjhsh.getSsny().getBytes("ISO-8859-1"),"UTF-8"));
		
		if(StringUtils.isNoneBlank(ydjhsh.getBmcode())
			&& StringUtils.isNoneBlank(ydjhsh.getLdcode())
			&& StringUtils.isNoneBlank(ydjhsh.getSsny())) {
			if(ydshService.canTijiaosh(ydjhsh.getBmcode(),ydjhsh.getLdcode(),ydjhsh.getSsny())){
				
				ydjhsh.setSqr(getUser().getUsername()); //申请人
				ydjhsh.setSqsj(RcyhUtils.getDateTimeStr()); //申请时间
				ydjhsh.setShzt((short)0); //设置状态为审核中
				
				int c = ydshService.tijiaoShenhe(ydjhsh);
				if( c > 0 ){
					gmap.put(Constants.ISSUCCESS, true);
					gmap.put(Constants.INFO, "提交审核申请成功");
					JsonUtils.write(gmap, getResponse().getWriter());
				}
				
			}else{
				
				// 判断是否是打回修改的
				RcyhYdjhshb yd = ydshService.queryYhjhshByCondition(ydjhsh.getBmcode(), ydjhsh.getLdcode(), ydjhsh.getSsny());
				
				if(yd.getShzt() == 1 ) { // 
				
					gmap.put(Constants.ISSUCCESS, false);
					gmap.put(Constants.INFO, ydjhsh.getSsny() + "在该路段上已提交过审核申请");
					JsonUtils.write(gmap, getResponse().getWriter());
			
				}else if(yd.getShzt() == 2 ){ // 打回修改
					
					ydjhsh.setSqr(getUser().getUsername()); //申请人
					ydjhsh.setSqsj(RcyhUtils.getDateTimeStr()); //申请时间
					ydjhsh.setShzt((short)0); //设置状态为审核中
					
					int c = ydshService.shenhe(ydjhsh);
					if( c > 0 ){
						gmap.put(Constants.ISSUCCESS, true);
						gmap.put(Constants.INFO, "重新提交审核申请成功");
						JsonUtils.write(gmap, getResponse().getWriter());
					}
				}else if(yd.getShzt() == 0 ) {
					gmap.put(Constants.ISSUCCESS, false);
					gmap.put(Constants.INFO, ydjhsh.getSsny() + "在该路段上已提交过审核申请");
					JsonUtils.write(gmap, getResponse().getWriter());
				}
			}
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO, "参数有误");
			JsonUtils.write(gmap, getResponse().getWriter());
		}
	}
	
	/**
	 * 审核月度计划
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void shenhe() throws IOException, Exception{
	
		if(StringUtils.isNotBlank(ydjhsh.getBmcode())
		  && StringUtils.isNotBlank(ydjhsh.getLdcode())
		  && StringUtils.isNotBlank(ydjhsh.getSsny())
		  && ydjhsh.getShzt() != null 
		){
			
			ydjhsh.setShrr(getUser().getUsername());
			ydjhsh.setShsj(RcyhUtils.getDateTimeStr()); // 审核时间
			ydjhsh.setSsny(new String(ydjhsh.getSsny().getBytes("ISO-8859-1"),"UTF-8"));
			
			int c = ydshService.shenhe(ydjhsh);
			if( c > 0 ){
				gmap.put(Constants.ISSUCCESS, true);
				gmap.put(Constants.INFO, "审核操作成功");
				JsonUtils.write(gmap, getResponse().getWriter());
			}else{
				gmap.put(Constants.ISSUCCESS, false);
				gmap.put(Constants.INFO, "更新数目小于0");
				JsonUtils.write(gmap, getResponse().getWriter());
			}
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO, "参数错误");
			JsonUtils.write(gmap, getResponse().getWriter());
		}
		
	}
	
	public void canAddYdjh() throws IOException, Exception{
		if(StringUtils.isNotBlank(ydjhsh.getBmcode())
				  && StringUtils.isNotBlank(ydjhsh.getLdcode())
				  && StringUtils.isNotBlank(ydjhsh.getSsny())
				  && ydjhsh.getShzt() != null 
				){
			
			// 判断是否是打回修改的
			RcyhYdjhshb yd = ydshService.queryYhjhshByCondition(ydjhsh.getBmcode(), ydjhsh.getLdcode(), ydjhsh.getSsny());
			
			if(yd.getShzt() == 1 ) { // 
			
				gmap.put(Constants.ISSUCCESS, false);
				gmap.put(Constants.INFO, ydjhsh.getSsny() + "在该路段上已提交过审核申请");
				JsonUtils.write(gmap, getResponse().getWriter());
		
			}else if(yd.getShzt() == 2 ){ // 打回修改
					gmap.put(Constants.ISSUCCESS, true);
					gmap.put(Constants.INFO, "重新提交审核申请成功");
					JsonUtils.write(gmap, getResponse().getWriter());
			}else if(yd.getShzt() == 0 ) {
				gmap.put(Constants.ISSUCCESS, false);
				gmap.put(Constants.INFO, ydjhsh.getSsny() + "在该路段上已提交过审核申请");
				JsonUtils.write(gmap, getResponse().getWriter());
			}else{
				gmap.put(Constants.ISSUCCESS, true);
				JsonUtils.write(gmap, getResponse().getWriter());
			}
			
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO, "参数错误");
			JsonUtils.write(gmap, getResponse().getWriter());
		}
	}
	
	public String ydjhsh(){
		return SUCCESS;
	}
	
}
