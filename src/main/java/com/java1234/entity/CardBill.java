package com.java1234.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * ic���ʵ���
 * ��ֵ ��¼ �����Ѽ�¼ȫ����һ������
 * @author Administrator
 */
public class CardBill {
	
	private Integer id;
	private Integer clientId;
	private String clientName;
	private String carno;//����
	private BigDecimal actual;//ʵ�ս��
	private BigDecimal discounts;//�Żݽ��
	private BigDecimal  money ;//��ֵ���   �� ���ͽ��
	private BigDecimal balance;//�����
	private Integer type;//����   ��ֵ��1��   ���ѡ�2��
	private String remark;//��ע
	//����ʱ�� ����Ա
	private Date createDateTime;
	private Integer createUserId;
	private User createUser;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public BigDecimal getActual() {
		return actual;
	}
	public void setActual(BigDecimal actual) {
		this.actual = actual;
	}
	public BigDecimal getDiscounts() {
		return discounts;
	}
	public void setDiscounts(BigDecimal discounts) {
		this.discounts = discounts;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	
	
	
	
}
