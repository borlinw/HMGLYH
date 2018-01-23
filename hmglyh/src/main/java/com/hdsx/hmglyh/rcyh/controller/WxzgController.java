package com.hdsx.hmglyh.rcyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzg;
import com.hdsx.hmglyh.rcyh.service.RcyhWxzgService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**   
 *  维修整改 - Controller
 * @author LiRui
 * @created 2015年6月25日 下午3:34:54
 */ 
@Controller 
@Scope(value="request") 
public class WxzgController extends BaseAction{ 

	private static final long serialVersionUID = -4262635649914820380L;
	
	private RcyhWxzg model = new RcyhWxzg();
    private boolean add  = false;        //判断是否是添加的 页面 跳转过来 
    private boolean view = false;        //判断是否是查看的 页面 跳转过来 
    private boolean fg = false;            //判断是否是审核的操作跳转的页面 
    private boolean sh = false;            //判断是否是审核的操作跳转的页面 

    private String newDateStrToView = "";//当前日期的字符串形式（2015年7月7日），目前用于添加“回复单”时展示数据 

    @Resource(name="rcyhWxzgServiceImpl") 
    private RcyhWxzgService service; 

    public RcyhWxzg getModel() { 
        return model; 
    } 

    public void setModel(RcyhWxzg model) { 
        this.model = model; 
    } 

    /** 
     * 维修整改首页
    */ 
    @SuppressWarnings("deprecation")
	public String index(){ 
        return getResultname(); 
    } 

    /** 
     * 整改通知单 
    * @return 
     */ 
    @SuppressWarnings("deprecation")
	public String zgtzd(){ 
        if(view){ 
            RcyhWxzg wxzgTzd = new RcyhWxzg(); 
            wxzgTzd.setTzdid(tzdid); 
            model = service.queryOneZgtzdByTzdid(wxzgTzd); 
        } 
        return getResultname(); 
    } 

    /** 
     * 整改回复单 
    * @return 
     */ 
    @SuppressWarnings("deprecation")
	public String zghfd(){ 
        if(add){ 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"); 
            //处理日期（显示用，添加数据的时候会在后台new Date()的） 
           newDateStrToView=sdf.format(new Date()); 
        }else if(sh){ 
            RcyhWxzg wxzgTzd = new RcyhWxzg(); 
            wxzgTzd.setTzdid(tzdid); 
            model = service.queryZghfdByTzdid(wxzgTzd); 
        }else if(fg){ 
            RcyhWxzg wxzgTzd = new RcyhWxzg(); 
            wxzgTzd.setTzdid(tzdid); 
            model = service.queryZghfdByTzdid(wxzgTzd); 
        }else if(view){ 
            RcyhWxzg wxzgTzd = new RcyhWxzg(); 
            wxzgTzd.setTzdid(tzdid); 
            model = service.queryZghfdByTzdid(wxzgTzd); 
        } 
        return getResultname(); 
    } 
 
