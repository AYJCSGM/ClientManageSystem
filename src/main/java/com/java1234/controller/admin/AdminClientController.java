package com.java1234.controller.admin;


import java.math.BigDecimal;
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
import com.java1234.entity.Client;
import com.java1234.entity.PageBean;
import com.java1234.entity.Result;
import com.java1234.entity.User;
import com.java1234.service.ClientService;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;


@Controller
@RequestMapping("/admin/client")
public class AdminClientController {
	
	@Resource
	private ClientService clientService;
	
	
	@RequestMapping("/add")
	public String add(Client client  ,  HttpServletResponse response, HttpServletRequest request) throws Exception {
		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		
		client.setCreateUserId(currentUser.getId());
		client.setCreateDateTime(new Date());
		BigDecimal balance =new BigDecimal("0");
		client.setBalance(balance );
		Result result = new Result();
		Gson gson  = new Gson();
		
		int resultTotal = -1;
		
		try {
			resultTotal = clientService.add(client);
		} catch (Exception e) {
			result.setSuccess(false);
			
			if(e.getMessage().indexOf("carno_only_one")!=-1){
				result.setMsg("Ìí¼ÓÊ§°Ü-¿¨ºÅÖØ¸´");
			}else{
				result.setMsg("Ìí¼ÓÊ§°Ü-Î´Öª´íÎó");
			}
			
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
		
		if (resultTotal > 0) {
			result.setSuccess(true);
			result.setMsg("Ìí¼Ó³É¹¦");
		} else {
			result.setSuccess(false);
			result.setMsg("Ìí¼ÓÊ§°Ü");
		}
		
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
	
	@RequestMapping("/update")
	public String update(Client client, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		Result result = new Result();
		Gson gson = new Gson();
		
		//²»ÐÞ¸Ä¿¨ºÅ
		client.setCarno(null);
		
		int resultTotal = -1 ;
		try {
			resultTotal = clientService.update(client);
		} catch (Exception e) {
			result.setSuccess(false);
			if(e.getMessage().indexOf("carno_only_one")!=-1){
				result.setMsg("ÐÞ¸ÄÊ§°Ü-¿¨ºÅÖØ¸´");
			}else{
				result.setMsg("ÐÞ¸ÄÊ§°Ü-Î´Öª´íÎó");
			}
			
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
		
		
		if (resultTotal > 0) {
			result.setSuccess(true);
			result.setMsg("ÐÞ¸Ä³É¹¦");
		} else {
			result.setSuccess(false);
			result.setMsg("ÐÞ¸ÄÊ§°Ü!!!!!!!");
		}
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String rows,
			@RequestParam(value = "q", required = false) String q,
			@RequestParam(value = "date1", required = false) String date1,
			@RequestParam(value = "date2", required = false) String date2,
			@RequestParam(value = "nickname", required = false) String nickname,
			@RequestParam(value = "clientTypeId", required = false) String clientTypeId,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("q", StringUtil.formatLike(q));
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("nickname",StringUtil.formatLike(nickname));
		map.put("clientTypeId", clientTypeId);
		List<Client> list = clientService.list(map);
		
		Client list_heji = clientService.list_heji(map);
		if(list_heji!=null){
			list_heji.setName("ºÏ¼Æ");
			list_heji.setCarno("-");
			list_heji.setPhone("-");
			list.add(list_heji);
		}
		
		Integer total = clientService.getTotal(map);
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