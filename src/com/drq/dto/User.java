package com.drq.dto;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * User 数据传输类
 * @author drq
 * @email 13096470398@qq.com
 * @date 2018-11-22 16:53:36
 * @version 1.0
 */
public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String userId;
	private String passWord;
	private String name;
	private String province;
	private String city;
	private int sex;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date birthday;
	private String email;
	private String phone;
	private String address;
	private int role;
	private java.util.Date createDate;
	private int activeStatus;
	private String activeCode;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserId(){
		return this.userId;
	}
	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	public String getPassWord(){
		return this.passWord;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setProvince(String province){
		this.province = province;
	}
	public String getProvince(){
		return this.province;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return this.city;
	}
	public void setSex(int sex){
		this.sex = sex;
	}
	public int getSex(){
		return this.sex;
	}
	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}
	public java.util.Date getBirthday(){
		return this.birthday;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setRole(int role){
		this.role = role;
	}
	public int getRole(){
		return this.role;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}
	public void setActiveStatus(int activeStatus){
		this.activeStatus = activeStatus;
	}
	public int getActiveStatus(){
		return this.activeStatus;
	}
	public void setActiveCode(String activeCode){
		this.activeCode = activeCode;
	}
	public String getActiveCode(){
		return this.activeCode;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", passWord="
				+ passWord + ", name=" + name + ", province=" + province
				+ ", city=" + city + ", sex=" + sex + ", birthday=" + birthday
				+ ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", role=" + role + ", createDate=" + createDate
				+ ", activeStatus=" + activeStatus + ", activeCode="
				+ activeCode + "]";
	}

	
}