    /** 
     * 查询全部“维修整改通知单” 
    */ 
    public void queryAllOfTzd(){ 
        try{ 
        	model.setPage(page+"");
        	model.setRows(rows+"");
            model.setTbbmcode(tbbmcode); 
            List<RcyhWxzg> modelList = service.queryZgtzdBySome(model); 
            EasyUIPage<RcyhWxzg> ep = new EasyUIPage<RcyhWxzg>(); 
            int n = service.countZgtzdNumBySome(model); 
            ep.setRows(modelList); 
            ep.setTotal(n); 
            JsonUtils.write(ep, getResponse().getWriter()); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
 
    /** 
     * 查询全部“维修整改回复单” 
    */ 
    public void queryAllOfHfd(){ 
        try{ 
        	model.setPage(page+"");
        	model.setRows(rows+"");
            model.setSbbmcode(sbbmcode); 
            List<RcyhWxzg> modelList = service.queryZghfdBySome(model); 
            EasyUIPage<RcyhWxzg> ep = new EasyUIPage<RcyhWxzg>(); 
            int n = service.countZghfdNumBySome(model); 
            ep.setRows(modelList); 
            ep.setTotal(n); 
            JsonUtils.write(ep, getResponse().getWriter()); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
 
    /** 
     * 添加“维修整改通知单” 
    */ 
    public void insertOneTzd(){ 
        try{ 
            String newUUId = UUID.randomUUID().toString(); 
            model.setTzdid(newUUId); 
            model.setTzdzt(0);//修改通知单状态为“已送出” 
            model.setTbbmcode(tbbmcode); 
            model.setTzdxlj(tzdxlj); 
            model.setSbbmcode(sbbmcode); 
            model.setWz(wz); 
            model.setYq(yq); 
            model.setSxtime(sxtime); 
            model.setTbrxm(tbrxm); 
            model.setSdtime(sdtime); 
            model.setTbusername(tbusername); 
            model.setCzwt(czwt); 
            model.setZgyq(zgyq);
            model.setSbbmname(sbbmname);
            model.setBhsl(bhsl);
            if(service.addOneTzd(model)){ 
                ResponseUtils.write(getResponse(), "true"); 
            }else{ 
                ResponseUtils.write(getResponse(), "false"); 
            } 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
 
    /** 

     * 添加“维修整改回复单” 
    */ 
    public void insertOneHfd(){ 
        try{ 
            String newUUId = UUID.randomUUID().toString(); 
            model.setHfdid(newUUId); 
            model.setHfdate(new Date()); 
            //从登陆用户信息中取出部门编码和用户名放入model实体中 
            model.setZybmcode(getUser().getBmcode()); 
            model.setTbusername(getUser().getUsername()); 
            //将前台回传的信息放入实体中 
            model.setSjwctime(sjwctime); 
            model.setTzdid(tzdid); 
            model.setZgcs(zgcs); 
            model.setZgjg(zgjg);
            if(service.addOneHfd(model)){ 
                ResponseUtils.write(getResponse(), "true"); 
            }else{ 
                ResponseUtils.write(getResponse(), "false"); 
            } 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 

    /** 
     * 删除“维修整改通知单” 
    */ 
    public void deleteOneTzd(){ 
        try{ 
            if(service.deleteOneTzd(model)){ 
                ResponseUtils.write(getResponse(), "true"); 
            }else{ 
                ResponseUtils.write(getResponse(), "false"); 
            } 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
 
    /** 
     * 删除“维修整改回复单” 
    */ 
    public void deleteOneHfd(){ 
        try{ 
            if(service.deleteOneHfd(model)){ 
                ResponseUtils.write(getResponse(), "true"); 
            }else{ 
                ResponseUtils.write(getResponse(), "false"); 
            } 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
 
    /** 
     * “整改通知单”的接单操作 
    * 描述：修改接单时间，接单用户名，通知单状态 
    */ 
    public void UpdateTzdOfJd(){ 
        try{ 
            model.setJdtime(new Date()); 
            model.setTzdid(tzdid);
            model.setJdusername(getUser().getUsername());
            if(service.updateOneTzdOfJd(model)){ 
                ResponseUtils.write(getResponse(), "true"); 
            }else{ 
                ResponseUtils.write(getResponse(), "false"); 
            } 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
 
    /** 
     * 根据通知单ID查询其详细信息 
    * 描述：用于“回复单Grid”中的查看 
    */ 
    public void queryOneTzdOfTzdid(){ 
        try{ 
            //model中必须有tzdid 
            RcyhWxzg wxzgTzd = service.queryOneZgtzdByTzdid(model); 

            JsonUtils.write(wxzgTzd, getResponse().getWriter()); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
 
    /** 
     * 根据通知单ID查询其信息以及其对应的回复单等信息 
    */ 
    public void queryZghfdByTzdid(){ 
        try{ 
            //必须含有tzdid 
            RcyhWxzg wxzgTzd = service.queryZghfdByTzdid(model); 
            JsonUtils.write(wxzgTzd, getResponse().getWriter()); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 

    /** 
     * 审核某回复单 
    */ 
    public void shHfd(){ 
        try{ 
            model.setJcusername(getUser().getUsername()); 
            model.setTzdzt(tzdzt); 
            model.setHfdid(hfdid); 
            model.setTzdid(tzdid); 
            model.setJcryj(jcryj); 
            model.setJcrxm(jcrxm); 
            if(service.updateOneHfdOfSh(model)){ 
                ResponseUtils.write(getResponse(), "true"); 
            }else{ 
                ResponseUtils.write(getResponse(), "false"); 
            } 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
 
    /** 
     * 返工“回复单”的修改 
    * 描述：修改sjwctime，zgcs，zgjg 
     */ 
    public void fgOfHfd(){ 
        try{ 
            RcyhWxzg zg = new RcyhWxzg(); 
            zg.setSjwctime(sjwctime); 
            zg.setZgcs(zgcs); 
            zg.setZgjg(zgjg); 
            zg.setHfdid(hfdid); 
            zg.setTzdid(tzdid); 
            if(service.fgOfHfd(zg)){ 
                ResponseUtils.write(getResponse(), "true"); 
            }else{ 
                ResponseUtils.write(getResponse(), "false"); 
            } 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 

    /**
     * 根据通知单ID查询通知单的详细信息
     * 描述：用于view（新版。通知单+回复单）
     */
    public void queryTzdDataToView(){
    	try{
    		RcyhWxzg tzd = new RcyhWxzg();
        	tzd.setTzdid(tzdid);
        	model = service.queryTzdToExport(tzd);
        	JsonUtils.write(model, getResponse().getWriter()); 
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    /**
     * 根据回复单单ID查询通知单的详细信息
     * 描述：用于view（新版。通知单+回复单）
     */
    public void queryHfdDataToView(){
    	try{
    		RcyhWxzg hfd = new RcyhWxzg();
        	//hfd.setHfdid(hfdid);
    		hfd.setTzdid(tzdid);
        	model = service.queryHfdToExport(hfd);
        	if(model == null){
        		ResponseUtils.write(getResponse(), "a"); 
        	}else{
        		JsonUtils.write(model, getResponse().getWriter()); 
        	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    //参数的get、set方法 
   private String tzdid;                //维修整改通知单ID 
    private String tbbmcode;        //填表单位 
   private String tbbmname;        //填表单位名称（显示用） 
   private String tbusername;    //填表人用户名 
   private String tzdxlj;                //通知单序列号 
   private String sbbmcode;        //送表单位 
   private String sbbmname;        //送表单位名称（显示用） 
   private Integer bhsl;            //病害数量
   public Integer getBhsl() {
	return bhsl;
}

public void setBhsl(Integer bhsl) {
	this.bhsl = bhsl;
}

private String wz;                    //位置 
   private String yq;                    //要求（立即/尽快） 
   private Date sxtime;                //时限（要求完成时间） 
   private String sxtimeStr;        //时限（中文格式） 
   private String tbrxm;                //检查人姓名（根据填表人获取，可修改）（可充当填报人） 
   private Date sdtime;                //送单时间 
   private String sdtimeStr;        //送单时间（中文格式） 
   private String czwt;                //存在问题 
   private String zgyq;                //整改要求 
   private String jdusername;    //接单人用户名（根据接单人生成，不可修改） 
   private String jdrxm;                //接单人姓名（显示用） 
   private Date jdtime;                //接单时间（根据首次查看时间生成，不可修改） 
   private String jdtimeStr;        //时限（中文格式） 
   private int tzdzt;                    //通知单状态（已送出 0，已送达 1，已回复 2，整改不合格 3，返工已回复 4，整改合格 5） 
   //维修整改回复单 
   private String hfdid;                //维修整改回复单ID 
   private String zybmcode;        //作业单位（自动获取，不可修改） 
   private String zybmname;        //作业部门名称（显示用） 
   private Date hfdate;                //日期（填单日期） 
   private String hfdateStr;        //日期（填单日期）（中文格式） 
   private Date sjwctime;            //实际完成时间 
   private String sjwctimeStr;    //实际完成时间（中文格式） 
   private String zgcs;                //整改措施 
   private String zgjg;                //整改结果 
   private String jcryj;                //检查人审核一件 
   private String jcusername;        //检查人用户名 
   private String jcrxm;                //检查人姓名（根据检查人获取，可修改） 

public boolean isAdd() {
	return add;
}

public void setAdd(boolean add) {
	this.add = add;
}

public boolean isView() {
	return view;
}

public void setView(boolean view) {
	this.view = view;
}

public boolean isFg() {
	return fg;
}

public void setFg(boolean fg) {
	this.fg = fg;
}

public boolean isSh() {
	return sh;
}

public void setSh(boolean sh) {
	this.sh = sh;
}

public String getNewDateStrToView() {
	return newDateStrToView;
}

public void setNewDateStrToView(String newDateStrToView) {
	this.newDateStrToView = newDateStrToView;
}

public String getTzdid() {
	return tzdid;
}

public void setTzdid(String tzdid) {
	this.tzdid = tzdid;
}

public String getTbbmcode() {
	return tbbmcode;
}

public void setTbbmcode(String tbbmcode) {
	this.tbbmcode = tbbmcode;
}

public String getTbbmname() {
	return tbbmname;
}

public void setTbbmname(String tbbmname) {
	this.tbbmname = tbbmname;
}

public String getTbusername() {
	return tbusername;
}

public void setTbusername(String tbusername) {
	this.tbusername = tbusername;
}

public String getTzdxlj() {
	return tzdxlj;
}

public void setTzdxlj(String tzdxlj) {
	this.tzdxlj = tzdxlj;
}

public String getSbbmcode() {
	return sbbmcode;
}

public void setSbbmcode(String sbbmcode) {
	this.sbbmcode = sbbmcode;
}

public String getSbbmname() {
	return sbbmname;
}

public void setSbbmname(String sbbmname) {
	this.sbbmname = sbbmname;
}

public String getWz() {
	return wz;
}

public void setWz(String wz) {
	this.wz = wz;
}

public String getYq() {
	return yq;
}

public void setYq(String yq) {
	this.yq = yq;
}

public Date getSxtime() {
	return sxtime;
}

public void setSxtime(Date sxtime) {
	this.sxtime = sxtime;
}

public String getSxtimeStr() {
	return sxtimeStr;
}

public void setSxtimeStr(String sxtimeStr) {
	this.sxtimeStr = sxtimeStr;
}

public String getTbrxm() {
	return tbrxm;
}

public void setTbrxm(String tbrxm) {
	this.tbrxm = tbrxm;
}

public Date getSdtime() {
	return sdtime;
}

public void setSdtime(Date sdtime) {
	this.sdtime = sdtime;
}

public String getSdtimeStr() {
	return sdtimeStr;
}

public void setSdtimeStr(String sdtimeStr) {
	this.sdtimeStr = sdtimeStr;
}

public String getCzwt() {
	return czwt;
}

public void setCzwt(String czwt) {
	this.czwt = czwt;
}

public String getZgyq() {
	return zgyq;
}

public void setZgyq(String zgyq) {
	this.zgyq = zgyq;
}

public String getJdusername() {
	return jdusername;
}

public void setJdusername(String jdusername) {
	this.jdusername = jdusername;
}

public String getJdrxm() {
	return jdrxm;
}

public void setJdrxm(String jdrxm) {
	this.jdrxm = jdrxm;
}

public Date getJdtime() {
	return jdtime;
}

public void setJdtime(Date jdtime) {
	this.jdtime = jdtime;
}

public String getJdtimeStr() {
	return jdtimeStr;
}

public void setJdtimeStr(String jdtimeStr) {
	this.jdtimeStr = jdtimeStr;
}

public int getTzdzt() {
	return tzdzt;
}

public void setTzdzt(int tzdzt) {
	this.tzdzt = tzdzt;
}

public String getHfdid() {
	return hfdid;
}

public void setHfdid(String hfdid) {
	this.hfdid = hfdid;
}

public String getZybmcode() {
	return zybmcode;
}

public void setZybmcode(String zybmcode) {
	this.zybmcode = zybmcode;
}

public String getZybmname() {
	return zybmname;
}

public void setZybmname(String zybmname) {
	this.zybmname = zybmname;
}

public Date getHfdate() {
	return hfdate;
}

public void setHfdate(Date hfdate) {
	this.hfdate = hfdate;
}

public String getHfdateStr() {
	return hfdateStr;
}

public void setHfdateStr(String hfdateStr) {
	this.hfdateStr = hfdateStr;
}

public Date getSjwctime() {
	return sjwctime;
}

public void setSjwctime(Date sjwctime) {
	this.sjwctime = sjwctime;
}

public String getSjwctimeStr() {
	return sjwctimeStr;
}

public void setSjwctimeStr(String sjwctimeStr) {
	this.sjwctimeStr = sjwctimeStr;
}

public String getZgcs() {
	return zgcs;
}

public void setZgcs(String zgcs) {
	this.zgcs = zgcs;
}

public String getZgjg() {
	return zgjg;
}

public void setZgjg(String zgjg) {
	this.zgjg = zgjg;
}

public String getJcryj() {
	return jcryj;
}

public void setJcryj(String jcryj) {
	this.jcryj = jcryj;
}

public String getJcusername() {
	return jcusername;
}

public void setJcusername(String jcusername) {
	this.jcusername = jcusername;
}

public String getJcrxm() {
	return jcrxm;
}

public void setJcrxm(String jcrxm) {
	this.jcrxm = jcrxm;
}

}  
