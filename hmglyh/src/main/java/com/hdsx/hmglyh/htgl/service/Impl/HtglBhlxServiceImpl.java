package com.hdsx.hmglyh.htgl.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.htgl.bean.HtglBhlx;
import com.hdsx.hmglyh.htgl.mapper.HtglBhlxMapper;
import com.hdsx.hmglyh.htgl.service.HtglBhlxService;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  后台管理 - 病害类型 - ServiceImpl
 * @author LiRui
 * @created 2015年5月28日 上午10:56:27 
 */
@Service
@Transactional
public class HtglBhlxServiceImpl implements HtglBhlxService {

	@Resource(name="htglBhlxMapper")
	private HtglBhlxMapper mapper;

	@Override
	public boolean bhlxAddOne(HtglBhlx bhlx) {
		if(mapper.bhlxAddOne(bhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean bhlxDeleteOne(HtglBhlx bhlx) {
		if(mapper.bhlxDeleteOne(bhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean bhlxUpdateOne(HtglBhlx bhlx) {
		if(mapper.bhlxUpdateOne(bhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean bhlxUpdateOneQyzt(HtglBhlx bhlx) {
		if(mapper.bhlxUpdateOneQyzt(bhlx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<HtglBhlx> queryAllBySome(HtglBhlx bhlx) {
		return mapper.queryAllBySome(bhlx);
	}

	@Override
	public int countNumBySome(HtglBhlx bhlx) {
		return mapper.countNumBySome(bhlx);
	}

	@Override
	public HtglBhlx queryBhlxDataToCreateTree(HtglBhlx bhlx) {
		//HtglBhlx bh = mapper.selectFather(bhlx);
		HtglBhlx bh = new HtglBhlx();
		if("".equals(bhlx.getBhid())){
			bh = new HtglBhlx("","全部病害类型",1);
			bh.setLength(bhlx.getLength());
		}else{
			bh = mapper.selectFather(bhlx);
		}
		List<HtglBhlx> children = getChildren(bh,bh.getLength());
		bh.setChildren(children);
		return bh;
	}

	/*@Override
	 public HtglBhlx queryBhlxDataToCreateTree() {
		HtglBhlx bhlxAll = new HtglBhlx("","全部病害类型");
		List<HtglBhlx> bhlxList = mapper.selectFather(bhlxAll);
		for(HtglBhlx bh : bhlxList){
			List<HtglBhlx> children = getChildren(bh,bh.getLength());
			bhlxAll.setChildren(children);
		}
		return bhlxAll;
	}*/

	/**
	 * 循环遍历创建“病害类型”子节点
	 */
	public List<HtglBhlx> getChildren(HtglBhlx bh,int length) {
		if(bh.getBhid().length() == length)
			return new ArrayList<HtglBhlx>();
		else{
			List<HtglBhlx> children = mapper.selectChildren(bh);
			for(HtglBhlx bhlx : children){
				bhlx.setChildren(getChildren(bhlx,length));
			}
			return children;
		}
	}

	@Override
	public Combotree bhlxToCombotree(HtglBhlx bhlx) {
		Combotree combo = new Combotree();
		combo.setId(bhlx.getBhid());
		if(bhlx.getQyzt() == 0){
			combo.setText(bhlx.getBhname()+"<font color=red >（禁）</font>");
		}else if(bhlx.getQyzt() == 1){
			combo.setText(bhlx.getBhname());
		}else{
			combo.setText(bhlx.getBhname()+"<font color=red >（误）</font>");
		}
		List<Combotree> children = new ArrayList<Combotree>();
		for(HtglBhlx bh : bhlx.getChildren()){
			children.add(bhlxToCombotree(bh));
		}
		combo.setChildren(children);
		return combo;
	}

	@Override
	public String generationPK(HtglBhlx bhlx) {
		HtglBhlx bh = mapper.generationPK(bhlx);
		return bh.getBhid();
	}

}
