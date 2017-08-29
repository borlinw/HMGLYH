package com.hdsx.hmglyh.htgl.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.htgl.service.HtglBmService;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  后台管理 - 部门Action
 * @author LiRui
 * @created 2015年6月5日 上午11:24:45 
 */
@Controller
@Scope(value="request")
public class HtglBmAction extends BaseActionSupport<HtglBm> {

	private static final long serialVersionUID = -966035293468899466L;

	@Resource(name="htglBmServiceImpl")
	private HtglBmService service;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 创建部门树
	 */
	public void createDapartTree(){
		try{
			//查询需要创建Tree的“部门信息”
			HtglBm bmxx = service.queryDataToCreateTree(model);
			//将查询出来的数据装换成Combotree数据
			Combotree combo = service.dataToCombotree(bmxx);
			List<Combotree> combos = new ArrayList<Combotree>();
			combos.add(combo);
			JsonUtils.write(combos, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 根据Bmcode查询全部信息
	 */
	@AnnotationAuth(mkid="0404")
	public void queryAllByBmcode(){
		try{
			if(model == null){
				model = new HtglBm();//构造方法
			}
			List<HtglBm> modelList = service.queryAllBySome(model);
			EasyUIPage<HtglBm> ep = new EasyUIPage<HtglBm>();
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
	@AnnotationAuth(mkid="0404")
	public void insertOneBm(){
		try{
			if(service.bmAddOne(model)){
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
	@AnnotationAuth(mkid="0404")
	public void deleteOneBm(){
		try{
			if(service.bmDeleteOne(model)){
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
	@AnnotationAuth(mkid="0404")
	public void updateOneBm(){
		try{
			if(service.bmUpdateOne(model)){
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
	 * 启用/禁用某部门
	 */
	@AnnotationAuth(mkid="0404")
	public void updateOneBmQyzt(){
		try{
			if(model.getQyzt() == 1){
				model.setQyzt(0);
			}else if(model.getQyzt() == 0){
				model.setQyzt(1);
			}else{
				throw new Exception("“启用状态”接收异常。");
			}
			if(service.bmUpdateOneQyzt(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "false");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 根据部门编码查询其下所有bmcode.length=6的部门
	 * 描述：用于点击“工料机”Tree上的查询条件
	 * @param bm
	 * @return
	 */
	public void queryBmToGlj(){
		try{
			if(model.getBmcode().length()<4){
				model.setBmcode("0");
			}
			List<HtglBm> bmList = service.queryBmToGlj(model);
			//2015-06-16废弃
			/*String bmStr = "";
			for(int i = 0;i<bmList.size();i++){
				if(i == 0){
					bmStr = bmList.get(i).getBmcode()+","+bmList.get(i).getBmname();
				}else{
					bmStr = bmStr + ";" + bmList.get(i).getBmcode()+","+bmList.get(i).getBmname();
				}
				//再次遍历List，整合数据
			}
			System.out.println("整合后的部门编码为："+bmStr);
			ResponseUtils.write(getResponse(), bmStr);*/
			List<Combobox> comboList = new ArrayList<Combobox>();
			for(HtglBm bm : bmList){
				Combobox com = new Combobox(bm.getBmcode(), bm.getBmname());
				comboList.add(com);
			}
			JsonUtils.write(comboList, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 根据部门编码查询部门名称（工料机Grid中的价格数据的限制）
	 */
	public void queryBmnameByBmcode(){
		try{
			String bmname = service.queryBmnameByBmcode(model);
			ResponseUtils.write(getResponse(), bmname);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
