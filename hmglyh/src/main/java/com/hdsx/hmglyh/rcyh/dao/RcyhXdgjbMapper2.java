package com.hdsx.hmglyh.rcyh.dao;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhXdgjb2;

@Mapper
public interface RcyhXdgjbMapper2 {
    int deleteByPrimaryKey(String xcid);

    int insert(RcyhXdgjb2 record);

    int insertSelective(RcyhXdgjb2 record);

    RcyhXdgjb2 selectByPrimaryKey(String xcid);

    int updateByPrimaryKeySelective(RcyhXdgjb2 record);

    int updateByPrimaryKeyWithBLOBs(RcyhXdgjb2 record);

    int updateByPrimaryKey(RcyhXdgjb2 record);
}