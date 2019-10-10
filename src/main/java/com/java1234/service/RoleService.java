package com.java1234.service;

import java.util.List;
import java.util.Map;
import com.java1234.entity.Role;

public interface RoleService {
	
	
	
	public Integer add(Role role);
	
	public Integer update(Role role);
	
	public List<Role> list(Map<String,Object> map);
	
	public Integer getTotal(Map<String,Object> map);
	
	public Role findById(Integer id);
	
	public Integer delete(Integer id);
	
	
}
