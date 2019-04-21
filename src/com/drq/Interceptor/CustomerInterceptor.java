package com.drq.Interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.drq.dto.User;

public class CustomerInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView view) throws Exception {
	
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		User userInfo=(User) request.getSession().getAttribute("userInfo");
		if(userInfo!=null){
			return true;
		}else{
			System.out.println(request.getServletContext().getServletContextName()+"=================");
			response.sendRedirect("/"+request.getServletContext().getServletContextName()+"/login.html");
			return false;
		}
	}

}
