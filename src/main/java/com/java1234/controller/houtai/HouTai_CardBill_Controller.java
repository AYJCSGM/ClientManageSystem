package com.java1234.controller.houtai;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.java1234.entity.Client;
import com.java1234.service.ClientService;


@Controller
@RequestMapping("/houtai/card/bill")
public class HouTai_CardBill_Controller {
	
	@Resource
	private ClientService clientService;
	
	/**
	 *  查看用户 帐单流水  
	 * /houtai/card/bill/manage?clientId=5
	 */
	@RequestMapping("/manage")
	public ModelAndView manage(@RequestParam(value = "clientId", required = false) String clientId) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Client client     = clientService.findById(Integer.parseInt(clientId));
		mav.addObject("client", client);
		
		mav.addObject("title", client.getName()+"对账单");
		
		mav.addObject("table_url", "/admin/card/bill/list?clientId="+clientId);
		mav.setViewName("/admin/page/card_bill/card_bill_manage");
		return mav;
	}
	
}
