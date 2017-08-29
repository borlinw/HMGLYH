package com.hdsx.hmglyh.rcyh.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.task.Task;

public interface WorkFlowService {

	/**
	 * 开启流程实例
	 */
	public void startProcess(String bussinessKey,HashMap<String,Object> variables);
	
	public void startProcess(String deplymentKey,String bussinessKey,HashMap<String,Object> variables);
	
	/**
	 * 通过 BusinessKey 完成 task
	 */
	public void completeTask(String businessKey);
	public void completeTask(String businessKey,HashMap<String,Object> variables) ;

	
	/**
	 * 根据用户名称 查询 用户可以办理的任务
	 */
	public List<Task> queryTaskUser(String username);
	
	/**
	 * 查询流程图片
	 * @return
	 */
	public InputStream getProcessPic();
	/**
	 * 
	 * @param definitionKey 流程定义KEY
	 * @return
	 */
	InputStream getProcessPic(String definitionKey);
	/**
	 * 流程跟踪信息
	 * @param bhjlid
	 * @return
	 */
	public ActivityImpl getProcessMap(String bhjlid);
	
	/**
	 * 重载上面的方法
	 * @param bhjlid
	 * @param definitionKey
	 * @return
	 */
	ActivityImpl getProcessMap(String bhjlid,String definitionKey);
	
	public Task queryTaskByBkeyAndTkey(String bkey,String tkey);
	/**
	 * 通过业务间 挂起 一个 流程实例
	 * @param businessKey
	 */
	public void deleteProcessInstance(String businessKey);

	/**
	 * 
	 * @param businessKey
	 * @return
	 */
	public String getTaskName(String businessKey);
}
