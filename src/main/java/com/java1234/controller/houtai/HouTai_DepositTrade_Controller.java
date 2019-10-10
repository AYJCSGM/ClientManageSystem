package com.java1234.controller.houtai;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.java1234.entity.Client;
import com.java1234.service.ClientService;
import com.java1234.util.StringUtil;


/**
 * 充值  控制器
 * @author Administrator
 */
@Controller
@RequestMapping("/houtai/deposit/trade")
public class HouTai_DepositTrade_Controller {
	
	@Resource
	private ClientService clientService;
	
	/**
	 * /houtai/deposit/trade/add?clientId=12
	 */
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam(value = "clientId", required = false) String clientId) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "添加");
		Client client = clientService.findById(Integer.parseInt(clientId));
		
		mav.addObject("client", client);
		mav.addObject("type", 1);
		mav.addObject("clientId", clientId);
		mav.addObject("save_url", "/admin/card/bill/add");
		mav.setViewName("/admin/page/deposit_trade/add_or_update");
		return mav;
	}
	
	/**
	 *  充值记录就查全部
	 * /houtai/deposit/trade/manage?type=1
	 */
	@RequestMapping("/manage")
	public ModelAndView manage(@RequestParam(value = "type", required = false) String type) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("table_url", "/admin/card/bill/list?type=1");
		mav.addObject("type", type);
		
		mav.setViewName("/admin/page/deposit_trade/deposit_manage");
		return mav;
	}
	
	
}
