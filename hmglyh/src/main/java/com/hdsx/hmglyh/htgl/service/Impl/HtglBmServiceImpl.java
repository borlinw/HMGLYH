package com.hdsx.hmglyh.htgl.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.htgl.mapper.HtglBmMapper;
import com.hdsx.hmglyh.htgl.service.HtglBmService;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  部门信息ServiceImpl
 * @author LiRui
 * @created 2015年6月5日 上午11:03:23 
 */
@Service
@Transactional
public class HtglBmServiceImpl implements HtglBmService {

	@Resource(name="htglBmMapper")
	private HtglBmMapper mapper;

	@Override
	public HtglBm queryDataToCreateTree(HtglBm bm) {
		HtglBm bmxx = new HtglBm();
		if("".equals(bm.getBmcode()) || bm.getBmcode() == null || bm.getBmcode().length()<4){
			bmxx = new HtglBm("01","全部部门信息",1);
		}else{
			bmxx = mapper.selectFather(bm);
		}
		List<HtglBm> children = getChildren(bmxx);
		bmxx.setChildren(children);
		return bmxx;
	}

	/**
	 * 循环遍历创建“部门信息”子节点
	 */
	public List<HtglBm> getChildren(HtglBm bm) {
			List<HtglBm> children = mapper.selectChildren(bm);
			if(children != null && children.size()>0){
				for(HtglBm bmxx : children){
					bmxx.setChildren(getChildren(bmxx));
				}
			}
			return children;
	}

	@Override
	public Combotree dataToCombotree(HtglBm bm) {
		Combotree combo = new Combotree();
		combo.setId(bm.getBmcode());
		combo.setQyzt(bm.getQyzt());
		if(bm.getQyzt() == 0){
			combo.setText(bm.getBmname()+"<font color=red >（禁）</font>");
		}else if(bm.getQyzt() == 1){
			combo.setText(bm.getBmname());
		}else{
			combo.setText(bm.getBmname()+"<font color=red >（误）</font>");
		}
		List<Combotree> children = new ArrayList<Combotree>();
		for(HtglBm bmxx : bm.getChildren()){
			children.add(dataToCombotree(bmxx));
		}
		combo.setChildren(children);
		return combo;
	}

	@Override
	public List<HtglBm> queryAllBySome(HtglBm bm) {
		return mapper.queryAllBySome(bm);
	}

	@Override
	public int countNumBySome(HtglBm bm) {
		return mapper.countNumBySome(bm);
	}

	@Override
	public boolean bmAddOne(HtglBm bm) {
		if(bm.getBmcode().length()<4){
			bm.setBmcode("01");
		}
		String newBmcode = mapper.generationPK(bm).getBmcode();//请求可用主键
		bm.setBmcode(newBmcode);
		if(mapper.bmAddOne(bm)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean bmDeleteOne(HtglBm bm) {
		if(mapper.bmDeleteOne(bm)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean bmUpdateOne(HtglBm bm) {
		if(mapper.bmUpdateOne(bm)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean bmUpdateOneQyzt(HtglBm bm) {
		if(mapper.bmUpdateOneQyzt(bm)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<HtglBm> queryBmToGlj(HtglBm bm) {
		return mapper.queryBmToGlj(bm);
	}

	@Override
	public String queryBmnameByBmcode(HtglBm bm) {
		return mapper.queryBmnameByBmcode(bm);
	}

}
