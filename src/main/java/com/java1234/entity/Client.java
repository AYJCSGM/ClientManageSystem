package com.java1234.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Client {
	
	private Integer id;
	private String carno;//���� Ψһ
	private String name;//��ʵ����
	private Integer sex;//1Ů  2��
	
	private String phone;//�绰
	private String address;//��ַ
	private BigDecimal balance;//�����
	private Date createDateTime;//����ʱ��
	private String remark;//��ע
	//�ͻ�����
	private Integer clientTypeId;
	private ClientType clientType;
	
	//����ʱ�� ����Ա
	private Integer createUserId;
	private User createUser;
	
	
	
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
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getClientTypeId() {
		return clientTypeId;
	}
	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}
	public ClientType getClientType() {
		return clientType;
	}
	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
	
	
	
	
	
	
}
