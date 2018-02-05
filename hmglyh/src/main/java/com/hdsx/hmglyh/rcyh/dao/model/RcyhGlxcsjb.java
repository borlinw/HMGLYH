package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RcyhGlxcsjb implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String xcid;
	
	//部门编码-->可以转换成部门名称
    private String bmcode;

    //登陆用户
    private String username;
    
    //开始时间
    private String stime;
    
    //结束时间
    private String etime;
    
    //巡查路段
    private String xsld;
    
    //巡查车辆--增加
    private String xscl;
    
    //巡查类型--增加
    private String xslx;
    
    //天气
    private String tq;
    
    //备注
    private String bz;
    
    //巡查人
    private String xcr;
    
    //记录人
    private String jlr;
     
    //负责人
    private String fzr;   
    
    //路面 --去掉
    private String lm;
    
    //路基--去掉
    private String lj;
    
    //桥涵构造物--去掉
    private String qsh;
    
    //沿线设施--去掉
    private String yxss;
       
    // 非持久化 属性
    
    private int page;
    private int rows;
    private String bmname;
    private String mkid;
    
    private boolean onlyS; // 是否只做显示用
    //导出用
    List<String> wxqk = new ArrayList<String>();		//维修情况,导出用
    private String xcrq;								//巡查日期
    private int sfsb;									//是否上报
    private String zpxx;								//照片信息
   
    
    public String getXscl() {
		return xscl;
	}


	public void setXscl(String xscl) {
		this.xscl = xscl;
	}


	public String getXslx() {
		return xslx;
	}


	public void setXslx(String xslx) {
		this.xslx = xslx;
	}


	public String getXcr() {
		return xcr;
	}


	public void setXcr(String xcr) {
		this.xcr = xcr;
	}


	public int getSfsb() {
		return sfsb;
	}


	public void setSfsb(int sfsb) {
		this.sfsb = sfsb;
	}


	public String getZpxx() {
		return zpxx;
	}


	public void setZpxx(String zpxx) {
		this.zpxx = zpxx;
	}


	public String getXcrq() {
		return xcrq;
	}


	public void setXcrq(String xcrq) {
		this.xcrq = xcrq;
	}


	public List<String> getWxqk() {
		return wxqk;
	}


	public void setWxqk(List<String> wxqk) {
		this.wxqk = wxqk;
	}


	public String getMkid() {
		return mkid;
	}


	public void setMkid(String mkid) {
		this.mkid = mkid;
	}


	public boolean isOnlyS() {
		return onlyS;
	}


	public void setOnlyS(boolean onlyS) {
		this.onlyS = onlyS;
	}


	@Override
	public String toString() {
		return "RcyhGlxcsjb [xcid=" + xcid + ", bmcode=" + bmcode
				+ ", username=" + username + ", stime=" + stime + ", etime="
				+ etime + ", xsld=" + xsld + ", jlr=" + jlr + ", fzr=" + fzr
				+ "]";
	}
    
    
	public String getBmname() {
		return bmname;
	}

	public void setBmname(String bmname) {
		this.bmname = bmname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getXcid() {
        return xcid;
    }

    public void setXcid(String xcid) {
        this.xcid = xcid == null ? null : xcid.trim();
    }

    public String getBmcode() {
        return bmcode;
    }

    public void setBmcode(String bmcode) {
        this.bmcode = bmcode == null ? null : bmcode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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


	public String getXsld() {
        return xsld;
    }

    public void setXsld(String xsld) {
        this.xsld = xsld == null ? null : xsld.trim();
    }

    public String getTq() {
        return tq;
    }

    public void setTq(String tq) {
        this.tq = tq == null ? null : tq.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getJlr() {
        return jlr;
    }

    public void setJlr(String jlr) {
        this.jlr = jlr == null ? null : jlr.trim();
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr == null ? null : fzr.trim();
    }

    public String getLm() {
        return lm;
    }

    public void setLm(String lm) {
        this.lm = lm == null ? null : lm.trim();
    }

    public String getLj() {
        return lj;
    }

    public void setLj(String lj) {
        this.lj = lj == null ? null : lj.trim();
    }

    public String getQsh() {
        return qsh;
    }

    public void setQsh(String qsh) {
        this.qsh = qsh == null ? null : qsh.trim();
    }

    public String getYxss() {
        return yxss;
    }

    public void setYxss(String yxss) {
        this.yxss = yxss == null ? null : yxss.trim();
    }
}