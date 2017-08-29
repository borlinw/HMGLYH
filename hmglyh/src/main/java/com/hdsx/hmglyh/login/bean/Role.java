package com.hdsx.hmglyh.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 角色
 * @author zhanglm
 *
 */
public class Role implements Serializable{
    /**  描述  */  
	private static final long serialVersionUID = 1L;

	private String jsid;

    private String jsname;

    private String jsms;
    
    // 非持久化对象
    private List<Auth> auths; // 

    public List<Auth> getAuths() {
		return auths;
	}

	public void setAuths(List<Auth> auths) {
		this.auths = auths;
	}

	public String getJsid() {
		return jsid;
	}

	public void setJsid(String jsid) {
		this.jsid = jsid;
	}

	public String getJsname() {
        return jsname;
    }

    public void setJsname(String jsname) {
        this.jsname = jsname == null ? null : jsname.trim();
    }

    public String getJsms() {
        return jsms;
    }

    public void setJsms(String jsms) {
        this.jsms = jsms == null ? null : jsms.trim();
    }
}
