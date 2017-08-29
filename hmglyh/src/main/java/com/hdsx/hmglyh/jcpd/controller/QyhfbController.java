
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfxxb;
import com.hdsx.hmglyh.jcpd.dto.Result;
import com.hdsx.hmglyh.jcpd.service.QyhfbService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月3日 下午8:29:20 
 */
@Controller
@Scope(value="request")
public class QyhfbController extends BaseActionSupport<Qyhfb> {
	private static final long serialVersionUID = -917040259212274774L;
	
	@Resource(name="qyhfbServiceImpl")
	private QyhfbService qyhfbService;
	
	private double points[];
	private String detail[];

	private Qyhfb qyhfb = new Qyhfb();
	
	private List<Qyhfb> qyhfList = new ArrayList<Qyhfb>();
	
	public String[] getDetail() {
		return detail;
	}
	public void setDetail(String[] detail) {
		this.detail = detail;
	}
	public List<Qyhfb> getQyhfList() {
		return qyhfList;
	}
	public void setQyhfList(List<Qyhfb> qyhfList) {
		this.qyhfList = qyhfList;
	}
	public double[] getPoints() {
		return points;
	}
	public void setPoints(double[] points) {
		this.points = points;
	}
	public Qyhfb getQyhfb() {
		return qyhfb;
	}
	public void setQyhfb(Qyhfb qyhfb) {
		this.qyhfb = qyhfb;
	}
	/**
	 * 插入区域划分
	 * 描述
	 * @throws Exception
	 */
	public void addQyhfb() throws Exception{
		double szhh = qyhfb.getSzhh();
		double ezhh = qyhfb.getEzhh();
		List<Qyhfb> list = new ArrayList<Qyhfb>();
		if(points == null || points.length == 0){
			Qyhfb q = new Qyhfb();
			q.setLxCode(qyhfb.getLxCode());
			q.setBmCode(qyhfb.getBmCode());
			q.setSzhh(szhh);
			q.setEzhh(ezhh);
			q.setCd((int)(Math.round(1000*ezhh)-Math.round(1000*szhh)));
			q.setBbid(qyhfb.getBbid());
			list.add(q);
		}else{
			Arrays.sort(points);
			for(int i=0;i<=points.length;i++){
				Qyhfb q = new Qyhfb();
				q.setLxCode(qyhfb.getLxCode());
				q.setBmCode(qyhfb.getBmCode());
				q.setBbid(qyhfb.getBbid());
				if(i==0){
					if(szhh<points[i]){
						q.setSzhh(szhh);
						q.setEzhh(points[i]);
						q.setCd((int)(Math.round(1000*points[i])-Math.round(1000*szhh)));
						list.add(q);
					}
				}else if(i == points.length){
					if(ezhh>points[i-1]){
						q.setSzhh(points[i-1]);
						q.setEzhh(ezhh);
						q.setCd((int)(Math.round(ezhh*1000)-Math.round(points[i-1]*1000)));
						list.add(q);
					}
				}else{
					if(points[i]>points[i-1]){
						q.setSzhh(points[i-1]);
						q.setEzhh(points[i]);
						q.setCd((int)(Math.round(points[i]*1000)-Math.round(points[i-1]*1000)));
						list.add(q);
					}
				}
			}
		}
		
		if(qyhfbService.addQyhfb(list)>0)
			ResponseUtils.write(getResponse(), "true");
		else
			ResponseUtils.write(getResponse(), "false");
	}
	/**
	 * 插入区划划分表以及详细表
	 * @throws Exception
	 */
	public void addQyhfbDetail() throws Exception{
		List<Qyhfxxb> xxbList = new ArrayList<Qyhfxxb>();
		List<Qyhfb> hfbList = new ArrayList<Qyhfb>();
		double[] szhhList = new double[detail.length+1];
		for(int i=0;i<detail.length;i++){
			String[] details = detail[i].split("-");	
			Qyhfxxb q = new Qyhfxxb();
			q.setLxCode(qyhfb.getLxCode());
			q.setBmCode(qyhfb.getBmCode());
			q.setBbid(qyhfb.getBbid());
			q.setSzhh(Double.parseDouble(details[0]));
			q.setEzhh(Double.parseDouble(details[1]));
			q.setYxys(details[2]);
			q.setDj(details[3]);
			szhhList[i] = Double.parseDouble(details[1]);
			xxbList.add(q);
		}
		szhhList[detail.length] = qyhfb.getSzhh();
		
		Arrays.sort(szhhList);
		for(int i=1;i<szhhList.length;i++){
			Qyhfb q = new Qyhfb();
			q.setLxCode(qyhfb.getLxCode());
			q.setBmCode(qyhfb.getBmCode());
			q.setBbid(qyhfb.getBbid());
			if(szhhList[i]>szhhList[i-1]){
				q.setSzhh(szhhList[i-1]);
				q.setEzhh(szhhList[i]);
				q.setCd((int)(Math.round(szhhList[i]*1000)-Math.round(szhhList[i-1]*1000)));
				hfbList.add(q);
			}
		}
		
		if(qyhfbService.addQyhfXxb(hfbList,xxbList))
			ResponseUtils.write(getResponse(), "true");
		else
			ResponseUtils.write(getResponse(), "false");
	}
	/**
	 * 清空某一版本某条路段上的区域划分
	 * 条件：路段，版本，单位
	 * @throws Exception
	 */
	public void clearQyhfb() throws Exception{
		Result r = new Result();
		r.setResult(qyhfbService.dropQyhfb(qyhfb));
		JsonUtils.write(r, this.getResponse().getWriter());
	}
	/**
	 * 查询区域划分的信息
	 * 条件：路段，版本，单位
	 * @throws Exception
	 */
	public void queryQyhfb() throws Exception{
		List<Qyhfb> list = qyhfbService.queryQyhfb(qyhfb);
		int total = qyhfbService.getQyhfbCount(qyhfb);
		EasyUIPage<Qyhfb> ep = new EasyUIPage<Qyhfb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}

	/**
	 * 区域划分是否已被使用
	 * @throws Exception
	 */
	public void isUsed() throws Exception{
		if(qyhfbService.isUsed(qyhfb))
			ResponseUtils.write(getResponse(), "true");
		else
			ResponseUtils.write(getResponse(), "false");
	}
	/**
	 * 导出区域划分
	 * @return
	 * @throws Exception
	 */
	public String exportQyhf() throws Exception{
		qyhfb.setBmName(new String(qyhfb.getBmName().getBytes("ISO-8859-1"),"UTF-8"));
		qyhfList = qyhfbService.exportQyhfb(qyhfb);
		return SUCCESS;
	}
	/**
	 * 查询之前在该路段有划分的区域划分版本
	 * @throws Exception
	 */
	public void getQybb() throws Exception{
		List<Bbkzb> list = qyhfbService.getQybb(qyhfb);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	/**
	 * 沿用之前版本添加区域划分
	 * @throws Exception
	 */
	public void copy() throws Exception{
		qyhfbService.copy(qyhfb);
		ResponseUtils.write(getResponse(), "true");
	}
	/**
	 * 获取需要更新的区域划分详细信息
	 * @throws Exception
	 */
	public void getXxbForUpdate() throws Exception{
		List<Qyhfxxb> list = qyhfbService.getXxbForUpdate(qyhfb);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	@Override
	public Qyhfb getModel() {
		return qyhfb;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
