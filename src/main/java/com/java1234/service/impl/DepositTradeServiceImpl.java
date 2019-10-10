package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.ConfigDao;
import com.java1234.dao.DepositTradeDao;
import com.java1234.entity.DepositTrade;
import com.java1234.service.DepositTradeService;



@Service("depositTradeService")
public class DepositTradeServiceImpl implements DepositTradeService {
	
	@Resource
	private DepositTradeDao depositTradeDao;
	
	@Override
	public Integer add(DepositTrade depositTrade) {
		// TODO Auto-generated method stub
		return depositTradeDao.add(depositTrade);
	}
	
	@Override
	public Integer update(DepositTrade depositTrade) {
		// TODO Auto-generated method stub
		return depositTradeDao.update(depositTrade);
	}
	
	@Override
	public List<DepositTrade> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return depositTradeDao.list(map);
	}
	
	@Override
	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return depositTradeDao.getTotal(map);
	}

}
