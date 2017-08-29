package com.hdsx.hmglyh.htgl.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.htgl.bean.HtglRyb;
import com.hdsx.hmglyh.htgl.mapper.HtglRybMapper;
import com.hdsx.hmglyh.htgl.service.HtglRybService;
import com.hdsx.hmglyh.util.Combobox;

/**  
 *  后台管理 - 人员表 - ServiceImpl
 * @author LiRui
 * @created 2015年6月10日 下午7:28:46 
 */
@Service
@Transactional
public class HtglRybServiceImpl implements HtglRybService {

	@Resource(name="htglRybMapper")
	private HtglRybMapper mapper;

	@Override
	public boolean addOneRy(HtglRyb ry) {
		if(mapper.addOneRy(ry)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteOneRy(HtglRyb ry) {
		if(mapper.deleteOneRy(ry)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneRy(HtglRyb ry) {
		if(mapper.updateOneRy(ry)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<HtglRyb> queryAllBySome(HtglRyb ry) {
		return mapper.queryAllBySome(ry);
	}

	@Override
	public int countNumBySome(HtglRyb ry) {
		return mapper.countNumBySome(ry);
	}

	@Override
	public int generationPK() {
		return mapper.generationPK();
	}

	@Override
	public List<HtglRyb> queryAllWithNoUsername(HtglRyb ry) {
		return mapper.queryAllWithNoUsername(ry);
	}

	@Override
	public List<Combobox> queryYear() {
		Combobox c = new Combobox("", "全部");
		List<Combobox> list = new ArrayList<Combobox>();
		list.add(c);
		List<HtglRyb> dataList = mapper.queryYear();
		for(HtglRyb r : dataList){
			Combobox cc = new Combobox(r.getYear(), r.getYear()+"年");
			list.add(cc);
		}
		return list;
	}

	@Override
	public boolean changeState(HtglRyb ry) {
		if(mapper.changeState(ry)>0)
			return true;
		return false;
	}

}
