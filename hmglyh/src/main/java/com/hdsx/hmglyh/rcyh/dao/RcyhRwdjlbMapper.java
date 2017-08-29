package com.hdsx.hmglyh.rcyh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
@Mapper
public interface RcyhRwdjlbMapper {
    int deleteByPrimaryKey(String rwdid);

    int insert(RcyhRwdjlb record);

    int insertSelective(RcyhRwdjlb record);

    /**
     * 包含任务单基础信息 材料信息和人员作业信息
     * @param rwdid
     * @return
     */
    RcyhRwdjlb selectByPrimaryKey(String rwdid);
    
    RcyhRwdjlb selectByPrimaryKeyWithClxhAndBh(String rwdid);
    
    /**
     * 包含任务单基础信息和 任务单相关联的材料信息
     * @param rwdid
     * @return
     */
	RcyhRwdjlb selectByPrimaryKeyWithClxh(String rwdid);
	
	/**
	 * 只包含任务单的基础信息
	 * @param rwdid
	 * @return
	 */
	RcyhRwdjlb selectByPrimaryKeySimple(String rwdid);
	
    int updateByPrimaryKeySelective(RcyhRwdjlb record);

    int updateByPrimaryKey(RcyhRwdjlb record);

	List<RcyhRwdjlb> listRwd(RcyhRwdjlb rwd);

	int listRwdCount(RcyhRwdjlb rwd);
	
	List<RcyhRwdjlb> listRwdcx(RcyhRwdjlb rwd);
	
	int listRwdcxCount(RcyhRwdjlb rwd);
	
	List<RcyhRwdjlb> listRwdForYdjh(RcyhRwdjlb rwd);
	int listRwdForYdjhCount(RcyhRwdjlb rwd);

	List<RcyhRwdjlb> listJhshRwd(@Param("bmcode") String bmcode,@Param("ldcode") String ldcode,@Param("ssny") String ssny);

}