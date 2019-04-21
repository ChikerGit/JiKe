package com.drq.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.drq.dto.OrderItem;
import com.drq.dto.PageBean;
import com.drq.dto.User;


public interface OrderItemMapper {

	//保存订单商品关联表
	void saveOrderItem(@Param("orderId") int orderId, @Param("goodsId") int goodsId,@Param("num") Integer num);

	//显示我的订单详情
	List<OrderItem> showMyOrder(@Param("user")User user,@Param("page") PageBean page);

	//获取订单总记录数
	Integer getOrderConunt(PageBean page);

	//显示图形报表
	
	List<Map<String,String>> showGoodsEcharts();


}
