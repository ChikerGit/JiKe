package com.drq.mapper;

import org.apache.ibatis.annotations.Param;

import com.drq.dto.GoodsDetailDto;

public interface GoodsDetailMapper {	
	
	GoodsDetailDto getGoodsDetailById(@Param("id") Integer id);

}
