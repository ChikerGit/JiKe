package com.drq.dao.inter;

import java.util.List;

import com.drq.dto.BrowseRecords;

public interface BrowseRecordsDaoInter {

	Integer insertRecord(Integer id);

	List<BrowseRecords> getBrowseRecordsList();
    
}
