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
import com.java1234.entity.DepositTrade;
import com.java1234.entity.PageBean;
import com.java1234.entity.Result;
import com.java1234.entity.User;
import com.java1234.service.CardBillService;
import com.java1234.service.ClientService;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;


@Controller
@RequestMapping("/admin/card/bill")
public class Admin_CardBill_Controller {
	
	@Resource
	private CardBillService cardBillService;
	@Resource
	private ClientService clientService;
	
	/**
	 * /admin/card/bill/add
	 */
	@RequestMapping("/add")
	public String add(CardBill  cardBill,@RequestParam(value = "clientId", required = false) String clientId,  HttpServletResponse response, HttpServletRequest request) throws Exception {
		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		cardBill.setCreateUserId(currentUser.getId());
		cardBill.setCreateDateTime(new Date());
		Client client = clientService.findById(Integer.parseInt(clientId));
		
		cardBill.setClientId(Integer.parseInt(clientId));
		cardBill.setClientName(client.getName());
		cardBill.setCarno(client.getCarno());
		
		//判断 充值  还是消费
		if(cardBill.getType()==1){
			client.setBalance(client.getBalance().add(cardBill.getMoney()));
		}else{
			client.setBalance(client.getBalance().subtract(cardBill.getMoney()));
		}
		
		clientService.update(client);
		cardBill.setBalance(client.getBalance());
		
		int resultTotal = cardBillService.add(cardBill);
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
	
	
	/**
	 * /admin/card/bill/list
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String rows,
			@RequestParam(value = "q", required = false) String q,
			@RequestParam(value = "date1", required = false) String date1,
			@RequestParam(value = "date2", required = false) String date2,
			@RequestParam(value = "clientId", required = false) String clientId,
			@RequestParam(value = "type", required = false) String type,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("q", StringUtil.formatLike(q));
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("clientId", clientId);
		map.put("type", type);
		
		List<CardBill> list = cardBillService.list(map);
		Integer total = cardBillService.getTotal(map);
		
		if(StringUtil.isNotEmpty(type)){
			CardBill  list_heji = cardBillService.list_heji(map);
			if(list_heji!=null){
				list_heji.setClientName("合计");
				list_heji.setCarno("-");
				list.add(list_heji);
			}
		}
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		
		map.clear();
		map.put("data", list);
		map.put("count", total);
		map.put("code", 0);
		map.put("msg", "");
		ResponseUtil.write(response, gson.toJson(map));
		return null;
	}
	
	
	
	
}
