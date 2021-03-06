package com.java1234.controller.houtai;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.management.relation.RoleList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.google.gson.Gson;
import com.java1234.entity.Result;
import com.java1234.entity.Role;
import com.java1234.entity.User;
import com.java1234.service.PublicService;
import com.java1234.service.RoleService;
import com.java1234.service.UserService;
import com.java1234.util.CryptographyUtil;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;



@Controller
@RequestMapping("/houtai/user")
public class HouTai_User_Controller {
	
	@Resource
	private RoleService  roleService;
	@Resource
	private UserService  userService;
	@Resource
	private PublicService  publicService;
	

	/**
	 * 
	 * @param t  是null 代表，是全部
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "用户管理");
		mav.addObject("title", "用户管理");
		mav.setViewName("/admin/page/user/user_manage");
		return mav;
	}
	
	
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("btn_text", "添加");
		mav.addObject("save_url", "/admin/user/add.do");
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Role> roleList = roleService.list(map );
		
		mav.addObject("roleList", roleList);
		
		mav.setViewName("/admin/page/user/add_or_update");
		return mav;
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id
			,HttpServletResponse response
			,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		User user = userService.findById(Integer.parseInt(id));
		
		mav.addObject("user", user);
		mav.addObject("btn_text", "修改");
		mav.addObject("save_url", "/admin/user/update.do?id="+id);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Role> roleList = roleService.list(map );
		mav.addObject("roleList", roleList);
		
		
		
		mav.setViewName("/admin/page/user/add_or_update");
		return mav;
	}
	
	@RequestMapping("/setPersm")
	public ModelAndView setPersm(@RequestParam(value = "id", required = false) String id,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		//如果id有值就是 更新 如果没有值  就是添加
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.setViewName("admin/page/user/set_persm");
		return mav;
	}
	
	@RequestMapping("/setPassword")
	public ModelAndView setPassword(@RequestParam(value = "id", required = false) String id,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		//如果id有值就是 更新 如果没有值  就是添加
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.addObject("save_url", "/admin/user/update?id="+id);
		mav.setViewName("admin/page/user/set_password");
		return mav;
	}
	
	
	
}
