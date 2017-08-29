package com.hdsx.hmglyh.htgl.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.htgl.bean.HtglLdb;
import com.hdsx.hmglyh.htgl.service.HtglLdbService;
import com.hdsx.hmglyh.util.AnnotationAuth;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  后台管理 - 路段表Action
 * @author LiRui
 * @created 2015年6月10日 上午11:04:56 
 */
@Controller
@Scope(value="request")
public class HtglLdbAction extends BaseActionSupport<HtglLdb> {

	private static final long serialVersionUID = 2123905450277114467L;

	@Resource(name="htglLdbServiceImpl")
	private HtglLdbService server;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 创建“路线”的Combobox下拉框
	 * 描述：用于“查询全部”和“添加路段”
	 */
	public void createLxCombobox(){
		try{
			List<Combobox> comboboxList = server.queryLxToCreateCombobox(model.getLxQueryType());
			JsonUtils.write(comboboxList, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 查询全部
	 */
	@AnnotationAuth(mkid="0405")
	public void queryAllBySome(){
		try{
			List<HtglLdb> modelList = server.selectAllLdBySome(model);
			EasyUIPage<HtglLdb> ep = new EasyUIPage<HtglLdb>();
			int n = server.countNumBySome(model);
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
	@AnnotationAuth(mkid="0405")
	public void addOneLd(){
		try{
			//路段的ldcode是其所属的bmcode+两位，在这里将bmcode作为ldcode传入查询下一个可用的ldcode
			model.setLdcode(model.getBmcode());
			String newLdcode = server.generationPK(model);
			model.setLdcode(newLdcode);
			//拼接路段名称
			String newLdname = model.getLxname()+"(K"+Double.toString(model.getSzhh())+"-K"+Double.toString(model.getEzhh())+")";
			model.setLdname(newLdname);
			double mileage = model.getEzhh()-model.getSzhh();
			model.setMileage(mileage);
			if(server.addOneLd(model)){
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
	@AnnotationAuth(mkid="0405")
	public void deleteOneLd(){
		try{
			if(server.deleteOneLd(model)){
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
	 * 描述：根据ldcode对ldname，szhh，ezhh，mileage，bz进行修改
	 */
	@AnnotationAuth(mkid="0405")
	public void updateOneLd(){
		try{
			//拼接路段名称
			String newLdname = model.getLxname()+"(K"+Double.toString(model.getSzhh())+"-K"+Double.toString(model.getEzhh())+")";
			model.setLdname(newLdname);
			double mileage = model.getEzhh()-model.getSzhh();
			model.setMileage(mileage);
			if(server.updateOneLd(model)){
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
	 * 创建“路段”的Combobox下拉框
	 * 描述：现在仅用于除雪快报表中的路段选择
	 */
	public void createLdCombobox(){
		try{
			List<Combobox> comboboxList = server.queryLdByBmcodeAndCreateCombobox(model);
			//List<Combobox> comboboxList = server.queryLxToCreateCombobox(model.getLxQueryType());
			JsonUtils.write(comboboxList, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
