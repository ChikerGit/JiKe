package com.drq.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drq.dto.Order;
import com.drq.dto.PageBean;
import com.drq.service.impl.OrderServiceImpl;
import com.drq.service.interfaces.OrderServiceInter;

@RequestMapping("/admin/order")
@Controller
public class OrderController {

	@RequestMapping("/showOrderList")
	public String showOrderList(ModelMap map,PageBean page,@DateTimeFormat(pattern="yyyy-MM-dd") Date timeSelect,String userSelect){
		String time=null;
		OrderServiceInter orderService=new OrderServiceImpl();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		if(timeSelect!=null){
			time=format.format(timeSelect);
		}
		Integer count=orderService.getRecordCount(time,userSelect);
		page.setRecordCount(count);
		List<Order> orderList=orderService.showOrderList(page,time,userSelect);
		map.put("time", time);
		map.put("userSelect", userSelect);
		map.put("orderList", orderList);
		map.put("pageModel", page);
		return "admin/order/orderList";
	}
}
