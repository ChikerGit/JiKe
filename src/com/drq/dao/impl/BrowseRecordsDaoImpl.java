package com.drq.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.drq.dao.BaseDao;
import com.drq.dao.inter.BrowseRecordsDaoInter;
import com.drq.dto.BrowseRecords;
import com.drq.dto.Goods;
import com.drq.mapper.BrowseRecordsMapper;

public class BrowseRecordsDaoImpl extends BaseDao implements BrowseRecordsDaoInter{

	@Override
	public Integer insertRecord(Integer goodsId) {
		SqlSession sqlSession=getSqlSession();
		BrowseRecordsMapper browseRecordsMapper=sqlSession.getMapper(BrowseRecordsMapper.class);
		Date recordDate = new Date();
		Integer status = browseRecordsMapper.insertRecord(goodsId,recordDate);
		sqlSession.commit();
		closeSqlSession();
		return status;
	}

	@Override
	public List<BrowseRecords> getBrowseRecordsList() {
		SqlSession sqlSession=getSqlSession();
		BrowseRecordsMapper browseRecordsMapper=sqlSession.getMapper(BrowseRecordsMapper.class);
		List<BrowseRecords>  browseRecords = browseRecordsMapper.getBrowseRecordsList();
		closeSqlSession();
		return browseRecords;
	}

}
