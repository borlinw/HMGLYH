package com.hdsx.hmglyh.rcyh.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.rcyh.dao.RcyhCxbbbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhCxbbb;
import com.hdsx.hmglyh.rcyh.service.RcyhCxbbbService;
import com.hdsx.hmglyh.util.Combobox;

/**  
 *  日常养护 - 除雪版本吧 - serviceImpl
 * @author LiRui
 * @created 2015年8月21日 下午1:24:16 
 */
@Service 
@Transactional 
public class RcyhCxbbbServiceImpl implements RcyhCxbbbService {

	@Resource(name="rcyhCxbbbMapper")
	private RcyhCxbbbMapper mapper;

	@Override
	public boolean addOneCxbbb(RcyhCxbbb cxbb) {
		if(mapper.addOneCxbbb(cxbb)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteOneCxbbb(RcyhCxbbb cxbb) {
		if(mapper.deleteOneCxbbb(cxbb)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneCxbbb(RcyhCxbbb cxbb) {
		if(mapper.updateOneCxbbb(cxbb)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<RcyhCxbbb> queryAll(RcyhCxbbb cxbb) {
		return mapper.queryAll(cxbb);
	}

	@Override
	public int countNum(RcyhCxbbb cxbb) {
		return mapper.countNum(cxbb);
	}

	@Override
	public int generationPK() {
		return mapper.generationPK();
	}

	@Override
	public RcyhCxbbb queryOneByBBID(RcyhCxbbb cxbb) {
		RcyhCxbbb cxbbb = mapper.queryOneByBBID(cxbb);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(cxbbb.getSsj() != null){
			cxbbb.setSsjStr(sdf.format(cxbbb.getSsj()));
		}
		if(cxbbb.getEsj() != null){
			cxbbb.setEsjStr(sdf.format(cxbbb.getEsj()));
		}
		return cxbbb;
	}

	@Override
	public List<Combobox> createCxbbbCombobox(RcyhCxbbb cxbb) {
		List<RcyhCxbbb> list = mapper.queryAll(cxbb);
		List<Combobox> boxList = new ArrayList<Combobox>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		for(RcyhCxbbb c : list){
			Combobox box = new Combobox(c.getBbid()+"", c.getBbmc());
			box.setSsjStr(sdf.format(c.getSsj()));
			box.setEsjStr(sdf.format(c.getEsj()));
			boxList.add(box);
		}
		return boxList;
	}

	@Override
	public boolean queryCxnbByBBIDAndBmcode(RcyhCxbbb cxbb) {
		System.out.println(mapper.queryCxnbByBBIDAndBmcode(cxbb)+"===================================================");
		if(mapper.queryCxnbByBBIDAndBmcode(cxbb) != null){
			System.out.println("=================================");
			return true;
		}else{
			return false;
		}
	}

}
