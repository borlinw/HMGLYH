package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class HtglYhlxb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String yhid;

	private String yhname;

	private String dw;

	private BigDecimal dj;

	private BigDecimal grde;

	private String yhxmms;

	private Short qyzt;

	private Short dezt;

	private Short deqdzt;

	private Short islfxb;

	private Short islqlmxb;
	
	private Double dejs; // 定额基数

	private BigDecimal px;

	// 非 持久化 字段

	private List<HtglYhlxb> children;

	private String id;

	private String text;

	private HashMap<String, Object> attributes = new HashMap<String, Object>();
	
	
	public HashMap<String, Object> getAttributes() {

		attributes.put("dw", this.dw);

		attributes.put("grde", this.grde);

		return this.attributes;

	}
	
	public Double getDejs() {
		return dejs;
	}



	public void setDejs(Double dejs) {
		this.dejs = dejs;
	}



	public void setAttributes(HashMap<String, Object> attributes) {

		this.attributes = attributes;

	}

	public String getId() {

		return id;

	}

	public void setId(String id) {

		this.id = id;

	}

	public String getText() {

		return text;

	}

	public void setText(String text) {

		this.text = text;

	}

	public List<HtglYhlxb> getChildren() {

		return children;

	}

	public void setChildren(List<HtglYhlxb> children) {

		this.children = children;

	}

	public String getYhid() {

		return yhid;

	}

	public void setYhid(String yhid) {

		this.yhid = yhid == null ? null : yhid.trim();

	}

	public String getYhname() {

		return yhname;

	}

	public void setYhname(String yhname) {

		this.yhname = yhname == null ? null : yhname.trim();

	}

	public String getDw() {

		return dw;

	}

	public void setDw(String dw) {

		this.dw = dw == null ? null : dw.trim();

	}

	public BigDecimal getDj() {

		return dj;

	}

	public void setDj(BigDecimal dj) {

		this.dj = dj;

	}

	public BigDecimal getGrde() {

		return grde;

	}

	public void setGrde(BigDecimal grde) {

		this.grde = grde;

	}

	public String getYhxmms() {

		return yhxmms;

	}

	public void setYhxmms(String yhxmms) {

		this.yhxmms = yhxmms == null ? null : yhxmms.trim();

	}

	public Short getQyzt() {

		return qyzt;

	}

	public void setQyzt(Short qyzt) {

		this.qyzt = qyzt;

	}

	public Short getDezt() {

		return dezt;

	}

	public void setDezt(Short dezt) {

		this.dezt = dezt;

	}

	public Short getDeqdzt() {

		return deqdzt;

	}

	public void setDeqdzt(Short deqdzt) {

		this.deqdzt = deqdzt;

	}

	public Short getIslfxb() {

		return islfxb;

	}

	public void setIslfxb(Short islfxb) {

		this.islfxb = islfxb;

	}

	public Short getIslqlmxb() {

		return islqlmxb;

	}

	public void setIslqlmxb(Short islqlmxb) {

		this.islqlmxb = islqlmxb;

	}

	public BigDecimal getPx() {

		return px;

	}

	public void setPx(BigDecimal px) {

		this.px = px;

	}

}
