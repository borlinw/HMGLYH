/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.rcyhtj.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.rcyhtj.bean.RcyhNdxxjlb;
import com.hdsx.hmglyh.rcyhtj.mapper.RcyhNdxxjlbMapper;
import com.hdsx.hmglyh.rcyhtj.service.RcyhNdxxjlbService;
/**
 * 
 * @author jason
 *
 */
@Transactional
@Service
public class RcyhNdxxjlbServiceImpl implements RcyhNdxxjlbService {
	@Resource(name="rcyhNdxxjlbMapper")
	private RcyhNdxxjlbMapper rcyhNdxxjlbMapper;
	@Override
	public List<RcyhNdxxjlb> queryXxjl(RcyhNdxxjlb r) {
		// TODO Auto-generated method stub
		return rcyhNdxxjlbMapper.queryXxjl(r);
	}
	@Override
	public int getXxCount(RcyhNdxxjlb r) {
		// TODO Auto-generated method stub
		return rcyhNdxxjlbMapper.getXxCount(r);
	}
	@Override
	public List<RcyhNdxxjlb> getNf(RcyhNdxxjlb r) {
		// TODO Auto-generated method stub
		return rcyhNdxxjlbMapper.getNf(r);
	}
	@Override
	public boolean add(RcyhNdxxjlb r) {
		rcyhNdxxjlbMapper.add(r);
		return true;
	}
	@Override
	public boolean change(RcyhNdxxjlb r) {
		rcyhNdxxjlbMapper.change(r);
		return true;
	}
	@Override
	public boolean drop(RcyhNdxxjlb r) {
		rcyhNdxxjlbMapper.drop(r);
		return true;
	}
	@Override
	public RcyhNdxxjlb queryByid(RcyhNdxxjlb r) {
		// TODO Auto-generated method stub
		return rcyhNdxxjlbMapper.queryByid(r);
	}

}
