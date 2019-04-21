package com.drq.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.drq.dao.BaseDao;
import com.drq.dao.inter.GoodsTypeDaoInter;
import com.drq.dto.GoodsType;
import com.drq.dto.PageBean;
import com.drq.mapper.GoodsTypeMapper;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDaoInter{

	@Override
	public List<GoodsType> showGoodsTypeList(PageBean pageModel,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsTypeMapper=sqlSession.getMapper(GoodsTypeMapper.class);
		List<GoodsType> goodsTypeList=goodsTypeMapper.showGoodsTypeList(pageModel,userSelect);
		closeSqlSession();
		return goodsTypeList;
	}

	@Override
	public Integer getRecordCount(String userSelect) {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper recordCount=sqlSession.getMapper(GoodsTypeMapper.class);
		Integer count=recordCount.getRecordCount(userSelect);
		closeSqlSession();
		return count;
	}

	@Override
	public GoodsType getGoodsTypeBycode(String code) {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsTypeMapper=sqlSession.getMapper(GoodsTypeMapper.class);
		GoodsType goodsType=goodsTypeMapper.getGoodsTypeBycode(code);
		closeSqlSession();
		return goodsType;
	}

	@Override
	public List<GoodsType> codeLengthTypeName(Integer codeLength) {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsType=sqlSession.getMapper(GoodsTypeMapper.class);
		List<GoodsType> goodsTypeList=goodsType.codeLengthTypeName(codeLength);
		closeSqlSession();
		return goodsTypeList;
	}

	@Override
	public Integer upDataGoodsType(GoodsType newGoodsType) {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsTypeMapper=sqlSession.getMapper(GoodsTypeMapper.class);
		Integer count=goodsTypeMapper.upDataGoodsType(newGoodsType);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public Integer deleteGoodsType(String[] ids) {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsTypeMapper=sqlSession.getMapper(GoodsTypeMapper.class);
		Integer count=goodsTypeMapper.deleteGoodsType(ids);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public String toAddMaxType() {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsTypeMapper=sqlSession.getMapper(GoodsTypeMapper.class);
		String code=goodsTypeMapper.toAddMaxType();
		closeSqlSession();
		return code;
	}

	@Override
	public String getGoodsMinType(String code) {
	    SqlSession sqlSession=getSqlSession();
	    GoodsTypeMapper goodsTypeMapper=sqlSession.getMapper(GoodsTypeMapper.class);
	    String newcode=goodsTypeMapper.getGoodsMinType(code);
	    closeSqlSession();
		return newcode;
	}

	@Override
	public List<GoodsType> getAllGoodsMaxTypeName() {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsTypeMapper=sqlSession.getMapper(GoodsTypeMapper.class);
		List<GoodsType> goodsTypes=goodsTypeMapper.getAllGoodsMaxTypeName();
		closeSqlSession();
		return goodsTypes;
	}

	@Override
	public Integer addGoodsMaxType(GoodsType goodsTypes) {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsTypeMapper=sqlSession.getMapper(GoodsTypeMapper.class);
		Integer count=goodsTypeMapper.addGoodsMaxType(goodsTypes);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}
	
	@Override
	public Integer addGoodsMinType(GoodsType goodsTypes) {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsTypeMapper=sqlSession.getMapper(GoodsTypeMapper.class);
		Integer count=goodsTypeMapper.addGoodsMinType(goodsTypes);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public List<GoodsType> getGoodsMinTypeNameByCode(String maxTypeCode) {
		SqlSession sqlSession=getSqlSession();
		GoodsTypeMapper goodsMapper=sqlSession.getMapper(GoodsTypeMapper.class);
		List<GoodsType> goodsTypeList=goodsMapper.getGoodsMinTypeNameByCode(maxTypeCode);
		closeSqlSession();
		return goodsTypeList;
	}


}
