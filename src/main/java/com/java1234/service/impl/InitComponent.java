package com.java1234.service.impl;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import com.java1234.entity.Config;
import com.java1234.service.ConfigService;
import net.sf.json.JSONObject;


@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{
	
	private static ApplicationContext applicationContext;
	
	
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application=sce.getServletContext();
		ConfigService configService=(ConfigService) applicationContext.getBean("configService");

		//把config  初始到全局缓存中
		Config config = configService.findById(1);
		//保存到 缓存中
		application.setAttribute("config", config);
		
		
		
		
	}
	
	
	
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

}
