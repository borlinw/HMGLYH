/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.card.mapper;



import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.gis.card.bean.Card;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午11:51:15 
 */
@Mapper
public interface CardMapper extends Dao<Card> {
	/**
	 * 添加卡片信息
	 * @param card
	 * @return
	 */
	int addCard(Card card);
	/**
	 * 根据卡片类型以及卡片对应的编码或者id查询卡片信息
	 * @param card
	 * @return
	 */
	List<Card> getCard(Card card);
	/**
	 * 更新卡片信息
	 * @param card
	 * @return
	 */
	int updateCard(Card card);
	/**
	 * 删除卡片信息
	 * @param card
	 * @return
	 */
	int dropCard(Card card);
}
