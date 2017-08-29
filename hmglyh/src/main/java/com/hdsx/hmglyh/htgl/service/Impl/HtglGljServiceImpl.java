package com.hdsx.hmglyh.htgl.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.htgl.bean.HtglGlj;
import com.hdsx.hmglyh.htgl.mapper.HtglGljMapper;
import com.hdsx.hmglyh.htgl.service.HtglGljService;
import com.hdsx.hmglyh.util.Attributes;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  后台管理 - 工料机ServiceImpl
 * @author LiRui
 * @created 2015年6月4日 下午2:49:05 
 */
@Service
@Transactional
public class HtglGljServiceImpl implements HtglGljService {

	@Resource(name="htglGljMapper")
	private HtglGljMapper mapper;

	@Override
	public HtglGlj queryDataToCreateTree(HtglGlj glj) {
		HtglGlj gg = new HtglGlj();
		if("".equals(glj.getLxid())){
			gg = new HtglGlj("","全部工料机",1);
		}else{
			gg = mapper.selectFather(glj);
		}
		List<HtglGlj> children = getChildren(gg);
		gg.setChildren(children);
		return gg;
	}

	/**
	 * 循环遍历创建“工料机”子节点
	 */
	public List<HtglGlj> getChildren(HtglGlj glj) {
			List<HtglGlj> children = mapper.selectChildren(glj);
			if(children != null && children.size()>0){
				for(HtglGlj gg : children){
					gg.setChildren(getChildren(gg));
				}
			}
			return children;
	}

	@Override
	public Combotree dataToCombotree(HtglGlj glj) {
		Combotree combo = new Combotree();
		combo.setId(glj.getLxid());
		//添加定额时增加单位的显示
		if(glj.getDw() != null){
			Attributes att = new Attributes();
			att.setDw(glj.getDw());
			combo.setAttributes(att);
		}
		if(glj.getQyzt() == 0){
			combo.setText(glj.getLxname()+"<font color=red >（禁）</font>");
		}else if(glj.getQyzt() == 1){
			combo.setText(glj.getLxname());
		}else{
			combo.setText(glj.getLxname()+"<font color=red >（误）</font>");
		}
		List<Combotree> children = new ArrayList<Combotree>();
		for(HtglGlj gg : glj.getChildren()){
			children.add(dataToCombotree(gg));
		}
		combo.setChildren(children);
		return combo;
	}

	@Override
	public String generationPK(HtglGlj glj) {
		return mapper.generationPK(glj).getLxid();
	}

	@Override
	public List<HtglGlj> queryGljByLxidAndBmcode(HtglGlj glj) {
		List<HtglGlj> gljList = mapper.queryAllBySome(glj);
		for(HtglGlj gg : gljList){
			HtglGlj g = mapper.queryJgByLxidAndBmcode(new HtglGlj(gg.getLxid(), glj.getBmcode(),""));
			if(g != null){
				gg.setBmcode(g.getBmcode());
				gg.setDj(g.getDj());
			}
		}
		return gljList;
	}

	@Override
	public int countNumBySome(HtglGlj glj) {
		return mapper.countNumBySome(glj);
	}

	@Override
	public boolean gljlxAddOne(HtglGlj glj) {
		if(mapper.gljlxAddOne(glj)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean gljlxDeleteOne(HtglGlj glj) {
		mapper.gljjgDelete(glj);//删除工料机价格
		if(mapper.gljlxDeleteOne(glj)>0){//删除工料机类型
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean gljlxUpdateOne(HtglGlj glj) {
		if(mapper.gljlxUpdateOne(glj)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean gljlxUpdateOneQyzt(HtglGlj glj) {
		if(mapper.gljlxUpdateOneQyzt(glj)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean gljjgAddOne(HtglGlj glj) {
		if(mapper.gljjgAddOne(glj)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean gljjgUpdateOne(HtglGlj glj) {
		if(mapper.gljjgUpdateOne(glj)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Combobox> queryAllToCreateComboboxToDeb() {
		List<HtglGlj> gljList = mapper.queryAllToCreateComboboxToDeb();
		List<Combobox> combos = new ArrayList<Combobox>();
		for(HtglGlj glj : gljList){
			Combobox combo = new Combobox(glj.getLxid(), glj.getLxname());
			combos.add(combo);
		}
		return combos;
	}

	@Override
	public List<HtglGlj> queryAllToCreateComboboxToDeb2() {
		List<HtglGlj> list = new ArrayList<HtglGlj>();
		HtglGlj cl = mapper.queryClToInsertDeb();
		HtglGlj jx = mapper.queryJxToInsertDeb();
		cl.setChildNum(100);//标识其下有子节点（不可被选定为定额）
		List<HtglGlj> childrenCl = getChildrenOfInsertDe(cl);
		cl.setChildren(childrenCl);
		jx.setChildNum(100);//标识其下有子节点（不可被选定为定额）
		List<HtglGlj> childrenJx = getChildrenOfInsertDe(jx);
		jx.setChildren(childrenJx);
		list.add(cl);
		list.add(jx);
		return list;
	}

	/**
	 * 循环遍历创建“工料机”子节点
	 * 用于：创建“添加定额”所需要的下拉树
	 */
	public List<HtglGlj> getChildrenOfInsertDe(HtglGlj glj) {
			List<HtglGlj> children = mapper.selectChildrenOfInsertDe(glj);
			if(children != null && children.size()>0){
				for(HtglGlj gg : children){
					gg.setChildren(getChildren(gg));
				}
			}
			return children;
	}

	@Override
	public Combotree createCombotreeToInsertDe(HtglGlj glj) {
		//添加“定额”专用
		Combotree combo = new Combotree();
		combo.setId(glj.getLxid());
		combo.setText(glj.getLxname());
		combo.setChildNum(glj.getChildNum());
		Attributes att = new Attributes();
		att.setChildNum(glj.getChildNum());
		combo.setAttributes(att);
		List<Combotree> children = new ArrayList<Combotree>();
		for(HtglGlj gg : glj.getChildren()){
			children.add(dataToCombotree(gg));
		}
		combo.setChildren(children);
		return combo;
	}

	@Override
	public boolean verifyBm(HtglGlj glj) {
		if(mapper.verifyBm(glj)>0){
			return true;
		}else{
			return false;
		}
	}

}
