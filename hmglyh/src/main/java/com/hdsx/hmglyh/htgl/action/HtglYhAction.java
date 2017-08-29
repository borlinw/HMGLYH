package com.hdsx.hmglyh.htgl.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.htgl.bean.HtglYhb;
import com.hdsx.hmglyh.htgl.service.HtglYhbService;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  后台管理 - 用户Action
 * @author LiRui
 * @created 2015年6月11日 下午1:37:30 
 */
@Controller
@Scope(value="request")
public class HtglYhAction extends BaseActionSupport<HtglYhb> {

	private static final long serialVersionUID = -8811373194819890974L;

	@Resource(name="htglYhbServiceImpl")
	private HtglYhbService service;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 查询全部
	 * 描述：参数Bmcode
	 */
	@AnnotationAuth(mkid="0407")
	public void queryAll(){
		try{
			List<HtglYhb> modelList = service.queryAllBySome(model);
			EasyUIPage<HtglYhb> ep = new EasyUIPage<HtglYhb>();
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
	@AnnotationAuth(mkid="0407")
	public void insertOneYh(){
		try{
			if(service.addOneYh(model)){
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
	@AnnotationAuth(mkid="0407")
	public void deleteOneYh(){
		try{
			if(service.deleteOneYh(model)){
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
	@AnnotationAuth(mkid="0407")
	public void updateOneYh(){
		try{
			if(service.updateOneYh(model)){
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
	 * 修改（“启用/禁用”）
	 */
	@AnnotationAuth(mkid="0407")
	public void updateOneYhQyzt(){
		try{
			if(model.getQyzt() == 1){
				model.setQyzt(0);
			}else if(model.getQyzt() == 0){
				model.setQyzt(1);
			}else{
				throw new Exception("“启用状态”接收异常。");
			}
			if(service.updateOneYhQyzt(model)){
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
	 * 验证用户名是否存在
	 */
	@AnnotationAuth(mkid="0407")
	public void verifyUsername(){
		try{
			if(service.verifyUsername(model)){
				//若用户已存在，则返回true
				ResponseUtils.write(getResponse(), "aa");
			}else{
				ResponseUtils.write(getResponse(), "");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
