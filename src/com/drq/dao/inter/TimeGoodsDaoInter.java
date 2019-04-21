package com.drq.dao.inter;

import java.util.List;

import com.drq.dto.PageBean;
import com.drq.dto.Timlimited;

public interface TimeGoodsDaoInter {

	//获取限时抢购的记录数
	Integer getRecordCount(String time,String userSelect);

	//显示限时抢购列表
	List<Timlimited> showTimeList(PageBean page,String time,String userSelect);

	//添加限时抢购
	Integer addTimeGoods(Timlimited time);

	//通过ID获取限时抢购信息
	Timlimited getTimeGoodsById(Integer id);

	//修改限时抢购
	Integer upDateTimeGoods(Timlimited time);

	//删除限时抢购
	Integer deleteTimeGoods(Integer[] ids);

}
