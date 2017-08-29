package com.hdsx.hmglyh.gis.jichusj.luxian.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLdb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLxb;
import com.hdsx.hmglyh.gis.util.Combobox;

@Mapper
public interface HtglLxbMapper {
   
    HtglLxb selectByPrimaryKey(String lxcode);

	List<Combobox> luxianCombobox(HashMap<String,Object> map);
	List<Combobox> luxianComboboxForBm(HashMap<String,Object> map);
	List<HtglLxb> luxianRows(HtglLxb lxb);
	int luxianCount(HtglLxb lxb);

	List<HtglLdb> luduanRows(HtglLdb ldb);
	int luduanCount(HtglLdb ldb);

	HashMap<String, Object> zhuanghaoByLxcodeAndBmcode(
			HashMap<String, Object> map);

	List<com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLdb> luduanCombobox(@Param("bmcode") String bmcode);
}
