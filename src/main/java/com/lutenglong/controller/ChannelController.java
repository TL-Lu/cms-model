package com.lutenglong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lutenglong.bean.Article;
import com.lutenglong.bean.Category;
import com.lutenglong.bean.Channel;
import com.lutenglong.bean.User;
import com.lutenglong.commen.CmsContent;
import com.lutenglong.service.ChannelService;
import com.lutenglong.service.UserService;

@Controller
@RequestMapping("channel")
public class ChannelController {
	
	@Value("${upload.path}")
	String picRoot;
	
	@Value("${pic.path}")
	String picUrl;
	
	
	@Autowired
	ChannelService channelService;
	@Autowired
	UserService userService;
	
	public static String picture;
	
	@ResponseBody
	@RequestMapping("category.do")
	public Object category(Model m,String id) {
		List<Category> categorys = channelService.getCategorys(id);
		return categorys;
	}

	
	@RequestMapping("getAllArticle.do")
	public Object getAllArticle(Model m,String id) {
		PageHelper.startPage(1,10);
		List<Article> articles = channelService.getArticles(id);
		m.addAttribute("articles", articles);
		return "user/list";
	}
	
	@RequestMapping("getArticleOfCategory.do")
	public Object getArticleOfCategory(Model m,String id) {
		PageHelper.startPage(1,10);
		List<Article> articles = channelService.getArticleOfCategory(id);
		m.addAttribute("articles", articles);
		return "user/list";
	}
	
	@RequestMapping("getArticleOfUser.do")
	public Object getArticleOfUser(Model m,String id,@RequestParam(defaultValue = "1")Integer currentPage) {
		PageHelper.startPage(currentPage,8);
		List<Article> articles = channelService.getArticleOfUser(id);
		PageInfo<Article> page = new PageInfo<Article>(articles);
		m.addAttribute("page", page);
		m.addAttribute("articles", articles);
		m.addAttribute("userId", id);
		
		return "user/article/myList";
	}
	
	@RequestMapping("goHome.do")
	public Object goHome(Model m,String id) {
		List<Channel> list = userService.getChannels();
		User user =channelService.findUserOfHome(id);
		m.addAttribute("user", user);
		m.addAttribute("list", list);
		return "user/userList";
	}
	@RequestMapping("toAddArticle.do")
	public Object toAddArticle(Model m) {
		List<Channel> list = userService.getChannels();
		m.addAttribute("list", list);
		return "user/article/addArticle";
	}
	
	@RequestMapping("toUpdateArticle.do")
	public Object toUpdateArticle(Model m,String id,HttpServletRequest request) {
		User loginUser = (User) request.getSession().getAttribute(CmsContent.User_Key);
		
		Article article= channelService.toUpdateArticle(id);
		picture=article.getPicture();
		if(loginUser.getId()!=article.getUser().getId()) {
			
		}
		List<Channel> list = userService.getChannels();
		m.addAttribute("article", article);
		m.addAttribute("list", list);
		m.addAttribute("picture", picUrl+article.getPicture());
		return "user/article/updateArticle";
	}
	
	@ResponseBody
	@RequestMapping("delArticle.do")
	public Object delArticle(Model m,String id) {
			boolean flag=channelService.delArticle(id);
		return flag;
	}
}
