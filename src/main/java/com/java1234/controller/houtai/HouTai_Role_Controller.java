package com.java1234.controller.houtai;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.ClientType;
import com.java1234.entity.Role;
import com.java1234.service.ClientTypeService;
import com.java1234.service.RoleService;

@Controller
@RequestMapping("/houtai/role")
public class HouTai_Role_Controller {
	
	@Resource
	private RoleService roleService;
	
	
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/role/role_manage");
		return mav;
	}
	
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "Ìí¼Ó");
		mav.addObject("save_url", "/admin/role/add");
		mav.setViewName("/admin/page/role/add_or_update");
		return mav;
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		Role role       = roleService.findById(Integer.parseInt(id));
		mav.addObject("role", role);
		mav.addObject("btn_text", "ÐÞ¸Ä");
		mav.addObject("save_url", "/admin/role/update?id=" + id);
		mav.setViewName("/admin/page/role/add_or_update");
		return mav;
	}
	
	
	
	
}
