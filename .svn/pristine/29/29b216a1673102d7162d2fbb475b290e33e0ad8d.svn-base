package com.java1234.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.java1234.dao.TreeDao;
import com.java1234.entity.Tree;
import com.java1234.service.TreeService;
import javax.annotation.Resource;



@Service("treeService")
public class TreeServiceImpl implements TreeService {

	@Resource
	private TreeDao  treeDao;



	public Tree findById(Integer id) {
		return treeDao.findById(id);
	}
	
	

	public List<Tree> getTreesByFatherOrIds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return treeDao.getTreesByFatherOrIds(map);
	}
 
	


	 
}
