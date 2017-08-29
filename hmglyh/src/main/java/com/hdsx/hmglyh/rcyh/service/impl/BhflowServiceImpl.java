
package com.hdsx.hmglyh.rcyh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.rcyh.dao.HtglMjlxMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhBhjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhGlxcsjbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhRwdjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhWxzyjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.BhjlAndRwd;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhCljxxhb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.ZP;
import com.hdsx.hmglyh.rcyh.service.BhflowService;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.Constants;

@Service
@Transactional
public class BhflowServiceImpl implements BhflowService {
	
	private static Logger log = LoggerFactory.getLogger(BhflowServiceImpl.class);
	
	@Autowired
	private RcyhBhjlbMapper bhjlMapper;
	@Autowired
	private RcyhRwdjlbMapper rwdMapper;
	@Autowired
	private HtglMjlxMapper mjlxMapper;
	@Autowired
	private RcyhWxzyjlbMapper wxzyMapper;
	@Autowired
	private RcyhGlxcsjbMapper xcjlMapper;
	
	@Autowired
	private WorkFlowService workflowService;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int saveBh(RcyhBhjlb bhjl) {
	
		String bhjlid = RcyhUtils.createBhID();
		bhjl.setBhjlid(bhjlid);
		
		HashMap<String,Object> variables = new HashMap<String,Object>();
		variables.put("bmcode", bhjl.getBmcode());
		workflowService.startProcess(bhjlid,variables);
		workflowService.completeTask(bhjlid,variables);
		
		// 1 插入病害
		int count = bhjlMapper.insertSelective(bhjl);
		if( count > 0 ) {
			log.info("插入" + bhjl.getBhjlid() + "病害成功");
		}else {
			log.error("插入" + bhjl.getBhjlid() + "病害失败");
		}
		
		//2  插入病害的 关联的照片信息
		List<ZP> zps = bhjl.getZps();
		List<ZP> zps2 = new ArrayList<ZP>();
		if( zps != null ) {
			for( ZP zp : zps ) {
				if( zp != null ){
					zp.setZpid(RcyhUtils.createZpID());
					zp.setSsid(bhjlid);
					zps2.add(zp);
				}
			}
			mjlxMapper.insertZpBatch(zps2);
			log.info(bhjl.getBhjlid()+ " 的 相关 图片信息 插入成功!");
		}
		
		//3 修改巡道记录 相关信息 
		RcyhUtils.updateXdjl(bhjl.getXcid());
		return count;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void shangbaoBh(RcyhBhjlb bhjlb) {
		
			int count = bhjlMapper.updateByPrimaryKeySelective(bhjlb);
			
			if( count > 0 ) {
				log.info("更新" + bhjlb.getBhjlid() + "成功!" );
			}else{
				log.error("更新" + bhjlb.getBhjlid() + "失败！");
			}
		
			// 1  更改病害表中 上报状态 的字段  记录上报人、上报时间、上报状态、上报对象
			HashMap<String,Object> variables = new HashMap<String,Object>();
			bhjlb.setPgzt("0");
			variables.put("bhsbzt",bhjlb.getBhsbzt());
			variables.put("bhjl", bhjlb);
			workflowService.completeTask(bhjlb.getBhjlid(),variables);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int savepg(RcyhRwdjlb rwd) {
		
		if("1".equals(rwd.getPgzt())) { // 同意派工
		
			String rwdid = RcyhUtils.createRWDID();
	
			// 1 保存任务单
			rwd.setRwdid(rwdid);
			if( rwd.isFromYdjh()) {
				rwd.setRwdzt(Constants.RwdYdjh1);
			}
			
			int count = rwdMapper.insert(rwd);
			if( count > 0 ) {
				log.info("插入了"+ count + "条 任务单信息");
			}else {
				log.error("插入任务单 信息  失败");
			}
			
			//2  插入 关联 材料 消耗信息
			if( rwd.getCljxxhs() != null ){
				List<RcyhCljxxhb> list = new ArrayList<RcyhCljxxhb>();
				for( RcyhCljxxhb clxh : rwd.getCljxxhs()){
					if(clxh != null ) {
						clxh.setSsid(rwd.getRwdid());
						clxh.setJe(clxh.getDj()*clxh.getSl());
						list.add(clxh);
					}
				}
				if( list.size() > 0 ) {
					mjlxMapper.insertCljxxhBatch(list);
					log.info("批量插入"+rwd.getCljxxhs().size()+"条机械 材料 消耗信息："+rwd.getRwdid());
				}
			}
			// 3 更新 与 该 任务单关联的病害的派工状态 改为已派工
			if( rwd.getBhjls() != null ) {
				for(RcyhBhjlb bhjl : rwd.getBhjls() ) {
					
					bhjl.setPgusename(rwd.getCjryname()); // 保存派工人  当前 登录用户
					bhjl.setPgtime(RcyhUtils.getDateTimeStr()); // 保存 派工时间  当前系统时间
					bhjl.setPgzt("1"); // 将 病害的状态 更改为 已经派工
					
					count = bhjlMapper.updateByPrimaryKeySelective(bhjl);  // 更新病害 
					if( count > 0 ) {
						log.info("更新了" + count + "条 病害信息");
					}else{
						log.error("更新"+bhjl.getBhjlid() +"病害信息失败");
					}
					
					// 插入 任务单与病害的 关联关系
					BhjlAndRwd bar = new BhjlAndRwd();
					bar.setBhjlid(bhjl.getBhjlid());
					bar.setRwdid(rwdid);
					count = bhjlMapper.saveRelativity(bar); // 保存任务单与病害的 关联关系
					if( count > 0 ) {
						log.info("插入 " + bar.getBhjlid() + "病害与" + bar.getRwdid() + "任务单的关系成功");
					}else{
						log.info("插入 " + bar.getBhjlid() + "病害与" + bar.getRwdid() + "任务单的关系失败");
					}
					Task task =workflowService.queryTaskByBkeyAndTkey(bhjl.getBhjlid(), "binghaipaigong");
					if(task != null) {
						HashMap<String,Object> variables2 = new HashMap<String,Object>();
						variables2.put("pgzt", 1);
						workflowService.completeTask(bhjl.getBhjlid(),variables2);
					}
				}
			}
			
			if(!rwd.isFromYdjh()) {
				HashMap<String,Object> variables = new HashMap<String,Object>();
				variables.put("rwd", rwd);
				workflowService.startProcess("wxProcess", rwdid,variables);
			}
			return 1; 
		}else if("2".equals(rwd.getPgzt())){ // 延期派工
			String duration = rwd.getDate();
			duration = RcyhUtils.getISO8601Date(Integer.parseInt(duration));
			// 1 更新病害的 派工状态为延期派工
			for( RcyhBhjlb bh : rwd.getBhjls()) {
				bh.setPgzt("2");
				bh.setYcpgtime(duration);
				int count = bhjlMapper.updateByPrimaryKeySelective(bh);
				if( count > 0 ) {
					log.info(bh.getBhjlid() + "病害的派工状态已经更改为 延迟派工");
				}else{
					log.info(bh.getBhjlid() + "病害的派工状态修改失败");
				}
				HashMap<String,Object> variables = new HashMap<String,Object>();
				variables.put("pgzt", "2");
				variables.put("date", duration);
			//	variables.put("duration", duration); //TODO 为兼容以前版本数据加上去的  建议以后删除
				bh  = bhjlMapper.selectByPrimaryKey2(bh.getBhjlid());
				variables.put("bhjl", bh);
				workflowService.completeTask(bh.getBhjlid(),variables);
 			}
			return 2;
		}else if("3".equals(rwd.getPgzt())) { // 取消派工
			
			// 1 将病害的派工状态 更改为 3 取消派工
			// 2 记录操作人 和 操作时间
			for( RcyhBhjlb bh : rwd.getBhjls()) {
				bh.setPgzt("3");
				bh.setPgtime(RcyhUtils.getDateTimeStr());
				bh.setPgusename(rwd.getCjusername());
				
				int count = bhjlMapper.updateByPrimaryKeySelective(bh);
				if( count > 0 ) {
					log.info(bh.getBhjlid() + "病害的派工状态已经更改为取消派工,更新了操作时间和操作人");
				}else{
					log.info(bh.getBhjlid() + "将病害的派工状态更改为取消派工失败");
				}
				
				HashMap<String,Object> variables = new HashMap<String,Object>();
				variables.put("pgzt", "3");
				workflowService.completeTask(bh.getBhjlid(),variables);
 			}
			return 3;
		}else if("4".equals(rwd.getPgzt())) { // 打回修改
			// 1 将 病害的 上报状态 更改 打回修改
			for( RcyhBhjlb bh : rwd.getBhjls()) {
				bh.setBhsbzt("3");
				int count = bhjlMapper.updateByPrimaryKeySelective(bh);
				if( count > 0 ) {
					log.info(bh.getBhjlid() + "将病害上报状态更改为打回修改成功");
				}else{
					log.info(bh.getBhjlid() + "将病害上报状态更改为打回修改失败");
				}
				
				HashMap<String,Object> variables = new HashMap<String,Object>();
				variables.put("pgzt", "4");
				bh = bhjlMapper.selectByPrimaryKey(bh.getBhjlid());
				variables.put("bmcode", bh.getBmcode());
				workflowService.completeTask(bh.getBhjlid(),variables);
 			}
			return 4;
		}
		return 0;
	}

	

	// 维修上报
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int saveSb(List<RcyhWxzyjlb> wxzys) {
		for( RcyhWxzyjlb zy : wxzys ) {
			
			if(zy.getYhid().startsWith("06") || zy.getYhid().startsWith("07")) {
				if(StringUtils.isNotBlank(zy.getRwdid())){
					RcyhRwdjlb rwd = rwdMapper.selectByPrimaryKeySimple(zy.getRwdid());
					if( rwd != null ) {
						rwd.setRwdzt("2");  //如果养护类型 生产或者非生产的 直接 已验收
						int c = rwdMapper.updateByPrimaryKeySelective(rwd);
						if( c > 0 ){
							log.info("辅助生产或非生产的任务单已经更改为已验收");
						}
					}
				}
				zy.setYszt("1");
				zy.setZysbzt("1");
			}
			
			// 更新 维修作业 状态
			int count = wxzyMapper.updateByPrimaryKeySelective(zy);
			if( count > 0 ) {
				log.info("更新" + count + "条 维修作业信息 成功");
			}else{
				log.error("更新" + count + " 条 维修作业信息 失败");
				throw new RuntimeException(zy.getZyid()+"维修作业修改失败");
			}
			HashMap<String,Object> variables = new HashMap<String,Object>();
			variables.put("wxzy", zy);
			variables.put("zysbzt", zy.getZysbzt());
			
			if(zy.getZysbzt().equals("2") || zy.getYhid().startsWith("06") || zy.getYhid().startsWith("07")) {
				workflowService.deleteProcessInstance(zy.getRwdid());
			}else{
				// 完成任务
				workflowService.completeTask(zy.getRwdid(), variables);
			}
		}
		return 1;
	}

	/**
	 * 删除任务单
	 * 0 该任务已经被认领无法删除
	 * 1 删除成功
	 */
	@Override
	public int delRwd(String rwdid) {
		RcyhRwdjlb rwd = rwdMapper.selectByPrimaryKeyWithClxhAndBh(rwdid);
	
		/*if(!"0".equals(rwd.getRwdzt())){
			return 0;
		}*/
		
		List<RcyhCljxxhb> xhs = rwd.getCljxxhs();
		if( xhs != null ) { // 删除相关联的机械材料
			int c = mjlxMapper.deleteGljxhBySsid(rwd.getRwdid());
			if(c > 0 ) {
				log.info("与" + rwd.getRwdid() + "相关连的机械材料信息删除成功");
			}
		}
		
		List<RcyhBhjlb> bhs = rwd.getBhjls();
		if( bhs != null ) { // 删除该任务单与病害的关联关系
			int c = mjlxMapper.deleteBhgl(rwd.getRwdid());
			if( c > 0 ) {
				log.info("与" + rwd.getRwdid() + "关联的病害信息删除成功!" );
			}
		}
		
		
		int c = rwdMapper.deleteByPrimaryKey(rwdid);
		if( c > 0 ) {
			log.info(rwdid + "已经成功删除");
		}
		workflowService.deleteProcessInstance(rwdid);
		return c;
	}

	@Override
	public int saveEditRwd(RcyhRwdjlb rwd) {
		
		// 1 删除 原来与任务单的 关联的材料信息
		int c = mjlxMapper.deleteGljxhBySsid(rwd.getRwdid());
		if(c > 0 ) {
			log.info("与" + rwd.getRwdid() + "相关连的机械材料信息删除成功");
		}
		// 2 修改任务单的信息
		c = rwdMapper.updateByPrimaryKeySelective(rwd);
		if( c > 0 ) {
			log.info("修改" + rwd.getRwdid() + " 的 任务单成功");
		}
		// 3 重新插入相关的机械材料消耗信息
		if( rwd.getCljxxhs() != null ){
			for( RcyhCljxxhb clxh : rwd.getCljxxhs()){
				if( clxh != null ) {
					clxh.setSsid(rwd.getRwdid());
					clxh.setJe(clxh.getDj()*clxh.getSl());
				}
			}
			mjlxMapper.insertCljxxhBatch(rwd.getCljxxhs());
			log.info("批量插入"+rwd.getCljxxhs().size()+"条机械 材料 消耗信息："+rwd.getRwdid());
		}
		return c;
	}

}
