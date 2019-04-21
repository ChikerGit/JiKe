package com.drq.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drq.service.impl.OrderServiceImpl;
import com.drq.service.interfaces.OrderServiceInter;

@RequestMapping("/admin/Echarts")
@Controller
public class EchartsController {

	
	@RequestMapping("/toShowGoodsEcharts")
	public String toShowGoodsEcharts(){	
		return "admin/Echarts/echarts";
	}
	
	@ResponseBody
	@RequestMapping("/showGoodsEcharts")
	public Map<String,String> showGoodsEcharts(){
		Map<String,String> map=new HashMap<String,String>();
		OrderServiceInter orderService=new OrderServiceImpl();
		List<Map<String,String>> list=orderService.showGoodsEcharts();
		for(Map<String,String> m:list){
			map.put(m.get("key").replaceAll("-",""), m.get("value"));
		}
		return map;
	}
}
