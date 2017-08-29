package com.hdsx.hmglyh.rcyh.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhZyysjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhZyysjlbExample;
@Mapper
public interface RcyhZyysjlbMapper {
    int countByExample(RcyhZyysjlbExample example);

    int deleteByExample(RcyhZyysjlbExample example);

    int deleteByPrimaryKey(String ysid);

    int insert(RcyhZyysjlb record);

    int insertSelective(RcyhZyysjlb record);

    List<RcyhZyysjlb> selectByExample(RcyhZyysjlbExample example);

    RcyhZyysjlb selectByPrimaryKey(String ysid);

    int updateByExampleSelective(@Param("record") RcyhZyysjlb record, @Param("example") RcyhZyysjlbExample example);

    int updateByExample(@Param("record") RcyhZyysjlb record, @Param("example") RcyhZyysjlbExample example);

    int updateByPrimaryKeySelective(RcyhZyysjlb record);

    int updateByPrimaryKey(RcyhZyysjlb record);
    
    /**
     * 判断 当前月是否可以验收
     * @param yhid
     * @return
     */
	int canYs(HashMap<String,Object> variable);
}