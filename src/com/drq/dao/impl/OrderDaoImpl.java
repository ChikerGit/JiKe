package com.drq.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.drq.dao.BaseDao;
import com.drq.dao.inter.OrderDaoInter;
import com.drq.dto.Goods;
import com.drq.dto.Order;
import com.drq.dto.OrderItem;
import com.drq.dto.PageBean;
import com.drq.dto.User;
import com.drq.mapper.OrderItemMapper;
import com.drq.mapper.OrderMapper;

public class OrderDaoImpl extends BaseDao implements OrderDaoInter{

	@Override
	public List<Order> showOrderList(PageBean page,String time,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<Order> orderList=orderMapper.showOrderList(page,time,userSelect);
		closeSqlSession();
		return orderList;
	}

	@Override
	public Integer getRecordCount(String time,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		Integer count=orderMapper.getRecordCount(time,userSelect);
		closeSqlSession();
		return count;
	}

	@Override
	public Integer saveOrder(Order order, List<Goods> goodsList) {
		SqlSession sqlSession=getSqlSession();
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		OrderItemMapper orderItemMapper=sqlSession.getMapper(OrderItemMapper.class);
		try {
			orderMapper.saveOrder(order);
			for(Goods g:goodsList){
				orderItemMapper.saveOrderItem(order.getId(),g.getId(),g.getBuyNum());
			}
			sqlSession.commit();
			closeSqlSession();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			closeSqlSession();
		}
		return 0;
	}

	@Override
	public List<OrderItem> showMyOrder(User user,PageBean page) {
		SqlSession sqlSession=getSqlSession();
		OrderItemMapper orderItemMapper=sqlSession.getMapper(OrderItemMapper.class);
		List<OrderItem> orderItem=orderItemMapper.showMyOrder(user,page);
		closeSqlSession();
		return orderItem;
	}

	@Override
	public Integer getOrderConunt(PageBean page) {
		SqlSession sqlSession=getSqlSession();
		OrderItemMapper orderItemMapper=sqlSession.getMapper(OrderItemMapper.class);
		Integer count=orderItemMapper.getOrderConunt(page);
		closeSqlSession();
		return count;
	}

	@Override
	public List<Map<String,String>> showGoodsEcharts() {
		SqlSession sqlSession=getSqlSession();
		OrderItemMapper orderItemMapper=sqlSession.getMapper(OrderItemMapper.class);
		List<Map<String,String>> map=orderItemMapper.showGoodsEcharts();
		closeSqlSession();
		return map;
	}


}
