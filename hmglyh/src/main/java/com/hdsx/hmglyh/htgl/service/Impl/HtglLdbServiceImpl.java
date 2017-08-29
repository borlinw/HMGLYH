package com.hdsx.hmglyh.htgl.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.htgl.bean.HtglLdb;
import com.hdsx.hmglyh.htgl.mapper.HtglLdbMapper;
import com.hdsx.hmglyh.htgl.service.HtglLdbService;
import com.hdsx.hmglyh.util.Combobox;

/**  
 *  后台管理 - 路线表ServiceImpl
 * @author LiRui
 * @created 2015年6月10日 上午10:54:17 
 */
@Service
@Transactional
public class HtglLdbServiceImpl implements HtglLdbService {

	@Resource(name="htglLdbMapper")
	private HtglLdbMapper mapper;

	@Override
	public List<HtglLdb> selectAllLdBySome(HtglLdb ld) {
		return mapper.selectAllLdBySome(ld);
	}

	@Override
	public int countNumBySome(HtglLdb ld) {
		return mapper.countNumBySome(ld);
	}

	@Override
	public List<Combobox> queryLxToCreateCombobox(String lxQueryType) {
		List<HtglLdb> ldList = mapper.queryLxToCreateCombobox();
		List<Combobox> comboList = new ArrayList<Combobox>();
		if("all".equals(lxQueryType)){
			Combobox combox = new Combobox("", "全部");
			comboList.add(combox);
		}
		for(HtglLdb ld : ldList){
			String newLxName = ld.getLxcode()+"("+ld.getLxname()+")";
			//Combobox combox = new Combobox(ld.getLxcode(), ld.getLxname());
			Combobox combox = new Combobox(ld.getLxcode(), newLxName);
			combox.setSzhh(ld.getSzhh());
			combox.setEzhh(ld.getEzhh());
			comboList.add(combox);
		}
		return comboList;
	}

	@Override
	public boolean addOneLd(HtglLdb ld) {
		if(mapper.addOneLd(ld)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteOneLd(HtglLdb ld) {
		if(mapper.deleteOneLd(ld)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOneLd(HtglLdb ld) {
		if(mapper.updateOneLd(ld)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String generationPK(HtglLdb ld) {
		return mapper.generationPK(ld).getLdcode();
	}

	@Override
	public List<Combobox> queryLdByBmcodeAndCreateCombobox(HtglLdb ldbData) {
		List<HtglLdb> ldList = mapper.queryLdByBmcodeToCreateCombobox(ldbData);
		List<Combobox> comboboxList = new ArrayList<Combobox>();
		for(HtglLdb ld : ldList){
			Combobox box = new Combobox(ld.getLdcode(), ld.getLdname());
			box.setSzhh(ld.getSzhh());
			box.setEzhh(ld.getEzhh());
			box.setLxcode(ld.getLxcode());
			comboboxList.add(box);
		}
		return comboboxList;
	}

}
