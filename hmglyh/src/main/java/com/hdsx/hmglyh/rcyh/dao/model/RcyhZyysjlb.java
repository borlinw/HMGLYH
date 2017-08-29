package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;

public class RcyhZyysjlb implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ysid;

    private String ystime;

    private String ysusername;

    private String bmcode;

    private String ldcode;

    private String ssny;

    private String yhid;

    private Double sbsl;

    private Double sbgr;

    private String ldzh;

    private Double cjsl;

    private Double yssl;

    private Double hgsl;

    private Double slfhl;

    private Double zlhgl;

    private Double yxsl;

    private Double yxgr;
    
    // 非 持久化字段
    private String yhname;
    private String ldname;
    private String zyyszt; // 0 未验收 ， 1 已验收  2 打回 
    
    private String dw;
    
    private String bmname;
    
    private Integer szhhkm;
    private Integer szhhm;
    private Integer ezhhkm;
    private Integer ezhhm;
    
    private Double dejs;
    
    public Double getDejs() {
		return dejs;
	}

	public void setDejs(Double dejs) {
		this.dejs = dejs;
	}

	public String getBmname() {
		return bmname;
	}

	public void setBmname(String bmname) {
		this.bmname = bmname;
	}

	public Integer getSzhhkm() {
		return szhhkm;
	}

	public void setSzhhkm(Integer szhhkm) {
		this.szhhkm = szhhkm;
	}

	public Integer getSzhhm() {
		return szhhm;
	}

	public void setSzhhm(Integer szhhm) {
		this.szhhm = szhhm;
	}

	public Integer getEzhhkm() {
		return ezhhkm;
	}

	public void setEzhhkm(Integer ezhhkm) {
		this.ezhhkm = ezhhkm;
	}

	public Integer getEzhhm() {
		return ezhhm;
	}

	public void setEzhhm(Integer ezhhm) {
		this.ezhhm = ezhhm;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getZyyszt() {
		return zyyszt;
	}

	public void setZyyszt(String zyyszt) {
		this.zyyszt = zyyszt;
	}

	public String getYhname() {
		return yhname;
	}

	public void setYhname(String yhname) {
		this.yhname = yhname;
	}

	public String getLdname() {
		return ldname;
	}

	public void setLdname(String ldname) {
		this.ldname = ldname;
	}

	public String getYsid() {
        return ysid;
    }

    public void setYsid(String ysid) {
        this.ysid = ysid == null ? null : ysid.trim();
    }


    public String getYstime() {
		return ystime;
	}

	public void setYstime(String ystime) {
		this.ystime = ystime;
	}

	public String getYsusername() {
        return ysusername;
    }

    public void setYsusername(String ysusername) {
        this.ysusername = ysusername == null ? null : ysusername.trim();
    }

    public String getBmcode() {
        return bmcode;
    }

    public void setBmcode(String bmcode) {
        this.bmcode = bmcode == null ? null : bmcode.trim();
    }

    public String getLdcode() {
        return ldcode;
    }

    public void setLdcode(String ldcode) {
        this.ldcode = ldcode == null ? null : ldcode.trim();
    }

    public String getSsny() {
        return ssny;
    }

    public void setSsny(String ssny) {
        this.ssny = ssny == null ? null : ssny.trim();
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

   
    public String getLdzh() {
        return ldzh;
    }

    public void setLdzh(String ldzh) {
        this.ldzh = ldzh == null ? null : ldzh.trim();
    }

	public Double getSbsl() {
		return sbsl;
	}

	public void setSbsl(Double sbsl) {
		this.sbsl = sbsl;
	}

	public Double getSbgr() {
		return sbgr;
	}

	public void setSbgr(Double sbgr) {
		this.sbgr = sbgr;
	}

	public Double getCjsl() {
		return cjsl;
	}

	public void setCjsl(Double cjsl) {
		this.cjsl = cjsl;
	}

	public Double getYssl() {
		return yssl;
	}

	public void setYssl(Double yssl) {
		this.yssl = yssl;
	}

	public Double getHgsl() {
		return hgsl;
	}

	public void setHgsl(Double hgsl) {
		this.hgsl = hgsl;
	}

	public Double getSlfhl() {
		return slfhl;
	}

	public void setSlfhl(Double slfhl) {
		this.slfhl = slfhl;
	}

	public Double getZlhgl() {
		return zlhgl;
	}

	public void setZlhgl(Double zlhgl) {
		this.zlhgl = zlhgl;
	}

	public Double getYxsl() {
		return yxsl;
	}

	public void setYxsl(Double yxsl) {
		this.yxsl = yxsl;
	}

	public Double getYxgr() {
		return yxgr;
	}

	public void setYxgr(Double yxgr) {
		this.yxgr = yxgr;
	}

   
}