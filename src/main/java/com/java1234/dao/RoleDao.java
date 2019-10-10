package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Client;
import com.java1234.entity.Role;

public interface RoleDao {
	
	public Integer add(Role role);
	
	public Integer update(Role role);
	
	public List<Role> list(Map<String,Object> map);
	
	public Integer getTotal(Map<String,Object> map);
	
	public Role findById(Integer id);
	
	public Integer delete(Integer id);
	
	
}
