package com.drq.dto;

/**
 * Goods 数据传输类
 * @author drq
 * @email 1309647039@qq.com
 * @date 2018-09-22 16:53:36
 * @version 1.0
 */
public class GoodsDetailDto implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int goodsId;
	private String color;
	private String netType;
	private String size;
	private String weight;
	private String thickness;
	private int stock;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNetType() {
		return netType;
	}
	public void setNetType(String netType) {
		this.netType = netType;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getThickness() {
		return thickness;
	}
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "GoodsDetailDto [id=" + id + ", goodsId=" + goodsId + ", color=" + color + ", netType=" + netType
				+ ", size=" + size + ", weight=" + weight + ", thickness=" + thickness + ", stock=" + stock + "]";
	}

}