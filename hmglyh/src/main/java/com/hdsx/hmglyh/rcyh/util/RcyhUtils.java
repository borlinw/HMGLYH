package com.hdsx.hmglyh.rcyh.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.HtglBmbMapper;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.rcyh.dao.HtglLuduanMapper;
import com.hdsx.hmglyh.rcyh.dao.HtglMjlxMapper;
import com.hdsx.hmglyh.rcyh.dao.HtglYhbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhBhjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhGlxcsjbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhWxzyjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhZyysjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx;
import com.hdsx.hmglyh.rcyh.dao.model.HtglGljlxb;
import com.hdsx.hmglyh.rcyh.dao.model.HtglLuduan;
import com.hdsx.hmglyh.rcyh.dao.model.HtglMjlx;
import com.hdsx.hmglyh.rcyh.dao.model.HtglYhlxb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhGlxcsjb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.ZP;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Constants;
import com.hdsx.hmglyh.util.SpringContextUtil;

public class RcyhUtils {

	private static Logger log = LoggerFactory.getLogger(RcyhUtils.class);

	// 自动 生成病害 id

	public static String createBhID() {

		StringBuilder sb = new StringBuilder();

		sb.append("BHID");

		sb.append(new Date().getTime());

		sb.append("_" + (int) (Math.random() * 100000));

		return sb.toString();

	}

	// 自动 巡查 id

	public static String createXCID() {

		StringBuilder sb = new StringBuilder();

		sb.append("XCID");

		sb.append(new Date().getTime());

		sb.append("_" + (int) (Math.random() * 100000));

		return sb.toString();

	}

	// 自动 任务单 ID

	public static String createRWDID() {

		StringBuilder sb = new StringBuilder();

		sb.append("RWDID");

		sb.append(new Date().getTime());

		sb.append("_" + (int) (Math.random() * 100000));

		return sb.toString();

	}
	
	public static String createRWDBH() {

		StringBuilder sb = new StringBuilder();

		sb.append("RWDBH");

		sb.append(new Date().getTime());

		sb.append("_" + (int) (Math.random() * 100000));

		return sb.toString();

	}
	
	// 创建 维修作业ID
	public static String createWxzyID(){
		StringBuilder sb = new StringBuilder();

		sb.append("WXZY");

		sb.append(new Date().getTime());

		sb.append("_" + (int) (Math.random() * 100000));

		return sb.toString();
	}
	
	public static String createZyysID(){
		StringBuilder sb = new StringBuilder();

		sb.append("ZYYS");

		sb.append(new Date().getTime());

		sb.append("_" + (int) (Math.random() * 100000));

		return sb.toString();
	}

	public static String createZpID(){
		StringBuilder sb = new StringBuilder();

		sb.append("ZP");

		sb.append(new Date().getTime());

		sb.append("_" + (int) (Math.random() * 100000));

		return sb.toString();
	}

	
	public static void writePic(InputStream is, OutputStream os)
			throws IOException {

		byte[] buf = new byte[2048];

		int len = 0;

		while ((len = is.read(buf)) != -1) {

			os.write(buf, 0, len);

		}

		is.close();

		os.flush();

		os.close();

	}

	/**
	 * 
	 * 
	 * 查询天气列表
	 * 
	 * 
	 * @return
	 */

	public static List<HtglMjlx> tqList() {

		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");

		HtglMjlx mjlx = new HtglMjlx();

		mjlx.setType("天气");

		List<HtglMjlx> list = mjlxMapper.selectTq(mjlx);

		return list;

	}

	/**
	 * 方向列表
	 */
	public static List<HtglMjlx> fxList() {

		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");

		HtglMjlx mjlx = new HtglMjlx();
		mjlx.setType("方向");
		List<HtglMjlx> list = mjlxMapper.selectTq(mjlx);
		return list;

	}
	
	/**
	 * 状态combobox
	 */
	public static List<Combobox> ztCombobox(HashMap<String,Object> map){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		return mjlxMapper.selectZtlb(map);
	}

	/**
	 * 
	 * 
	 * 状态转换
	 * 
	 * 
	 * @return
	 */

