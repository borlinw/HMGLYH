package com.hdsx.hmglyh.htgl.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.htgl.bean.HtglDeb;
import com.hdsx.hmglyh.htgl.bean.HtglYhlxb;
import com.hdsx.hmglyh.htgl.mapper.HtglZyxmlbglMapper;
import com.hdsx.hmglyh.htgl.service.HtglZyxmlbglService;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  后台管理 - 作业项目类别管理
 * @author LiRui
 * @created 2015年6月11日 下午8:37:47 
 */
@Service
@Transactional
public class HtglZyxmlbglServiceImpl implements HtglZyxmlbglService {

	@Resource(name="htglZyxmlbglMapper")
	private HtglZyxmlbglMapper mapper;

	@Override
	public boolean addOneYhlxb(HtglYhlxb yhlx) {
		String newYhid = mapper.generationPKOfYhlx(yhlx);
		yhlx.setYhid(newYhid);
		if(mapper.addOneYhlxb(yhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteOneYhlxb(HtglYhlxb yhlx) {
		if(mapper.deleteOneYhlxb(yhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneYhlxb(HtglYhlxb yhlx) {
		if(mapper.updateOneYhlxb(yhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneYhlxbQyzt(HtglYhlxb yhlx) {
		if(mapper.updateOneYhlxbQyzt(yhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<HtglYhlxb> queryAllBySomeOfYhlx(HtglYhlxb yhlx) {
		return mapper.queryAllBySomeOfYhlx(yhlx);
	}

	@Override
	public int countNumBySomeOfYhlx(HtglYhlxb yhlx) {
		return mapper.countNumBySomeOfYhlx(yhlx);
	}

	@Override
	public List<HtglYhlxb> createYhlxTree() {
		List<HtglYhlxb> yhlxList = mapper.selectFatherOfYhlx();
		for(HtglYhlxb yhlx : yhlxList){
			List<HtglYhlxb> children = getChildren(yhlx);
			yhlx.setChildren(children);
		}
		return yhlxList;
	}

	/**
	 * 循环遍历创建“养护类型”子节点
	 */
	public List<HtglYhlxb> getChildren(HtglYhlxb yhlx) {
		List<HtglYhlxb> children = mapper.selectChildrenOfYhlx(yhlx);
		if(children != null && children.size() != 0){
			for(HtglYhlxb yh : children){
				yh.setChildren(getChildren(yh));
			}
			return children;
		}else{
			return new ArrayList<HtglYhlxb>();
		}
	}

	@Override
	public List<Combotree> createListOfCombotree(List<HtglYhlxb> yhlxList) {
		List<Combotree> combotreeList = new ArrayList<Combotree>();
		for(HtglYhlxb yh : yhlxList){
			Combotree tree = dataToCombotree(yh);
			combotreeList.add(tree);
		}
		return combotreeList;
	}

	/**
	 * 将单条“养护类型”数据转化为单条Combotree
	 */
	public Combotree dataToCombotree(HtglYhlxb yhlx) {
		Combotree combo = new Combotree(yhlx.getYhid(), yhlx.getYhname());
		List<Combotree> children = new ArrayList<Combotree>();
		for(HtglYhlxb yh : yhlx.getChildren()){
			children.add(dataToCombotree(yh));
		}
		combo.setChildren(children);
		return combo;
	}

	@Override
	public boolean updateOneYhlxbDezt(HtglYhlxb yhlx) {
		if(mapper.updateOneYhlxbDezt(yhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneYhlxbDeqdzt(HtglYhlxb yhlx) {
		if(mapper.updateOneYhlxbDeqdzt(yhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneYhlxbIslfxb(HtglYhlxb yhlx) {
		if(mapper.updateOneYhlxbIslfxb(yhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneYhlxbIslqlmxb(HtglYhlxb yhlx) {
		if(mapper.updateOneYhlxbIslqlmxb(yhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean addDe(List<HtglDeb> deList) {
		for(HtglDeb de : deList){
			if(!(mapper.addOneDe(de)>0)){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean deleteDeOfYhid(HtglDeb de) {
		List<HtglDeb> deList = mapper.queryDeByYhid(de);
		if(deList == null || deList.size() == 0){
			return true;
		}else{
			if(mapper.deleteDeOfYhid(de)>0){
				return true;
			}else{
				return false;
			}
		}
	}

	@Override
	public List<HtglDeb> queryAllDeByYhid(HtglDeb de) {
		return mapper.queryDeByYhid(de);
	}

}
