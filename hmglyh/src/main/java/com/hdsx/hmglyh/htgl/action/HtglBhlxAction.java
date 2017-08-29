package com.hdsx.hmglyh.htgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.htgl.bean.HtglBhlx;
import com.hdsx.hmglyh.htgl.service.HtglBhlxService;
import com.hdsx.hmglyh.rcyh.service.BhService;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.HDFreeMarker;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;
import com.hdsx.hmglyh.util.SpringContextUtil;

/**  
 *  后台管理 - 病害类型 - Action
 * @author LiRui
 * @created 2015年5月28日 上午11:16:16 
 */
@Controller
@Scope(value="request")
public class HtglBhlxAction extends BaseActionSupport<HtglBhlx> {

	private static final long serialVersionUID = -3477680328955205636L;

	@Resource(name="htglBhlxServiceImpl")
	private HtglBhlxService service;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 创建病害类型Tree
	 */
	public void createBhlxTree() throws Exception{
		try{
			//查询需要创建Tree的“病害类型”数据
			HtglBhlx bhlx = service.queryBhlxDataToCreateTree(model);
			//将查询出来的数据装换成Combotree数据
			Combotree combo = service.bhlxToCombotree(bhlx);
			List<Combotree> combos = new ArrayList<Combotree>();
			combos.add(combo);
			JsonUtils.write(combos, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 测试用
	 * 描述：查询全部
	 */
	public void test(){
		try{
			List<HtglBhlx> aa = service.queryAllBySome(new HtglBhlx());
			JsonUtils.write(aa, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 查询全部
	 * 描述：病害id的层级
	 */
	@AnnotationAuth(mkid="0401")
	public void queryAllByBhid(){
		try{
			if(model == null){
				model = new HtglBhlx("", "");//构造方法（bhid,bhname）
			}
			List<HtglBhlx> modelList = service.queryAllBySome(model);
			EasyUIPage<HtglBhlx> ep = new EasyUIPage<HtglBhlx>();
			int n = service.countNumBySome(model);
			ep.setRows(modelList);
			ep.setTotal(n);
			JsonUtils.write(ep, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void createBhlxJsonFile(){
		// 生成病害 类型树 json 文件
		HDFreeMarker fm = new HDFreeMarker("template/");
		BhService bhService = (BhService) SpringContextUtil.getBean("bhServiceImpl");
		List<com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx> bhlxList = bhService.selectBhlxs();
		HashMap<String,Object> root = new HashMap<String,Object>();
		root.put("list", bhlxList);
		String path = ServletActionContext.getServletContext().getRealPath("/");
		fm.createJsonFile(root, "bhlxtree.ftl", path+"/template/bhlxtree.json");
	}
	
	/**
	 * 添加
	 */
	@AnnotationAuth(mkid="0401")
	public void insertOneBh(){
		try{
			String newBhid = service.generationPK(model);
			model.setBhid(newBhid);
			if(service.bhlxAddOne(model)){
				this.createBhlxJsonFile();
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
	@AnnotationAuth(mkid="0401")
	public void deleteOneBh(){
		try{
			if(service.bhlxDeleteOne(model)){
				this.createBhlxJsonFile();
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
	@AnnotationAuth(mkid="0401")
	public void updateOneBh(){
		try{
			if(service.bhlxUpdateOne(model)){
				this.createBhlxJsonFile();
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
	 * 启用/禁用某病害
	 */
	@AnnotationAuth(mkid="0401")
	public void updateOneBhQyzt(){
		try{
			if(model.getQyzt() == 1){
				model.setQyzt(0);
			}else if(model.getQyzt() == 0){
				model.setQyzt(1);
			}else{
				throw new Exception("“启用状态”接收异常。");
			}
			if(service.bhlxUpdateOneQyzt(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
			ResponseUtils.write(getResponse(), "false");
		}
	}

}
