package com.hdsx.hmglyh.rcyh.dao;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhXdgjb;

@Mapper
public interface RcyhXdgjbMapper {
    int deleteByPrimaryKey(String xcid);

    int insert(RcyhXdgjb record);

    int insertSelective(RcyhXdgjb record);

    RcyhXdgjb selectByPrimaryKey(String xcid);

    int updateByPrimaryKeySelective(RcyhXdgjb record);

    int updateByPrimaryKeyWithBLOBs(RcyhXdgjb record);

    int updateByPrimaryKey(RcyhXdgjb record);
}