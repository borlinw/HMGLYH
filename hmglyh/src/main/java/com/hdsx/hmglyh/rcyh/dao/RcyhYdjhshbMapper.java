package com.hdsx.hmglyh.rcyh.dao;

import org.apache.ibatis.annotations.Param;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhYdjhshb;

@Mapper
public interface RcyhYdjhshbMapper {
    int insert(RcyhYdjhshb record);
    int insertSelective(RcyhYdjhshb record);
	int updateByCondition(RcyhYdjhshb r);
	RcyhYdjhshb queryYdjhshByCondition(@Param("bmcode") String bmcode,@Param("ldcode") String ldcode,@Param("ssny") String ssny);
	int canTijiaosh(@Param("bmcode") String bmcode,@Param("ldcode") String ldcode,@Param("ssny") String ssny);
}