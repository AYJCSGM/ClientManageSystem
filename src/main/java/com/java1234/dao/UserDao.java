package com.java1234.dao;


import java.util.List;
import java.util.Map;

import com.java1234.entity.User;


public interface UserDao {
	
	
	public Integer add(User user);
	
	public Integer update(User user);
	
	public List<User> list(Map<String, Object> map);
	
	public Integer getTotal(Map<String, Object> map);
	
	public User findByName(String name);
	
	public User findById(Integer id);
	
	public Integer delete(Integer id);
	
	
}
