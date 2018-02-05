package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglRyb;

public class RcyhRwdjlb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 250930824064791095L;

	private String rwdid;

	private String ssny;

	private String cjtime;

	private String cjusername;

	private String bmcode;

	private String ldcode;

	private String tq;

	private Integer szhhkm;

	private Integer szhhm;

	private Integer ezhhkm;

	private Integer ezhhm;

	private String wzbc;

	private String qlcode;

	private String qlname;

	private String sdcode;

	private String sdname;

	private String hdcode;

	private String hdname;

	private String bhid;

	private String yhid;

	private Double sl;

	private String bz;

	private Double rgdj;

	private Double grde;

	private Double jhgr;

	private Double rgf;

	private Double clf;

	private Double jxf;

	private String xfsx;

	private String rwdzt;

	private String rwdlx;
	
	private String rwbh;
	
	private String rwdckzt;

	
	public String getRwdckzt() {
		return rwdckzt;
	}

	public void setRwdckzt(String rwdckzt) {
		this.rwdckzt = rwdckzt;
	}

	// 非持久化 字段
	private String cjryname; // 用于显示的 名称
	private String duration; // 延期天数
	private String starttime;
	private String endtime;
	private String bmname; // 部门名称
	private String yhlxname; // 养护类型名称
	private String ldname;
	private String wgtime;
	private List<RcyhBhjlb> bhjls;
	private List<RcyhCljxxhb> cljxxhs = new ArrayList<RcyhCljxxhb>();
	private List<RcyhCljxxhb> cls = new ArrayList<RcyhCljxxhb>();
	private List<RcyhCljxxhb> jxs = new ArrayList<RcyhCljxxhb>();
	private List<HtglRyb> rys;
	private String pgzt; //
	private String rwdlxname;
	private String rwdztname;
	private String date;
	private String dw;
	private boolean fromYdjh = false;
	private Double dejs;

	
	public String getRwbh() {
		return rwbh;
	}

	public void setRwbh(String rwbh) {
		this.rwbh = rwbh;
	}

	public Double getDejs() {
		return dejs;
	}

	public void setDejs(Double dejs) {
		this.dejs = dejs;
	}

	public boolean isFromYdjh() {
		return fromYdjh;
	}

	public void setFromYdjh(boolean fromYdjh) {
		this.fromYdjh = fromYdjh;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public List<RcyhCljxxhb> getCls() {
		
		if(cls.size() > 0 ) {
			return cls;
		}
		
		for(RcyhCljxxhb cljx: cljxxhs) {
			if( cljx.getLxid().startsWith("002") ) { //材料
				cls.add(cljx);
			}
		}
		return cls;
	}

	public void setCls(List<RcyhCljxxhb> cls) {
		this.cls = cls;
	}


	public List<RcyhCljxxhb> getJxs() {
		
		if(jxs.size() > 0 ) {
			return jxs;
		}
		
		for(RcyhCljxxhb cljx: cljxxhs) {
			if( cljx.getLxid().startsWith("003") ) { //材料
				jxs.add(cljx);
			}
		}
		return jxs;
	}


	public void setJxs(List<RcyhCljxxhb> jxs) {
		this.jxs = jxs;
	}


	public String getDate() {
		return date;
	}

	
	public String getRwdztname() {
		return rwdztname;
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

	public void setRwdztname(String rwdztname) {
		this.rwdztname = rwdztname;
	}




	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "RcyhRwdjlb [rwdid=" + rwdid + ", ssny=" + ssny + ", cjtime="
				+ cjtime + ", cjusername=" + cjusername + ", bmcode=" + bmcode
				+ ", ldcode=" + ldcode + ", tq=" + tq + ", szhhkm=" + szhhkm
				+ ", szhhm=" + szhhm + ", ezhhkm=" + ezhhkm + ", ezhhm="
				+ ezhhm + ", wzbc=" + wzbc + ", qlcode=" + qlcode + ", qlname="
				+ qlname + ", sdcode=" + sdcode + ", sdname=" + sdname
				+ ", hdcode=" + hdcode + ", hdname=" + hdname + ", bhid="
				+ bhid + ", yhid=" + yhid + ", sl=" + sl + ", bz=" + bz
				+ ", grde=" + grde + ", jhgr=" + jhgr + ", rgf=" + rgf
				+ ", clf=" + clf + ", jxf=" + jxf + ", xfsx=" + xfsx
				+ ", rwdzt=" + rwdzt + ", rwdlx=" + rwdlx + ", rwdckzt=" + rwdckzt + ", bhjls=" + bhjls
				+ ", cljxxhs=" + cljxxhs + ", cjryname=" + cjryname + "]";
	}

	
	
	public String getRwdlxname() {
		return rwdlxname;
	}



	public void setRwdlxname(String rwdlxname) {
		this.rwdlxname = rwdlxname;
	}



	public String getPgzt() {
		return pgzt;
	}

	public void setPgzt(String pgzt) {
		this.pgzt = pgzt;
	}

	
	public String getWgtime() {
		return wgtime;
	}

	public void setWgtime(String wgtime) {
		this.wgtime = wgtime;
	}

	public String getLdname() {
		return ldname;
	}

	public void setLdname(String ldname) {
		this.ldname = ldname;
	}

	public List<HtglRyb> getRys() {
		return rys;
	}

	public void setRys(List<HtglRyb> rys) {
		this.rys = rys;
	}

	public String getYhlxname() {
		return yhlxname;
	}

	public void setYhlxname(String yhlxname) {
		this.yhlxname = yhlxname;
	}

	public String getBmname() {
		return bmname;
	}

	public void setBmname(String bmname) {
		this.bmname = bmname;
	}

	private int page;
	private int rows;

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
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

	public List<RcyhCljxxhb> getCljxxhs() {
		
		if( cljxxhs.size() > 0 ) {
			return cljxxhs;
		}
		
		if( this.cls != null ) {
			for( RcyhCljxxhb cl : this.cls ) {
				if( cl != null ) {
					this.cljxxhs.add(cl);
				}
			}
		}
		
		if( this.jxs != null ) {
			
			for( RcyhCljxxhb jx : this.jxs ) {
				if( jx != null ) {
					this.cljxxhs.add(jx);
				}
			}
			
		}
		
		return cljxxhs;
	}

	public void setCljxxhs(List<RcyhCljxxhb> cljxxhs) {
		this.cljxxhs = cljxxhs;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCjryname() {
		return cjryname;
	}

	public void setCjryname(String cjryname) {
		this.cjryname = cjryname;
	}

	public List<RcyhBhjlb> getBhjls() {
		return bhjls;
	}

	public void setBhjls(List<RcyhBhjlb> bhjls) {
		this.bhjls = bhjls;
	}

	public String getRwdid() {
		return rwdid;
	}

	public void setRwdid(String rwdid) {
		this.rwdid = rwdid == null ? null : rwdid.trim();
	}

	public String getSsny() {
		return ssny;
	}

	public void setSsny(String ssny) {
		this.ssny = ssny == null ? null : ssny.trim();
	}

	public String getCjtime() {
		return cjtime;
	}

	public void setCjtime(String cjtime) {
		this.cjtime = cjtime;
	}

	public String getCjusername() {
		return cjusername;
	}

	public void setCjusername(String cjusername) {
		this.cjusername = cjusername == null ? null : cjusername.trim();
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

	public String getTq() {
		return tq;
	}

	public void setTq(String tq) {
		this.tq = tq == null ? null : tq.trim();
	}

	public String getWzbc() {
		return wzbc;
	}

	public void setWzbc(String wzbc) {
		this.wzbc = wzbc == null ? null : wzbc.trim();
	}

	public String getQlcode() {
		return qlcode;
	}

	public void setQlcode(String qlcode) {
		this.qlcode = qlcode == null ? null : qlcode.trim();
	}

	public String getQlname() {
		return qlname;
	}

	public void setQlname(String qlname) {
		this.qlname = qlname == null ? null : qlname.trim();
	}

	public String getSdcode() {
		return sdcode;
	}

	public void setSdcode(String sdcode) {
		this.sdcode = sdcode == null ? null : sdcode.trim();
	}

	public String getSdname() {
		return sdname;
	}

	public void setSdname(String sdname) {
		this.sdname = sdname == null ? null : sdname.trim();
	}

	public String getHdcode() {
		return hdcode;
	}

	public void setHdcode(String hdcode) {
		this.hdcode = hdcode == null ? null : hdcode.trim();
	}

	public String getHdname() {
		return hdname;
	}

	public void setHdname(String hdname) {
		this.hdname = hdname == null ? null : hdname.trim();
	}

	public String getBhid() {
		return bhid;
	}

	public void setBhid(String bhid) {
		this.bhid = bhid == null ? null : bhid.trim();
	}

	public String getYhid() {
		return yhid;
	}

	public void setYhid(String yhid) {
		this.yhid = yhid == null ? null : yhid.trim();
	}

	

	public Double getSl() {
		return sl;
	}

	public void setSl(Double sl) {
		this.sl = sl;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}

	
	
	
	
	public Double getRgdj() {
		return rgdj;
	}

	public void setRgdj(Double rgdj) {
		this.rgdj = rgdj;
	}

	public Double getGrde() {
		return grde;
	}

	public void setGrde(Double grde) {
		this.grde = grde;
	}

	public Double getJhgr() {
		return jhgr;
	}

	public void setJhgr(Double jhgr) {
		this.jhgr = jhgr;
	}

	public Double getRgf() {
		return rgf;
	}

	public void setRgf(Double rgf) {
		this.rgf = rgf;
	}

	public Double getClf() {
		return clf;
	}

	public void setClf(Double clf) {
		this.clf = clf;
	}

	public Double getJxf() {
		return jxf;
	}

	public void setJxf(Double jxf) {
		this.jxf = jxf;
	}

	public String getXfsx() {
		return xfsx;
	}

	public void setXfsx(String xfsx) {
		this.xfsx = xfsx;
	}

	public String getRwdzt() {
		return rwdzt;
	}

	public void setRwdzt(String rwdzt) {
		this.rwdzt = rwdzt;
	}

	public String getRwdlx() {
		return rwdlx;
	}

	public void setRwdlx(String rwdlx) {
		this.rwdlx = rwdlx;
	}
}