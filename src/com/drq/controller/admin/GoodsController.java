package com.drq.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.drq.dto.Goods;
import com.drq.dto.GoodsType;
import com.drq.dto.PageBean;
import com.drq.service.impl.GoodsServiceImpl;
import com.drq.service.impl.GoodsTypeServicImpl;
import com.drq.service.interfaces.GoodsSericeInter;
import com.drq.service.interfaces.GoodsTypeServicInter;
import com.drq.util.Constant;
import com.drq.util.GoodsTypeCode;

@RequestMapping("/admin/Goods")
@Controller
public class GoodsController {

	@RequestMapping("/showGoodsList")
	public String showGoodsList(ModelMap map,PageBean page,@DateTimeFormat(pattern="yyyy-MM-dd") Date timeSelect,String userSelect){
		String time=null;
		GoodsSericeInter goodsService=new GoodsServiceImpl();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		if(timeSelect!=null){
			time=format.format(timeSelect);
		}
		Integer count=goodsService.getGoodsRecordCount(time,userSelect);
		page.setRecordCount(count);
		List<Goods> goodsList=goodsService.showGoodsList(page,time,userSelect);
		map.put("time", time);
		map.put("userSelect", userSelect);
		map.put("goodsList", goodsList);
		map.put("pageModel", page);
		return "admin/Goods/goodsList";
	}
	
	@RequestMapping("/saveGoods")
	public String addGoods(@RequestParam("myFile") MultipartFile file,ModelMap map,Goods goods,String typeCode){
		GoodsSericeInter goodsService=new GoodsServiceImpl();
		GoodsType gt=new GoodsType();
		gt.setCode(typeCode);
		goods.setGoodsType(gt);
		//保存图片
		String imageName=GoodsTypeCode.uploadImg(file);
		goods.setImage(imageName);
		goods.setCreateDate(new Date());
		Integer count=goodsService.addGoods(goods);
		map.put(Constant.TIP, count>0?"添加成功":"添加失败");
		return "forward:toAddGoods";
	}
	
	@RequestMapping("/toAddGoods")
	public String loginToHome(ModelMap map){
		GoodsTypeServicInter goodsType=new GoodsTypeServicImpl();
		List<GoodsType> goodMinType=goodsType.codeLengthTypeName(8);
		map.put("goodMinType", goodMinType);
		return "admin/Goods/addGoods";
	}
	
	@RequestMapping("/toUpGoods")
	public String toUpGoods(Integer id,ModelMap map){
		GoodsSericeInter goodsService=new GoodsServiceImpl();
		Goods goods=goodsService.getGoodsById(id);
		GoodsTypeServicInter goodsType=new GoodsTypeServicImpl();
		List<GoodsType> goodMinType=goodsType.codeLengthTypeName(8);
		map.put("goodMinType", goodMinType);
		map.put("goods", goods);
		return "admin/Goods/updataGoods";
	}
	
	@RequestMapping("/upDataGoods")
	public String upDataGoods(@RequestParam("myFile") MultipartFile file,ModelMap map,Goods goods,String typeCode,String urlImage){
		GoodsSericeInter goodsService=new GoodsServiceImpl();
		GoodsType gt=new GoodsType();
		gt.setCode(typeCode);
		goods.setGoodsType(gt);
		//保存图片
		String imageName=GoodsTypeCode.uploadImg(file);
		if(imageName==null || "".equals(imageName)){
			goods.setImage(urlImage);
		}else{
			goods.setImage(imageName);
		}
		Integer count=goodsService.upDataGoods(goods);
		map.put(Constant.TIP, count>0?"修改成功":"修改失败");
		return "forward:toUpGoods";
	}
	
	@RequestMapping("/deleteGoods")
	public String deleteGoods(Integer[] ids,ModelMap map){
		GoodsSericeInter goodsService=new GoodsServiceImpl();
		Integer count=goodsService.deleteGoods(ids);
		map.put(Constant.TIP, count>0?"共删除了"+count+"条记录":"删除失败");
		return "forward:showGoodsList";
	}
}
