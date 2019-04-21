package com.drq.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drq.dto.GoodsType;
import com.drq.dto.PageBean;
import com.drq.dto.Timlimited;
import com.drq.service.impl.GoodsTypeServicImpl;
import com.drq.service.impl.TimeGoodsServiceImpl;
import com.drq.service.interfaces.GoodsTypeServicInter;
import com.drq.service.interfaces.TimeGoodsServiceInter;
import com.drq.util.Constant;
import com.drq.util.GoodsTypeCode;

@RequestMapping("admin/time")
@Controller
public class TimeGoodsController {

	@RequestMapping("/showTimeList")
	public String showTimeList(ModelMap map,PageBean page,@DateTimeFormat(pattern="yyyy-MM-dd") Date timeSelect,String userSelect){
		String time=null;
		TimeGoodsServiceInter timeService=new TimeGoodsServiceImpl();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		if(timeSelect!=null){
			time=format.format(timeSelect);
		}
		Integer couont=timeService.getRecordCount(time,userSelect);
		page.setRecordCount(couont);
		List<Timlimited> timeGoodsList=timeService.showTimeList(page,time,userSelect);
		for(Timlimited t:timeGoodsList){
			System.out.println(t.getGoods().getId()+"");
		}
		map.put("time", time);
		map.put("userSelect", userSelect);
		map.put("pageModel", page);
		map.put("timeGoodsList", timeGoodsList);
		return "admin/time/timeGoodsList";
	}
	
	@RequestMapping("/toAddTimeGoods")
	public String toAddTimeGoods(ModelMap map){
		GoodsTypeServicInter goodsType=new GoodsTypeServicImpl();
		List<GoodsType> goodsTypeList=goodsType.codeLengthTypeName(4);
		map.put("goodsTypeList", goodsTypeList);
		return "admin/time/addTimeGoods";
	}
	
	@RequestMapping("addTimeGoods")
	public String addTimeGoods(ModelMap map,Timlimited time,Integer gid){
		TimeGoodsServiceInter timeService=new TimeGoodsServiceImpl();
		Integer count=timeService.addTimeGoods(time,gid);
		map.put(Constant.TIP, count>0?"添加成功":"添加失败");
		return "forward:toAddTimeGoods";
	}
	
	@RequestMapping("/toUpDateGoodsTime")
	public String toUpDateGoodsTime(ModelMap map,Integer id){
		GoodsTypeServicInter goodsType=new GoodsTypeServicImpl();
		List<GoodsType> goodsTypeList=goodsType.codeLengthTypeName(4);
		map.put("goodsTypeList", goodsTypeList);
		TimeGoodsServiceInter timeService=new TimeGoodsServiceImpl();
		Timlimited time=timeService.getTimeGoodsById(id);
		//获取商品的title
		String goodsTitle=time.getGoods().getTitle();
		//获取商品小类型的code
		String minCode=time.getGoods().getGoodsType().getCode();
		GoodsType minType=goodsType.getGoodsTypeBycode(minCode);
		String maxCode=GoodsTypeCode.getMaxCode(minCode);
		GoodsType maxType=goodsType.getGoodsTypeBycode(maxCode);
		map.put("goodsId", time.getGoods().getId());
		map.put("goodsTitle", goodsTitle);
		map.put("minType", minType);
		map.put("maxType", maxType);
		map.put("time", time);
		return "admin/time/upDateTimeGoods";
	}
	
	@RequestMapping("/upDateTimeGoods")
	public String upDateTimeGoods(ModelMap map,Integer gid,Timlimited time){
		TimeGoodsServiceInter timeService=new TimeGoodsServiceImpl();
		Integer count=timeService.upDateTimeGoods(time,gid);
		map.put(Constant.TIP, count>0?"修改成功":"修改失败");
		return "forward:toUpDateGoodsTime";
	}
	
	@RequestMapping("/deleteTimeGoods")
	public String deleteTimeGoods(ModelMap map,Integer[] ids){
		TimeGoodsServiceInter timeService=new TimeGoodsServiceImpl();
		Integer count=timeService.deleteTimeGoods(ids);
		map.put(Constant.TIP, count>0?"成功删除"+count+"条记录":"删除失败");
		return "forward:showTimeList";
	}
}
