package com.drq.dto;

/**
 * Order 数据传输类
 * @author zhangsheng
 * @email 2355774928@qq.com
 * @date 2018-09-22 16:53:36
 * @version 1.0
 */
public class Order implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String orderCode;
	private java.util.Date createDate;
	private java.util.Date sendDate;
	private int tradingStatus;
	private double totalAmount;
	private User user;
	private int alipay;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(java.util.Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getTradingStatus() {
		return tradingStatus;
	}
	public void setTradingStatus(int tradingStatus) {
		this.tradingStatus = tradingStatus;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAlipay() {
		return alipay;
	}
	public void setAlipay(int alipay) {
		this.alipay = alipay;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderCode=" + orderCode + ", createDate="
				+ createDate + ", sendDate=" + sendDate + ", tradingStatus="
				+ tradingStatus + ", totalAmount=" + totalAmount + ", user="
				+ user + ", alipay=" + alipay + "]";
	}

	

}