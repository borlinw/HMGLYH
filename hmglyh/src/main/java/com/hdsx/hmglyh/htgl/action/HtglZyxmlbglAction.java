package com.hdsx.hmglyh.htgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.htgl.bean.HtglDeb;
import com.hdsx.hmglyh.htgl.bean.HtglYhlxb;
import com.hdsx.hmglyh.htgl.service.HtglZyxmlbglService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.HDFreeMarker;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  后台管理 - 作业项目类别管理Action
 * @author LiRui
 * @created 2015年6月11日 下午8:58:12 
 */
@Controller
@Scope(value="request")
public class HtglZyxmlbglAction extends BaseActionSupport<HtglYhlxb> {

	private static final long serialVersionUID = 3501755457314727327L;

	@Resource(name="htglZyxmlbglServiceImpl")
	private HtglZyxmlbglService service;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 创建“养护类型”数据Tree
	 */
	public void createYhlxbTree(){
		try{
			List<HtglYhlxb> yhlxList = service.createYhlxTree();
			List<Combotree> treeList = service.createListOfCombotree(yhlxList);
			JsonUtils.write(treeList, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void createYhlxJsonFile(){
		HDFreeMarker fm = new HDFreeMarker("template/");
		String path = ServletActionContext.getServletContext().getRealPath("/");
		List<com.hdsx.hmglyh.rcyh.dao.model.HtglYhlxb> yhlxlist = RcyhUtils.getYhlxTree();
		HashMap<String,Object> root = new HashMap<String,Object>();
		root.put("list", yhlxlist);
		fm.createJsonFile(root, "yhlxtree.ftl", path+"/template/yhlxtree.json");
	}
	

	/**
	 * 查询全部
	 * 参数：yhid（养护类型表主键）
	 */
	@AnnotationAuth(mkid="0402")
	public void queryAllByYhid(){
		try{
			List<HtglYhlxb> modelList = service.queryAllBySomeOfYhlx(model);
			EasyUIPage<HtglYhlxb> ep = new EasyUIPage<HtglYhlxb>();
			int n = service.countNumBySomeOfYhlx(model);
			ep.setRows(modelList);
			ep.setTotal(n);
			JsonUtils.write(ep, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 添加（养护类型）
	 */
	@AnnotationAuth(mkid="0402")
	public void addOneYhlx(){
		try{
			//创建新的yhid在Service层
			if(model.getDejs() == 0){
				model.setDejs(1);
			}
			if(service.addOneYhlxb(model)){
				this.createYhlxJsonFile();
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
	 * 删除（养护类型）
	 */
	@AnnotationAuth(mkid="0402")
	public void deleteOneYhlx(){
		try{
			if(service.deleteOneYhlxb(model)){
				this.createYhlxJsonFile();
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
	 * 修改（养护类型）
	 */
	@AnnotationAuth(mkid="0402")
	public void updateOneYhlx(){
		try{
			if(service.updateOneYhlxb(model)){
				this.createYhlxJsonFile();
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
	 * 修改“启用/禁用”
	 */
	@AnnotationAuth(mkid="0402")
	public void updateOneYhlxQyzt(){
		try{
			if(model.getQyzt() == 1){
				model.setQyzt(0);
			}else if(model.getQyzt() == 0){
				model.setQyzt(1);
			}else{
				throw new Exception("“启用状态”接收异常。");
			}
			if(service.updateOneYhlxbQyzt(model)){
				this.createYhlxJsonFile();
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
	 * 修改“定额状态”
	 */
	//代码思路：添加定额并启动“Dezt”，删除定额并关闭“Dezt”
	//方法转移至“insertDe”
	//方法已废弃
	public void updateOneYhlxbDezt(){
		try{
			/*if(model.getDezt() == 1){
				model.setDezt(0);
			}else if(model.getDezt() == 0){
				model.setDezt(1);
			}else{
				throw new Exception("“定额状态”接收异常。");
			}
			if(service.updateOneYhlxbDezt(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 修改“定额启动状态”
	 */
	@AnnotationAuth(mkid="0402")
	public void updateOneYhlxbDeqdzt(){
		try{
			if(model.getDeqdzt() == 1){
				model.setDeqdzt(0);
			}else if(model.getDeqdzt() == 0){
				model.setDeqdzt(1);
			}else{
				throw new Exception("“定额启动状态”接收异常。");
			}
			if(service.updateOneYhlxbDeqdzt(model)){
				this.createYhlxJsonFile();
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
	 * 修改“是否裂缝修补”
	 */
	@AnnotationAuth(mkid="0402")
	public void updateOneYhlxbIslfxb(){
		try{
			if(model.getIslfxb() == 1){
				model.setIslfxb(0);
			}else if(model.getIslfxb() == 0){
				model.setIslfxb(1);
			}else{
				throw new Exception("“是否裂缝修补”接收异常。");
			}
			if(service.updateOneYhlxbIslfxb(model)){
				this.createYhlxJsonFile();
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
	 * 修改“是否沥青路面修补”
	 */
	@AnnotationAuth(mkid="0402")
	public void updateOneYhlxbIslqlmxb(){
		try{
			if(model.getIslqlmxb() == 1){
				model.setIslqlmxb(0);
			}else if(model.getIslqlmxb() == 0){
				model.setIslqlmxb(1);
			}else{
				throw new Exception("“是否沥青路面修补”接收异常。");
			}
			if(service.updateOneYhlxbIslqlmxb(model)){
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
	 * 添加“定额”并更改所属养护类型的dezt=1
	 * 并启动“定额启动状态”=1
	 */
	@AnnotationAuth(mkid="0402")
	public void insertDe(){
		try{
			//处理“定额”信息
			List<HtglDeb> deList = new ArrayList<HtglDeb>();
			String deArray[] = model.getDeStrToAdd().split("##");//将每条“定额”信息拆分开
			String yhid = model.getYhid();
			for(int i = 0;i<deArray.length;i++){
				String deData[] = deArray[i].split(",");//拆分一条“定额”信息拿到lxid和sl
				HtglDeb de = new HtglDeb(yhid, deData[0], Double.parseDouble(deData[1]));
				deList.add(de);
			}
			if(service.addDe(deList)){
				model.setDezt(1);//添加定额之后“定额状态”就应该为：1
				if(service.updateOneYhlxbDezt(model)){
					model.setDeqdzt(1);
					if(service.updateOneYhlxbDeqdzt(model)){
						ResponseUtils.write(getResponse(), "true");
					}else{
						ResponseUtils.write(getResponse(), "false");
					}
				}else{
					ResponseUtils.write(getResponse(), "false");
				}
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
			ResponseUtils.write(getResponse(), "false");
		}
	}

	/**
	 * 删除“定额”并更改所属养护类型的dezt=0
	 */
	@AnnotationAuth(mkid="0402")
	public void deleteDe(){
		try{
			String yhid = model.getYhid();
			HtglDeb de = new HtglDeb(yhid, "", 0);
			if(service.deleteDeOfYhid(de)){
				model.setDezt(0);
				if(service.updateOneYhlxbDezt(model)){
					ResponseUtils.write(getResponse(), "true");
				}else{
					ResponseUtils.write(getResponse(), "false");
				}
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
			ResponseUtils.write(getResponse(), "false");
		}
	}

	/**
	 * 修改定额信息
	 * 描述：先删除后添加（不改变任何状态）
	 */
	@AnnotationAuth(mkid="0402")
	public void updateDe(){
		//处理“定额”信息
		List<HtglDeb> deList = new ArrayList<HtglDeb>();
		String deArray[] = model.getDeStrToAdd().split("##");//将每条“定额”信息拆分开
		String yhid = model.getYhid();
		for(int i = 0;i<deArray.length;i++){
			String deData[] = deArray[i].split(",");//拆分一条“定额”信息拿到lxid和sl
			HtglDeb de = new HtglDeb(yhid, deData[0], Double.parseDouble(deData[1]));
			deList.add(de);
		}
		if(service.deleteDeOfYhid(new HtglDeb(yhid, "", 0))){
			if(service.addDe(deList)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}else{
			ResponseUtils.write(getResponse(), "false");
		}
		//添加“定额”信息
		/*
		if(service.addDe(deList)){}*/
		
	}

	/**
	 * 根据yhid查询其下的所有定额信息
	 * 描述：查看某Yhid下的全部定额信息
	 */
	@AnnotationAuth(mkid="0402")
	public void queryAllDeByYhid(){
		try{
			HtglDeb newde = new HtglDeb(model.getYhid(), "", 0);
			List<HtglDeb> deList = service.queryAllDeByYhid(newde);
			//JsonUtils.write(deList, getResponse().getWriter());
			String deDataToStr = "";
			for(HtglDeb de : deList){
				if("".equals(deDataToStr)){
					deDataToStr = de.getLxid()+","+de.getLxname()+","+de.getSl()+","+de.getDw();
				}else{
					deDataToStr = deDataToStr+"##"+de.getLxid()+","+de.getLxname()+","+de.getSl()+","+de.getDw();
				}
			}
			ResponseUtils.write(getResponse(), deDataToStr);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
