package com.drq.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtil {

	public static void myCook(String userId,String passWord,String online,HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies=request.getCookies();
		if("0".equals(online)){
			Cookie autoCookie=new Cookie("online", null);
			autoCookie.setPath("/");
			autoCookie.setMaxAge(0);
			response.addCookie(autoCookie);
			Cookie userCookie=new Cookie("username", null);
			
			userCookie.setPath("/");
			userCookie.setMaxAge(0);
			response.addCookie(userCookie);
			Cookie pwdCookie=new Cookie("pwd", null);
			pwdCookie.setPath("/");
			pwdCookie.setMaxAge(0);
			response.addCookie(pwdCookie);
		}
		if(cookies!=null){
			for(Cookie c:cookies){
				if("1".equals(online) && c.getName()!="online"){
					Cookie autoCookie=new Cookie("online", online);
					autoCookie.setPath("/");
					autoCookie.setMaxAge(60*60*7);
					response.addCookie(autoCookie);
					Cookie userCookie=new Cookie("username", userId);
					userCookie.setPath("/");
					userCookie.setMaxAge(60*60*7);
					response.addCookie(userCookie);
					Cookie pwdCookie=new Cookie("pwd", passWord);
					pwdCookie.setPath("/");
					pwdCookie.setMaxAge(60*60*7);
					response.addCookie(pwdCookie);
				}
			}
		}
	}
	
	//生成订单编号
	public static String getOrderCode(){
		return System.currentTimeMillis()+"";
	}

}
