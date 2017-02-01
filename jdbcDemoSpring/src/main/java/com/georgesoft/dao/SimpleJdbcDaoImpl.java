package com.georgesoft.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {

	
	public int getCountCircle(){
		String sql = "select count(*) from circle";
		return this.getJdbcTemplate().queryForInt(sql);
	}
	
	
}
