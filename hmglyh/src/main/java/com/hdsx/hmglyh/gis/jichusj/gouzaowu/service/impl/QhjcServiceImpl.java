package com.hdsx.hmglyh.gis.jichusj.gouzaowu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.QhjcMapper;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Hddqjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Hdjcxjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qhjc;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qlbjqstpb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qldqjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qljcxjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.service.QhjcService;

/**  
 *  
 * @author Baiyy
 * @created 2017年9月4日 下午11:16:13 
 */
@Service
@Transactional
public class QhjcServiceImpl implements QhjcService {
	
	@Resource(name="qhjcMapper")
	private QhjcMapper qhjcMapper;

	@Override
	public List<Qljcxjcb> queryQljcxjc(Qhjc q) {
		return qhjcMapper.queryQljcxjc(q);
	}

	@Override
	public int getQljcxjcCount(Qhjc q) {
		return qhjcMapper.getQljcxjcCount(q);
	}

	@Override
	public List<Hdjcxjcb> queryHdjcxjc(Qhjc q) {
		return qhjcMapper.queryHdjcxjc(q);
	}

	@Override
	public int getHdjcxjcCount(Qhjc q) {
		return qhjcMapper.getHdjcxjcCount(q);
	}

	@Override
	public boolean addQldqjc(Qhjc q) {
		if(qhjcMapper.addQldqjc(q)>0)
			return true;
		return false;
	}

	@Override
	public List<Qldqjcb> queryQldqjc(Qhjc q) {
		return qhjcMapper.queryQldqjc(q);
	}

	@Override
	public int getQldqjcCount(Qhjc q) {
		return qhjcMapper.getQldqjcCount(q);
	}

	@Override
	public boolean addHddqjc(Qhjc q) {
		if(qhjcMapper.addHddqjc(q)>0)
			return true;
		return false;
	}

	@Override
	public List<Hddqjcb> queryHddqjc(Qhjc q) {
		return qhjcMapper.queryHddqjc(q);
	}

	@Override
	public int getHddqjcCount(Qhjc q) {
		return qhjcMapper.getHddqjcCount(q);
	}

	@Override
	public boolean addTpbm(List<Qlbjqstpb> list) {
		if(list == null || list.size() == 0)
			return true;
		
		qhjcMapper.dropTpbm(list.get(0).getQldqjcid());
		for(Qlbjqstpb q:list){
			if(qhjcMapper.addTpbm(q) == -1)
				return false;
		}
		return true;
	}

	@Override
	public List<Qlbjqstpb> getTpbm(String qldqjcid) {
		return qhjcMapper.getTpbm(qldqjcid);
	}

	@Override
	public boolean addQljcxjc(Qhjc q) {
		if(qhjcMapper.addQljcxjc(q) != -1)
			return true;
		return false;
	}

	@Override
	public boolean addHdjcxjc(Qhjc q) {
		if(qhjcMapper.addHdjcxjc(q) != -1)
			return true;
		return false;
	}

	@Override
	public boolean deleteQldqjc(Qhjc q) {
		
		return false;
	}

}
