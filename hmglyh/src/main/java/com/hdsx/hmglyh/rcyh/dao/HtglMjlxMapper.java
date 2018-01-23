package com.hdsx.hmglyh.rcyh.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.controller.dto.Dedto;
import com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx;
import com.hdsx.hmglyh.rcyh.dao.model.HtglGljlxb;
import com.hdsx.hmglyh.rcyh.dao.model.HtglMjlx;
import com.hdsx.hmglyh.rcyh.dao.model.HtglYhlxb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhCljxxhb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRyzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.ZP;
import com.hdsx.hmglyh.util.Combobox;

@Mapper
public interface HtglMjlxMapper {

	List<HtglMjlx> selectTq(HtglMjlx mjlx);

	String selectZt(HashMap<String, Object> map);

	String bhlxConvert(String bhid);

	HtglBhlx selectBhlxByPrimaryKey(String bhid);
	
	/**
	 * 
	 * 
	 * 养护类型树
	 * 
	 * 
	 * @return
	 */

	List<HtglYhlxb> selectYhlxTree();
	List<HtglYhlxb> selectYhlxChildren(String yhid);

	Double getRgfdj(String bmcode);

	/**
	 * 后台管理 工料机机械 树
	 * @return
	 */

	List<HtglGljlxb> selectGljjxTree();

	/**
	 * 材料树
	 * @return
	 */

	List<HtglGljlxb> selectGljclTree();

	HashMap<String, Object> getGljdjs(HashMap<String, Object> map);

	Double getGljdjsForParent(HashMap<String, Object> map);

	/**
	 * 批量插入
	 */
	void insertCljxxhBatch(List<RcyhCljxxhb> cljxxhs);

	/**
	 * 状态comnbobox
	 * 
	 * @param map
	 * @return
	 */
	public List<Combobox> selectZtlb(HashMap<String, Object> map);

	/**
	 * 通过 养护 类型 ID 获得 养护类型名称
	 * 
	 * @param yhlxid
	 * @return
	 */
	String getYhlxName(String yhlxid);

	/**
	 * 批量插入 人员作业记录表
	 */
	void insertRyzyjlBatch(List<RcyhRyzyjlb> ryzys);

	public List<String> selectBhjlids(String rwdid);

	/**
	 * 枚举类型 转换
	 */
	public String mjlxConvert(HashMap<String, Object> map);

	/**
	 * 根据当前时间 获取所属年月
	 * 
	 * @param today
	 * @return
	 */
	public String getSsny(String today);

	/**
	 * 根据 当前时间 获取 年月基础表中的 当前 时间 与 结束 时间
	 * 
	 * @param today
	 * @return
	 */
	HashMap<String, Object> getStimeAndEtime(@Param("today") String today);
	
	/**
	 * 根据所属年月 获取开始时间和结束时间
	 * @param ssny
	 * @return
	 */
	HashMap<String, Object> getStimeAndEtimeBySsny(@Param("ssny") String ssny);

	/**
	 * 根据 养护类型的ID 和 工料机 类型的 ID 查询 工料机的数量
	 * 
	 * @param variable
	 * @return
	 */
	Integer getGljsl(HashMap<String, Object> variable);

	/**
	 * 根据 路线编码 获取 到 路线名称
	 * 
	 * @param ldcode
	 * @return
	 */
	String getLdname(String ldcode);
	
	/**
	 * 根据 路线编码 获取 到 路线名称
	 * 
	 * @param ldcode
	 * @return
	 */
	String getQdname(String ldcode);

	/**
	 * 查询 当前部门同级部门的 养护站 所管辖的 路段
	 * 
	 * @param bmcode
	 */
	List<HashMap<String, Object>> xdjlLds(String bmcode);

	/**
	 * 通过 病害 ID 查询 此种病害 的 修复时限
	 * @param bhid
	 * @return
	 */
	String getWxsx(String bhid);

	/**
	 * 根据养护ID 和 部门ID 查询 工料机 消耗信息
	 * @param variable
	 * @return
	 */
	List<HashMap<String, Object>> listGljxhs(HashMap<String, Object> variable);

