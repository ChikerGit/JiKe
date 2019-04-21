package com.drq.dto;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Timlimited 数据传输类
 * @author zhangsheng
 * @email 2355774928@qq.com
 * @date 2018-09-22 16:53:36
 * @version 1.0
 */
public class Timlimited implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date limitDate;
	private Goods goods;
	private int isEnd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.util.Date getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(java.util.Date limitDate) {
		this.limitDate = limitDate;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Timlimited [id=" + id + ", limitDate=" + limitDate + ", goods="
				+ goods + ", isEnd=" + isEnd + "]";
	}

	

}