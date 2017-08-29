/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.basicData.bean.GpsRoad;
import com.hdsx.hmglyh.basicData.service.GpsRoadService;
import com.hdsx.hmglyh.jcpd.bean.Qmldb;
import com.hdsx.hmglyh.jcpd.dto.Result;
import com.hdsx.hmglyh.jcpd.service.QmldbService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月28日 下午8:38:42 
 */
@Controller
@Scope(value="request")
public class QmldbController extends BaseActionSupport<Qmldb> {
	private static final long serialVersionUID = -2981070644899382759L;
	@Resource(name="qmldbServiceImpl")
	private QmldbService qmldbService;
	@Resource(name="gpsRoadServiceImpl")
	private GpsRoadService gpsRoadService;
	
	private Qmldb qmldb = new Qmldb();
	private List<Qmldb> mxbList = new ArrayList<Qmldb>();
	private List<Qmldb> qmldList = new ArrayList<Qmldb>();
	
	
	public List<Qmldb> getQmldList() {
		return qmldList;
	}

	public void setQmldList(List<Qmldb> qmldList) {
		this.qmldList = qmldList;
	}

	public List<Qmldb> getMxbList() {
		return mxbList;
	}

	public void setMxbList(List<Qmldb> mxbList) {
		this.mxbList = mxbList;
	}

	public Qmldb getQmldb() {
		return qmldb;
	}

	public void setQmldb(Qmldb qmldb) {
		this.qmldb = qmldb;
	}
	/**
	 * 生成千米路段
	 * 返回值：1、生成成功，0、生成失败，-1、千米路段已经被使用，不能重新生成
	 * @throws Exception
	 */
	public void createQmldb() throws Exception{
		int msg = 0;
		try {
			List<GpsRoad> list = gpsRoadService.getAllLd();
			boolean result = qmldbService.createQmld(list, qmldb.getBbid());
			if(result)
				msg = 1;
			else
				msg = -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Result r = new Result();
		r.setResult(msg);
		JsonUtils.write(r, this.getResponse().getWriter());
	}
	/**
	 * 查询千米路段
	 */
	public void getQmld() throws Exception{
		System.out.println("Controller===="+qmldb);
		List<Qmldb> list = qmldbService.getQmld(qmldb);
		int total = qmldbService.getQmldCount(qmldb);
		EasyUIPage<Qmldb> ep = new EasyUIPage<Qmldb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	/**
	 * 清空千米路段
	 * 返回值：-2、清空数据失败，-1、千米数据已经被使用，不能清空，0、没有数据需要清空，>1清空成功
	 */
	public void dropQmld() throws Exception{
		int result = -2;
		try {
			result = qmldbService.dropQmld(qmldb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Result r = new Result();
		r.setResult(result);
		JsonUtils.write(r, this.getResponse().getWriter());
	}
	/**
	 * 
	 * 路况调查用，查询千米路段及其对应的路况调查主表
	 */
	public void getQmldForLkdc() throws Exception{
		List<Qmldb> list = qmldbService.getQmldForLkdc(qmldb);
		int total = qmldbService.getQmldCountForLkdc(qmldb);
		EasyUIPage<Qmldb> ep = new EasyUIPage<Qmldb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	
	/**
	 * 生成路况评定明细表
	 */
	public void createMxb() throws Exception{
		try {
			qmldbService.createMxb(qmldb);
			ResponseUtils.write(getResponse(), "true");
		} catch (Exception e) {
			e.printStackTrace();
			ResponseUtils.write(getResponse(), "false");
		}
	}
	/**
	 * 查询路况评定明细
	 */
	public void getMxb() throws Exception{
		List<Qmldb> list = qmldbService.queryMxb(qmldb);
		int total = qmldbService.getMxbCount(qmldb);
		EasyUIPage<Qmldb> ep = new EasyUIPage<Qmldb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	
	/**
	 * 查询路况评定明细表用于导出
	 */
	public String exportMxb() throws Exception{
		qmldb.setFxName(new String(qmldb.getFxName().getBytes("ISO-8859-1"),"UTF-8"));
		System.out.println(qmldb.getFxName()+"=================================================="+qmldb.getIsgs());
		mxbList = qmldbService.queryMxb(qmldb);
		qmldb.setMxbList(mxbList);
		return SUCCESS;
	}
	
	/**
	 * 查询统计路面类型
	 */
	public void getLmlx() throws Exception{
		List<Qmldb> list = qmldbService.getLmlx(qmldb);
		JsonUtils.write(list,this.getResponse().getWriter());
	}
	
	/**
	 * 查询统计技术等级
	 */
	public void getJsdj() throws Exception{
		List<Qmldb> list = qmldbService.getJsdj(qmldb);
		JsonUtils.write(list,this.getResponse().getWriter());
	}
	
	public String getLmdcForExport() throws Exception{
		qmldb.setFxName(new String(qmldb.getFxName().getBytes("ISO-8859-1"),"UTF-8"));
		qmldList = qmldbService.getLmdcForExport(qmldb);
		switch(qmldb.getLmlx()){
		case 1: return "lqlm";
		case 2: return "snlm";
		default : return "sslm";
		}
//		JsonUtils.write(qmldList, this.getResponse().getWriter());
	}
	
	public String getLjdcForExport() throws Exception{
		qmldb.setFxName(new String(qmldb.getFxName().getBytes("ISO-8859-1"),"UTF-8"));
		qmldList = qmldbService.getLjdcForExport(qmldb);
		return SUCCESS;
	}
	
	public String getQshdcForExport() throws Exception{
		qmldb.setFxName(new String(qmldb.getFxName().getBytes("ISO-8859-1"),"UTF-8"));
		qmldList = qmldbService.getQshdcForExport(qmldb);
		return SUCCESS;
	}
	
	public String getYxssdcForExport() throws Exception{
		qmldb.setFxName(new String(qmldb.getFxName().getBytes("ISO-8859-1"),"UTF-8"));
		qmldList = qmldbService.getYxssdcForExport(qmldb);
		return SUCCESS;
	}
	/**
	 * 区段划分用，各区段病害分类统计
	 * 参数：lxCode,szhh,ezhh,dcbbid
	 * @throws Exception
	 */
	public void getBhfltj() throws Exception{
		List<Qmldb> bhfltj = qmldbService.getBhfltj(qmldb);
		JsonUtils.write(bhfltj,this.getResponse().getWriter());
	}
	
	
	
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Qmldb getModel() {
		return qmldb;
	}
	
}