	/**
	 * 根据养护ID 查询 该养护类型的相关信息
	 * @param yhid
	 * @return
	 */
	HashMap<String, Object> getYhlx(String yhid);

	/**
	 * 批量 插入和病害 关联的 照片信息
	 * @param yhid
	 * @return
	 */
	void insertZpBatch(List<ZP> zps);

	/**
	 * 通过 所属 ID 查询 照片的集合 
	 * @param ssid
	 * @return
	 */
	List<ZP> getZpsBySsid(@Param("ssid") String ssid);

	/**
	 * 通过 所属 ID 删除 照片表中的信息
	 * @param bhjlid
	 */
	int delPicBySsid(@Param("ssid") String ssid);
	
	/**
	 * 通过照片的 ID 删除照片
	 * @param zpid
	 */
	int delPicByPicId(@Param("zpid") String zpid);

	/**
	 * 通过作业ID 删除 和 该作业 相关的 人员作业记录
	 * @param zyid
	 */
	int deleteRyzysByZyid(@Param("zyid") String zyid);
	
	/**
	 * 通过 ssid 删除和 维修作业 相关的材料机械消耗信息 
	 * @param ssid
	 * @return
	 */
	int deleteGljxhBySsid(@Param("ssid") String ssid);
	
	/**
	 * 根据路段编码 返回 路线编码 
	 * @param ldcode
	 * @return
	 */
	String getLxcodeByld(String ldcode);
	
	/**
	 * 根据路段编码 返回 路线编码 
	 * @param ldcode
	 * @return
	 */
	String getLxcodeBylsld(String ldcode);

	/**
	 * 根据部门编码 查询 该部门的所有的人员
	 * @param bmcode
	 * @return
	 */
	List<HashMap<String, Object>> selectRysByBmcode(String bmcode);

	/**
	 * 删除任务单与病害的关联关系
	 * @param rwdid
	 * @return
	 */
	int deleteBhgl(String rwdid);
	
	
	Dedto getDedto(@Param("yhid") String yhid,@Param("bmcode") String bmcode);
	List<HtglGljlxb> getDeCls(@Param("yhid") String yhid,@Param("bmcode") String bmcode);
	List<HtglGljlxb> getDeJxs(@Param("yhid") String yhid,@Param("bmcode") String bmcode);
	
	/**
	 * 通过bhid 查询 病害数量的dw
	 * @param bhid
	 * @return
	 */
	String getDwByBhid(@Param("bhid") String bhid);

	/**
	 * 根据养护ID 查询 维修的单位
	 * @param yhid
	 * @return
	 */
	String getDwByYhid(@Param("yhid") String yhid);
	
	/**
	 * 根据人员ID 查询 出 人员姓名
	 * @param ryid
	 * @return
	 */
	String getRynameByRyid(@Param("ryid") String ryid);
	
	/**
	 * 维修部门 获取分局下的所有的人员
	 * @param bmcode
	 * @return
	 */
	List<com.hdsx.hmglyh.rcyh.controller.dto.RyDataList> getRyTreegrid(@Param("bmcode") String bmcode);
	
	/**
	 * 通过养护ID 获取 定额基数
	 * @param yhid
	 * @return
	 */
	Double getDejs(@Param("yhid") String yhid);
	
	/**
	 * 通过路段查询 部门编码
	 * @param ldcode
	 * @return
	 */
	String getBmcodeByLdcode(@Param("ldcode") String ldcode);
	
	String getSsnyByDateTime(@Param("datetime") String datetime);

	Double getGrde(@Param("yhid") String yhid,@Param("bmcode")  String bmcode);

	/**
	 * 通过养护类型ID 获取养护类型单价
	 * @param yhid
	 * @return
	 */
	Double getYhlxDj(@Param("yhid") String yhid);
	/**
	 * 根据 路段编码 获取 到 路线编码
	 * @param ldcode
	 * @return
	 */
	String getRoadcode(String ldcode);
	
}
