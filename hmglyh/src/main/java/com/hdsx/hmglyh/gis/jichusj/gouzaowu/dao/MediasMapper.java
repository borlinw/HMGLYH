package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Medias;
@Mapper
public interface MediasMapper {
    int insert(Medias record);
    int insertSelective(Medias record);
    Medias selectByKey(String id);
    void deleteByKey(String id);
}