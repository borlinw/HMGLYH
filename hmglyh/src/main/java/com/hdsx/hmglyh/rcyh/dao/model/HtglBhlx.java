package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class HtglBhlx implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String bhid;

    private String bhname;

    private String dw;

    private String bhms;

    private BigDecimal wxsx;

    private Short qyzt;

    private BigDecimal px;
    
    private HashMap<String,Object> attributes = new HashMap<String,Object>();
    
    

    public HashMap<String, Object> getAttributes() {
    	attributes.put("dw", this.getDw());
		return attributes;
	}

	public void setAttributes(HashMap<String, Object> attributes) {
		this.attributes = attributes;
	}

	// 非持久化属性 
    private String id;
    private String text;
    private String state;
	private List<HtglBhlx> children;
   
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


    
    public List<HtglBhlx> getChildren() {
		return children;
	}

	public void setChildren(List<HtglBhlx> children) {
		this.children = children;
	}

	public String getBhid() {
        return bhid;
    }

    public void setBhid(String bhid) {
        this.bhid = bhid == null ? null : bhid.trim();
    }

    public String getBhname() {
        return bhname;
    }

    public void setBhname(String bhname) {
        this.bhname = bhname == null ? null : bhname.trim();
    }

    public String getDw() {
    	if(dw == null) {
    		dw = "";
    	}
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw == null ? "" : dw.trim();
    }

    public String getBhms() {
        return bhms;
    }

    public void setBhms(String bhms) {
        this.bhms = bhms == null ? "" : bhms.trim();
    }

    public BigDecimal getWxsx() {
        return wxsx;
    }

    public void setWxsx(BigDecimal wxsx) {
        this.wxsx = wxsx;
    }

    public Short getQyzt() {
        return qyzt;
    }

    public void setQyzt(Short qyzt) {
        this.qyzt = qyzt;
    }

    public BigDecimal getPx() {
        return px;
    }

    public void setPx(BigDecimal px) {
        this.px = px;
    }
}