package com.hdsx.hmglyh.gis.jichusj.gouzaowu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Hddqjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Hdjcxjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qhjc;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qlbjqstpb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qldqjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qljcxjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.service.QhjcService;
import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  
 * @author Baiyy
 * @created 2017年9月4日 下午11:31:24 
 */
@Controller
@Scope(value="request")
public class QhjcController extends BaseActionSupport<Qhjc> {
	private static final long serialVersionUID = -296044950087790808L;
	
	@Resource(name="qhjcServiceImpl")
	private QhjcService qhjcService;
	
	private Qhjc qhjc = new Qhjc();
	
	private String qldqjcid;
	
	private String[] tpbm;
	
	private String[] tpms;
	
	private String[] cfdz;
	
	private String[] fjmc;
	
	private List<Qlbjqstpb> tpList = new ArrayList<Qlbjqstpb>();

	public String[] getFjmc() {
		return fjmc;
	}

	public void setFjmc(String[] fjmc) {
		this.fjmc = fjmc;
	}

	public List<Qlbjqstpb> getTpList() {
		return tpList;
	}

	public void setTpList(List<Qlbjqstpb> tpList) {
		this.tpList = tpList;
	}

	public Qhjc getQhjc() {
		return qhjc;
	}

	public String getQldqjcid() {
		return qldqjcid;
	}

	public void setQldqjcid(String qldqjcid) {
		this.qldqjcid = qldqjcid;
	}

	public String[] getTpms() {
		return tpms;
	}

	public void setTpms(String[] tpms) {
		this.tpms = tpms;
	}

	public String[] getCfdz() {
		return cfdz;
	}

	public void setCfdz(String[] cfdz) {
		this.cfdz = cfdz;
	}

	public void setTpbm(String[] tpbm) {
		this.tpbm = tpbm;
	}
	
	public String[] getTpbm(){
		return tpbm;
	}

	public void setQhjc(Qhjc qhjc) {
		this.qhjc = qhjc;
	}
	/**
	 * 桥梁定期检查签到
	 * 描述
	 * @throws Exception
	 */
	public void addQldqjc() throws Exception{
		if(qhjc.getFzr() == null || qhjc.getFzr().equals("")){
			LoginUser user = (LoginUser)getRequest().getSession().getAttribute("loginuser");
			qhjc.setFzr(user.getRyname());
		}
		boolean result = qhjcService.addQldqjc(qhjc);
		if(result){
			ResponseUtils.write(getResponse(), "true");
		}else{
			ResponseUtils.write(getResponse(), "false");
		}
	}
	
	/**
	 * 桥梁定期检查查询
	 * 描述
	 * @throws Exception
	 */
	public void getQldqjc() throws Exception{
		List<Qldqjcb> list = qhjcService.queryQldqjc(qhjc);
		int total = qhjcService.getQldqjcCount(qhjc);
		EasyUIPage<Qldqjcb> ep = new EasyUIPage<Qldqjcb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, getResponse().getWriter());
	}
	
	public String getTpbms() throws Exception{
		tpList = qhjcService.getTpbm(qldqjcid);
		return SUCCESS;
	}
	
	public void addTpbm() throws Exception{
		List<Qlbjqstpb> list = new ArrayList<Qlbjqstpb>();
		for(int i=0;i<tpbm.length;i++){
			Qlbjqstpb q = new Qlbjqstpb();
			q.setQldqjcid(qldqjcid);
			q.setTpbm(tpbm[i]);
			q.setTpms(tpms[i]);
			q.setCfdz(cfdz[i]);
			q.setFjmc(fjmc[i]);
			list.add(q);
		}
		if(qhjcService.addTpbm(list)){
			ResponseUtils.write(getResponse(), "true");
		}else{
			ResponseUtils.write(getResponse(), "false");
		}
	}
	
	
	/**
	 * 桥梁经常性检查签到
	 * 描述
	 * @throws Exception
	 */
	public void addQljcxjc() throws Exception{
		if(qhjc.getFzr() == null || qhjc.getFzr().equals("")){
			LoginUser user = (LoginUser)getRequest().getSession().getAttribute("loginuser");
			qhjc.setFzr(user.getRyname());
		}
		boolean result = qhjcService.addQljcxjc(qhjc);
		if(result){
			ResponseUtils.write(getResponse(), "true");
		}else{
			ResponseUtils.write(getResponse(), "false");
		}
	}
	
	/**
	 * 桥梁经常性检查查询
	 * @throws Exception
	 */
	public void getQljcxjc() throws Exception{
		List<Qljcxjcb> list = qhjcService.queryQljcxjc(qhjc);
		int total = qhjcService.getQljcxjcCount(qhjc);
		EasyUIPage<Qljcxjcb> ep = new EasyUIPage<Qljcxjcb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, getResponse().getWriter());
	}
	
	/**
	 * 桥梁定期检查签到
	 * 描述
	 * @throws Exception
	 */
	public void addHddqjc() throws Exception{
		if(qhjc.getFzr() == null || qhjc.getFzr().equals("")){
			LoginUser user = (LoginUser)getRequest().getSession().getAttribute("loginuser");
			qhjc.setFzr(user.getRyname());
		}
		boolean result = qhjcService.addHddqjc(qhjc);
		if(result){
			ResponseUtils.write(getResponse(), "true");
		}else{
			ResponseUtils.write(getResponse(), "false");
		}
	}
	
	/**
	 * 桥梁定期检查查询
	 * 描述
	 * @throws Exception
	 */
	public void getHddqjc() throws Exception{
		List<Hddqjcb> list = qhjcService.queryHddqjc(qhjc);
		int total = qhjcService.getHddqjcCount(qhjc);
		EasyUIPage<Hddqjcb> ep = new EasyUIPage<Hddqjcb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, getResponse().getWriter());
	}
	
	
	
	/**
	 * 桥梁经常性检查签到
	 * 描述
	 * @throws Exception
	 */
	public void addHdjcxjc() throws Exception{
		if(qhjc.getFzr() == null || qhjc.getFzr().equals("")){
			LoginUser user = (LoginUser)getRequest().getSession().getAttribute("loginuser");
			qhjc.setFzr(user.getRyname());
		}
		boolean result = qhjcService.addHdjcxjc(qhjc);
		if(result){
			ResponseUtils.write(getResponse(), "true");
		}else{
			ResponseUtils.write(getResponse(), "false");
		}
	}
	
	/**
	 * 涵洞经常性检查查询
	 * @throws Exception
	 */
	public void getHdjcxjc() throws Exception{
		List<Hdjcxjcb> list = qhjcService.queryHdjcxjc(qhjc);
		int total = qhjcService.getHdjcxjcCount(qhjc);
		EasyUIPage<Hdjcxjcb> ep = new EasyUIPage<Hdjcxjcb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, getResponse().getWriter());
	}
	
	


	@Override
	public Qhjc getModel() {
		return qhjc;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
