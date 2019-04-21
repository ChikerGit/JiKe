package com.drq.dto;

/**
 * OrderItem 数据传输类
 * @author zhangsheng
 * @email 2355774928@qq.com
 * @date 2018-09-22 16:53:36
 * @version 1.0
 */
public class OrderItem implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Order order;
	private Goods goods;
	private Integer buyNum;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "OrderItem [order=" + order + ", goods=" + goods + ", buyNum="
				+ buyNum + "]";
	}
	
	

}