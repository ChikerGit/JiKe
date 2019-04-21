package com.drq.controller.Customer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drq.dto.Goods;
import com.drq.dto.OrderItem;
import com.drq.dto.PageBean;
import com.drq.dto.User;
import com.drq.service.impl.GoodsServiceImpl;
import com.drq.service.impl.OrderServiceImpl;
import com.drq.service.interfaces.GoodsSericeInter;
import com.drq.service.interfaces.OrderServiceInter;
import com.drq.util.Constant;

@RequestMapping("/customer/buyCar")
@Controller
public class BuyCarController {

	private static Integer news=0;
	
	@ResponseBody
	@RequestMapping("/addToCar")
	public Map<Integer, Integer> addToCar(HttpSession session,Integer gid,Integer buyNum){
		Map<Integer, Integer> buyCar=(Map<Integer, Integer>) session.getAttribute(Constant.BUYCAR_SESSION);
		if(buyCar==null){
			buyCar=new HashMap<Integer, Integer>();
			session.setAttribute(Constant.BUYCAR_SESSION, buyCar);
		}
		if(buyCar!=null && buyCar.containsKey(gid)){
			Integer num=buyCar.get(gid)+buyNum;
			buyCar.put(gid, num);
		}else{
			buyCar.put(gid, buyNum);
		}
		session.setAttribute(Constant.BUYCAR_SESSION, buyCar);
		return buyCar;
	}
	
	//购物车中的商品数量
	@ResponseBody
	@RequestMapping("/showBuyNum")
	public Integer showBuyNum(HttpSession session){
		Integer count=0;
		Map<Integer, Integer> buyCar=(Map<Integer, Integer>) session.getAttribute(Constant.BUYCAR_SESSION);
		if(buyCar!=null){
			Set<Entry<Integer, Integer>> set=buyCar.entrySet();
			for(Entry<Integer, Integer> s:set){
				count+=s.getValue();
			}
		}
		return count;
	}
	
	@RequestMapping("/showBuyCar")
	public String showBuyCar(HttpSession session,ModelMap map){
		Map<Integer, Integer> buyCar=(Map<Integer, Integer>) session.getAttribute(Constant.BUYCAR_SESSION);
		List<Goods> goodsList=new ArrayList<Goods>();
		if(buyCar!=null){
			GoodsSericeInter goodsService=new GoodsServiceImpl();
			DecimalFormat format=new DecimalFormat("0.00");
			Set<Entry<Integer, Integer>> set=buyCar.entrySet();
			for(Entry<Integer, Integer> s:set){
				Goods goods=goodsService.getGoodsById(s.getKey());
				goods.setBuyNum(s.getValue());
				Double money=Double.parseDouble(format.format(s.getValue()*goods.getFavorablePrice()));
				goods.setMoney(money);
				goodsList.add(goods);
			}
			
		}
		map.put("goodsList", goodsList);
		return "buycar";
	}
	
	@ResponseBody
	@RequestMapping("/deleteGoods")
	public void deleteGoods(HttpSession session,Integer id){
		Map<Integer, Integer> buyCar=(Map<Integer, Integer>) session.getAttribute(Constant.BUYCAR_SESSION);
		buyCar.remove(id);
	}
	
	//修改购物车
	@ResponseBody
	@RequestMapping("/upDatJiKeCar")
	public void upDatJiKeCar(Integer gid,Integer num,HttpSession session){
		Map<Integer, Integer> buyCar=(Map<Integer, Integer>) session.getAttribute(Constant.BUYCAR_SESSION);
		buyCar.put(gid, num);
		session.setAttribute(Constant.BUYCAR_SESSION, buyCar);
	}

	@RequestMapping("/submitOrder")
	public String submitOrder(Integer[] ids,HttpSession session,ModelMap map){
		Map<Integer, Integer> buyCar=(Map<Integer, Integer>) session.getAttribute(Constant.BUYCAR_SESSION);
		GoodsSericeInter goodsService=new GoodsServiceImpl();
		List<Goods> goodsList=new ArrayList<Goods>();
		double sumMoney=0.00;
		DecimalFormat format=new DecimalFormat("0.00");
		for(int i=0;i<ids.length;i++){
			Goods goods=goodsService.getGoodsById(ids[i]);
			goods.setBuyNum(buyCar.get(ids[i]));
			Double money=Double.parseDouble(format.format(buyCar.get(ids[i])*goods.getFavorablePrice()));
			goods.setMoney(money);
			sumMoney+=money;
			goodsList.add(goods);
		}
		map.put("goodsList", goodsList);
		map.put("sumMoney", sumMoney);
		return "orderSubmit";
	}
	
	//保存订单
	@RequestMapping("/saveOrder")
	public String saveOrder(Integer[] ids,HttpSession session,ModelMap map){
		Map<Integer, Integer> buyCar=(Map<Integer, Integer>) session.getAttribute(Constant.BUYCAR_SESSION);
		User user=(User) session.getAttribute("userInfo");
		//保存订单消息数
		news++;
		session.getServletContext().setAttribute("news", news);
		GoodsSericeInter goodsService=new GoodsServiceImpl();
		List<Goods> goodsList=new ArrayList<Goods>();
		Integer count=0;
		double sumMoney=0.00;
		DecimalFormat format=new DecimalFormat("0.00");
		if(ids!=null&&buyCar!=null){
			for(int i=0;i<ids.length;i++){
				Goods goods=goodsService.getGoodsById(ids[i]);
				goods.setBuyNum(buyCar.get(ids[i]));
				System.out.println();
				if(buyCar.get(ids[i])!=null){
					Double money=Double.parseDouble(format.format(buyCar.get(ids[i])*goods.getFavorablePrice()));
					goods.setMoney(money);
					sumMoney+=money;
					goodsList.add(goods);
					OrderServiceInter orderService=new OrderServiceImpl();
					count=orderService.saveOrder(sumMoney,user,goodsList);
				}
			}
		}
		if(count>0){
			buyCar.clear();
			map.put("goodsList", goodsList);
		}
		return "orderSuccess";
	}
	
	@RequestMapping("/showMyOrder")
	public String showMyOrder(ModelMap map,HttpSession session,PageBean page){
		User user=(User) session.getAttribute("userInfo");
		OrderServiceInter orderService=new OrderServiceImpl();
		Integer count=orderService.getOrderConunt(page);
		page.setRecordCount(count);
		List<OrderItem> orderItems=orderService.showMyOrder(user,page);
		map.put("orderItems", orderItems);
		map.put("pageModel", page);
		return "myOrder";
	}
	
	@ResponseBody
	@RequestMapping("/clearCar")
	public void clearCar(HttpSession session){
		Map<Integer, Integer> buyCar=(Map<Integer, Integer>) session.getAttribute(Constant.BUYCAR_SESSION);
		buyCar.clear();
	}
}
