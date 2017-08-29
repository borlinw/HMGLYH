/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.mapper.BbkzbMapper;
import com.hdsx.hmglyh.jcpd.service.BbkzbService;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月28日 下午11:48:46 
 */
@Transactional
@Service
public class BbkzbServiceImpl implements BbkzbService {
	@Resource(name="bbkzbMapper")
	private BbkzbMapper bbkzbMapper;
	
	@Override
	public boolean addBbkzb(Bbkzb b) {
		bbkzbMapper.addBbkzb(b);
		return true;
	}

	@Override
	public boolean changeBbkzb(Bbkzb b) {
		if(bbkzbMapper.isUsed(b).size() != 0)
			return false;
		bbkzbMapper.changeBbkzb(b);
		return true;
	}

	@Override
	public List<Bbkzb> queryBb(Bbkzb b) {
		return bbkzbMapper.queryBb(b);
	}

	@Override
	public int getBbCount(Bbkzb b) {
		return bbkzbMapper.getBbCount(b);
	}

	@Override
	public boolean dropBb(Bbkzb b) {
		if(bbkzbMapper.isUsed(b).size() != 0)
			return false;
		bbkzbMapper.dropBb(b);
		return true;
	}

	@Override
	public List<Bbkzb> getBbid(Bbkzb b) {
		System.out.println(b.getBbid()+"==="+b.getBblx());
		return bbkzbMapper.getBbid(b);
	}

	@Override
	public List<Bbkzb> getBb(Bbkzb b) {
		
		return bbkzbMapper.getBb(b);
	}

	@Override
	public List<Bbkzb> getBbForLmjc(Bbkzb bbkzb) {
		return bbkzbMapper.getBbForLmjc(bbkzb);
	}

	@Override
	public List<Bbkzb> getBbForQdhf(Bbkzb bbkzb) {
		return bbkzbMapper.getBbForQdhf(bbkzb);
	}

}
