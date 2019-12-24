package com.lutenglong.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lutenglong.bean.User;
import com.lutenglong.commen.CmsContent;
import com.lutenglong.service.UserService;

public class UserInterceptor implements HandlerInterceptor {
	
	@Autowired
	UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {

		User user =(User) request.getSession().getAttribute(CmsContent.User_Key);
		if(user!=null) {
			return true;
		}else {
			User user2 = new User();
			
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("userName")) {
					user2.setUserName(cookie.getValue());
				}
				if(cookie.getName().equals("pwd")) {
					user2.setPassWord(cookie.getValue());
				}
			}
			
			if(null==user2.getUserName() || null== user2.getPassWord()) {
				/* response.sendRedirect("/user/toLogin.do"); */
				//request.getRequestDispatcher("/user/login").forward(request, response);
				return true;
			}
			
			User findAUser = userService.findAUser(user2);
			if(findAUser!=null) {
				request.setAttribute("user", findAUser);
				return true;
			}
			
			/* response.sendRedirect("/user/toLogin.do"); */
			return true;
		}
	}
}
