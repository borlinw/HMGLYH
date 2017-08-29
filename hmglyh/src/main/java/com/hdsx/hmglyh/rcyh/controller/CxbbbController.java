package com.hdsx.hmglyh.rcyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhCxbbb;
import com.hdsx.hmglyh.rcyh.service.RcyhCxbbbService;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  日常养护 - 除雪版本 - Action
 * @author LiRui
 * @created 2015年8月21日 下午1:32:56 
 */
@Controller
@Scope(value="request")
public class CxbbbController extends BaseAction {

	private static final long serialVersionUID = 4797647147848323434L;

	@Resource(name="rcyhCxbbbServiceImpl")
	private RcyhCxbbbService service;

	//相关参数声明
	private RcyhCxbbb model = new RcyhCxbbb();
	private int bbid;					//版本id
	private String bmcode;		//创建用户部门（用于“查看/添加”除雪年报主/副表）
	private String bbidStr;		//版本id（Str用于查看/编辑是数据传输错误）
	private String bbmc;			//版本名称
	private Date ssj;					//开始时间
	private Date esj;					//结束时间
	private String zjczr;			//创建人（用户名）
	//操作类型参数（用于标识此次操作类型）
	private boolean toAdd = false;
	private boolean toView = false;
	private boolean toEdit = false;

	/**
	 * 页面跳转至index.jsp
	 */
	@AnnotationAuth(mkid="0108")
	@SuppressWarnings("deprecation")
	public String index(){
			return getResultname();
	}

	/**
	 * 查询全部
	 */
	@AnnotationAuth(mkid="0108")
	public void queryAll(){
		try{
			List<RcyhCxbbb> modelList = service.queryAll(model);
			EasyUIPage<RcyhCxbbb> ep = new EasyUIPage<RcyhCxbbb>();
			int n = service.countNum(model);
			ep.setRows(modelList);
			ep.setTotal(n);
			JsonUtils.write(ep, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * （添加/查看/编辑）除雪版本信息的操作
	 * 描述：用于跳转至addCxbb.jsp页面
	 * @return
	 */
	@AnnotationAuth(mkid="0108")
	@SuppressWarnings("deprecation")
	public String addCxbb(){
		if(toAdd){
			System.out.println("--添加除雪版本信息--");
		}
		if(toEdit || toView){
			RcyhCxbbb cx = new RcyhCxbbb();
			cx.setBbid(bbid);
			model = service.queryOneByBBID(cx);
			System.out.println("--编辑/查看除雪版本--");
		}
		return getResultname();
	}

	/**
	 * 添加
	 */
	@AnnotationAuth(mkid="0108")
	public void addOneCxbbb(){
		try{
			model.setBbid(service.generationPK());
			model.setBbmc(bbmc);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			model.setSsj(sdf2.parse(sdf1.format(ssj)+" 00:00:01"));
			model.setEsj(sdf2.parse(sdf1.format(esj)+" 23:59:59"));
			model.setZjczr(getUser().getUsername());
			if(service.addOneCxbbb(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 */
	@AnnotationAuth(mkid="0108")
	public void deleteOneCxbbb(){
		try{
			model.setBbid(bbid);
			if(service.deleteOneCxbbb(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 编辑
	 */
	@AnnotationAuth(mkid="0108")
	public void updateCxbbb(){
		try{
			model.setBbid(bbid);
			model.setBbmc(bbmc);
			model.setSsj(ssj);
			model.setEsj(esj);
			if(service.updateOneCxbbb(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 创建版本树
	 * 描述：查询全部版本数据
	 * 用于：除雪汇总表
	 */
	public void createCxbbCombobox(){
		try{
			List<Combobox> list = service.createCxbbbCombobox(model);
			JsonUtils.write(list, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 根据bbid和bmcode查询当前部门版本的除雪年报是否已添加
	 * 用于：添加、查看除雪年报
	 */
	public void queryCxnbByBBIDAndBmcode(){
		try{
			model.setBbid(bbid);
			model.setBmcode(getUser().getBmcode());
			if(service.queryCxnbByBBIDAndBmcode(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//Get、Set方法
	public RcyhCxbbb getModel() {
		return model;
	}
	public void setModel(RcyhCxbbb model) {
		this.model = model;
	}
	public int getBbid() {
		return bbid;
	}
	public void setBbid(int bbid) {
		this.bbid = bbid;
	}
	public String getBbmc() {
		return bbmc;
	}
	public void setBbmc(String bbmc) {
		this.bbmc = bbmc;
	}
	public Date getSsj() {
		return ssj;
	}
	public void setSsj(Date ssj) {
		this.ssj = ssj;
	}
	public Date getEsj() {
		return esj;
	}
	public void setEsj(Date esj) {
		this.esj = esj;
	}
	public String getZjczr() {
		return zjczr;
	}
	public void setZjczr(String zjczr) {
		this.zjczr = zjczr;
	}
	public boolean isToAdd() {
		return toAdd;
	}
	public void setToAdd(boolean toAdd) {
		this.toAdd = toAdd;
	}
	public boolean isToView() {
		return toView;
	}
	public void setToView(boolean toView) {
		this.toView = toView;
	}
	public boolean isToEdit() {
		return toEdit;
	}
	public void setToEdit(boolean toEdit) {
		this.toEdit = toEdit;
	}
	public String getBbidStr() {
		return bbidStr;
	}
	public void setBbidStr(String bbidStr) {
		this.bbidStr = bbidStr;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}

}
