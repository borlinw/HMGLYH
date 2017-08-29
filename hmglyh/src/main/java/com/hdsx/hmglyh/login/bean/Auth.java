package com.hdsx.hmglyh.login.bean;

import java.io.Serializable;


/**
 * 权限
 * @author zhanglm
 *
 */
public class Auth implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2690213076859849852L;

	private String mkid;

    private String mkname;

    private String mkms;

    private String url;
    
    

    @Override
	public String toString() {
		return "Auth [mkid=" + mkid + ", mkname=" + mkname + ", mkms=" + mkms
				+ ", url=" + url + "]";
	}

	public String getMkid() {
        return mkid;
    }

    public void setMkid(String mkid) {
        this.mkid = mkid == null ? null : mkid.trim();
    }

    public String getMkname() {
        return mkname;
    }

    public void setMkname(String mkname) {
        this.mkname = mkname == null ? null : mkname.trim();
    }

    public String getMkms() {
        return mkms;
    }

    public void setMkms(String mkms) {
        this.mkms = mkms == null ? null : mkms.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}