	package com.drq.dto;

import java.util.Date;

/**
 * 
 * @author dai
 *
 */
public class BrowseRecords implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Date recordTime;
	private Integer goodsId;
	private Goods goods;
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		
		this.goods = goods;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BrowseRecords [recordTime=" + recordTime + ", goodsId=" + goodsId + "]";
	}
	
	
	
	
}
