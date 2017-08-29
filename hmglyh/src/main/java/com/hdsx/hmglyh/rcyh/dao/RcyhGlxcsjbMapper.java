package com.hdsx.hmglyh.rcyh.dao;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhGlxcsjb;

@Mapper
public interface RcyhGlxcsjbMapper {
    int deleteByPrimaryKey(String xcid);

    int insert(RcyhGlxcsjb record);

    int insertSelective(RcyhGlxcsjb record);

    RcyhGlxcsjb selectByPrimaryKey(RcyhGlxcsjb record);

    int updateByPrimaryKeySelective(RcyhGlxcsjb record);

    int updateByPrimaryKey(RcyhGlxcsjb record);
    
    public RcyhGlxcsjb selectGlxcsjbByUsername(String username);
    
	List<RcyhGlxcsjb> listXdsj(RcyhGlxcsjb xdjl);
	
	int listXdsjCount(RcyhGlxcsjb xdjl);

	int canDelXdjl(RcyhGlxcsjb xdjl);
    /**
     * 查询统计巡道记录信息表用，按条件查询巡道记录
     * @param xdjl
     * @return
     */
	List<RcyhGlxcsjb> getXdsj(RcyhGlxcsjb xdjl);
	/**
	 * 查询统计巡道记录信息表用，按条件查询巡道记录条数
	 * @param xdjl
	 * @return
	 */
	int getXdsjCount(RcyhGlxcsjb xdjl);
	/**
	 * 根据巡道id查询维修情况
	 * @param xcid
	 * @return
	 */
	List<String> getWxqkByXcid(String xcid);
	/**
	 * 根据巡道id查询巡道详细信息
	 * @param xcid
	 * @return
	 */
	RcyhGlxcsjb getDetailByXcid(String xcid);
	
}