package com.hdsx.hmglyh.rcyh.dao.model;


public class RcyhYdjhshb {
	
	
    private String bmcode; // 部门编码
    private String ldcode; // 路段编码
    private String ssny;   // 所属年月 

    private Short sqzt;    // 申请状态 

    private String sqr;    // 申请人

    private String sqsj;   // 申请时间

    private Short shzt;  // 审核状态

    private String shr;    // 审核人

    private String shsj;   // 审核时间
    
    private String stime;  // 开始时间
    private String etime;  // 结束时间
    
    private String shrr;
    
    public String getShrr() {
		return shrr;
	}
	public void setShrr(String shrr) {
		this.shrr = shrr;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
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

    public Short getSqzt() {
        return sqzt;
    }

    public void setSqzt(Short sqzt) {
        this.sqzt = sqzt;
    }

    public String getSqr() {
        return sqr;
    }

    public void setSqr(String sqr) {
        this.sqr = sqr == null ? null : sqr.trim();
    }

    public String getSqsj() {
		return sqsj;
	}

	public void setSqsj(String sqsj) {
		this.sqsj = sqsj;
	}

	public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr == null ? null : shr.trim();
    }

	
	public Short getShzt() {
		return shzt;
	}
	public void setShzt(Short shzt) {
		this.shzt = shzt;
	}
	public String getShsj() {
		return shsj;
	}

	public void setShsj(String shsj) {
		this.shsj = shsj;
	}
}