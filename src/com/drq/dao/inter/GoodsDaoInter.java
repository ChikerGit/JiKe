package com.drq.dao.inter;

import java.util.List;

import com.drq.dto.Goods;
import com.drq.dto.PageBean;

public interface GoodsDaoInter {

	//显示商品列表
	List<Goods> showGoodsList(PageBean page,String time,String userSelect);

	//获取商品记录数
	Integer getGoodsRecordCount(String time,String userSelect);

	//添加成功
	Integer addGoods(Goods goods);

	//通过ID得到商品
	Goods getGoodsById(Integer id);

	//修改商品
	Integer upDataGoods(Goods goods);

	//删除商品
	Integer deleteGoods(Integer[] ids);

	//通过code获取goods
	List<Goods> getGoodsTitile(String minTypeCode);

	//通过小类型code获取goods
	List<Goods> getGoodsListByMinCode(String minCode,PageBean page);

	//前台商品列表的总数量
	Integer getGoodsListCount(String minCode,PageBean page);

	//通过id集合获取商品列表
	List<Goods> getGoodsListByIds(List<Integer> gids);

	//通过id数组获取商品列表
	List<Goods> getGoodsListByGids(Integer[] ids);

}
