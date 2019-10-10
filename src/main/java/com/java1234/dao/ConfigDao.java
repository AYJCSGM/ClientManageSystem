package com.java1234.dao;

import com.java1234.entity.Config;

public interface ConfigDao {
	
	public Integer update(Config config);
	public Config findById(Integer id);
	
	
}
