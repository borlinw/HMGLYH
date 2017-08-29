package com.hdsx.hmglyh.htgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.htgl.bean.HtglGlj;
import com.hdsx.hmglyh.htgl.service.HtglGljService;
import com.hdsx.hmglyh.rcyh.dao.model.HtglGljlxb;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.HDFreeMarker;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  后台管理 - 工料机Action
 * @author LiRui
 * @created 2015年6月4日 下午3:05:40 
 */
@Controller
@Scope(value="request")
public class HtglGljAction extends BaseActionSupport<HtglGlj> {

	private static final long serialVersionUID = -566703609530288781L;

	@Resource(name="htglGljServiceImpl")
	private HtglGljService server;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 创建“工料机”树
	 */
	public void createGljTree(){
		try{
			//查询需要创建Tree的“病害类型”数据
			HtglGlj glj = server.queryDataToCreateTree(model);
			//将查询出来的数据装换成Combotree数据
			Combotree combo = server.dataToCombotree(glj);
			List<Combotree> combos = new ArrayList<Combotree>();
			combos.add(combo);
			JsonUtils.write(combos, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 查询全部
	 * 参数：lxid，bmcode
	 */
	@AnnotationAuth(mkid="0403")
	public void queryAllBySome(){
		try{
			List<HtglGlj> modelList = server.queryGljByLxidAndBmcode(model);
			EasyUIPage<HtglGlj> ep = new EasyUIPage<HtglGlj>();
			int n = server.countNumBySome(model);
			ep.setRows(modelList);
			ep.setTotal(n);
			JsonUtils.write(ep, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void createGljtreeJsonFile(){
		HDFreeMarker fm = new HDFreeMarker("template/");
		HashMap<String,Object> root = new HashMap<String,Object>();
		String path = ServletActionContext.getServletContext().getRealPath("/");
		List<HtglGljlxb> cllist = RcyhUtils.getGljclTree();
		root.put("list", cllist);
		fm.createJsonFile(root, "clgljtree.ftl", path+"/template/clgljtree.json");
		List<HtglGljlxb> jxlist = RcyhUtils.getGljjxTree();
		root.put("list", jxlist);
		fm.createJsonFile(root, "jxgljtree.ftl", path+"/template/jxgljtree.json");
	}

	/**
	 * 添加（类型）
	 */
	@AnnotationAuth(mkid="0403")
	public void gljlxAddOne(){
		try{
			String newLxid = server.generationPK(model);
			model.setLxid(newLxid);
			if(server.gljlxAddOne(model)){
				this.createGljtreeJsonFile();
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
	 * 删除（类型+价格）
	 */
	@AnnotationAuth(mkid="0403")
	public void gljlxDeleteOne(){
		try{
			if(server.gljlxDeleteOne(model)){
				this.createGljtreeJsonFile();
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
	 * 修改（类型）
	 */
	@AnnotationAuth(mkid="0403")
	public void gljlxUpdateOne(){
		try{
			if(server.gljlxUpdateOne(model)){
				this.createGljtreeJsonFile();
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
	 * 修改（“启用/禁用”状态）
	 */
	@AnnotationAuth(mkid="0403")
	public void gljlxUpdateOneQyzt(){
		try{
			if(model.getQyzt() == 1){
				model.setQyzt(0);
			}else if(model.getQyzt() == 0){
				model.setQyzt(1);
			}else{
				throw new Exception("“启用状态”接收异常。");
			}
			if(server.gljlxUpdateOneQyzt(model)){
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
	 * 添加（价格）
	 */
	@AnnotationAuth(mkid="0403")
	public void gljjgAddOne(){
		try{
			if(server.gljjgAddOne(model)){
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
	 * 修改（价格）
	 */
	@AnnotationAuth(mkid="0403")
	public void gljjgUpdateOne(){
		try{
			if(server.gljjgUpdateOne(model)){
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
	 * 创建“工料机”下拉框
	 * 查询全部非“类型”类的“工料机”
	 * 用于：作业项目类别管理中的“添加定额”
	 * 2016-06-16废弃（添加定额的时候需的是一个Combotree，而不是Combobox）
	 */
	public void createGljCombobox(){
		try{
			List<Combobox> combos = server.queryAllToCreateComboboxToDeb();
			JsonUtils.write(combos, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 创建“工料机”Combotree
	 * 描述：用于添加”定额“
	 * 2016-06-16新建的方法
	 * 因为此方法仅用于添加定额，因此权限限制为有“养护类别管理”权限的用户访问
	 */
	public void createGljCombotreeToInsertDe(){
		try{
			List<HtglGlj> list = server.queryAllToCreateComboboxToDeb2();
			List<Combotree> trees = new ArrayList<Combotree>();
			for(HtglGlj g : list){
				Combotree tree = server.createCombotreeToInsertDe(g);
				trees.add(tree);
			}
			JsonUtils.write(trees, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 验证编码是否存在
	 */
	public void verifyBm(){
		try{
			if(server.verifyBm(model)){
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
