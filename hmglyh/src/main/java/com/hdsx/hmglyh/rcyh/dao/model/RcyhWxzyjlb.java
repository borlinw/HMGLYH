package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RcyhWxzyjlb implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String zyid;

    private String rwdid;

    private String wgtime;

    private String jlusername;

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

    private String yhid;

    private Double sl;

    private String bz;

    private Double grde;

    private Double jhgr;

    private Double rgf;

    private Double clf;

    private Double jxf;
    
    private Double hgsl = (double) 0;

    private String zysbzt;

    private String sbusername;

    private String sbtime;

    private String yszt;
    
    private String starttime;
    
    private String endtime;
    
    private Double rgdj;
    private Double dejs;
    
    private String roadcode;
    
    
    // 非 持久化 字段
    
    private Date stime;
    private Date etime;
    private String yhname;
    private String bmname;
    private boolean fromYs = false;
    private String szhh;
    private String ezhh;
    
    private int page;
    private int rows;
    private String ysztname;
    private String zysbztname;
    private String ldname;
    private String jlryname; // 记录人员名
    private String select;
    private String lxcode; // 路线编码
    private String ssny;
    
    private List<RcyhRyzyjlb> ryzys;
    
    private List<RcyhCljxxhb> cljxxhs  = new ArrayList<RcyhCljxxhb>() ;
    
    private List<RcyhCljxxhb> cls = new ArrayList<RcyhCljxxhb>();
    
    private List<RcyhCljxxhb> jxs = new ArrayList<RcyhCljxxhb>();;

    private List<ZP> zps;
    
    private String dw;
    
    private Double dj;
    
	public String getRoadcode() {
		return roadcode;
	}

	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}

	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Double getHgsl() {
		return hgsl;
	}

	public void setHgsl(Double hgsl) {
		this.hgsl = hgsl;
	}

	public String getSsny() {
		return ssny;
	}

	public void setSsny(String ssny) {
		this.ssny = ssny;
	}

	public Double getDejs() {
		return dejs;
	}

	public void setDejs(Double dejs) {
		this.dejs = dejs;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	

	public List<RcyhCljxxhb> getCls() {
    	if( cls.size() > 0 ) {
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
		
		if( jxs.size() > 0 ) {
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

	public String getLxcode() {
		return lxcode;
	}

	public void setLxcode(String lxcode) {
		this.lxcode = lxcode;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getJlryname() {
		return jlryname;
	}

	public void setJlryname(String jlryname) {
		this.jlryname = jlryname;
	}

	public String getLdname() {
		return ldname;
	}

	public void setLdname(String ldname) {
		this.ldname = ldname;
	}

	public String getYsztname() {
		return ysztname;
	}

	public void setYsztname(String ysztname) {
		this.ysztname = ysztname;
	}

	public String getZysbztname() {
		return zysbztname;
	}

	public void setZysbztname(String zysbztname) {
		this.zysbztname = zysbztname;
	}

	

	public List<ZP> getZps() {
		return zps;
	}

	public void setZps(List<ZP> zps) {
		this.zps = zps;
	}

	public String getSzhh() {
		return szhh;
	}

	public void setSzhh(String szhh) {
		this.szhh = szhh;
	}

	public String getEzhh() {
		return ezhh;
	}

	public void setEzhh(String ezhh) {
		this.ezhh = ezhh;
	}

	@Override
	public String toString() {
		return "RcyhWxzyjlb [zyid=" + zyid + ", rwdid=" + rwdid + ", wgtime="
				+ wgtime + ", jlusername=" + jlusername + ", bmcode=" + bmcode
				+ ", ldcode=" + ldcode + ", tq=" + tq + ", szhhkm=" + szhhkm
				+ ", szhhm=" + szhhm + ", ezhhkm=" + ezhhkm + ", ezhhm="
				+ ezhhm + ", wzbc=" + wzbc + ", qlcode=" + qlcode + ", qlname="
				+ qlname + ", sdcode=" + sdcode + ", sdname=" + sdname
				+ ", hdcode=" + hdcode + ", hdname=" + hdname + ", yhid="
				+ yhid + ", sl=" + sl + ", bz=" + bz + ", grde=" + grde
				+ ", jhgr=" + jhgr + ", rgf=" + rgf + ", clf=" + clf + ", jxf="
				+ jxf + ", zysbzt=" + zysbzt + ", sbusername=" + sbusername
				+ ", sbtime=" + sbtime + ", yszt=" + yszt + ", starttime="
				+ starttime + ", endtime=" + endtime + ", page=" + page
				+ ", rows=" + rows + ", ryzys=" + ryzys + ", cljxxhs="
				+ cljxxhs + "]";
	}

	public String getBmname() {
		return bmname;
	}





	public void setBmname(String bmname) {
		this.bmname = bmname;
	}





	public String getYhname() {
		return yhname;
	}




	public void setYhname(String yhname) {
		this.yhname = yhname;
	}




	public boolean isFromYs() {
		return fromYs;
	}




	public void setFromYs(boolean fromYs) {
		this.fromYs = fromYs;
	}




	public Date getStime() {
		return stime;
	}



	public void setStime(Date stime) {
		this.stime = stime;
	}



	public Date getEtime() {
		return etime;
	}



	public void setEtime(Date etime) {
		this.etime = etime;
	}



	public List<RcyhRyzyjlb> getRyzys() {
		return ryzys;
	}



	public void setRyzys(List<RcyhRyzyjlb> ryzys) {
		this.ryzys = ryzys;
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

	public String getZyid() {
        return zyid;
    }

    public void setZyid(String zyid) {
        this.zyid = zyid == null ? null : zyid.trim();
    }

    public String getRwdid() {
        return rwdid;
    }

    public void setRwdid(String rwdid) {
        this.rwdid = rwdid == null ? null : rwdid.trim();
    }


    public String getWgtime() {
		return wgtime;
	}


	public void setWgtime(String wgtime) {
		this.wgtime = wgtime;
	}



	public String getJlusername() {
        return jlusername;
    }

    public void setJlusername(String jlusername) {
        this.jlusername = jlusername == null ? null : jlusername.trim();
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

	public Double getRgdj() {
		return rgdj;
	}

	public void setRgdj(Double rgdj) {
		this.rgdj = rgdj;
	}

	public String getSbusername() {
        return sbusername;
    }

    public void setSbusername(String sbusername) {
        this.sbusername = sbusername == null ? null : sbusername.trim();
    }


	public String getSbtime() {
		return sbtime;
	}



	public void setSbtime(String sbtime) {
		this.sbtime = sbtime;
	}



	public String getZysbzt() {
		return zysbzt;
	}



	public void setZysbzt(String zysbzt) {
		this.zysbzt = zysbzt;
	}



	public String getYszt() {
		return yszt;
	}



	public void setYszt(String yszt) {
		this.yszt = yszt;
	}

	
}