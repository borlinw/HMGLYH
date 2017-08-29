
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.jcpd.bean.Qdhfb;
import com.hdsx.hmglyh.jcpd.bean.Qdhfshb;
import com.hdsx.hmglyh.jcpd.mapper.QdhfshbMapper;
import com.hdsx.hmglyh.jcpd.service.QdhfshbService;

/**  
 *  
 * @author Baiyy
 * @created 2015年8月8日 下午2:40:02 
 */
@Transactional
@Service
public class QdhfshbServiceImpl implements QdhfshbService {
	@Resource(name="qdhfshbMapper")
	private QdhfshbMapper qdhfshbMapper;
	
	@Override
	public boolean report(Qdhfshb qdhfshb) {
		if(!qdhfshbMapper.isAbleToReport(qdhfshb))
			return false;
		if(qdhfshbMapper.addShb(qdhfshb)>0)
			return true;
		return false;
	}
	
	@Override
	public boolean reReport(Qdhfshb qdhfshb) {
		if(!qdhfshbMapper.isAbleToReport(qdhfshb))
			return false;
		if(qdhfshbMapper.report(qdhfshb)>0)
			return true;
		return false;
	}

	@Override
	public boolean check(Qdhfshb qdhfshb) {
		if(qdhfshbMapper.check(qdhfshb)>0)
			return true;
		return false;
	}

	@Override
	public List<Qdhfshb> getShb(Qdhfshb qdhfshb) {
		// TODO Auto-generated method stub
		return qdhfshbMapper.getShb(qdhfshb);
	}

	@Override
	public List<Qdhfshb> getShbForReport(Qdhfshb qdhfshb) {
		List<Qdhfshb> list = new ArrayList<Qdhfshb>();
		List<Qdhfshb> qd = qdhfshbMapper.getShbForReport(qdhfshb);
		if(qd != null){
			for(Qdhfshb q:qd){
				if(qdhfshbMapper.isAbleToReport(q))
					list.add(q);
			}
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Qdhfb> getQdhf(Qdhfshb qdhfshb) {
		// TODO Auto-generated method stub
		return qdhfshbMapper.getQdhf(qdhfshb);
	}

	@Override
	public int getQdhfCount(Qdhfshb qdhfshb) {
		// TODO Auto-generated method stub
		return qdhfshbMapper.getQdhfCount(qdhfshb);
	}

}
