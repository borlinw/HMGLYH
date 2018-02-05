package com.hdsx.hmglyh.rcyh.dao.model;
import java.io.Serializable;
import java.util.List;

import com.hdsx.hmglyh.login.bean.LoginUser;

public class RcyhBhjlb implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4372628020271293099L;

	// bhsbzt 取值
	public static int WeiShangbao = 0; // 未上报
	public static int YiShangbao = 1; // 确认上报
	public static int QuxiaoShangbao = 2 ; // 取消上报
	public static int PaigongDahui = 3; // 派工被打回
	
	// 派工状态取值
	public static int WeiPaigong = 0 ; // 未派工
	public static int YiPaigong = 1 ; // 已派工
	public static int YanchiPaigong = 2 ; // 延迟派工
	public static int QuxiaoPaigong = 3 ; // 取消派工
	
	//病害记录ID--可用
    private String bhjlid;
    
    //记录时间--系统增加时间
    private String jltime;
    
    //记录人员--可用
    private String jlusername;
    
    //部门编码--可用
    private String bmcode;
    
    //路段编码--未知
    private String ldcode;
    
    //天气--去掉
    private String tq;
    
    //起点桩号--可用
    private Integer szhhkm;
    
    //起点桩号+ --可用
    private Integer szhhm;
    
    //止点桩号--可用
    private Integer ezhhkm;
    
    //止点桩号+ --可用
    private Integer ezhhm;
    
    //位置补充--去掉
    private String wzbc;
    
    //桥梁编码--未知
    private String qlcode;
    
    //桥梁名称--未知
    private String qlname;
    
    //隧道编码--未知
    private String sdcode;
    
    //隧道名称--未知
    private String sdname;
    
    //涵洞编码--未知
    private String hdcode;
    
    //涵洞名称--未知
    private String hdname;
    
    //病害id--可用
    private String bhid;
    
    //数量--可用
    private String sl;
    
    //备注--去掉
    private String bz;
    
    //病害上报状态--未知
    private String bhsbzt;
    
    //上报人--未知
    private String sbusername;
    
    //上报时间--未知
    private String sbtime;
    
    //上报部门编码--未知
    private String sbbmcode;
    
    //派工状态--未知
    private String pgzt;
    
    //派工人员--未知
    private String pgusename;
    
    //派工时间--未知
    private String pgtime;
    
    //延期派工时间--未知
    private String ycpgtime;
    
    //病害维修状态--未知
    private String bhwxzt;
    
    //现场处置情况--新增
    private String xcczqk;
    
    //是否上报--新增
    private Integer isSB; 
    
    
    
    // 非 持久化 属性
    
  /*  private List<HtglBhlx> bhlxs;*/
    
    private LoginUser user;
    
    private String xcid; // 外键 巡查ID
    
    private String bmname; // 部门名称
    
    private String xsldname; // 所属路段名称
    
    private String starttime; // 开始时间
    
    private String endtime; // 结束时间
    
    private String bhlxname; // 病害类型名称
    
    private RcyhGlxcsjb glxcsjb; // 所属 巡查数据表
    
    private boolean onlyS = false; // 是否只是做显示用
    
    private double pos;
    
    private String bhsbztname;
    
    private String lxcode;
    
    private int page;
    private int rows;
    
    private String sbbmname;
    
    private List<RcyhRwdjlb> rwds; // 任务单记录表
    
    private String select;
    
    private String dw; // 数量单位
    
    private String ldname; // 路段名称
    
    private String roadcode;
    
	public String getRoadcode() {
		return roadcode;
	}

	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}

	public String getSbbmname() {
		return sbbmname;
	}

	public void setSbbmname(String sbbmname) {
		this.sbbmname = sbbmname;
	}

	public String getLdname() {
		return ldname;
	}

	public void setLdname(String ldname) {
		this.ldname = ldname;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
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

	public double getPos() {
		return pos;
	}

	public void setPos(double pos) {
		this.pos = pos;
	}

	public String getBhsbztname() {
		return bhsbztname;
	}

	public void setBhsbztname(String bhsbztname) {
		this.bhsbztname = bhsbztname;
	}

	private List<ZP> zps;
    
    private String jlryname;
    
	public String getJlryname() {
		return jlryname;
	}

	public void setJlryname(String jlryname) {
		this.jlryname = jlryname;
	}

	public List<ZP> getZps() {
		return zps;
	}

	public void setZps(List<ZP> zps) {
		this.zps = zps;
	}



	public List<RcyhRwdjlb> getRwds() {
		return rwds;
	}

	
	
	public String getBhlxname() {
		return bhlxname;
	}



	public void setBhlxname(String bhlxname) {
		this.bhlxname = bhlxname;
	}



	public void setRwds(List<RcyhRwdjlb> rwds) {
		this.rwds = rwds;
	}

	public int getPage() {
		return page;
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

	public boolean isOnlyS() {
		return onlyS;
	}

	public void setOnlyS(boolean onlyS) {
		this.onlyS = onlyS;
	}

	public String getBmname() {
		return bmname;
	}

	public void setBmname(String bmname) {
		this.bmname = bmname;
	}

	public String getXsldname() {
		return xsldname;
	}

	public void setXsldname(String xsldname) {
		this.xsldname = xsldname;
	}

	@Override
	public String toString() {
		return "RcyhBhjlb [bhjlid=" + bhjlid + ", bmcode=" + bmcode + ", bhid="
				+ bhid + ", bhsbzt=" + bhsbzt + ", pgzt=" + pgzt + ", pgtime="
				+ pgtime + ", bhwxzt=" + bhwxzt + ", xcid=" + xcid + "]";
	}


	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getBhsbzt() {
		return bhsbzt;
	}

	public void setBhsbzt(String bhsbzt) {
		this.bhsbzt = bhsbzt;
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

	public RcyhGlxcsjb getGlxcsjb() {
		return glxcsjb;
	}

	public void setGlxcsjb(RcyhGlxcsjb glxcsjb) {
		this.glxcsjb = glxcsjb;
	}

	public String getXcid() {
		return xcid;
	}

	public void setXcid(String xcid) {
		this.xcid = xcid;
	}

	public LoginUser getUser() {
		return user;
	}

	public void setUser(LoginUser user) {
		this.user = user;
	}

	public String getBhjlid() {
        return bhjlid;
    }

    public void setBhjlid(String bhjlid) {
        this.bhjlid = bhjlid == null ? null : bhjlid.trim();
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

    public String getBhid() {
        return bhid;
    }

    public void setBhid(String bhid) {
        this.bhid = bhid == null ? null : bhid.trim();
    }

   

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    
    public String getSbusername() {
        return sbusername;
    }

    public void setSbusername(String sbusername) {
        this.sbusername = sbusername == null ? null : sbusername.trim();
    }


    public String getSbbmcode() {
        return sbbmcode;
    }

    public void setSbbmcode(String sbbmcode) {
        this.sbbmcode = sbbmcode == null ? null : sbbmcode.trim();
    }

   

    public String getPgusename() {
        return pgusename;
    }

    public void setPgusename(String pgusename) {
        this.pgusename = pgusename == null ? null : pgusename.trim();
    }

    
    
    public String getJltime() {
		return jltime;
	}



	public void setJltime(String jltime) {
		this.jltime = jltime;
	}



	public String getSbtime() {
		return sbtime;
	}



	public void setSbtime(String sbtime) {
		this.sbtime = sbtime;
	}



	public String getPgtime() {
		return pgtime;
	}



	public void setPgtime(String pgtime) {
		this.pgtime = pgtime;
	}

	public String getYcpgtime() {
		return ycpgtime;
	}

	public void setYcpgtime(String ycpgtime) {
		this.ycpgtime = ycpgtime;
	}

	public String getPgzt() {
		return pgzt;
	}

	public void setPgzt(String pgzt) {
		this.pgzt = pgzt;
	}

	public String getBhwxzt() {
		return bhwxzt;
	}

	public void setBhwxzt(String bhwxzt) {
		this.bhwxzt = bhwxzt;
	}

	public String getXcczqk() {
		return xcczqk;
	}

	public void setXcczqk(String xcczqk) {
		this.xcczqk = xcczqk;
	}

	public Integer getIsSB() {
		return isSB;
	}

	public void setIsSB(Integer isSB) {
		this.isSB = isSB;
	}

    
}