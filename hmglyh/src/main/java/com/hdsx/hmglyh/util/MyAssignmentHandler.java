package com.hdsx.hmglyh.util;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.rcyh.dao.RcyhBhjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;

public class MyAssignmentHandler implements TaskListener{
	
	private static Logger log = LoggerFactory.getLogger(MyAssignmentHandler.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		// 使用 name 有可能 改变 ， 直接 使用 key 判断
		
 		String key = delegateTask.getTaskDefinitionKey();
		if("binghaijilu".equals(key)) { // 病害记录     
			// 分配对象 为 当前用户的 所在部门
			String bmcode = (String) delegateTask.getVariable("bmcode");
			delegateTask.addCandidateGroup(bmcode);
			log.info(bmcode + "部门的人员分配了 病害记录的任务");
		}
		else if( "binghaishangbao".equals(key)) { //  病害上报
			//上报对象  分局或公路局养护管理科
			//LoginUser user = (LoginUser) delegateTask.getVariable("loginUser");
			String bmcode = (String) delegateTask.getVariable("bmcode");
			delegateTask.addCandidateGroup(bmcode);
			log.info(bmcode + "部门的人员获得了 病害上报的任务");
		}
		else if( "binghaipaigong".equals(key) ) { // 病害派工
			RcyhBhjlb bhjl = (RcyhBhjlb) delegateTask.getVariable("bhjl");
			delegateTask.addCandidateGroup(bhjl.getSbbmcode());
			
			String pgzt = bhjl.getPgzt();
			
			if("2".equals(pgzt)) { // 延期派工过来的 ， 将该病害派工的 派工状态改未派工
				RcyhBhjlbMapper bhjlMapper = (RcyhBhjlbMapper) SpringContextUtil.getBean("rcyhBhjlbMapper");
				bhjl.setPgzt("0");
				int c = bhjlMapper.updateByPrimaryKeySelective(bhjl);
				if( c > 0 ) {
					log.info(bhjl.getBhjlid() + "延期派工的时间已经到了，将其状态 改为 未派工");
				}else{
					log.info(bhjl.getBhjlid() + "更改状态 改为 未派工失败");
				}
			}
			
			log.info(bhjl.getSbbmcode()+ "部门的人员获得了病害派工的任务");
		}
		else if( "weixiuzuoye".equals(key) ) { // 维修作业
			RcyhRwdjlb rwd = (RcyhRwdjlb) delegateTask.getVariable("rwd");
			delegateTask.addCandidateGroup(rwd.getBmcode());
			log.info(rwd.getBmcode() + ") 的 人员 获得 了 维修作业的任务");
		}
		else if( "zuoyeshangbao".equals(key) ) { // 作业上报
			RcyhWxzyjlb wxzy  = (RcyhWxzyjlb) delegateTask.getVariable("wxzy");
			delegateTask.addCandidateGroup(wxzy.getBmcode());
			log.info(  wxzy.getBmcode() + ") 的 人员 获得 了 作业上报的任务");
		}
		else if( "zuoyeyanshou".equals(key)) { // 作业验收 
			/**
			 * 如果是是 分局或者0101 上报 权限 的是 人 上报 ，那么 验收就让他自己验收好了
			 */
			// 由分局 人员 进行验收 
			RcyhWxzyjlb wxzy  = (RcyhWxzyjlb) delegateTask.getVariable("wxzy");
			String bmcode = wxzy.getBmcode();
			if(bmcode.length() == 8 ) {  // 上报给分局
				bmcode = bmcode.substring(0,bmcode.length()-2);
			}else{ // 交安设施 上报给 路的 管辖 者
				bmcode = RcyhUtils.getBmcodeByLdcode(wxzy.getLdcode());
				if(bmcode.length() == 8 ) {
					bmcode = bmcode.substring(0, bmcode.length() - 2 );
				}
			}
			delegateTask.addCandidateGroup(bmcode);
			log.info(bmcode + "部门 人员获得了作业验收的任务");
		}
	}
}	