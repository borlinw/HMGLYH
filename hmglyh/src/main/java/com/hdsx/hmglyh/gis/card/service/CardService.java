
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.card.service;

import com.hdsx.hmglyh.gis.card.bean.Card;

/**  
 *  
 * @author Baiyy
 * @created 2015年8月6日 下午3:49:22 
 */

public interface CardService {
	/**
	 * 添加卡片信息
	 * @param card
	 * @return
	 */
	boolean addCard(Card card);
	/**
	 * 查询卡片信息
	 * @param card
	 * @return
	 */
	Card getCard(Card card);
	/**
	 * 更新卡片信息
	 * @param card
	 * @return
	 */
	boolean updateCard(Card card);
}
