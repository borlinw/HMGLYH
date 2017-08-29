package com.hdsx.hmglyh.htgl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.htgl.bean.HtglMjlx;
import com.hdsx.hmglyh.htgl.mapper.HtglMjMapper;
import com.hdsx.hmglyh.htgl.service.HtglMjService;

/**  
 *  枚举类型ServiceImpl
 * @author LiRui
 * @created 2015年6月5日 上午10:24:31 
 */
@Service
@Transactional
public class HtglMjServiceImpl implements HtglMjService {

	@Resource(name="htglMjMapper")
	private HtglMjMapper mapper;

	@Override
	public List<HtglMjlx> queryDateToCreateCombobox(HtglMjlx mj) {
		return mapper.queryMjByTypeToCreateCombobox(mj);
	}

}
