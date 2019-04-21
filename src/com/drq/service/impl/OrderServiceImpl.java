package com.drq.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.drq.dao.impl.OrderDaoImpl;
import com.drq.dao.inter.OrderDaoInter;
import com.drq.dto.Goods;
import com.drq.dto.Order;
import com.drq.dto.OrderItem;
import com.drq.dto.PageBean;
import com.drq.dto.User;
import com.drq.service.interfaces.OrderServiceInter;
import com.drq.util.MyUtil;

public class OrderServiceImpl implements OrderServiceInter{

	OrderDaoInter orderDao=new OrderDaoImpl();
	@Override
	public List<Order> showOrderList(PageBean page,String time,String userSelect) {
		return orderDao.showOrderList(page,time,userSelect);
	}
	
	@Override
	public Integer getRecordCount(String time,String userSelect) {
		return orderDao.getRecordCount(time,userSelect);
	}

	@Override
	public Integer saveOrder(double sumMoney, User user, List<Goods> goodsList) {
		Order order=new Order();
		order.setOrderCode(MyUtil.getOrderCode());
		order.setCreateDate(new Date());
		order.setTradingStatus(0);
		order.setTotalAmount(sumMoney);
		order.setUser(user);
		order.setAlipay(0);
		return orderDao.saveOrder(order,goodsList);
	}

	@Override
	public List<OrderItem> showMyOrder(User user,PageBean page) {
		return orderDao.showMyOrder(user,page);
	}


	@Override
	public Integer getOrderConunt(PageBean page) {
		return orderDao.getOrderConunt(page);
	}

	@Override
	public List<Map<String,String>> showGoodsEcharts() {
		return orderDao.showGoodsEcharts();
	}

}
