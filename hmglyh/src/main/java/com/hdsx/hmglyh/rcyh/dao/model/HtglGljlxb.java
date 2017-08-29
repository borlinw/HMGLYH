package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class HtglGljlxb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String lxid;

	private String lxname;

	private String gg;

	private String dw;

	private String bz;

	private BigDecimal px;

	private Short qyzt;

	// 非 持久化 字段

	private String text;

	private String id;
	
	private Double dj;
	
	private String bm;
	
	private Double sl;
	

	public Double getDj() {
		return dj;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}


	public Double getSl() {
		return sl;
	}

	public void setSl(Double sl) {
		this.sl = sl;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}



	private boolean checkbox = true;

	private HashMap<String, Object> attributes = new HashMap<String, Object>();

	private List<HtglGljlxb> children;

	public boolean isCheckbox() {
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	public List<HtglGljlxb> getChildren() {

		return children;

	}

	public void setChildren(List<HtglGljlxb> children) {

		this.children = children;

	}

	public String getText() {

		return text;

	}

	public void setText(String text) {

		this.text = text;

	}

	public String getId() {

		return id;

	}

	public void setId(String id) {

		this.id = id;

	}

	public HashMap<String, Object> getAttributes() {

		this.attributes.put("gg", this.gg);

		this.attributes.put("dw", this.dw);

		return attributes;

	}

	public void setAttributes(HashMap<String, Object> attributes) {

		this.attributes = attributes;

	}

	public String getLxid() {

		return lxid;

	}

	public void setLxid(String lxid) {

		this.lxid = lxid == null ? null : lxid.trim();

	}

	public String getLxname() {

		return lxname;

	}

	public void setLxname(String lxname) {

		this.lxname = lxname == null ? null : lxname.trim();

	}

	public String getGg() {

		return gg;

	}

	public void setGg(String gg) {

		this.gg = gg == null ? null : gg.trim();

	}

	public String getDw() {

		return dw;

	}

	public void setDw(String dw) {

		this.dw = dw == null ? null : dw.trim();

	}

	public String getBz() {

		return bz;

	}

	public void setBz(String bz) {

		this.bz = bz == null ? null : bz.trim();

	}

	public BigDecimal getPx() {

		return px;

	}

	public void setPx(BigDecimal px) {

		this.px = px;

	}

	public Short getQyzt() {

		return qyzt;

	}

	public void setQyzt(Short qyzt) {

		this.qyzt = qyzt;

	}

}
