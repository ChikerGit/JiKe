package com.drq.service.impl;

import java.util.List;

import com.drq.dao.impl.GoodsTypeDaoImpl;
import com.drq.dao.inter.GoodsTypeDaoInter;
import com.drq.dto.GoodsType;
import com.drq.dto.PageBean;
import com.drq.service.interfaces.GoodsTypeServicInter;
import com.drq.util.GoodsTypeCode;

public class GoodsTypeServicImpl implements GoodsTypeServicInter{

	GoodsTypeDaoInter goodsTypeDaoInter=new GoodsTypeDaoImpl();
	@Override
	public List<GoodsType> showGoodsTypeList(PageBean pageModel,String userSelect) {
		return goodsTypeDaoInter.showGoodsTypeList(pageModel,userSelect);
	}
	
	//获取总记录数
	@Override
	public Integer getRecordCount(String userSelect) {
		return goodsTypeDaoInter.getRecordCount(userSelect);
	}

	@Override
	public GoodsType getGoodsTypeBycode(String code) {
		return goodsTypeDaoInter.getGoodsTypeBycode(code);
	}

	@Override
	public List<GoodsType> codeLengthTypeName(Integer codeLength) {
		return goodsTypeDaoInter.codeLengthTypeName(codeLength);
	}

	@Override
	public Integer upDataGoodsType(GoodsType newGoodsType) {
		return goodsTypeDaoInter.upDataGoodsType(newGoodsType);
	}

	@Override
	public Integer deleteGoodsType(String[] ids) {
		return goodsTypeDaoInter.deleteGoodsType(ids);
	}

	@Override
	public String toAddMaxType() {
		String maxTypeCode=goodsTypeDaoInter.toAddMaxType();
		String newCode=GoodsTypeCode.getGoodsTypeCode(maxTypeCode);
		return newCode;
	}

	@Override
	public String getGoodsMinType(String code) {
		String minTypeCode=goodsTypeDaoInter.getGoodsMinType(code);
		if(minTypeCode==null){
			minTypeCode=code+"0000";
		}
		String newCode=GoodsTypeCode.getGoodsTypeCode(minTypeCode);
		return newCode;
	}

	@Override
	public List<GoodsType> getAllGoodsMaxTypeName() {
		return goodsTypeDaoInter.getAllGoodsMaxTypeName();
	}

	@Override
	public Integer addGoodsMaxType(GoodsType goodsTypes) {
		return goodsTypeDaoInter.addGoodsMaxType(goodsTypes);
	}

	@Override
	public Integer addGoodsMinType(GoodsType goodsType) {
		/*GoodsType newGoodsType=GoodsTypeCode.getGoodsMinTypeName(goodsType);*/
		return goodsTypeDaoInter.addGoodsMinType(goodsType);
	}

	@Override
	public List<GoodsType> getGoodsMinTypeNameByCode(String maxTypeCode) {
		return goodsTypeDaoInter.getGoodsMinTypeNameByCode(maxTypeCode);
	}

}
