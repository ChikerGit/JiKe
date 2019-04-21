package com.drq.controller.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drq.dao.impl.GoodsDetailsDaoImpl;
import com.drq.dao.inter.GoodsDetailDaoInter;
import com.drq.dto.BrowseRecords;
import com.drq.dto.Goods;
import com.drq.dto.GoodsDetailDto;
import com.drq.service.impl.BrowseRecordsServiceImpl;
import com.drq.service.impl.GoodsServiceImpl;
import com.drq.service.impl.GoodsTypeServicImpl;
import com.drq.service.interfaces.BrowseRecordsServiceInter;
import com.drq.service.interfaces.GoodsSericeInter;
import com.drq.service.interfaces.GoodsTypeServicInter;

@RequestMapping("/customer/details")
@Controller
public class DetailsController {

	GoodsSericeInter goodsService=new GoodsServiceImpl();
	BrowseRecordsServiceInter browseRecordsService=new BrowseRecordsServiceImpl();
	//商品详情类
	GoodsDetailDaoInter goodsDetailDao = new GoodsDetailsDaoImpl();
	
	@RequestMapping("/goodsDetails")
	public String goodsDetails(ModelMap map,Integer id){
		/*browseRecordsService.insertRecord(id);*/
		Goods goods=goodsService.getGoodsById(id);
		int goodsDetailsId = goods.getGoodsDetailsId();
		GoodsTypeServicInter   goodsTypeServicImpl =new GoodsTypeServicImpl();
		//大类型名称
		map.put("goodsMaxTypeName",goodsTypeServicImpl.getGoodsTypeBycode(goods.getGoodsType().getCode().substring(0, 4)).getName());
		//小类型名称
		map.put("goodsMinTypeName",goodsTypeServicImpl.getGoodsTypeBycode(goods.getGoodsType().getCode()).getName());
		GoodsDetailDto goodsDetailDto = goodsDetailDao.getGoodsDetailById(goodsDetailsId);
		map.put("goodsDetailDto", goodsDetailDto);
		map.put("goods", goods);
		return "details";
	}
}
