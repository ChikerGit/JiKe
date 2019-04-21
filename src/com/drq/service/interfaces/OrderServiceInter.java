package com.drq.service.interfaces;

import java.util.List;
import java.util.Map;

import com.drq.dto.Goods;
import com.drq.dto.Order;
import com.drq.dto.OrderItem;
import com.drq.dto.PageBean;
import com.drq.dto.User;

public interface OrderServiceInter {

	//显示订单列表
	List<Order> showOrderList(PageBean page,String time,String userSelect);

	//获取订单总记录数
	Integer getRecordCount(String time,String userSelect);

	//保存订单
	Integer saveOrder(double sumMoney, User user, List<Goods> goodsList);

	//显示我的订单详情
	List<OrderItem> showMyOrder(User user,PageBean page);

	//获取订单总记录数
	Integer getOrderConunt(PageBean page);

	//显示图形报表
	List<Map<String,String>> showGoodsEcharts();

}
