
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.card.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.gis.card.bean.Card;
import com.hdsx.hmglyh.gis.card.mapper.CardMapper;
import com.hdsx.hmglyh.gis.card.service.CardService;

/**  
 *  
 * @author Baiyy
 * @created 2015年8月6日 下午3:59:35 
 */
@Service
public class CardServiceImpl implements CardService {
	@Resource(name="cardMapper")
	private CardMapper cardMapper;
	
	
	@Override
	public boolean addCard(Card card) {
		cardMapper.dropCard(card);
		if(cardMapper.addCard(card)>0)
			return true;
		return false;
	}

	@Override
	public Card getCard(Card card) {
		List<Card> list = cardMapper.getCard(card);
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	@Override
	public boolean updateCard(Card card) {
		if(cardMapper.updateCard(card)>0)
			return true;
		return false;
	}

}
