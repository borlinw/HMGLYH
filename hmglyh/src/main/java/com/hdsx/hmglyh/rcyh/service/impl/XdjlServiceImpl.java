
package com.hdsx.hmglyh.rcyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.rcyh.dao.HtglYhbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhBhjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhGlxcsjbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhGlxcsjb;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;
import com.hdsx.hmglyh.rcyh.service.XdjlService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;

@Service
@Transactional
public class XdjlServiceImpl implements XdjlService {

	@Autowired
	private RcyhGlxcsjbMapper glxcsjbMapper;
	@Autowired
	private RcyhBhjlbMapper bhjlMapper;
	@Autowired
	private HtglYhbMapper yhMapper;
	
	@Autowired
	private WorkFlowService workflowService;

	@Override
	public RcyhGlxcsjb queryglxcsjbByUsername(String username) {
		return glxcsjbMapper.selectGlxcsjbByUsername(username);
	}
	
	@Override
	public RcyhGlxcsjb selectGlxcsjb(RcyhGlxcsjb xcsj) {
		return bhjlMapper.selectGlxcsjb(xcsj.getXcid());
	}

	@Override
	public List<RcyhGlxcsjb> listXdsj(RcyhGlxcsjb xdjl) {
		
		return glxcsjbMapper.listXdsj(xdjl);
	}

	@Override
	public int listXdsjCount(RcyhGlxcsjb xcsj) {
		return glxcsjbMapper.listXdsjCount(xcsj);
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int saveXdjl(RcyhGlxcsjb xdjl) {
		
		return glxcsjbMapper.insert(xdjl);
	}

	@Override
	public boolean canDelXdjl(RcyhGlxcsjb xdjl) {
		int count = glxcsjbMapper.canDelXdjl(xdjl);
		if(count == 0) return true;else return false;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void delXdjl(RcyhGlxcsjb xdjl) {
		glxcsjbMapper.deleteByPrimaryKey(xdjl.getXcid());
	}

	@Override
	public void delXdjls(RcyhGlxcsjb xdjl) {
		//TODO 删除多条寻道记录
	}

	@Override
	public RcyhGlxcsjb queryXdsjByKey(RcyhGlxcsjb xcsj) {
		return glxcsjbMapper.selectByPrimaryKey(xcsj);
	}	
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int updateXdjl(RcyhGlxcsjb xdjl) {
		return glxcsjbMapper.updateByPrimaryKeySelective(xdjl);
	}

	@Override
	public List<RcyhGlxcsjb> getXdjlForXdcx(RcyhGlxcsjb xdjl) {
		return glxcsjbMapper.getXdsj(xdjl);
	}

	@Override
	public int getXdjlCountForXdcx(RcyhGlxcsjb xdjl) {
		return glxcsjbMapper.getXdsjCount(xdjl);
	}

	@Override
	public RcyhGlxcsjb getXcsjForExport(String xcid) {
		RcyhGlxcsjb xcsj = glxcsjbMapper.getDetailByXcid(xcid);
		xcsj.setWxqk(glxcsjbMapper.getWxqkByXcid(xcid));
		return xcsj;
	}
	
	
	
	
}
