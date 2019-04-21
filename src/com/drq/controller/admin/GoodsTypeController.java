package com.drq.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drq.dto.GoodsType;
import com.drq.dto.PageBean;
import com.drq.service.impl.GoodsTypeServicImpl;
import com.drq.service.interfaces.GoodsTypeServicInter;
import com.drq.util.Constant;

@RequestMapping("/admin/goodsType")
@Controller
public class GoodsTypeController {

	@RequestMapping("/showGoodsTypeList")
	public String showGoodsTypeList(ModelMap map,PageBean pageModel,String userSelect){
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		Integer recordCount=goodsTypeService.getRecordCount(userSelect);
		pageModel.setRecordCount(recordCount);
		List<GoodsType> goodsTypeList=goodsTypeService.showGoodsTypeList(pageModel,userSelect);
		map.put("userSelect", userSelect);
		map.put("goodsTypeList", goodsTypeList);
		map.put("pageModel", pageModel);
		return "admin/GoodsType/goodsTypeList";
	}
	
	@RequestMapping("/toUpDataGoodsType")
	public String toUpDataGoodsType(String code,ModelMap map){
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		GoodsType goodsType=goodsTypeService.getGoodsTypeBycode(code);
		Integer codeLength=code.length();
		List<GoodsType> codeLengthTypeName=goodsTypeService.codeLengthTypeName(codeLength);
		map.put("codeLengthTypeName", codeLengthTypeName);
		map.put("goodsType", goodsType);
		return "admin/GoodsType/updataGoodsType";
	}
	
	@RequestMapping("/upDataGoodsType")
	public String upDataGoodsType(GoodsType goodsType,ModelMap map){
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		Integer count=goodsTypeService.upDataGoodsType(goodsType);
		map.put(Constant.TIP, count>0?"修改成功":"修改失败");
		return "forward:toUpDataGoodsType";
	}
	
	@RequestMapping("/deleteGoodsType")
	public String deleteGoodsType(String[] ids,ModelMap map){
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		Integer count=goodsTypeService.deleteGoodsType(ids);
		map.put(Constant.TIP, count>0?"成功删除"+count+"条记录":"删除失败");
		return "forward:showGoodsTypeList";
	}
	
	@RequestMapping("/toAddMaxType")
	public String toAddMaxType(ModelMap map){
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		String typeCode=goodsTypeService.toAddMaxType();
		map.put("typeCode", typeCode);
		return "admin/GoodsType/addGoodsMaxType";
	}
	
	@ResponseBody
	@RequestMapping("/getGoodsMinType")
	public Map<String, String> getGoodsMinType(String code){
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		Map<String, String> map=new HashMap<String, String>();
		String typeCode=goodsTypeService.getGoodsMinType(code);
		map.put("typeCode", typeCode);
		return map;
		
	}
	
	@RequestMapping("/addGoodsMaxType")
	public String addGoodsMaxType(GoodsType goodsType,ModelMap map){
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		Integer count=goodsTypeService.addGoodsMaxType(goodsType);
		map.put(Constant.TIP, count>0?"添加成功":"添加失败");
		return "forward:toAddMaxType";
	}
	
	@RequestMapping("/toAddMinType")
	public String toAddMinType(ModelMap map){
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		List<GoodsType> goodsTypes=goodsTypeService.getAllGoodsMaxTypeName();
		map.put("goodsTypes", goodsTypes);
		return "admin/GoodsType/addGoodsMinType";
	}
	
	@RequestMapping("/addGoodsMinType")
	public String addGoodsMinType(GoodsType goodsType,ModelMap map){
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		Integer count=goodsTypeService.addGoodsMinType(goodsType);
		map.put(Constant.TIP, count>0?"添加成功":"添加失败");
		return "forward:toAddMinType";
	}
}
