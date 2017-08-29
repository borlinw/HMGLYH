
package com.hdsx.hmglyh.rcyh.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.rcyh.dao.RcyhRwdjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhYdjhshbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhYdjhshb;
import com.hdsx.hmglyh.rcyh.service.YdjhshService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.Constants;

@Service
@Transactional
public class YdjhshServiceImpl implements YdjhshService{

	Log log = LogFactory.getLog(YdjhshServiceImpl.class);
	
	@Autowired
	RcyhRwdjlbMapper rwdMapper;
	
	@Autowired
	RcyhYdjhshbMapper ydjhshMapper;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int tijiaoShenhe(RcyhYdjhshb ydjhsh) {
			int c = ydjhshMapper.insertSelective(ydjhsh);
			if( c > 0 ) {
				log.info(ydjhsh.getBmcode()+"部门在"+ydjhsh.getLdcode()+ "添加了一条月度计划申请记录");
			}
			
			// 更新任务单状态 为 不可修改
			List<RcyhRwdjlb> listRwd = rwdMapper.listJhshRwd(ydjhsh.getBmcode(),ydjhsh.getLdcode(),ydjhsh.getSsny());
			for( RcyhRwdjlb rwd : listRwd ) {
				rwd.setRwdzt(Constants.RwdYdjh2);
				rwdMapper.updateByPrimaryKeySelective(rwd);
			}
			
			return c;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int shenhe(RcyhYdjhshb ydjhsh) {
			int c = ydjhshMapper.updateByCondition(ydjhsh);			
			if( c > 0 ) {
				log.info("计划审核表更新成功");
			}
			
			if( ydjhsh.getShzt() == 2 ) { // 打回修改 将任务单状态 更改新为可修改 可删除
				List<RcyhRwdjlb> listRwd = rwdMapper.listJhshRwd(ydjhsh.getBmcode(),ydjhsh.getLdcode(),ydjhsh.getSsny());
				for( RcyhRwdjlb rwd : listRwd ) {
					rwd.setRwdzt(Constants.RwdYdjh1);
					rwdMapper.updateByPrimaryKeySelective(rwd);
				}
			}else if(ydjhsh.getShzt() == 1 || ydjhsh.getShzt() == 0) {
				List<RcyhRwdjlb> listRwd = rwdMapper.listJhshRwd(ydjhsh.getBmcode(),ydjhsh.getLdcode(),ydjhsh.getSsny());
				for( RcyhRwdjlb rwd : listRwd ) {
					rwd.setRwdzt(Constants.RwdYdjh2);
					rwdMapper.updateByPrimaryKeySelective(rwd);
				}
			}
			
			return c;
	}

	@Override
	public RcyhYdjhshb queryYhjhshByCondition(String bmcode,String ldcode,String ssny) {
		return ydjhshMapper.queryYdjhshByCondition(bmcode,ldcode,ssny);
	}

	@Override
	public boolean canTijiaosh(String bmcode, String ldcode, String ssny) {
		int c = ydjhshMapper.canTijiaosh(bmcode,ldcode,ssny);
		if( c > 0 ) {
			return false;
		}else{
			return true;
		}
	}
}
