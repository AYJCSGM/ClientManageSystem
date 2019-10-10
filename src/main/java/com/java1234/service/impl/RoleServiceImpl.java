package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.CardBillDao;
import com.java1234.dao.RoleDao;
import com.java1234.entity.Role;
import com.java1234.service.RoleService;




@Service("roleService")
public class RoleServiceImpl implements RoleService {
	

	@Resource
	private RoleDao roleDao;
	
	
	
	@Override
	public Integer add(Role role) {
		// TODO Auto-generated method stub
		return roleDao.add(role);
	}

	@Override
	public Integer update(Role role) {
		// TODO Auto-generated method stub
		return roleDao.update(role);
	}

	@Override
	public List<Role> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.getTotal(map);
	}

	@Override
	public Role findById(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}
	
	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.delete(id);
	}

}
