package com.hdsx.hmglyh.util;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hdsx.hmglyh.rcyh.dao.HtglMjlxMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhBhjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhRwdjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhWxzyjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhZyysjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhCljxxhb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRyzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhZyysjlb;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;

public class WxzyHandler implements TaskListener{
	
	private static Logger log = LoggerFactory.getLogger(WxzyHandler.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
	/*	String key = delegateTask.getTaskDefinitionKey();
		if( "weixiuzuoye".equals(key) ) { // 维修作业
			bhwxTask(delegateTask);
		}
		else if( "zuoyeshangbao".equals(key) ) { // 作业上报
			zysbTask(delegateTask);
		}
		else if( "zuoyeyanshou".equals(key) ) { // 作业审核 	
			zyysTask(delegateTask);
		}*/
	}
	
	/**
	 * 作业验收操作
	 * @param delegateTask
	 */
	private void zyysTask(DelegateTask delegateTask) {
		
		RcyhRwdjlbMapper rwdMapper = (RcyhRwdjlbMapper) SpringContextUtil.getBean("rcyhRwdjlbMapper");
		RcyhWxzyjlbMapper wxzyMapper = (RcyhWxzyjlbMapper) SpringContextUtil.getBean("rcyhWxzyjlbMapper");
		RcyhBhjlbMapper bhMapper = (RcyhBhjlbMapper) SpringContextUtil.getBean("rcyhBhjlbMapper");
		RcyhWxzyjlb wxzy = (RcyhWxzyjlb) delegateTask.getVariable("wxzy");
		
		int zyyszt = Integer.parseInt((String) delegateTask.getVariable("zyyszt"));
		if( zyyszt == 2 ) { // 打回返工
			
			// 1 修改 '任务单状态' 为打回返工 修改  '任务单标识'  为 补充, 修改任务的所属年月为下月
			RcyhRwdjlb rwd = rwdMapper.selectByPrimaryKey(wxzy.getRwdid());
			rwd.setRwdlx("2");
			rwd.setRwdzt("3");
			rwd.setSsny(RcyhUtils.getSsny(1));
			int re = rwdMapper.updateByPrimaryKeySelective(rwd);
			if( re > 0 ) {
				log.info(rwd.getRwdid() + " 更改任务单状态成功！");
			}else{
				log.error(rwd.getRwdid() + " 更改任务单状态失败！");
			}
			delegateTask.setVariable("rwd", rwd);
			// 2 修改对应的病害的维修标识 0 未维修
			List<RcyhBhjlb> bhList = RcyhUtils.getBhsByRwdId(rwd.getRwdid());
			for( RcyhBhjlb b : bhList) {
				b.setBhwxzt("0");
				bhMapper.updateByPrimaryKey(b);
				log.info(b.getBhjlid() + " 病害的状态 已经更改为 未维修!");
			}
			// 3 修改所有的维修记录的 '验收状态' 为 验收不通过，删除任务单与维修记录单的 关联关系
			wxzy.setYszt("2");
			wxzy.setRwdid(null);
			wxzyMapper.updateByPrimaryKey(wxzy);
		} else if( zyyszt == 1 ) { // 验收通过(全部验收)
			
			// 2 更改 维修作业记录表的状态 zyyszt 为 1 已验收
			wxzy.setYszt("1");
			wxzyMapper.updateByPrimaryKeySelective(wxzy);
			// 3 更改任务单 记录 rwdzt = 2 已验收
			RcyhRwdjlb rwd = rwdMapper.selectByPrimaryKey(wxzy.getRwdid());
			rwd.setRwdzt("2");
			int r = rwdMapper.updateByPrimaryKeySelective(rwd);
			if( r > 0 ) {
				log.info(rwd.getRwdid() + "任务单的状态已经更改为已验收");
			}else{
				log.info(rwd.getRwdid() + "任务单的状态更改失败");
			}
			// 4 更改对应的病害 为 已 维修 bhwxzt = 1 已维修
			List<RcyhBhjlb> bhList = RcyhUtils.getBhsByRwdId(rwd.getRwdid());
			for( RcyhBhjlb b : bhList) {
				b.setBhwxzt("1");
				bhMapper.updateByPrimaryKey(b);
				log.info(b.getBhjlid() + " 病害的状态 已经更改为 已维修!");
			}
		}
	}
	

	/**
	 * 作业上报操作
	 * @param delegateTask
	 */
	private void zysbTask(DelegateTask delegateTask) {
		
		RcyhWxzyjlbMapper wxzyMapper = (RcyhWxzyjlbMapper) SpringContextUtil.getBean("rcyhWxzyjlbMapper");
		
		RcyhWxzyjlb wxzy = (RcyhWxzyjlb) delegateTask.getVariable("wxzy");

		// 更新 维修作业 状态
		int count = wxzyMapper.updateByPrimaryKeySelective(wxzy);
		if( count > 0 ) {
			log.info("更新" + count + "条 维修作业信息 成功");
		}else{
			log.error("更新" + count + " 条 维修作业信息 失败");
		}
	}

	/**
	 * 病害维修操作
	 * @param delegateTask
	 */
	private void bhwxTask(DelegateTask delegateTask) {
		RcyhRwdjlbMapper rwdMapper = (RcyhRwdjlbMapper) SpringContextUtil.getBean("rcyhRwdjlbMapper");
		RcyhWxzyjlbMapper wxzyMapper = (RcyhWxzyjlbMapper) SpringContextUtil.getBean("rcyhWxzyjlbMapper");
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		RcyhRwdjlb rwd = (RcyhRwdjlb) delegateTask.getVariable("rwd");
		RcyhWxzyjlb wxzy  =(RcyhWxzyjlb) delegateTask.getVariable("wxzy");
		int count = rwdMapper.updateByPrimaryKeySelective(rwd);
		if( count > 0 ) {
			log.info("更新任务单状态更改为已维修 :" + rwd.getRwdid());
		}else{
			log.error("更新"+rwd.getRwdid()+"任务单更新没有成功");
		}
		// 2 保存维修作业记录
		count = wxzyMapper.insert(wxzy);
		if(count > 0) {
			log.info("新插入了一条维修记录信息"+wxzy.getZyid());
		}else{
			log.error("插入维修作业信息 失败!");
		}
		
		// 3  保存关联的 人员工作量信息
		for( RcyhRyzyjlb zyjl : wxzy.getRyzys()) {
			zyjl.setZyid(wxzy.getZyid());
		}
		
		mjlxMapper.insertRyzyjlBatch(wxzy.getRyzys());
		count = wxzy.getRyzys().size();
		if(count  > 0 ) {
			log.info("批量插入了" + count + "和 修作业相关的 人员信息");
		}else{
			log.error("批量插入 维修相关的 人员信息 失败");
		}
		
		
		
		// 4  保存关联的 机械消耗 信息 
		for(RcyhCljxxhb cljx : wxzy.getCljxxhs()) {
			cljx.setSsid(wxzy.getZyid());
			cljx.setJe(cljx.getDj() * cljx.getSl());
		}
		mjlxMapper.insertCljxxhBatch(wxzy.getCljxxhs());
		count = wxzy.getCljxxhs().size();
		if(count  > 0 ) {
			log.info("批量插入了" + count + "和 修作业相关的 材料信息");
		}else{
			log.error("批量插入 维修相关的 材料信息 失败");
		}
	}


}
