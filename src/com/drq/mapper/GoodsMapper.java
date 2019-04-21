package com.drq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drq.dto.Goods;
import com.drq.dto.PageBean;

public interface GoodsMapper {

	//显示商品列表
	List<Goods> showGoodsList(@Param("page") PageBean page,@Param("time") String time,@Param("userSelect") String userSelect);

	//获取商品的记录数
	Integer getGoodsRecordCount(@Param("time") String time,@Param("userSelect") String userSelect);

	//添加商品
	Integer addGoods(@Param("goods") Goods goods);

	//通过ID的到商品
	Goods getGoodsById(Integer id);

	//修改商品
	Integer upDataGoods(@Param("goods") Goods goods);

	//删除商品
	Integer deleteGoods(Integer[] ids);

	//通过code获取goods
	List<Goods> getGoodsTitile(String minTypeCode);

	//通过大类型获取goods
	List<Goods> getGoodsListByMinCode(@Param("minCode") String minCode,@Param("page") PageBean page);

	//前台商品列表的总数量
	Integer getGoodsListCount(@Param("maxCode") String maxCode,@Param("page") PageBean page);

	List<Goods> getGoodsListByIds(List<Integer> gids);

	List<Goods> getGoodsListByGids(Integer[] ids);
	

}
