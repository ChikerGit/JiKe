package com.drq.dto;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Goods 数据传输类
 * @author drq
 * @email 1309647039@qq.com
 * @date 2018-09-22 16:53:36
 * @version 1.0
 */
public class Goods implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String brandName;
	private double price;
	private double favorablePrice;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date groundingDate;
	private int storage;
	private String image;
	private String description;
	private GoodsType goodsType;
	private java.util.Date createDate;
	private Integer buyNum;
	private Double money;
	private int goodsDetailsId;
	
	
	
	public int getGoodsDetailsId() {
		return goodsDetailsId;
	}
	public void setGoodsDetailsId(int goodsDetailsId) {
		this.goodsDetailsId = goodsDetailsId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getFavorablePrice() {
		return favorablePrice;
	}
	public void setFavorablePrice(double favorablePrice) {
		this.favorablePrice = favorablePrice;
	}
	public java.util.Date getGroundingDate() {
		return groundingDate;
	}
	public void setGroundingDate(java.util.Date groundingDate) {
		this.groundingDate = groundingDate;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", title=" + title + ", brandName="
				+ brandName + ", price=" + price + ", favorablePrice="
				+ favorablePrice + ", groundingDate=" + groundingDate
				+ ", storage=" + storage + ", image=" + image
				+ ", description=" + description + ", goodsType=" + goodsType
				+ ", createDate=" + createDate + ", buyNum=" + buyNum
				+ ", money=" + money + "]";
	}
	
    
	

}