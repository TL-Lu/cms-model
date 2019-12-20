package com.lutenglong.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.lutenglong.bean.User;
import com.lutenglong.commen.CmsContent;

public class UserInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		
		User user =(User) request.getSession().getAttribute(CmsContent.User_Key);
		System.out.println(user);
		if(user!=null) {
			return true;
		}else {
			response.sendRedirect("/user/toLogin.do");
			return false;
		}
	}
}
