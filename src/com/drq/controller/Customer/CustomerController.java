package com.drq.controller.Customer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ParameterParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drq.dao.impl.UserDaoImpl;
import com.drq.dao.inter.UserDaoInter;
import com.drq.dto.GoodsType;
import com.drq.dto.Picturcarousel;
import com.drq.dto.Timlimited;
import com.drq.dto.User;
import com.drq.service.impl.GoodsTypeServicImpl;
import com.drq.service.impl.PicetureServiceImpl;
import com.drq.service.impl.TimeGoodsServiceImpl;
import com.drq.service.impl.UserImpl;
import com.drq.service.interfaces.GoodsTypeServicInter;
import com.drq.service.interfaces.PicetureServiceInter;
import com.drq.service.interfaces.TimeGoodsServiceInter;
import com.drq.service.interfaces.UserInter;
import com.drq.util.Code;
import com.drq.util.Constant;
@RequestMapping("/customer")
@Controller
public class CustomerController {

	@RequestMapping("/autoCode")
	public void getCode(HttpServletRequest request,HttpServletResponse response){
		String autoNum=Code.getRandomNum();
		request.getSession().setAttribute(Constant.AUTO_NUM, autoNum);
		BufferedImage bi=Code.getImage(autoNum);
		try {
			ImageIO.write(bi, "jpg", response.getOutputStream());
		} catch (IOException e) {
			System.out.println("验证码响应失败");
			e.printStackTrace();
		}
	}
	
	
	@ResponseBody
	@RequestMapping("/compareNameByAdd")
	public Map<String, String> compareNameByAdd(String userId){
		Map<String, String> map=new HashMap<String, String>();
		UserInter u=new UserImpl();
		Integer count =u.compareNameByAdd(userId);
		map.put(Constant.FLAG, count>0?"fail":"success");
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public Map<String, String>  register(User user) {
		Map<String, String> map=new HashMap<String, String>();
		UserInter u=new UserImpl();
		Integer count=u.addAdmin(user);
		map.put(Constant.FLAG, count>0?"success":"fail");
		map.put(Constant.TIP, count>0?"注册成功":"注册失败");
		return map;
	}
	
	@RequestMapping("/toUpdateCustomer")
	public String  toUpdateCustomer(String id,ModelMap map) {
		UserInter u=new UserImpl();
		User user=u.toUpDateUser(id);
		map.put("user", user);
		return "updateCustomer";
	}
	
	@ResponseBody
	@RequestMapping("/updateCustomer")
	public Map<String, String> updateCustomer(User user){
		Map<String, String> map=new HashMap<String, String>();
		UserInter u=new UserImpl();
		Integer count=u.upDateCustomer(user);
		map.put(Constant.FLAG, count>0?"success":"fail");
		return map;
	}
	
	@RequestMapping("/index")
	public String toIndex(ModelMap map){
		PicetureServiceInter piceService=new PicetureServiceImpl();
		//轮播图
		List<Picturcarousel> piceList=piceService.showPicetureList(null,null);
		TimeGoodsServiceInter timeService=new TimeGoodsServiceImpl();
		//限时抢购
		List<Timlimited> timeGoodsList=timeService.showTimeList(null,null,null);
		map.put("timeGoodsList", timeGoodsList);
		map.put("piceList", piceList);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/showNav")
	public Map<String, List<List<GoodsType>>> showNav(){
		Map<String, List<List<GoodsType>>> typeMap=new HashMap<String, List<List<GoodsType>>>();
		List<List<GoodsType>> maxList=new ArrayList<List<GoodsType>>();
		List<List<GoodsType>> minList=new ArrayList<List<GoodsType>>();
		GoodsTypeServicInter goodsTypeService=new GoodsTypeServicImpl();
		List<GoodsType> maxTypeList=goodsTypeService.getAllGoodsMaxTypeName();
		maxList.add(maxTypeList);
		typeMap.put("maxType", maxList);
		for(GoodsType g:maxTypeList){
			String code=g.getCode()+"";
			List<GoodsType> minTypeList=goodsTypeService.getGoodsMinTypeNameByCode(code);
			minList.add(minTypeList);
			typeMap.put("minType", minList);
		}
		return typeMap;
	}
	
	@RequestMapping("/outLogin")
	public String outLogin(HttpSession session){
		session.removeAttribute("userInfo");
		session.removeAttribute(Constant.BUYCAR_SESSION);
		return "forward:index";
	}
}
