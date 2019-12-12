package com.lutenglong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lutenglong.bean.Category;
import com.lutenglong.bean.Channel;
import com.lutenglong.bean.User;
import com.lutenglong.commen.CmsContent;
import com.lutenglong.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("toLogin.do")
	public String toLogin(Model m ) {
		m.addAttribute("user", new User());
		return "user/login";
	}
	@RequestMapping("toRegist.do")
	public String toRegist(Model m ) { 
		m.addAttribute("user", new User());
		return "user/regist";
	}
	
	@RequestMapping("regist.do")
	public String regist(Model m,@Valid @ModelAttribute("user")User user,BindingResult result) {
		if (result.hasErrors()) {
			return "user/regist";
		}
		userService.add(user);
		return "redirect:toLogin.do";
	}
	
	@RequestMapping("getAUser.do")
	public String getAUser(Model m,String userName) {
			User checkName = userService.checkName(userName);
			m.addAttribute("user", checkName);
		return "user/userHome";
	}
	
	

	
	
	@RequestMapping("login.do")
	public String login(Model m,User user,HttpServletRequest request) {
		User user2 = userService.findAUser(user);
		if(user2!=null) {
			request.getSession().setAttribute("user_key",CmsContent.User_Key);
			if(user2.getRole()==0) {
				List<Channel> list = userService.getChannels();
				m.addAttribute("user", user2);
				m.addAttribute("list", list);
				return "user/userList";
			}else {
				return "user/rootList";
			}
		}else {
			m.addAttribute("err", "账号或密码错误");
			return "user/login";
		}
	}
	
	
	@RequestMapping("checkName.do")
	@ResponseBody
	public boolean checkName(Model m,String userName) {
		User user = userService.checkName(userName);
		if(user!=null) {
			return false;
		}
		return true;
	}
}
