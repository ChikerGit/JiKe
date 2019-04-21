package com.drq.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Code {

	static Random random = new Random();
	//生产4个随机数
	public static String getRandomNum(){
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<4;i++){
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	
	//2.创建图片
	public static BufferedImage getImage(String code){
		//1.创建画布
		BufferedImage img = new BufferedImage(88, 28, BufferedImage.TYPE_INT_RGB);
		//2.创建画笔
		Graphics grap =  img.getGraphics();
		//---3.1)设置背景
		grap.setColor(Color.white);
		//---3.2)绘制矩形
		grap.fillRect(0, 0, 88, 58);
		
		
		//---3.3)设置字体
		grap.setFont(new Font("宋体", Font.PLAIN, 28));
		//---3.4)设置字体颜色
		grap.setColor(Color.black);
		
		//4.根据字符串绘制验证码
		for(int i=0;i<code.length();i++){
			char c = code.charAt(i);
			grap.drawString(c+"",20*i+5 , 24);
		}
		
		//5.干扰线
		for(int i=0;i<5;i++){
			int x1 = random.nextInt(88);
			int y1 = random.nextInt(28);
			int x2 = random.nextInt(88);
			int y2 = random.nextInt(28);
			grap.drawLine(x1, y1, x2, y2);
		}
		
		return img;
	}
	
}