	public static String ztConvert(String ztcode, String key) {
		
		if( ztcode == null || key == null || ztcode == "" || ztcode == "") {
			return "状态转换条件有误";
		}

		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ztcode", ztcode);
		if( key == null ) {
			map.put("key", "0");
		}else{
			map.put("key", key);
		}
		
		String value = mjlxMapper.selectZt(map);
		
		if( value == null ) {
			value = "没有查询出对应的状态";
		}
		
		return value;

	}
	
	/**
	 * 通过病害类型ID 查找 该病害的 修复时限
	 * @param bhid
	 * @return
	 */
	public static String getWxsx(String bhid){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		return mjlxMapper.getWxsx(bhid);
	}
	/**
	 * 
	 * 
	 * 病害类型 转换
	 * 
	 * 
	 * @return
	 */

	public static String bhlxConvert(String bhcode) {

		if (bhcode == null)
			return "";

		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");

		return mjlxMapper.bhlxConvert(bhcode);

	}
	
	/**
	 * 枚举类型转换
	 */
	public static String mjlxConvert(String typecode , String key) {
		if (typecode ==  null || key == null || typecode == "" || key == "")
			return "枚举转换条件有误";

		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("typecode",typecode);
		map.put("key", key);
		
		String value = mjlxMapper.mjlxConvert(map);
		if( value == null ) {
			return "没有查询出对应的枚举值";
		}
		return value;
	}

	/**
	 * 巡查 病害 上报的 对象
	 */

	public static List<HashMap<String,Object>> xdjlYhs(String bmcode) {

		HtglYhbMapper yhbMapper = (HtglYhbMapper) SpringContextUtil
				.getBean("htglYhbMapper");

		List<HashMap<String,Object>> list = yhbMapper.xdjlYhs(bmcode);

		return list;

	}
	
	public static String getRynameByRyid(String ryid) {
		if(ryid == null ) {
			return "查询参数有错";
		}
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		String ryname = mjlxMapper.getRynameByRyid(ryid);
		if( ryname == null ) {
			return "该用户没姓名";
		}
		return ryname;
	}

	/**
	 * 
	 * 
	 * 当前记录用户 所管辖路段
	 */

	public static List<HtglLuduan> luduanList(String bmcode) {

		HtglLuduanMapper luduanMapper = (HtglLuduanMapper) SpringContextUtil
				.getBean("htglLuduanMapper");

		HtglLuduan ldb = new HtglLuduan();

		ldb.setBmcode(bmcode);

		List<HtglLuduan> list = luduanMapper.luduanList(ldb);

		return list;

	}

	/**
	 * 
	 * 
	 * 将人员编码 转换为 姓名
	 * 
	 * 
	 * @return
	 */

	public static String usernameToString(String username) {

		if (username == null)
			return "";

		HtglYhbMapper yhbMapper = (HtglYhbMapper) SpringContextUtil
				.getBean("htglYhbMapper");

		return yhbMapper.getRealName(username);

	}

	/**
	 * 
	 * 
	 * 将部门编码 转换名名称
	 * 
	 * 
	 * @param bmcode
	 * 
	 * 
	 * @return
	 */

	public static String getBmname(String bmcode) {
		
		if( StringUtils.isBlank(bmcode)) {
			return "";
		}
		
		HtglYhbMapper yhbMapper = (HtglYhbMapper) SpringContextUtil
				.getBean("htglYhbMapper");

		return yhbMapper.getBmname(bmcode);

	}

	/**
	 * 
	 * 
	 * 获取 上报部门对象
	 * 
	 * 
	 * @return
	 */

	public static List<HtglBmb> getSbdx(String bmcode) {

		HtglBmbMapper bmbMapper = (HtglBmbMapper) SpringContextUtil
				.getBean("htglBmbMapper");

		List<HtglBmb> list = new ArrayList<HtglBmb>();

		while (bmcode.length() != 4) {

			HtglBmb bmb = bmbMapper.bumenParents(bmcode);

			list.add(bmb);

			if (list.size() == 1) { // 理他 最近的 部门 默认处于 选中的状态

				bmb.setSelected(true);

			}

			bmcode = bmb.getBmcode();

		}

		return list;

	}

	/**
	 * 
	 * 
	 * 根据 部门编码 查询 所有的 派工对象
	 * 
	 * 
	 * @param bmcode
	 * 
	 * 
	 * @return
	 */

