package com.hdsx.hmglyh.htgl.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.htgl.bean.HtglJs;
import com.hdsx.hmglyh.htgl.mapper.HtglJsMapper;
import com.hdsx.hmglyh.htgl.service.HtglJsService;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  后台管理 - 角色ServiceImpl
 * @author LiRui
 * @created 2015年6月11日 上午11:10:53 
 */
@Service
@Transactional
public class HtglJsServiceImpl implements HtglJsService {

	@Resource(name="htglJsMapper")
	private HtglJsMapper mapper;

	@Override
	public boolean addOneJs(HtglJs js) {
		if(mapper.addOneJs(js)>0){//添加角色
			//添加角色OK之后循环遍历添加角色页面对应信息
			int jsid = js.getJsid();
			String mkStr[] = js.getJsmkStr().split(",");
			for(int i = 0;i<mkStr.length;i++){
				if(mapper.addJsMk(new HtglJs(jsid, mkStr[i]))>0){
					//添加角色页面关系表
				}else{
					return false;
				}
			}
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int generationPK() {
		return mapper.generationPK();
	}

	@Override
	public boolean deleteOneJs(HtglJs js) {
		mapper.delereJsMk(js);
		if(mapper.deleteOneJs(js)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneJs(HtglJs js) {
		mapper.delereJsMk(js);//先删除某角色对应的“角色页面对应信息”
		if(mapper.updateOneJs(js)>0){
			//修改角色OK之后循环遍历添加角色页面对应信息
			int jsid = js.getJsid();
			String mkStr[] = js.getJsmkStr().split(",");
			for(int i = 0;i<mkStr.length;i++){
				if(mapper.addJsMk(new HtglJs(jsid, mkStr[i]))>0){
					//添加角色页面关系表
				}else{
					return false;
				}
			}
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<HtglJs> queryAllJs(HtglJs js) {
		List<HtglJs> jsList = mapper.queryAllJs(js);
		for(HtglJs j : jsList){
			String mkStr = mapper.queryJsMkByJsid(j);
			j.setJsmkStr(mkStr);
		}
		return jsList;
	}

	@Override
	public int countNum() {
		return mapper.countNum();
	}

	@Override
	public List<Combobox> createJsCombobox(HtglJs js) {
		List<HtglJs> jsList = mapper.queryAllJsToYh();
		List<Combobox> comboxList = new ArrayList<Combobox>();
		if("all".equals(js.getQueryTypeOfYh())){
			Combobox com = new Combobox("", "全部");
			comboxList.add(com);
		}
		for(HtglJs j : jsList){
			Combobox com = new Combobox(j.getJsid()+"", j.getJsname());
			comboxList.add(com);
		}
		return comboxList;
	}

	@Override
	public List<HtglJs> queryDataToCreateYmTree() {
		List<HtglJs> jsList = mapper.selectFatherOfMk();
		for(HtglJs js : jsList){
			List<HtglJs> children = getChildren(js);
			js.setChildren(children);
		}
		return jsList;
	}

	/**
	 * 循环遍历创建“页面配置”子节点
	 */
	public List<HtglJs> getChildren(HtglJs js) {
		List<HtglJs> children = mapper.selectChildrenOfMk(js);
		if(children != null && children.size() != 0){
			for(HtglJs j : children){
				j.setChildren(getChildren(j));
			}
			return children;
		}else{
			return new ArrayList<HtglJs>();
		}
	}

	@Override
	public Combotree dataToCombotree(HtglJs js) {
		Combotree combo = new Combotree(js.getMkid(), js.getMkname());
		List<Combotree> children = new ArrayList<Combotree>();
		for(HtglJs j : js.getChildren()){
			children.add(dataToCombotree(j));
		}
		combo.setChildren(children);
		return combo;
	}

}
