package com.hdsx.hmglyh.rcyh.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.hdsx.hmglyh.dao.Mapper;
@Mapper
public interface HtglYhbMapper {
	
    public ArrayList<HashMap<String,Object>> xdjlYhs(String bmcode);
    
    public String getRealName(String username);
    
    public String getBmname(String bmcode);
    
    public ArrayList<String> getBmusername(String bmcode);

}