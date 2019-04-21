	package com.drq.controller.Customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drq.dto.Goods;
import com.drq.dto.GoodsType;
import com.drq.dto.PageBean;
import com.drq.service.impl.GoodsServiceImpl;
import com.drq.service.impl.GoodsTypeServicImpl;
import com.drq.service.interfaces.GoodsSericeInter;
import com.drq.service.interfaces.GoodsTypeServicInter;

@RequestMapping("/customer/goodsList")
@Controller
public class GoodsListController {

	@RequestMapping("/goodsMinList")
	public String goodsMinList(String minCode,ModelMap map,PageBean page){
		GoodsSericeInter goodsService=new GoodsServiceImpl();
		Integer count=goodsService.getGoodsListCount(minCode,page);
		page.setRecordCount(count);
		page.setPageSize(15);
		List<Goods> goodsList=goodsService.getGoodsListByMinCode(minCode,page);
		GoodsTypeServicInter   goodsTypeServicImpl =new GoodsTypeServicImpl();
		//大类型名称
		map.put("goodsMaxTypeName",goodsTypeServicImpl.getGoodsTypeBycode(minCode.substring(0, 4)).getName());
		//小类型名称
		map.put("goodsMinTypeName",goodsTypeServicImpl.getGoodsTypeBycode(minCode).getName());
		//商品个数
		map.put("goodsCount", count);
		map.put("goodsList", goodsList);
		map.put("minCode", minCode);
		map.put("pageModel", page);
		return "goodsMinList";
	}
	
	@RequestMapping("/goodsSelect")
	public String goodsSelect(String userSelect,ModelMap map,PageBean page){
		GoodsSericeInter goodsService=new GoodsServiceImpl();
		Integer count=goodsService.getGoodsRecordCount(null,userSelect);
		page.setRecordCount(count);
		page.setPageSize(15);
		//首页查询
		List<Goods> goodsList=goodsService.showGoodsList(page,null,userSelect);
		//总记录数
		map.put("count", count);
		map.put("goodsList", goodsList);
		map.put("pageModel", page);
		map.put("userSelect", userSelect);
		return "goodsSelectList";
	}
}
