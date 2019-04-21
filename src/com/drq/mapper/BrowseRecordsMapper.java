package com.drq.mapper;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;

import com.drq.dto.BrowseRecords;

public interface BrowseRecordsMapper {

	Integer insertRecord(@Param("goodsId") Integer goodsId, @Param("recordDate") Date recordDate);

	List<BrowseRecords> getBrowseRecordsList();

}
