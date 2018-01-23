
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
import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.bean.Ldb;
import com.hdsx.hmglyh.jcpd.bean.Qdhfb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfb;
import com.hdsx.hmglyh.jcpd.dto.HighChart;
import com.hdsx.hmglyh.jcpd.service.QdhfbService;
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
public class QdhfbController extends BaseActionSupport<Qdhfb> {
	private static final long serialVersionUID = -917040259212274774L;
	
	@Resource(name="qdhfbServiceImpl")
	private QdhfbService qdhfbService;
	
	private Qdhfb qdhfb = new Qdhfb();
	private double[] start;
	private double[] end;
	private String qdhfStr = "";
	private String[] jds;
	private String[] gydws;
	
	
	public String[] getGydws() {
		return gydws;
	}
	public void setGydws(String[] gydws) {
		this.gydws = gydws;
	}
	public String[] getJds() {
		return jds;
	}
	public void setJds(String[] jds) {
		this.jds = jds;
	}
	public String getQdhfStr() {
		return qdhfStr;
	}
	public void setQdhfStr(String qdhfStr) {
		this.qdhfStr = qdhfStr;
	}
	public double[] getStart() {
		return start;
	}
	public void setStart(double[] start) {
		this.start = start;
	}
	public double[] getEnd() {
		return end;
	}
	public void setEnd(double[] end) {
		this.end = end;
	}
	public Qdhfb getQdhfb() {
		return qdhfb;
	}
	public void setQdhfb(Qdhfb qdhfb) {
		this.qdhfb = qdhfb;
	}
	/**
	 * 插入区段划分
	 * 描述
	 * @throws Exception
	 */
	public void addQdhfb() throws Exception{
		List<Qdhfb> list = new ArrayList<Qdhfb>();
		if(start == null || start.length == 0){
			qdhfb.setCd((int)(Math.round(qdhfb.getEzhh()*1000)-Math.round(qdhfb.getSzhh()*1000)));
			list.add(qdhfb);
		}
		else{
			for(int i=0 ; i<start.length ; i++){
				Qdhfb q = new Qdhfb();
				q.setBbid(qdhfb.getBbid());
				q.setBmCode(qdhfb.getBmCode());
				q.setSzhh(start[i]);
				q.setEzhh(end[i]);
				q.setLxCode(qdhfb.getLxCode());
				q.setPdbbid(qdhfb.getPdbbid());
				q.setFx(qdhfb.getFx());
				q.setCd((int)(Math.round(1000*q.getEzhh())-Math.round(1000*q.getSzhh())));
				q.setJd(jds[i]);
				q.setGydw(gydws[i]);
				list.add(q);
			}
			if(end[end.length-1]<qdhfb.getEzhh()){
				qdhfb.setSzhh(end[end.length-1]);
				qdhfb.setCd((int)(Math.round(1000*qdhfb.getEzhh())-Math.round(1000*qdhfb.getSzhh())));
				list.add(qdhfb);
			}
		}
		if(qdhfbService.addQdhfb(list) < 0){
			ResponseUtils.write(getResponse(), "false");
		}else{
			ResponseUtils.write(getResponse(), "true");
		}
	}
	
	/**
	 * 清空某一版本某条路段上的区段划分
	 * 条件：路段，版本，单位
	 * @throws Exception
	 */
	public void clearQdhfb() throws Exception{
		if(qdhfbService.dropQdhfb(qdhfb) < 0)
			ResponseUtils.write(getResponse(), "false");
		else
			ResponseUtils.write(getResponse(), "true");
	}
	/**
	 * 查询区段划分的信息
	 * 条件：路段，版本，单位
	 * @throws Exception
	 */
	public void queryQdhfb() throws Exception{
		List<Qdhfb> list = qdhfbService.queryQdhfb(qdhfb);
		int total = qdhfbService.getQdhfbCount(qdhfb);
		EasyUIPage<Qdhfb> ep = new EasyUIPage<Qdhfb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	/**
	 * 区段划分用，获取图表需要的数据
	 * 需要参数：区域的路线编码，起止点桩号，路况评定的版本
	 */
	public void getHighChartData() throws Exception{
		HighChart highChart = qdhfbService.getPciIri(qdhfb);
		JsonUtils.write(highChart, this.getResponse().getWriter());
	}

	/**
	 * 区段划分用，查询版本信息以及区段划分信息
	 * 需要参数：区域的路线编码，起止点桩号，区域区段划分的版本，部门编码
	 * @throws Exception
	 */
	public void getBb() throws Exception{
		Bbkzb bbkzb = qdhfbService.getBb(qdhfb);
		JsonUtils.write(bbkzb, this.getResponse().getWriter());
	}

	
	public String exportQdhf() throws Exception{
		qdhfb.setBmName(new String(qdhfb.getBmName().getBytes("ISO-8859-1"),"UTF-8"));
		List<Ldb> list = qdhfbService.exportQdhf(qdhfb);
		int total = 1;
		for(Ldb ldb:list){
			qdhfStr += "<tr><td>"+total+"</td><td rowspan='"+ldb.getColspan()+"'>"+ldb.getLxCode()+"</td>";
			List<Qyhfb> qyhfList = ldb.getQyhf();
			if(qyhfList.size()==0){
				qdhfStr += "<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
				total++;
			}else{
				for(int i=0 ; i<qyhfList.size() ; i++){
					if(i == 0){
						qdhfStr += "<td rowspan='"+qyhfList.get(i).getColspan()+"'>K"+qyhfList.get(i).getSzhh()+"-K"+qyhfList.get(i).getEzhh()+"</td>";
					}else{
						qdhfStr += "<tr><td>"+total+"</td><td rowspan='"+qyhfList.get(i).getColspan()+"'>K"+qyhfList.get(i).getSzhh()+"-K"+qyhfList.get(i).getEzhh()+"</td>";
					}
					List<Qdhfb> qdhfList = qyhfList.get(i).getQdhfList();
					if(qdhfList.size() == 0){
						qdhfStr += "<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
						total++;
					}else{
						for(int j=0 ; j<qdhfList.size() ; j++){
							if(j==0){
								qdhfStr += "<td>K"+qdhfList.get(j).getSzhh()+"-K"+qdhfList.get(j).getEzhh()+"</td><td>"+qdhfList.get(j).getLength()+"</td>"
										+ "<td>"+qdhfList.get(j).getPci()+"</td><td>"+qdhfList.get(j).getIri()+"</td><td></td><td></td><td></td><td></td></tr>";
							}else{
								qdhfStr += "<tr><td>"+total+"</td><td>K"+qdhfList.get(j).getSzhh()+"-K"+qdhfList.get(j).getEzhh()+"</td><td>"+qdhfList.get(j).getLength()+"</td>"
										+ "<td>"+qdhfList.get(j).getPci()+"</td><td>"+qdhfList.get(j).getIri()+"</td><td></td><td></td><td></td><td></td></tr>";
							}
							total++;
						}
					}
				}
			}
		}
		System.out.println(qdhfStr);
		return SUCCESS;
	}
	/**
	 * 根据路况调查版本,区段划分版本，路线编码，起止桩号获取病害分类统计表内容
	 * @throws Exception
	 */
	public void getBhfl() throws Exception{
		List<Qdhfb> list = qdhfbService.getBhfl(qdhfb);
		JsonUtils.write(list, this.getResponse().getWriter());
	}

	
	@Override
	public Qdhfb getModel() {
		return qdhfb;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
