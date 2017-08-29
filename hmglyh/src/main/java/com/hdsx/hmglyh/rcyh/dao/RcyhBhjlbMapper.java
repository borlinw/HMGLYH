package com.hdsx.hmglyh.rcyh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.BhjlAndRwd;
import com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhGlxcsjb;
@Mapper
public interface RcyhBhjlbMapper {

	RcyhBhjlb selectByPrimaryKey2(String bhjlid);
	
	int deleteByPrimaryKey(String bhjlid);

    int insert(RcyhBhjlb record);

    int insertSelective(RcyhBhjlb record);

    RcyhBhjlb selectByPrimaryKey(String bhjlid);
    
    RcyhBhjlb selectByPrimaryKeyWithZps(String bhjlid);

    int updateByPrimaryKeySelective(RcyhBhjlb record);

    int updateByPrimaryKey(RcyhBhjlb record);
    
    RcyhGlxcsjb selectGlxcsjb(String xcid);
    
    List<HtglBhlx> selectBhlxs();

    /**
     * 病害记录列表 带分页
     * @param bhjl
     * @return
     */
	List<RcyhBhjlb> listBh(RcyhBhjlb bhjl);
	
	/**
	 * 根据巡查ID 查询 所管辖 部门的病害记录
	 * @param xcid
	 * @param bmcode
	 * @return
	 */
	List<RcyhBhjlb> selectBhByXcid(@Param("xcid") String xcid);

	int listBhCount(RcyhBhjlb bhjl);
	
	int saveRelativity(BhjlAndRwd bar);
	/**
	 * 批量保存 任务单 与 病害的关联关系
	 * @param list
	 * @return
	 */
	int saveRelativitys(List<BhjlAndRwd> list);
	
	RcyhBhjlb selectBhByBhjlid(String bhjlid);

	/**
	 * 根据 任务单 ID 查询 所有的病害记录
	 * @param rwdid
	 * @return
	 */
	List<RcyhBhjlb> getBhsByRwdId(String rwdid);
	/**
	 * 方法同上 加上了 分页
	 * @param rwdid
	 * @return
	 */
	List<RcyhBhjlb> getBhsByRwdIdWithPage(@Param("page")  int page,@Param("rows") int rows,@Param("rwdid") String rwdid);
	/**
	 * 上衣方法 对应的总数
	 * @param rwdid
	 * @return
	 */
	int getBhsByRwdIdWithPageCount(@Param("rwdid") String rwdid);

	/**
	 * 病害查询中的病害；列表
	 * @param bhjl
	 * @return
	 */
	List<RcyhBhjlb> bhcxList(RcyhBhjlb bhjl);

	/**
	 * 病害查询中的病害列表总数
	 * @param bhjl
	 * @return
	 */
	int bhcxListCount(RcyhBhjlb bhjl);
}