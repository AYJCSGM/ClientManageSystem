package com.java1234.controller.houtai;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.Client;
import com.java1234.service.ClientService;

/**
 * 消费  控制器
 * @author Administrator  
 */
@Controller
@RequestMapping("/houtai/consumption")
public class HouTai_Consumption_Controller {
	
	@Resource
	private ClientService clientService;
	
	/**
	 * /houtai/consumption/add
	 */
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam(value = "clientId", required = false) String clientId) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "添加");
		Client client = clientService.findById(Integer.parseInt(clientId));
		
		mav.addObject("client", client);
		mav.addObject("type", 2);
		mav.addObject("clientId", clientId);
		mav.addObject("save_url", "/admin/card/bill/add");
		mav.setViewName("/admin/page/consumption/add_or_update");
		return mav;
	}
	
	
	/**
	 *  消费记录就查全部
	 * /houtai/consumption/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage(@RequestParam(value = "type", required = false) String type) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("table_url", "/admin/card/bill/list?type=2");
		mav.setViewName("/admin/page/consumption/consumption_manage");
		return mav;
	}
	
	
}
