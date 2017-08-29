/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.basicData.bean.Bhlx;
import com.hdsx.hmglyh.basicData.mapper.BhlxMapper;
import com.hdsx.hmglyh.basicData.service.BhlxService;
import com.hdsx.hmglyh.util.Combotree;

/**
 * 病害类型
 * @author jason
 *
 */

@Service
public class BhlxServiceImpl implements BhlxService {
	@Resource(name="bhlxMapper")
	private BhlxMapper bhlxMapper;
	
	
	@Override
	public List<Bhlx> getAllBhlx() {
		// TODO Auto-generated method stub
		return bhlxMapper.getAllBhlx();
	}


	@Override
	public List<Bhlx> queryDataToCreatetree() {
		List<Bhlx> bhxx=new ArrayList<Bhlx>();
		bhxx = bhlxMapper.selectFather();
		for(Bhlx b:bhxx){
			List<Bhlx> children = getChildren(b);
			b.setChildren(children);
		}
		return bhxx;
	}
	/**
	 * 循环遍历创建"病害信息"子节点
	 */
	private List<Bhlx> getChildren(Bhlx bh){
		List<Bhlx>children = bhlxMapper.selectChildren(bh);
		if(children != null&& children.size()>0){
			for(Bhlx bhxx : children){
				bhxx.setChildren(getChildren(bhxx));;
			}
		}
		return children;
	}
	

	@Override
	public Combotree dataToComboTree(Bhlx bh) {
		Combotree combo = new Combotree();
		combo.setId(bh.getBhid());
		combo.setText(bh.getBhname());
		List<Combotree> children = new ArrayList<Combotree>();
		for(Bhlx bhxx:bh.getChildren()){
			children.add(dataToComboTree(bhxx));
		}
		combo.setChildren(children);
		return combo;
	}

}
