package com.drq.service.impl;

import com.drq.dao.impl.BrowseRecordsDaoImpl;
import com.drq.dao.inter.BrowseRecordsDaoInter;
import com.drq.dto.BrowseRecords;
import com.drq.service.interfaces.BrowseRecordsServiceInter;

public class BrowseRecordsServiceImpl implements BrowseRecordsServiceInter {
	BrowseRecordsDaoInter browseRecordsDao = new BrowseRecordsDaoImpl();

	@Override
	public Integer insertRecord(Integer id) {
		// TODO Auto-generated method stub
		return browseRecordsDao.insertRecord(id);
	}
	

}
