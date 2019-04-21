package com.drq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drq.dto.Order;
import com.drq.dto.PageBean;


public interface OrderMapper {

	//显示订单列表
	List<Order> showOrderList(@Param("page") PageBean page,@Param("time") String time,@Param("userSelect") String userSelect);

	//获取订单总记录数
	Integer getRecordCount(@Param("time") String time,@Param("userSelect") String userSelect);

	//保存订单
	void saveOrder(Order order);

	Order getOrderById(Integer id);

}
