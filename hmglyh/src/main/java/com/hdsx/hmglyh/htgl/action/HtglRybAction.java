package com.hdsx.hmglyh.htgl.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.htgl.bean.HtglRyb;
import com.hdsx.hmglyh.htgl.service.HtglRybService;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  后台管理 - 人员表 - Action
 * @author LiRui
 * @created 2015年6月10日 下午7:32:12 
 */
@Controller
@Scope(value="request")
public class HtglRybAction extends BaseActionSupport<HtglRyb> {

	private static final long serialVersionUID = -3029245909064906030L;

	@Resource(name="htglRybServiceImpl")
	private HtglRybService service;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 查询
	 */
	@AnnotationAuth(mkid="0406")
	public void queryAllRy(){
		try{
			List<HtglRyb> modelList = service.queryAllBySome(model);
			EasyUIPage<HtglRyb> ep = new EasyUIPage<HtglRyb>();
			int n = service.countNumBySome(model);
			ep.setRows(modelList);
			ep.setTotal(n);
			JsonUtils.write(ep, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 添加
	 */
	@AnnotationAuth(mkid="0406")
	public void insertOneRy(){
		try{
			int newRyid = service.generationPK();
			model.setRyid(newRyid+""); // ？ 不知道什么操作 导致报错， zhanglm 改 
			if(service.addOneRy(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
			ResponseUtils.write(getResponse(), "false");
		}
	}

	/**
	 * 删除
	 */
	@AnnotationAuth(mkid="0406")
	public void deleteOneRy(){
		try{
			if(service.deleteOneRy(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
			ResponseUtils.write(getResponse(), "false");
		}
	}

	/**
	 * 修改
	 */
	@AnnotationAuth(mkid="0406")
	public void updateOneRy(){
		try{
			if(service.updateOneRy(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
			ResponseUtils.write(getResponse(), "false");
		}
	}
	
	/**
	 * 修改启用禁用状态
	 */
	@AnnotationAuth(mkid="0406")
	public void changeState(){
		try{
			if(service.changeState(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
			ResponseUtils.write(getResponse(), "false");
		}
	}

	/**
	 * 查询没有用户名的人员信息
	 * 描述：用于“用户表”的添加
	 */
	public void createRyComboboxWithNoUsername(){
		try{
			List<HtglRyb> ryList = service.queryAllWithNoUsername(model);
			List<Combobox> combos = new ArrayList<Combobox>();
			for(HtglRyb ry : ryList){
				Combobox combo = new Combobox(ry.getRyid()+"", ry.getRyname());
				combos.add(combo);
			}
			JsonUtils.write(combos, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 查询没有用户名的人员信息
	 * 描述：用于“用户表”的添加
	 */
	public void queryYear(){
		try{
			List<Combobox> list = service.queryYear();
			JsonUtils.write(list, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
