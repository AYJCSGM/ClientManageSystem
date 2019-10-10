package com.java1234.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * ic卡帐单表。
 * 充值 记录 和消费记录全放在一个表中
 * @author Administrator
 */
public class CardBill {
	
	private Integer id;
	private Integer clientId;
	private String clientName;
	private String carno;//卡号
	private BigDecimal actual;//实收金额
	private BigDecimal discounts;//优惠金额
	private BigDecimal  money ;//储值金额   和 加油金额
	private BigDecimal balance;//卡余额
	private Integer type;//区别   充值【1】   消费【2】
	private String remark;//备注
	//操作时间 操作员
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