	public static List<HtglBmb> getPgdx(String bmcode) {

		HtglBmbMapper bmbMapper = (HtglBmbMapper) SpringContextUtil
				.getBean("htglBmbMapper");

		List<HtglBmb> bmbList = null;
		
		if(bmcode.length() == 4 ) { // 总局的 人
			bmbList = bmbMapper.getZjPgdx(bmcode);
		}else if( bmcode.length() == 6 ) { // 分局的人
			bmbList = bmbMapper.getFjPgdx(bmcode);
		}else{ // 养护站的人
			bmbList = bmbMapper.getYhzPgdx(bmcode);
		}
		
		if (bmbList.size() > 0) {

			bmbList.get(0).setSelected(true);

		}

		return bmbList;

	}

	/**
	 * 
	 * 
	 * 根据 病害记录id 数组 查询 病害记录ID 的 实体对象
	 */

	public static List<RcyhBhjlb> getBhjls(List<String> bhjlids) {

		RcyhBhjlbMapper bhjlbMapper = (RcyhBhjlbMapper) SpringContextUtil
				.getBean("rcyhBhjlbMapper");

		List<RcyhBhjlb> list = new ArrayList<RcyhBhjlb>();

		for (String bhjlid : bhjlids) {

			RcyhBhjlb bh = bhjlbMapper.selectBhByBhjlid(bhjlid);

			list.add(bh);

		}

		return list;

	}
	
	
	/**
	 * 养护类型 名称转换
	 */
	public static String getYhlxName(String yhlxid) {
		if(StringUtils.isBlank(yhlxid)) {
			return "参数错误";
		}else{
			HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
					.getBean("htglMjlxMapper");
			return mjlxMapper.getYhlxName(yhlxid);
		}
	}
	

	/**
	 * 
	 * 
	 * 养护类型 树
	 */

	public static List<HtglYhlxb> getYhlxTree() {

		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		
		List<HtglYhlxb> list = mjlxMapper.selectYhlxTree();
		
		getYhlxChildren(list, mjlxMapper);
		
		return list;

	}
	
	private static void getYhlxChildren(List<HtglYhlxb> list,HtglMjlxMapper mjlxMapper){
		for(HtglYhlxb yhlx:list ) {
			while( yhlx.getChildren() == null ){
				yhlx.setChildren(mjlxMapper.selectYhlxChildren(yhlx.getYhid()));
				if(yhlx.getChildren() != null && yhlx.getChildren().size() > 0 ) 
					RcyhUtils.getYhlxChildren(yhlx.getChildren(), mjlxMapper);
			}
			
		}
	}

	/**
	 * 
	 * 
	 * 材料类型 树
	 */

	public static List<HtglGljlxb> getGljclTree() {

		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");

		return mjlxMapper.selectGljclTree();

	}

	/**
	 * 
	 * 
	 * 机械类型树
	 */

	public static List<HtglGljlxb> getGljjxTree() {

		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		return mjlxMapper.selectGljjxTree();
	}

	
	/**
	 * 根据当前 时间  获取所属年月 
	 * @return
	 */
	public static String getSsny(){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		return mjlxMapper.getSsny(today);
	}	
	
