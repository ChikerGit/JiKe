package com.drq.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.drq.dto.GoodsType;

public class GoodsTypeCode {

	//自动生成商品编码
	public static String getGoodsTypeCode(String maxTypeCode){
		
		Integer code=Integer.parseInt(maxTypeCode);
		code++;
		String newString=code.toString();
		StringBuffer sb=new StringBuffer();
		sb.append(newString);
		Integer num=maxTypeCode.length()-sb.toString().length();
		for(int i=0;i<num;i++){
			sb.insert(i, "0");
		}
		return sb.toString();
	}
	
	//处理小编码类型的名字
	public static GoodsType getGoodsMinTypeName(GoodsType goodsType){
		String name=goodsType.getName();
		System.out.println(name+"----------------------------------------");
		StringBuffer sBuff=new StringBuffer();
		sBuff.append(name);
		sBuff.insert(0, "----");
		goodsType.setName(sBuff.toString());
		System.out.println(sBuff.toString()+"+++++++++++++++++++++++++++++++++");
		return goodsType;
	}

	//传入文件返回文件名
	public static String uploadImg(MultipartFile file) {
		String imgName = file.getOriginalFilename();
		StringBuilder sb = new StringBuilder();
		if(imgName!=null&&!"".equals(imgName)){
			//生成新的名字
			// apple.jpg
			String[] strArray = imgName.split("\\.");
			//通过UUID生成唯一字符串
			UUID uid = UUID.randomUUID();
			sb.append(uid+"."+strArray[1]);
			//保存图片，File.separator为Windows的\为了兼容不同系统写成File.separator，兼容不同系统D也要修改
			String serverPath = "D:"+File.separator+"demo"+File.separator+"file";
			File targetFile = new File(serverPath,sb.toString());
			//转储图片
			try {
				file.transferTo(targetFile);
			} catch (IllegalStateException e) {
				System.out.println("图片保存失败");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("图片保存失败");
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	//通过轮播图的请求路径获取商品的ID
	public static Integer getGoodsIdByPicRequestUrl(String requestUrl){
		// /customer/detail.action?goods.id=11
		String[] str=requestUrl.split("=");
		String idStr=str[1];
		return Integer.parseInt(idStr);
	}
	
	//通过小类型的code获取大类型的code
	public static String getMaxCode(String minCode){
		return minCode.substring(0, 4);
	}
	
}
