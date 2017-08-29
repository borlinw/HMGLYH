package com.hdsx.hmglyh.rcyh.dao;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.HtglLuduan;

@Mapper
public interface HtglLuduanMapper {
   List<HtglLuduan> luduanList(HtglLuduan luduan);
}