package com.hdsx.hmglyh.htgl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.htgl.bean.HtglYhb;
import com.hdsx.hmglyh.htgl.mapper.HtglYhMapper;
import com.hdsx.hmglyh.htgl.service.HtglYhbService;

/**  
 *  后台管理 - 用户表ServiceImpl
 * @author LiRui
 * @created 2015年6月11日 下午1:33:18 
 */
@Service
@Transactional
public class HtglYhbServiceImpl implements HtglYhbService {

	@Resource(name="htglYhMapper")
	private HtglYhMapper mapper;

	@Override
	public boolean addOneYh(HtglYhb yh) {
		if(mapper.addOneYh(yh)>0){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean deleteOneYh(HtglYhb yh) {
		if(mapper.deleteOneYh(yh)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneYh(HtglYhb yh) {
		if(mapper.updateOneYh(yh)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneYhQyzt(HtglYhb yh) {
		if(mapper.updateOneYhQyzt(yh)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<HtglYhb> queryAllBySome(HtglYhb yh) {
		return mapper.queryAllBySome(yh);
	}

	@Override
	public int countNumBySome(HtglYhb yh) {
		return mapper.countNumBySome(yh);
	}
	@Override
	public boolean verifyUsername(HtglYhb yh) {
		if(mapper.verifyUsername(yh)>0){
			return true;
		}else{
			return false;
		}
	}

}
