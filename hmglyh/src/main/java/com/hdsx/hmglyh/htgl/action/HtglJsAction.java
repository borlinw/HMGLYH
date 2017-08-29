package com.hdsx.hmglyh.htgl.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.htgl.bean.HtglJs;
import com.hdsx.hmglyh.htgl.service.HtglJsService;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  后台管理 - 角色Action
 * @author LiRui
 * @created 2015年6月11日 上午11:22:36 
 */
@Controller
@Scope(value="request")
public class HtglJsAction extends BaseActionSupport<HtglJs> {

	private static final long serialVersionUID = 2183332463575768847L;

	@Resource(name="htglJsServiceImpl")
	private HtglJsService server;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 创建角色下拉框
	 * 用于：“用户”模块：添加/查询/编辑
	 */
	public void createJsCombobox(){
		try{
			List<Combobox> combbList = server.createJsCombobox(model);
			JsonUtils.write(combbList, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 创建“模块（页面）”Tree
	 * 用于：“添加/编辑”角色
	 */
	public void createMkCombotree(){
		try{
			List<HtglJs> jsList = server.queryDataToCreateYmTree();
			List<Combotree> treeList = new ArrayList<Combotree>();
			for(HtglJs js : jsList){
				Combotree tree = server.dataToCombotree(js);
				treeList.add(tree);
			}
			JsonUtils.write(treeList, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 查询全部
	 */
	@AnnotationAuth(mkid="0408")
	public void queryAllJs(){
		try{
			List<HtglJs> modelList = server.queryAllJs(new HtglJs());
			EasyUIPage<HtglJs> ep = new EasyUIPage<HtglJs>();
			int n = server.countNum();
			ep.setRows(modelList);
			ep.setTotal(n);
			JsonUtils.write(ep, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 添加角色
	 */
	@AnnotationAuth(mkid="0408")
	public void addOneJs(){
		try{
			int newJsid = server.generationPK();
			model.setJsid(newJsid);
			if(server.addOneJs(model)){
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
	@AnnotationAuth(mkid="0408")
	public void deleteOneJs(){
		try{
			if(server.deleteOneJs(model)){
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
	@AnnotationAuth(mkid="0408")
	public void updateOneJs(){
		try{
			if(server.updateOneJs(model)){
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
