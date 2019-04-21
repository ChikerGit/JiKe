package com.drq.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.drq.dto.Goods;
import com.drq.dto.GoodsType;
import com.drq.dto.PageBean;
import com.drq.dto.Picturcarousel;
import com.drq.service.impl.GoodsServiceImpl;
import com.drq.service.impl.GoodsTypeServicImpl;
import com.drq.service.impl.PicetureServiceImpl;
import com.drq.service.interfaces.GoodsSericeInter;
import com.drq.service.interfaces.GoodsTypeServicInter;
import com.drq.service.interfaces.PicetureServiceInter;
import com.drq.util.Constant;
import com.drq.util.GoodsTypeCode;

@RequestMapping("/admin/piceture")
@Controller
public class PictureController {

	@RequestMapping("/showPicetureList")
	public String showPicetureList(PageBean page,ModelMap map,String userSelect){
		PicetureServiceInter piceService=new PicetureServiceImpl();
		Integer count=piceService.getRecordCount(userSelect);
		page.setRecordCount(count);
		List<Picturcarousel> piceList=piceService.showPicetureList(page,userSelect);
		map.put("userSelect", userSelect);
		map.put("piceList", piceList);
		map.put("pageModel", page);
		return "admin/picture/picetureList";
	}
	
	@RequestMapping("/toAddPice")
	public String toAddPice(ModelMap map){
		GoodsTypeServicInter goodsType=new GoodsTypeServicImpl();
		List<GoodsType> goodsTypeList=goodsType.codeLengthTypeName(4);
		map.put("goodsTypeList", goodsTypeList);
		return "admin/picture/addPiceture";
	}
	
	@ResponseBody
	@RequestMapping("/getMinType")
	public Map<String, List<GoodsType>> getMinType(String maxTypeCode){
		Map<String, List<GoodsType>> map=new HashMap<String, List<GoodsType>>();
		GoodsTypeServicInter goodsType=new GoodsTypeServicImpl();
		List<GoodsType> goodsTypeList=goodsType.getGoodsMinTypeNameByCode(maxTypeCode);
		map.put("minTypeList", goodsTypeList);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/getGoodsTitile")
	public Map<String, List<Goods>> getGoodsTitile(String minTypeCode){
		Map<String, List<Goods>> map=new HashMap<String, List<Goods>>();
		GoodsSericeInter goodService=new GoodsServiceImpl();
		List<Goods> goodsList=goodService.getGoodsTitile(minTypeCode);
		map.put("goodsList", goodsList);
		return map;
	}
	
	@RequestMapping("/addPiceRoute")
	public String addPiceRoute(@RequestParam("myFile") MultipartFile file,String gid,ModelMap map){
		String imageUrl=GoodsTypeCode.uploadImg(file);
		Picturcarousel pic=new Picturcarousel();
		pic.setImageUrl(imageUrl);
		pic.setRequestUrl("/customer/detail.action?goods.id="+gid);
		PicetureServiceInter piceService=new PicetureServiceImpl();
		Integer count=piceService.addPiceRoute(pic);
		map.put(Constant.TIP, count>0?"保存成功":"保存失败");
		return "forward:toAddPice";
	}
	
	@RequestMapping("/toUpdatePic")
	public String toUpdatePic(ModelMap map,String id){
		PicetureServiceInter piceService=new PicetureServiceImpl();
		Picturcarousel pic=piceService.getPicByid(id);
		//获取商品的ID
		Integer goodsId=GoodsTypeCode.getGoodsIdByPicRequestUrl(pic.getRequestUrl());
		GoodsSericeInter goodsServer=new GoodsServiceImpl();
		//获取商品title
		String goodsTitle=goodsServer.getGoodsById(goodsId).getTitle();
		//获取商品小类型的code
		String goodsMinTypeCode=goodsServer.getGoodsById(goodsId).getGoodsType().getCode();
		GoodsTypeServicInter goodsType=new GoodsTypeServicImpl();
		//获取商品小类型
		GoodsType minType=goodsType.getGoodsTypeBycode(goodsMinTypeCode);
		//获取大类型的code
		String goodsMaxTypeCode=GoodsTypeCode.getMaxCode(goodsMinTypeCode);
		GoodsType maxType=goodsType.getGoodsTypeBycode(goodsMaxTypeCode);
		List<GoodsType> goodsTypeList=goodsType.codeLengthTypeName(4);
		map.put("goodsId", goodsId);
		map.put("goodsTitle", goodsTitle);
		map.put("minType", minType);
		map.put("maxType", maxType);
		map.put("goodsTypeList", goodsTypeList);
		map.put("pic", pic);
		return "admin/picture/upDatePiceture";
	}
	
	@RequestMapping("/upDatePiceRoute")
	public String upDatePiceRoute(@RequestParam("myFile") MultipartFile file,String imageUrl,Integer id,String gid,ModelMap map){
		Picturcarousel pic=new Picturcarousel();
		String url=GoodsTypeCode.uploadImg(file);
		if(url==null || "".equals(url)){
			pic.setImageUrl(imageUrl);
		}else{
			pic.setImageUrl(url);
		}
		pic.setRequestUrl("/customer/detail.action?goods.id="+gid);
		pic.setId(id);
		PicetureServiceInter piceService=new PicetureServiceImpl();
		Integer count=piceService.upDatePiceRoute(pic);
		map.put(Constant.TIP, count>0?"修改成功":"修改失败");
		return "forward:toUpdatePic";
	}
	
	@RequestMapping("/deletePic")
	public String deletePic(Integer[] ids,ModelMap map){
		PicetureServiceInter piceService=new PicetureServiceImpl();
		Integer count=piceService.deletePic(ids);
		map.put(Constant.TIP, count>0?"成功删除"+count+"条记录":"删除失败");
		return "forward:showPicetureList";
	}
}
