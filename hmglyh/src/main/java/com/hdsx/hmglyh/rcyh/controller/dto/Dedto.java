package com.hdsx.hmglyh.rcyh.controller.dto;

import java.util.List;

import com.hdsx.hmglyh.rcyh.dao.model.HtglGljlxb;

public class Dedto {
	
	private String dw;	// 派工数量
	private Double grde; // 工日定额
	private Double rgdj; // 人工单价
	private Double clfTotal;
	private Double jxfTotal;
	private Double dejs; // 定额基数
	private Double dj; //养护类型单价
	
	private List<HtglGljlxb> gljs;
	private List<HtglGljlxb> cls;
	private List<HtglGljlxb> jxs;
		
	public Double getDj() {
		return dj;
	}
	public void setDj(Double dj) {
		this.dj = dj;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public Double getGrde() {
		return grde;
	}
	public void setGrde(Double grde) {
		this.grde = grde;
	}
	public Double getRgdj() {
		return rgdj;
	}
	public void setRgdj(Double rgdj) {
		this.rgdj = rgdj;
	}
	public Double getClfTotal() {
		return clfTotal;
	}
	public void setClfTotal(Double clfTotal) {
		this.clfTotal = clfTotal;
	}
	public Double getJxfTotal() {
		return jxfTotal;
	}
	public void setJxfTotal(Double jxfTotal) {
		this.jxfTotal = jxfTotal;
	}
	public Double getDejs() {
		return dejs;
	}
	public void setDejs(Double dejs) {
		this.dejs = dejs;
	}
	public List<HtglGljlxb> getGljs() {
		return gljs;
	}
	public void setGljs(List<HtglGljlxb> gljs) {
		this.gljs = gljs;
	}
	public List<HtglGljlxb> getCls() {
		return cls;
	}
	public void setCls(List<HtglGljlxb> cls) {
		this.cls = cls;
	}
	public List<HtglGljlxb> getJxs() {
		return jxs;
	}
	public void setJxs(List<HtglGljlxb> jxs) {
		this.jxs = jxs;
	}
	
 }
