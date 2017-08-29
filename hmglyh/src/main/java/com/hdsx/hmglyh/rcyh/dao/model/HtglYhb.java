package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表 关联 路段 
 * @author zhanglm
 *
 */
public class HtglYhb implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

    private String pw;

    private String ryid;

    private String jsid;

    private Short qyzt;
    
    private List<HtglLuduan> lds;     // 当前巡视人员 所管辖的 路段
    
    private String bmcode;
    
    // 非 持久化 表
    
    private String ryname; 
    
    @Override
	public String toString() {
		return "HtglYhb [username=" + username + ", pw=" + pw + ", ryid="
				+ ryid + ", jsid=" + jsid + ", qyzt=" + qyzt + ", lds=" + lds
				+ ", bmcode=" + bmcode + ", ryname=" + ryname + "]";
	}

	public String getRyname() {
		return ryname;
	}

	public void setRyname(String ryname) {
		this.ryname = ryname;
	}

	public String getBmcode() {
		return bmcode;
	}

	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}

	public List<HtglLuduan> getLds() {
		return lds;
	}

	public void setLds(List<HtglLuduan> lds) {
		this.lds = lds;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw == null ? null : pw.trim();
    }

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getJsid() {
		return jsid;
	}

	public void setJsid(String jsid) {
		this.jsid = jsid;
	}

	public Short getQyzt() {
        return qyzt;
    }

    public void setQyzt(Short qyzt) {
        this.qyzt = qyzt;
    }
}