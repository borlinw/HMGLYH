package com.hdsx.hmglyh.rcyh.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.login.bean.Auth;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;
import com.hdsx.hmglyh.util.Constants;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="prototype")
public class HomeController extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<HashMap<String,Object>> bhjlTasks = new ArrayList<HashMap<String,Object>>();
	private List<HashMap<String,Object>> bhsbTasks = new ArrayList<HashMap<String,Object>>();
	private List<HashMap<String,Object>> bhpgTasks = new ArrayList<HashMap<String,Object>>(); 
	private List<HashMap<String,Object>> bhwxTasks = new ArrayList<HashMap<String,Object>>();
	private List<HashMap<String,Object>> wxsbTasks = new ArrayList<HashMap<String,Object>>();
	private List<HashMap<String,Object>> wxysTasks = new ArrayList<HashMap<String,Object>>();
	private HashMap<String,Object> mks = new HashMap<String,Object>();
	
	@Autowired
	private WorkFlowService workFlowService;
	
	private List<Auth> menus = new ArrayList<Auth>();
	
	public HashMap<String, Object> getMks() {
		return mks;
	}

	public void setMks(HashMap<String, Object> mks) {
		this.mks = mks;
	}

	public List<HashMap<String, Object>> getBhjlTasks() {
		return bhjlTasks;
	}

	public void setBhjlTasks(List<HashMap<String, Object>> bhjlTasks) {
		this.bhjlTasks = bhjlTasks;
	}

	public List<HashMap<String, Object>> getBhsbTasks() {
		return bhsbTasks;
	}

	public void setBhsbTasks(List<HashMap<String, Object>> bhsbTasks) {
		this.bhsbTasks = bhsbTasks;
	}

	public List<HashMap<String, Object>> getBhpgTasks() {
		return bhpgTasks;
	}

	public void setBhpgTasks(List<HashMap<String, Object>> bhpgTasks) {
		this.bhpgTasks = bhpgTasks;
	}

	public List<HashMap<String, Object>> getBhwxTasks() {
		return bhwxTasks;
	}

	public void setBhwxTasks(List<HashMap<String, Object>> bhwxTasks) {
		this.bhwxTasks = bhwxTasks;
	}

	public List<HashMap<String, Object>> getWxsbTasks() {
		return wxsbTasks;
	}

	public void setWxsbTasks(List<HashMap<String, Object>> wxsbTasks) {
		this.wxsbTasks = wxsbTasks;
	}

	public List<HashMap<String, Object>> getWxysTasks() {
		return wxysTasks;
	}

	public void setWxysTasks(List<HashMap<String, Object>> wxysTasks) {
		this.wxysTasks = wxysTasks;
	}

	public List<Auth> getMenus() {
		return menus;
	}

	public void setMenus(List<Auth> menus) {
		this.menus = menus;
	}

	/**
	 * 页面 上方
	 * @return
	 */
	public String top(){
		return SUCCESS;
				
	}
	
	/**
	 * 主页
	 * @return
	 */
	public String index(){
		return SUCCESS;
	}
	
	/**
	 * 左侧菜单 
	 */
	public String left(){
		// struts2 标签 用的 不够好 ， 还是在这里 直接 组织个 对象 传过去 算了
		
		for( Auth auth : getUser().getRole().getAuths() ) {
			if( auth.getMkid().startsWith("01") && auth.getMkid().length() == 4 ) {
				menus.add(auth);
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * 日常养护首页
	 * @return
	 */
	public String main(){
		// 查询 当前用户 需要 办理的 业务  在首页显示
		// 单独 分配给 此用户的任务 
		
		List<Task> tasks = workFlowService.queryTaskUser(getUser().getUsername());
		
		for(Task t : tasks ) {
			
			String key = t.getTaskDefinitionKey();
			
			if("binghaijilu".equals(key)) { // 病害记录
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				bhjlTasks.add(map);
			}
			else if( "binghaishangbao".equals(key)) { //  病害上报
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				bhsbTasks.add(map);
			
			}
			else if( "binghaipaigong".equals(key) ) { // 病害派工
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				bhpgTasks.add(map);
				
			} 
			else if( "weixiuzuoye".equals(key) ) { // 维修作业
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				bhwxTasks.add(map);
				
			}
			else if( "zuoyeshangbao".equals(key) ) { // 作业上报
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				wxsbTasks.add(map);
				
			}
			else if( "zuoyeyanshou".equals(key) ) { // 作业审核 	
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				wxysTasks.add(map);
				
			}
		}
		
		
		
		// 查看用户 所具有的 权限 
		for( Auth auth : getUser().getRole().getAuths() ) {
			if( auth.getMkid().startsWith("01") && auth.getMkid().length() == 6 ) {
				mks.put("mid"+auth.getMkid(), true);
			}
		}
		
		return SUCCESS;
	}

	
	/**
	 * 页面底部
	 * @return
	 */
	public String bottom(){
		return SUCCESS;
	}
	
	//即时提醒
	public void remember() throws IOException, Exception{
		List<Task> tasks = workFlowService.queryTaskUser(getUser().getUsername());
		
		if(tasks.size() == 0 ) {
			gmap.put(Constants.ISSUCCESS, false);
			gmap.put("bhjlTasks", bhjlTasks.size());
			gmap.put("bhsbTasks", bhsbTasks.size());
			gmap.put("bhpgTasks", bhpgTasks.size());
			gmap.put("bhwxTasks", bhwxTasks.size());
			gmap.put("wxsbTasks", wxsbTasks.size());
			gmap.put("wxysTasks", wxysTasks.size());
			JsonUtils.write(gmap, getResponse().getWriter());
			return;
		}
		
		for(Task t : tasks ) {
			String key = t.getTaskDefinitionKey();
			if("binghaijilu".equals(key)) { // 病害记录
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				bhjlTasks.add(map);
			}
			else if( "binghaishangbao".equals(key)) { //  病害上报
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				bhsbTasks.add(map);
			
			}
			else if( "binghaipaigong".equals(key) ) { // 病害派工
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				bhpgTasks.add(map);
				
			} 
			else if( "weixiuzuoye".equals(key) ) { // 维修作业
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				bhwxTasks.add(map);
				
			}
			else if( "zuoyeshangbao".equals(key) ) { // 作业上报
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				wxsbTasks.add(map);
				
			}
			else if( "zuoyeyanshou".equals(key) ) { // 作业审核 	
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("name",t.getName());
				wxysTasks.add(map);
				
			}
		
		}
		gmap.put(Constants.ISSUCCESS, true);
		gmap.put("bhjlTasks", bhjlTasks.size());
		gmap.put("bhsbTasks", bhsbTasks.size());
		gmap.put("bhpgTasks", bhpgTasks.size());
		gmap.put("bhwxTasks", bhwxTasks.size());
		gmap.put("wxsbTasks", wxsbTasks.size());
		gmap.put("wxysTasks", wxysTasks.size());
		JsonUtils.write(gmap, getResponse().getWriter());
		
	}
}
