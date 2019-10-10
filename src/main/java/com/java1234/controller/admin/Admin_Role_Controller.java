package com.java1234.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java1234.entity.CardBill;
import com.java1234.entity.Client;
import com.java1234.entity.ClientType;
import com.java1234.entity.PageBean;
import com.java1234.entity.Result;
import com.java1234.entity.Role;
import com.java1234.entity.User;
import com.java1234.service.CardBillService;
import com.java1234.service.RoleService;
import com.java1234.util.CryptographyUtil;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;

@Controller
@RequestMapping("/admin/role")
public class Admin_Role_Controller {

	@Resource
	private RoleService roleService;

	@RequestMapping("/add")
	public String add(Role role, HttpServletResponse response, HttpServletRequest request) throws Exception {
		role.setCreateDateTime(new Date());
		int resultTotal = roleService.add(role);
		Result result = new Result();
		Gson gson = new Gson();
		if (resultTotal > 0) {
			result.setSuccess(true);
			result.setMsg("添加成功");
		} else {
			result.setSuccess(false);
			result.setMsg("添加失败");
		}
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}

	@RequestMapping("/update")
	public String update(Role role, HttpServletResponse response, HttpServletRequest request) throws Exception {
		int resultTotal = roleService.update(role);
		Result result = new Result();
		Gson gson = new Gson();
		if (resultTotal > 0) {
			result.setSuccess(true);
			result.setMsg("修改成功");
			
		} else {
			result.setSuccess(false);
			result.setMsg("修改失败");
		}
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}

	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String rows, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Role> list = roleService.list(map);
		Integer total = roleService.getTotal(map);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		map.clear();
		map.put("data", list);
		map.put("count", total);
		map.put("code", 0);
		map.put("msg", "");
		ResponseUtil.write(response, gson.toJson(map));
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids", required = false) String ids, HttpServletResponse response)
			throws Exception {
		String[] idsStr = ids.split(",");
		Gson gson = new Gson();
		Result result = new Result();
		/**
		 * 这里需要 判断一上，有没有 客户在使用这个类型
		 */
		for (int i = 0; i < idsStr.length; i++) {
			roleService.delete(Integer.parseInt(idsStr[i]));
		}
		result.setSuccess(true);
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
	

}
