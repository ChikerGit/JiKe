package com.drq.dto;

/**
 * Picturcarousel 数据传输类
 * @author zhangsheng
 * @email 2355774928@qq.com
 * @date 2018-09-22 16:53:36
 * @version 1.0
 */
public class Picturcarousel implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String imageUrl;
	private String requestUrl;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}
	public String getImageUrl(){
		return this.imageUrl;
	}
	public void setRequestUrl(String requestUrl){
		this.requestUrl = requestUrl;
	}
	public String getRequestUrl(){
		return this.requestUrl;
	}
	@Override
	public String toString() {
		return "Picturcarousel [id=" + id + ", imageUrl=" + imageUrl
				+ ", requestUrl=" + requestUrl + "]";
	}

}