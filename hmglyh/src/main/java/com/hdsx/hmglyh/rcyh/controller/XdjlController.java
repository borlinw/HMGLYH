package com.hdsx.hmglyh.rcyh.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.util.EasyUIPage;
import com.hdsx.hmglyh.gis.util.MapCatchUtil;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.dao.model.HtglLuduan;
import com.hdsx.hmglyh.rcyh.dao.model.HtglMjlx;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhGlxcsjb;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;
import com.hdsx.hmglyh.rcyh.service.XdjlService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Constants;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="request")
public class XdjlController extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private WorkFlowService wfService;
	@Autowired
	private XdjlService xdjlService;
	
	/**
	 * 天气列表
	 */
	public void tqList(){
		List<HtglMjlx> tqList = RcyhUtils.tqList();
		try {
			tqList.get(0).setSelected(true);
			JsonUtils.write(tqList, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询 部门 所 管辖的 路段
	 */
	public void ldsList(){
		List<HtglLuduan> ldList = RcyhUtils.luduanList(getXcsj().getBmcode());
		if(ldList.size() > 0 ) {
			if( selectFirst ) {
				ldList.get(0).setSelected(true);
			}
		}
		try {
			JsonUtils.write(ldList, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 巡道记录 中的 记录人与 负责人 用户列表
	 */
	public void xdjlYhs(){
		try {
			List<HashMap<String,Object>> list = RcyhUtils.xdjlYhs(getUser().getBmcode());
			JsonUtils.write(list, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 巡道记录 中 选择的 列表 当前登录用户 同级的养护站 所管辖的 路段
	 */
	public void xdjlLds(){
		try {
			List<HashMap<String,Object>> list = RcyhUtils.xdjlLds(getUser().getBmcode());
			list.get(0).put("selected", true);
			JsonUtils.write(list, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 根据巡查ID 显示 巡查ID 的详细信息
	 * @return
	 */
	public String showXdjl(){
		setResultpage("addXundaojl");
		setShow(true);
		xcsj = xdjlService.queryXdsjByKey(xcsj);
	//	xcsj.setJlr(RcyhUtils.usernameToString(xcsj.getJlr()));
	//	xcsj.setFzr(RcyhUtils.usernameToString(xcsj.getFzr()));
		xcsj.setJlr(RcyhUtils.getRynameByRyid(xcsj.getJlr())); // 回写记录人员 姓名
		xcsj.setFzr(RcyhUtils.getRynameByRyid(xcsj.getFzr())); // 回写负责人
		xcsj.setTq(RcyhUtils.mjlxConvert(Constants.tianqi, xcsj.getTq()));
		return SUCCESS;
	}
	
	public String exportXdjl(){
		setResultpage("exportXdjl");
		xcsj = xdjlService.queryXdsjByKey(xcsj);
		xcsj.setJlr(RcyhUtils.getRynameByRyid(xcsj.getJlr()));
		xcsj.setFzr(RcyhUtils.getRynameByRyid(xcsj.getFzr())); // 回写负责人
		xcsj.setTq(RcyhUtils.mjlxConvert(Constants.tianqi, xcsj.getTq()));
		System.out.println(xcsj);
		return SUCCESS;
	}
	
	
	public String exportXcjlDetail(){
		setResultpage("exportXcjlDetail");
		xcsj = xdjlService.getXcsjForExport(xcsj.getXcid());
		xcsj.setJlr(RcyhUtils.getRynameByRyid(xcsj.getJlr()));
		return SUCCESS;
	}
	
	/**
	 * 添加一条寻道记录
	 * @return
	 */
	@AnnotationAuth(mkid="010101")
	public String addXundaojl(){
		setAdd(true);
		getXcsj().setStime(RcyhUtils.getDateStr() + " 06:00:00"); 
		getXcsj().setEtime(RcyhUtils.getDateStr() + " 18:00:00");
		getXcsj().setJlr(getUser().getRyid()+"");
		getXcsj().setFzr(getUser().getRyid()+"");
		getXcsj().setBmcode(getUser().getBmcode());
		getXcsj().setUsername(getUser().getUsername());
		return SUCCESS;
	}
	
	/**
	 * 保存巡查数据
	 * TODO 后台数据校验
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@AnnotationAuth(mkid="010101")
	public void saveXdjl() throws IOException, Exception{
		int c = xdjlService.saveXdjl(getXcsj());
		if( c ==  1 ) {
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.INFO,"保存巡道记录成功");
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO,"保存巡道记录失败");
		}
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	
	/**
	 * 更新一条 寻道记录
	 * @return
	 */
	@AnnotationAuth(mkid="010101")
	public String updateXdjl(){
		setUpdate(true);
		setResultpage("addXundaojl");
		this.setXcsj(xdjlService.queryXdsjByKey(getXcsj()));		
		return SUCCESS;
	}
	
	@AnnotationAuth(mkid="010101")
	public void saveUpdateXdjl() throws IOException, Exception{
		int c = xdjlService.updateXdjl(xcsj);
		if( c ==  1 ) {
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.INFO,"更新巡道记录成功");
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO,"更新巡道记录失败");
		}
		JsonUtils.write(gmap, getResponse().getWriter());
	}
	
	/**
	 * 巡查数据列表
	 * @return
	 */
	@AnnotationAuth(mkid="010101")
	public String listXdjl(){
		return SUCCESS;
	}
	
	@AnnotationAuth(mkid="010101")
	public void xundaojlRows(){
		try {
			getXcsj().setPage(getPage());
			getXcsj().setRows(getRows());
		//	getXcsj().setBmcode(getUser().getBmcode());
			List<RcyhGlxcsjb> rows = xdjlService.listXdsj(getXcsj());
			for(RcyhGlxcsjb glxcsjb :rows) {
				glxcsjb.setUsername(RcyhUtils.usernameToString(glxcsjb.getUsername()));
				glxcsjb.setFzr(RcyhUtils.getRynameByRyid(glxcsjb.getFzr()));
				glxcsjb.setJlr(RcyhUtils.getRynameByRyid(glxcsjb.getJlr()));
				glxcsjb.setBmcode(RcyhUtils.getBmname(glxcsjb.getBmcode()));
				glxcsjb.setTq(RcyhUtils.mjlxConvert(Constants.tianqi, glxcsjb.getTq()));
			}
			int total = xdjlService.listXdsjCount(getXcsj());
			EasyUIPage<RcyhGlxcsjb> epage = new EasyUIPage<RcyhGlxcsjb>();
			epage.setRows(rows);
			epage.setTotal(total);
			JsonUtils.write(epage, getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据寻道记录的id 删除 一条 xdjl
	 * @return
	 */
	@AnnotationAuth(mkid="010101")
	public void delXdjl(){
		if(!xdjlService.canDelXdjl(getXcsj())){ // 拥有子记录 不能删除
			getGmap().put(Constants.ISSUCCESS, false);
			getGmap().put(Constants.INFO,"查询到此条记录拥有关联的病害记录，无法删除！");
		}else{
			try {
				xdjlService.delXdjl(getXcsj());
				getGmap().put(Constants.ISSUCCESS, true);
			} catch (Exception e) {
				getGmap().put(Constants.ISSUCCESS, false);
				getGmap().put(Constants.INFO,"后台抛出了异常！");
				e.printStackTrace();
			}
		}
		try {
			JsonUtils.write(getGmap(), getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getXdgjShape() throws IOException, Exception{
		HashMap<String,Object> map  = MapCatchUtil.getXdjlShapeByXcid(xcsj.getXcid());
		if( map != null ) {
			gmap.put(Constants.ISSUCCESS, true);
			gmap.put(Constants.DATA,map);
		}else{
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put(Constants.INFO, "没有查询该条巡道记录对应的轨迹信息");
		}
		
		JsonUtils.write(gmap, getResponse().getWriter());
		
	}
	
	public String xdcx(){
		return SUCCESS;
	}
	/**
	 * 查询统计巡道记录信息表用，按条件查询巡道记录
	 * @throws Exception
	 */
	public void getXdsjForXdcx() throws Exception{
		getXcsj().setPage(getPage());
		getXcsj().setRows(getRows());
		List<RcyhGlxcsjb> rows = xdjlService.getXdjlForXdcx(getXcsj());
		for(RcyhGlxcsjb glxcsjb :rows) {
			glxcsjb.setUsername(RcyhUtils.usernameToString(glxcsjb.getUsername()));
			glxcsjb.setFzr(RcyhUtils.getRynameByRyid(glxcsjb.getFzr()));
			glxcsjb.setJlr(RcyhUtils.getRynameByRyid(glxcsjb.getJlr()));
			glxcsjb.setBmcode(RcyhUtils.getBmname(glxcsjb.getBmcode()));
			glxcsjb.setTq(RcyhUtils.mjlxConvert(Constants.tianqi, glxcsjb.getTq()));
		}
		int total = xdjlService.getXdjlCountForXdcx(getXcsj());
		EasyUIPage<RcyhGlxcsjb> epage = new EasyUIPage<RcyhGlxcsjb>();
		epage.setRows(rows);
		epage.setTotal(total);
		JsonUtils.write(epage, getResponse().getWriter());
	}
}
