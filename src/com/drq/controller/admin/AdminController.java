package com.drq.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drq.dto.PageBean;
import com.drq.dto.User;
import com.drq.service.impl.UserImpl;
import com.drq.service.interfaces.UserInter;
import com.drq.util.Constant;
import com.drq.util.MyUtil;
@RequestMapping("/admin")
@Controller
public class AdminController {

	@RequestMapping("/toLogin")
	public String toLogin(){
		return "admin/login";
	}
	
	@RequestMapping("/toIndex")
	public String toIndex(){
		return "admin/index";
	}
	
	@ResponseBody
	@RequestMapping("/loginToHome")
	public Map<String, String> loginToHome(@RequestParam("userId") String userId,@RequestParam("passWord") String passWord,@RequestParam("codeInput") String codeInput,@RequestParam("online") String online,HttpServletRequest request,HttpServletResponse response){
		Map<String, String> map=new HashMap<String, String>();
		UserInter u=new UserImpl();
		String auroNum=(String) request.getSession().getAttribute(Constant.AUTO_NUM);
		if(auroNum.equals(codeInput)){
			User userInfo=u.userLogin(userId,passWord);
		     if(userInfo!=null){
		    	 if(userInfo.getRole()==0){
		    		 map.put(Constant.FLAG, "fail");
						map.put(Constant.TIP, "你不是本站管理员");
						return map;	
		    	 }
				MyUtil.myCook(userId, passWord, online, request, response);
				request.getSession().setAttribute("userInfo", userInfo);
				
				map.put(Constant.FLAG, "success");
				return map;	
			}else{
				map.put(Constant.FLAG, "fail");
				map.put(Constant.TIP, "账户或密码错误");
				return map;
			}
		}else{
			map.put(Constant.FLAG, "codeFail");
			map.put(Constant.TIP, "验证码错误");
			return map;
		}
		
	}
	
/*	@RequestMapping("/register")
	public String  register(User user,ModelMap map) {
		UserInter u=new UserImpl();
		Integer count=u.addAdmin(user);
		map.put(Constant.TIP, count>0?"注册成功":"注册失败");
		return "forward:index";
	}*/
	
	@RequestMapping("/showUserList")
	public String showUserList(PageBean page,ModelMap map,@DateTimeFormat(pattern="yyyy-MM-dd") Date timeSelect,String userSelect){
		String time=null;
		UserInter u=new UserImpl();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		if(timeSelect!=null){
			time=format.format(timeSelect);
		}
		Integer recordCount=u.getRecordCountByPage(time,userSelect);
		
		page.setRecordCount(recordCount);
		List<User> userListByPage=u.showUserList(page,time,userSelect);
		map.put("time", time);
		map.put("userSelect", userSelect);
		map.put("userListByPage", userListByPage);
		map.put("pageModel", page);
		return "admin/list";
	}
	
	@RequestMapping("/toWelcome")
	public String toWelcome(){
		return "admin/welcome";
	}
	
	@RequestMapping("/*.html")
	public void toHtml(){
		
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
	
	@RequestMapping("/addAdmin")
	public String addAdmin(User user,ModelMap map){
		UserInter u=new UserImpl();
		Integer count=null;
		user.setPassWord("123456");
		count=u.addAdmin(user);
		map.put(Constant.TIP, count>0?"保存成功":"保存失败");
	    map.put(Constant.TIP, "用户名已存在");
		return "admin/add";
	}
	
	@ResponseBody
	@RequestMapping("/addAdminTest")
	public ModelMap addAdminTest(User user,ModelMap map){
		UserInter u=new UserImpl();
		Integer count=null;
		count=u.addAdmin(user);
		map.put(Constant.FLAG, count>0?"":"用户名已存在");
		return map;
	}
	
	@RequestMapping("/toUpDateUser")
	public String toUpDateUser(String id,ModelMap map){
		UserInter u=new UserImpl();
		User user=u.toUpDateUser(id);
		map.put("user", user);
		return "admin/update";
	}
	
	@RequestMapping("/upDateUser")
	public String upDateUser(User user,ModelMap map){
		UserInter u=new UserImpl();
		Integer count=u.upDateUser(user);
		map.put(Constant.TIP, count>0?"修改成功":"修改失败");
		return "forward:toUpDateUser";
	}
	
	//根据用户ID删除用户
	@RequestMapping("/deleteUserById")
	public String deleteUserById(Integer[] id){
		Map<String, String> map=new HashMap<String, String>();
		UserInter u=new UserImpl();
		Integer count=u.deleteUserById(id);
		map.put(Constant.FLAG,count>0?"success":"fail");
		return "forward:showUserList";
	}
	
	@RequestMapping("/outLogin")
	public String outLogin(HttpSession session){
		session.removeAttribute("userInfo");
		return "admin/login";
	}
	
	
	
}