	public static String getSsny(int i) {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, i);
		Date nextMonthD = cal.getTime();
		String nextMonth = format.format(nextMonthD);
		return mjlxMapper.getSsny(nextMonth);
	}
	
	/**
	 * 根据传入日期格式的字符串 查询 所属年月
	 * @param datetime
	 * @return
	 */
	public static String getSsnyByDateTime(String datetime) {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		return mjlxMapper.getSsnyByDateTime(datetime);
	}
	
	/**
	 * 根据 当前时间  获取 基础时间 的 开始 时间 与 结束时间
	 */
	public static HashMap<String,Object> getStimeAndEtime(){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		HashMap<String,Object> map  = mjlxMapper.getStimeAndEtime(today);
		Timestamp t1 = (Timestamp) map.get("STIME");
		Timestamp t2 = (Timestamp) map.get("ETIME");
		String starttime  = format.format(t1);
		String endtime = format.format(t2);
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		return map;
	
	}
	
	public static HashMap<String,Object> getStimeAndEtime(String ssny){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		HashMap<String,Object> map  = mjlxMapper.getStimeAndEtimeBySsny(ssny);
		Timestamp t1 = (Timestamp) map.get("STIME");
		Timestamp t2 = (Timestamp) map.get("ETIME");
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		String starttime  = format.format(t1);
		String endtime = format.format(t2);
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		return map;
	}
	
	/**
	 * 只有分局的 用户 才具有此操作 
	 * 根据分局的 部门编码 查询 此分局下 所有 部门类型 为 0102的 部门集合
	 */
	public static List<HtglBmb> getYhzs(String bmcode){
		
		if( bmcode.length() != 6 ) { // 非 分局用户 登录 操作
			return null;
		}
		HtglBmbMapper bmbMapper = (HtglBmbMapper) SpringContextUtil
				.getBean("htglBmbMapper");
		return bmbMapper.getYhzs(bmcode);
		
	}
	
	/**
	 * 得到当前 时间的 字符串 格式 
	 * @return
	 */
	public static String getDateStr(){
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		return today;
	}

	/**
	 * 获取当前日期时间 格式的字符串
	 * @return
	 */
	public static String getDateTimeStr() {
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = format.format(new Date());
		return today;
	}
	
	/**
	 * 根据 路段编码 获取 到 路段名称
	 * @param ldcode
	 * @return
	 */
	public static String getLdname(String ldcode) {
		
		if( ldcode == null || "".equals(ldcode)) {
			return "--";
		}
		
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		
//		String ldname = mjlxMapper.getLdname(ldcode);
		String ldname = mjlxMapper.getQdname(ldcode);
		
		if( ldname == null ) {
//			ldname = ldcode + "没有名称";
			ldname = "";
		}
		
		return ldname;
	}
	
	/**
	 * 根据 路段编码 获取 到 路线编码
	 * @param ldcode
	 * @return
	 */
	public static String getRoadcode(String ldcode) {
		
		if( ldcode == null || "".equals(ldcode)) {
			return "--";
		}
		
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		
		String roadcode = mjlxMapper.getRoadcode(ldcode);
		
		if( roadcode == null ) {
			roadcode = "";
		}
		
		return roadcode;
	}

	/**
	 * 根据 当前用户 的  部门编码 查询同级部门养护站 所管辖的 路段 如果是分局 或者 最高级
	 * 的部门 直接 使用 自己的 bmcode
	 * @param bmcode
	 * @return
	 */
	public static List<HashMap<String, Object>> xdjlLds(String bmcode) {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
//		if(bmcode.length() == 8 ) {
//			return mjlxMapper.xdjlLds(bmcode.substring(0, bmcode.length()-2));
//		}else{
//			return mjlxMapper.xdjlLds(bmcode);
//		}
		return mjlxMapper.xdjlLds(bmcode);
	}

	
	/**
	 * 寻找 当前用户 委派 部门 的 人工费
	 */
	public static Double getRgfdj(String bmcode) {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		
		if( StringUtils.isBlank(bmcode)) {
			return (double)0;
		}
		
		if( bmcode.length() == 4 ) { // 管理员 ， 科级
			Double rgf = mjlxMapper.getRgfdj(bmcode);
			if( rgf == null ) {
				rgf = (double)0;
			}
			return rgf;
		} else if( bmcode.length() == 6 ) {
			Double rgf = mjlxMapper.getRgfdj(bmcode);
			return rgf;
		} else {
			String bmc = bmcode.substring(0,bmcode.length()-2);
			Double rgf = mjlxMapper.getRgfdj(bmc);
			return rgf;
		}
		
	}
	
	/**
	 * 根据工料机类型iD 和 部门编码 查询 工料机 价格
	 * @param ids 工料机 类型 ID 数组
	 * @param bmcode 部门编码
	 * @return
	 */
	public static List<HashMap<String, Object>> getGljdj(List<String> ids,
			String bmcode,String yhlxid) {
		
		if( bmcode.length() == 8 ) {
			bmcode = bmcode.substring(0,bmcode.length() - 2 );
		}
		
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
		//过滤掉 无用的值
		for(String id : ids) {
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("lxid", id);
			map.put("yhid", yhlxid);
			map.put("bmcode",bmcode);
			HashMap<String,Object> reMap = mjlxMapper.getGljdjs(map);
			resultList.add(reMap);
		}
		return resultList;
	}
	
	/**
	 * 根据部门编码 和 养护ID 查询 工料机 消耗
	 */
	public static List<HashMap<String,Object>> listGljxhs(String yhid,String bmcode) {
		
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		HashMap<String,Object> variable = new HashMap<String,Object>();
		variable.put("yhid", yhid);
		
		if( bmcode.length() == 8 ) {
			bmcode = bmcode.substring(0, bmcode.length() - 2 );
		}
		
		variable.put("bmcode", bmcode);
		
		List<HashMap<String,Object>> list = mjlxMapper.listGljxhs(variable);
		
		// 过滤单价 
		for(HashMap<String,Object> m : list ) {
			if(m.get("dj") == null ) {
				HashMap<String,Object> var = new HashMap<String,Object>();
				var.put("id",m.get("id"));
				var.put("bmcode", m.get("bmcode"));
				Double dj = mjlxMapper.getGljdjsForParent(var);
				if( dj != null ) {
					m.put("dj",dj);
				}else{
					m.put("dj", 0);
				}
			}
		}
		return list;
	}
	
	/**
	 * 根据 养护 ID 获取 养护 类型 
	 * @param yhid
	 * @return
	 */
	public static HashMap<String,Object> getYhlx(String yhid){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil
				.getBean("htglMjlxMapper");
		return mjlxMapper.getYhlx(yhid);
	}

	/**
	 * 根据 任务单 ID 查询 所有 关联的 病害
	 * @param rwdid
	 * @return
	 */
	public static List<RcyhBhjlb> getBhsByRwdId(String rwdid) {
		RcyhBhjlbMapper bhMapper = (RcyhBhjlbMapper) SpringContextUtil
				.getBean("rcyhBhjlbMapper");
		return bhMapper.getBhsByRwdId(rwdid);
	}
	
	/**
	 * 判断 此种类型的养护 ID 当前月 是否可以验收 
	 * @param yhid
	 * @return
	 */
	public static boolean canYs(String yhid,String ldcode,String ysbmcode){
		RcyhZyysjlbMapper zyysMapper = (RcyhZyysjlbMapper) SpringContextUtil.getBean("rcyhZyysjlbMapper"); 
		HashMap<String,Object> variable = RcyhUtils.getStimeAndEtime();
		variable.put("yhid", yhid);
		variable.put("ldcode",ldcode);
		variable.put("ysbmcode",ysbmcode);
		int r = zyysMapper.canYs(variable);
		if( r > 0 ) {
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 上一个方法 加上所属年月
	 * @param yhid
	 * @param ldcode
	 * @param ysbmcode
	 * @param ssny
	 * @return
	 */
	public static boolean canYs(String yhid,String ldcode,String ysbmcode,String ssny){
		RcyhZyysjlbMapper zyysMapper = (RcyhZyysjlbMapper) SpringContextUtil.getBean("rcyhZyysjlbMapper"); 
		HashMap<String,Object> variable = RcyhUtils.getStimeAndEtime(ssny);
		variable.put("yhid", yhid);
		variable.put("ldcode",ldcode);
		variable.put("ysbmcode",ysbmcode);
		int r = zyysMapper.canYs(variable);
		if( r > 0 ) {
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 根据 养护ID 和 路段编码 查询 当前月的 维修记录
	 * @param yhid
	 * @param ldcode
	 * @return
	 */
	public static List<RcyhWxzyjlb> wxjlByYhidAndLd(String yhid, String ldcode) {
		RcyhWxzyjlbMapper wxzyMapper = (RcyhWxzyjlbMapper) SpringContextUtil.getBean("rcyhWxzyjlbMapper");
		HashMap<String,Object> variable = RcyhUtils.getStimeAndEtime();
		variable.put("yhid", yhid);
		variable.put("ldcode", ldcode);
		return wxzyMapper.wxjlByYhidAndLd(variable);
	}
	
	/**
	 * 加入所属年月
	 * @param yhid
	 * @param ldcode
	 * @param ssny
	 * @return
	 */
	public static List<RcyhWxzyjlb> wxjlByYhidAndLd(String yhid, String ldcode,String ssny,String bmcode) {
		RcyhWxzyjlbMapper wxzyMapper = (RcyhWxzyjlbMapper) SpringContextUtil.getBean("rcyhWxzyjlbMapper");
		HashMap<String,Object> variable = RcyhUtils.getStimeAndEtime(ssny);
		variable.put("yhid", yhid);
		variable.put("ldcode", ldcode);
		variable.put("bmcode", bmcode);
		return wxzyMapper.wxjlByYhidAndLd(variable);
	}

	/**
	 * 初始化 任务单
	 * @param rwd
	 * @param globleResultMap
	 * @param bhjls
	 */
	public static void initRwd(RcyhRwdjlb rwd,
		HashMap<String, Object> globleResultMap,List<RcyhBhjlb> bhjls) {
		rwd.setCjtime(RcyhUtils.getDateTimeStr()); 	// 回写任务单创建  时间
		rwd.setSsny(RcyhUtils.getSsny());		  // 回写 所属年月
		// 回写 病害名称 ,由传过来的病害数组 去重
		HashMap<String,Object> bhlxs = new HashMap<String,Object>();
		RcyhBhjlbMapper bhMapper = (RcyhBhjlbMapper) SpringContextUtil.getBean("rcyhBhjlbMapper");
		Double bhsl = 0.0;
		double maxZh = 0;
		double minZh = 2147483647;
		for( RcyhBhjlb bh: bhjls ) {
			bhsl += Double.parseDouble(bh.getSl());
			bhlxs.put(bh.getBhid(), RcyhUtils.bhlxConvert(bh.getBhid())); // 病害名称去重复
			double zh1 =  bh.getSzhhkm().doubleValue() + bh.getSzhhm().doubleValue() / 1000;
			double zh2 =  bh.getEzhhkm().doubleValue() + bh.getEzhhm().doubleValue() / 1000;
		
			if( zh1 >= 0 && zh1 > maxZh ) {
				maxZh = zh1;
			}
			
			if( zh1 >= 0 && zh1 < minZh ) {
				minZh = zh1;
			}
			
			if( zh2 >= 0 && zh2 < minZh ) {
				minZh = zh2;
			}
			
			if( zh2 >= 0 && zh2 > maxZh) {
				maxZh = zh2;
			}
		}
		
		RcyhBhjlb bh = bhMapper.selectByPrimaryKey(bhjls.get(0).getBhjlid());
		
		if(StringUtils.isNotBlank(bh.getQlcode())) {
			rwd.setQlcode(bh.getQlcode());
			rwd.setQlname(bh.getQlname());
		}
		
		if( StringUtils.isNotBlank(bh.getSdcode())) {
			rwd.setSdcode(bh.getSdcode());
			rwd.setSdname(bh.getSdname());
		}
		
		if( StringUtils.isNotBlank(bh.getHdcode())){
			rwd.setHdcode(bh.getHdcode());
			rwd.setHdname(bh.getHdname());
		}
		
		// 回写任务单 最大最小桩号
		rwd.setSzhhkm(new Integer((int)minZh));
		rwd.setSzhhm(new Integer((int)(minZh*1000%1000)));
		rwd.setEzhhkm(new Integer((int)maxZh));
		rwd.setEzhhm(new Integer((int)(maxZh*1000%1000)));
		globleResultMap.put("bhlxs", bhlxs);
		rwd.setLdname(RcyhUtils.getLdname(bhjls.get(0).getLdcode())); // 回写路段名称
		rwd.setLdcode(bhjls.get(0).getLdcode());
		rwd.setBmcode(RcyhUtils.getBmcodeByLdcode(bhjls.get(0).getLdcode()));
		rwd.setXfsx(RcyhUtils.getWxsx(bhjls.get(0).getBhid())); // 回写 病害的 修复时限
		rwd.setDw(RcyhUtils.getDwByBhid(bhjls.get(0).getBhid()));
		rwd.setSl(new Double(bhsl));
		rwd.setTq(bhjls.get(0).getTq());
	}

	/**
	 * 更新 巡道记录 的 病害 汇总 信息
	 * @param xcid
	 * @return
	 */
	public static void updateXdjl(String xcid){
		
		RcyhBhjlbMapper bhjlMapper = (RcyhBhjlbMapper) SpringContextUtil.getBean("rcyhBhjlbMapper");
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		RcyhGlxcsjbMapper xcjlMapper = (RcyhGlxcsjbMapper) SpringContextUtil.getBean("rcyhGlxcsjbMapper");
		List<RcyhBhjlb> bhList = bhjlMapper.selectBhByXcid(xcid);
		StringBuffer lumianSB = new StringBuffer();
		StringBuffer lujiSB = new StringBuffer();
		StringBuffer qshSB = new StringBuffer();
		StringBuffer yanxianSB = new StringBuffer();
	//	StringBuffer bzSb = new StringBuffer();
		
		for( RcyhBhjlb b : bhList) {
			String ldname = RcyhUtils.getLdname(b.getLdcode());
			HtglBhlx bhlx = mjlxMapper.selectBhlxByPrimaryKey(b.getBhid());
			if( b.getBhid().startsWith("01")) { // 路面
				// 所属路段
				lumianSB.append(ldname + " K"+b.getSzhhkm() + "+" + b.getSzhhm());
				
				if( b.getEzhhkm() != null && b.getEzhhm() != null && b.getEzhhkm() != -1 && b.getEzhhm() != -1 ) {
					lumianSB.append("- K"+b.getEzhhkm() + "+" + b.getEzhhm());
				}
				
				lumianSB.append("处,"+ bhlx.getBhname() + " "+b.getSl() );
				
				if(bhlx.getDw() != null && !("".equals(bhlx.getDw()))){
					lumianSB.append(bhlx.getDw());
				}
				
				lumianSB.append(";");
			
				
			}else if( b.getBhid().startsWith("02")) { // 路基
				
				lujiSB.append(ldname + " K"+b.getSzhhkm() + "+" + b.getSzhhm());
				if(b.getEzhhkm() != null && b.getEzhhkm() != -1 && b.getEzhhm() != null && b.getEzhhm() != -1 ) {
					lujiSB.append("- K"+b.getEzhhkm() + "+" + b.getEzhhm());
				}
				lujiSB.append("处," + bhlx.getBhname() + " "+b.getSl());
				
				if(bhlx.getDw() != null && !("".equals(bhlx.getDw()))) {
					lujiSB.append(bhlx.getDw());
				}
				lujiSB.append(";");
				
			}else if( b.getBhid().startsWith("03")) { // 沿线设施
				
				yanxianSB.append(ldname + " K"+b.getSzhhkm() + "+" + b.getSzhhm() );
				
				if(b.getEzhhkm() != null && b.getEzhhkm() != -1 && b.getEzhhm() != null && b.getEzhhm() != -1 ) {
					yanxianSB.append("- K"+b.getEzhhkm() + "+" + b.getEzhhm());
				}
				yanxianSB.append("处," + bhlx.getBhname() + " "+b.getSl());
				
				if(bhlx.getDw() != null && !("".equals(bhlx.getDw()))) {
					yanxianSB.append(bhlx.getDw());
				}
				
				yanxianSB.append(";");
				
				
			}else{ // 桥梁 隧道 涵洞
				qshSB.append(ldname + " K"+b.getSzhhkm() + "+" + b.getSzhhm() );
				if(b.getEzhhkm() != null && b.getEzhhkm() != -1 && b.getEzhhm() != null && b.getEzhhm() != -1 ) {
					qshSB.append("- K"+b.getEzhhkm() + "+" + b.getEzhhm());
				}
				qshSB.append("处," + bhlx.getBhname() + " "+b.getSl());
				
				if(bhlx.getDw() != null && !("".equals(bhlx.getDw()))) {
					qshSB.append(bhlx.getDw());
				}
				qshSB.append(";");
			}
			
			/*if(b.getBz() != null && !("".equals(b.getBz()))) {
				bzSb.append(b.getBz()+";");
			}*/
			
		}
		
		
		RcyhGlxcsjb xcQ = new RcyhGlxcsjb(); xcQ.setXcid(xcid);
		RcyhGlxcsjb xcjl = xcjlMapper.selectByPrimaryKey(xcQ);
		xcjl.setLm(lumianSB.toString());
		xcjl.setLj(lujiSB.toString());
		xcjl.setQsh(qshSB.toString());
		xcjl.setYxss(yanxianSB.toString());
//		xcjl.setBz(bzSb.toString());
		
		int c = xcjlMapper.updateByPrimaryKeySelective(xcjl);
		if( c > 0 ) {
			log.info(xcid + " 更新成功");
		}else{
			log.info(xcid + " 更新失败");
		}
	}
	
	/**
	 * 删除 照片的 集合 从服务器上 删除掉
	 * @param listZp
	 */
	public static void removePicFromServer(List<ZP> listZp) {
		String uploadPath = Constants.UploadPath;
		for( ZP zp : listZp) {
			File f = new File(uploadPath + "\\" + zp.getZpdz());
			if(f.exists()) {
				f.delete();
				log.info(zp.getZpmc() + "删除成功!");
			}else{
				log.error(zp.getZpmc() + "删除失败,原因：照片不存在！"+f.getAbsolutePath());
			}
		}
	}
	
	/**
	 * 从服务器上 删除 单张照片
	 * @param zp
	 */
	public static void removePicFromServer(ZP zp) {
		String uploadPath = Constants.UploadPath;
		File f = new File(uploadPath + "\\" + zp.getZpdz());
		if(f.exists()) {
			f.delete();
			log.info(zp.getZpdz() + "删除成功!");
		}else{
			log.error(zp.getZpdz() + "删除失败,原因：照片不存在！" + f.getAbsolutePath());
		}
	}

	/**
	 * 上报状态列表
	 * @return
	 */
	public static List<Combobox> sbCombobox() {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("ssbd", "rcyh_bhjlb");
		paramMap.put("ztcode", "bhsbzt");
		return mjlxMapper.selectZtlb(paramMap);
	}

	/**
	 * 派工状态列表
	 * @return
	 */
	public static List<Combobox> pgCombobox() {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("ssbd", "rcyh_bhjlb");
		paramMap.put("ztcode", "pgzt");
		return mjlxMapper.selectZtlb(paramMap);
	}
	
	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String getISO8601Date(int d){
		Date pgDay = new DateTime(new Date()).plusDays(d).toDate();
		Format dfm = new  SimpleDateFormat("yyyy-MM-dd");
		String date = dfm.format(pgDay);
		return date+"T01:00:00";
	}
	
	public static List<HashMap<String,Object>> getRysByBmcode(String bmcode) {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		return mjlxMapper.selectRysByBmcode(bmcode);
	}
	
	/**
	 * 根据病害ID 查询 病害数量的单位
	 * @param bhid
	 * @return
	 */
	public static String getDwByBhid(String bhid){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		String dw = mjlxMapper.getDwByBhid(bhid);
		if( dw == null ) {
			dw = "(无单位)";
		}
		return dw;
	}

	/**
	 * 根据养护ID 查询维修作业的单位
	 * @param yhid
	 * @return
	 */
	public static String getDwByYhid(String yhid) {
		
		if(yhid == null ) {
			return "(单位查询失败)";
		}
		
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		String dw = mjlxMapper.getDwByYhid(yhid);
		if( dw == null ) {
			dw = "(无单位)";
		}
		return dw;
	}
	
	public static Double getDejs(String yhid) {
		
		if(yhid == null ) {
			return (double)1;
		}
		
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		Double dejs = mjlxMapper.getDejs(yhid);
		if( dejs == null ) {
			dejs = (double)1;
		}
		return dejs;
	}
	
	public static List<com.hdsx.hmglyh.rcyh.controller.dto.RyDataList> getRyTreeGrid(String bmcode){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		return mjlxMapper.getRyTreegrid(bmcode);
	}
	
	public static String getBmcodeByLdcode(String ldcode){
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		return mjlxMapper.getBmcodeByLdcode(ldcode);
	}

	public static Double getGrde(String yhid, String bmcode) {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		return mjlxMapper.getGrde(yhid,bmcode);
	}

	public static Double getYhlxDj(String yhid) {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		return mjlxMapper.getYhlxDj(yhid);
	}
	
}
