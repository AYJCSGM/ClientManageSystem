package com.java1234.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import javax.annotation.Resource;
import javax.naming.spi.ObjectFactoryBuilder;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.java1234.entity.Config;
import com.java1234.entity.Result;
import com.java1234.entity.Tree;
import com.java1234.entity.User;
import com.java1234.http.HttpClient;
import com.java1234.service.ConfigService;
import com.java1234.service.PublicService;
import com.java1234.service.TreeService;
import com.java1234.service.UserService;
import com.java1234.util.DateUtil;
import com.java1234.util.MyUtil;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;
import com.java1234.util.XMLUtil;
import com.mysql.fabric.xmlrpc.base.Data;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 主页Contrller
 * 版本 2.10 更新 上去
 */

@Controller
@RequestMapping("/")
public class IndexContrller {

	@Resource
	private TreeService treeService;
	@Resource
	private PublicService publicService;
	
	
	/**
	 * /wap/laws/index
	 * 请求主页
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletResponse  res,HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String UserAgent = req.getHeader("User-Agent");
		//判断AppleWebKit 和  Firefox
		
		if(MyUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/pc/login/login");
		}else{
			mav.setViewName("/admin/common/s_mode");
		}
		
		System.out.println("【UserAgent】【】【】【】】【"+UserAgent);
		return mav;
	}
	
	
	/**
	 * 电脑登陆
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletResponse  res,HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String UserAgent = req.getHeader("User-Agent");
		//判断AppleWebKit 和  Firefox
		
		if(MyUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/pc/login/login");
		}else{
			mav.setViewName("/admin/common/s_mode");
		}
		
		System.out.println("【UserAgent】【】【】【】】【"+UserAgent);
		return mav;
	}
	
	
	/**
	 * 后台主页
	 */
	@RequestMapping("/admin/main")
	public ModelAndView admin_main(HttpServletResponse  res,HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		publicService.addLeftMenu(mav);
		
		System.out.println(MyUtil.getRemoteAddress(req));
		
		
		
		String UserAgent = req.getHeader("User-Agent");
		if(MyUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/admin/main");
		}else{
			mav.setViewName("/admin/common/s_mode");
		}
		return mav;
	}
	
	
}
