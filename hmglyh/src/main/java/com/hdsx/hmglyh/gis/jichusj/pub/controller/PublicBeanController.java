
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.pub.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.pub.dao.model.PublicBean;
import com.hdsx.hmglyh.gis.jichusj.pub.service.PublicBeanService;
import com.hdsx.hmglyh.util.JsonUtils;

/**  
 *  
 * @author Baiyy
 * @created 2016年5月25日 上午10:31:05 
 */
@Controller
@Scope(value="request")
public class PublicBeanController{
	@Resource(name="publicBeanServiceImpl")
	private PublicBeanService pbService;
	
	private PublicBean pb = new PublicBean();
	
	public PublicBean getPb() {
		return pb;
	}

	public void setPb(PublicBean pb) {
		this.pb = pb;
	}
	/**
	 * 提供表头，列名，表名，以及查询条件，导出数据
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception{
		String rows = new String(pb.getData().getBytes("ISO-8859-1"),"UTF-8");
		String data = rows.substring(0, rows.length()-1).replaceAll("#", "||'</td><td>'||");
		pb.setData("'<tr><td>'||" + data + "||'</td></tr>'");
		
		pb.setCondition(new String(pb.getCondition().getBytes("ISO-8859-1"),"UTF-8"));
		
		System.out.println(pb.getData()+"============");
		List<String> result = pbService.getData(pb);
		String html = new String(pb.getTitle().getBytes("ISO-8859-1"),"UTF-8");
		for(String a:result){
			html += a;
		}
		pb.setHtml(html);
		
		return "success";
	}
	/**
	 * 用于构造物导出，参数太长，无法用url直接跳转
	 * @throws Exception
	 */
	public void getHtmlForGzw() throws Exception{
		String rows = pb.getData();
		String data = rows.substring(0, rows.length()-1).replaceAll("#", "||'</td><td>'||");
		pb.setData("'<tr><td>'||" + data + "||'</td></tr>'");
		
		System.out.println(pb.getData()+"============");
		List<String> result = pbService.getData(pb);
		String html = pb.getTitle();
		for(String a:result){
			html += a;
		}
		pb.setHtml(html);
		
		ServletActionContext.getRequest().getSession().setAttribute("pb", pb);
		
		JsonUtils.write(pb, ServletActionContext.getResponse().getWriter());
	}



}
