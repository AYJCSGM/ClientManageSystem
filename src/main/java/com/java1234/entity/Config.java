package com.java1234.entity;

import java.util.Date;

public class Config {
	
	private Integer id;
	private String domain_name;//��վ�ı���   
	private String web_site;//��ַ http://www.baiduc.com
	private String headStr;//headͷ����Ķ���  ��һ�޸�headͷ   ����һ��һ���ļ��޸�    ����ģʽ  jq   ����վСͼ��
	//layui �汾
	private String layuiStr;
	private Integer init_money;//�Ƿ��ʼ���ͻ���� 0û�г�ʼ��  1�ѳ�ʼ��
	
	
	public Integer getInit_money() {
		return init_money;
	}
	public void setInit_money(Integer init_money) {
		this.init_money = init_money;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDomain_name() {
		return domain_name;
	}
	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}
	public String getWeb_site() {
		return web_site;
	}
	public void setWeb_site(String web_site) {
		this.web_site = web_site;
	}
	public String getHeadStr() {
		return headStr;
	}
	public void setHeadStr(String headStr) {
		this.headStr = headStr;
	}
	public String getLayuiStr() {
		return layuiStr;
	}
	public void setLayuiStr(String layuiStr) {
		this.layuiStr = layuiStr;
	}
	
	
	
	
	
	
  
}
