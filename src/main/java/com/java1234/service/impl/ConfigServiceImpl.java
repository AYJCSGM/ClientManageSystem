package com.java1234.service.impl;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.java1234.dao.ConfigDao;
import com.java1234.entity.Config;
import com.java1234.service.ConfigService;

import net.sf.json.JSONObject;


@Service("configService")
public class ConfigServiceImpl implements ConfigService {
	
	@Resource
	private ConfigDao configDao;
	
	
	public Integer update(Config config) {
		int i =  configDao.update(config);
		config = configDao.findById(1);
		//ˢ�»���
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();  
        ServletContext servletContext = webApplicationContext.getServletContext(); 
        servletContext.setAttribute("config", config);
		return i ;
	}
	
	public Config findById(Integer id) {
		// TODO Auto-generated method stub
		return configDao.findById(id);
	}
	
	
}
