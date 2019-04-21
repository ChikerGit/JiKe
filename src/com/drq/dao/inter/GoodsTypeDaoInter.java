package com.drq.dao.inter;

import java.util.List;

import com.drq.dto.GoodsType;
import com.drq.dto.PageBean;

public interface GoodsTypeDaoInter {

	//显示商品类型列表
	List<GoodsType> showGoodsTypeList(PageBean pageModel,String userSelect);

	//获取总记录数
	Integer getRecordCount(String userSelect);

	//通过code获取商品类型
	GoodsType getGoodsTypeBycode(String code);

	//获取相同code长度的类型名字
	List<GoodsType> codeLengthTypeName(Integer codeLength);

	//修改商品类型
	Integer upDataGoodsType(GoodsType newGoodsType);

	//删除商品类型
	Integer deleteGoodsType(String[] ids);

	//生成商品大类型最大编码
	String toAddMaxType();

	//生成商品小类型的最大编码
	String getGoodsMinType(String code);

	//获取商品大类型的所有名字
	List<GoodsType> getAllGoodsMaxTypeName();

	//添加商品大类型
	Integer addGoodsMaxType(GoodsType goodsTypes);
	
	//添加商品大类型
	Integer addGoodsMinType(GoodsType goodsTypes);
	
	//通过大类型获取小类型
	List<GoodsType> getGoodsMinTypeNameByCode(String maxTypeCode);


}
