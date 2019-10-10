package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.TreeDao;
import com.java1234.dao.UserDao;
import com.java1234.entity.User;
import com.java1234.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao  userDao;

	public Integer add(User user) {
		// TODO Auto-generated method stub
		return userDao.add(user);
	}

	public Integer update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	public List<User> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.list(map);
	}

	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.getTotal(map);
	}

	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}
	

	
	
	
}
