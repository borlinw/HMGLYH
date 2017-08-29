/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.ydjh.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.ydjh.bean.RcyhRwdjlb;
import com.hdsx.hmglyh.ydjh.mapper.YdjhMapper;
import com.hdsx.hmglyh.ydjh.service.YdjhService;

@Transactional
@Service
public class YdjhServiceImpl implements YdjhService {
	@Resource(name="ydjhMapper")
	private YdjhMapper ydjhMapper;


	@Override
	public List<RcyhRwdjlb> getRwdBytj(RcyhRwdjlb rcyhRwdjlb) {
		// TODO Auto-generated method stub
		return ydjhMapper.getRwdBytj(rcyhRwdjlb);
	}
	@Override
	public int getRwdBytjCount(RcyhRwdjlb rcyhRwdjlb) {
		// TODO Auto-generated method stub
		return ydjhMapper.getRwdBytjCount(rcyhRwdjlb);
	}

	
	

}
