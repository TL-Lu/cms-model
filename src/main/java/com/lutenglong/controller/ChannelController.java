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
import com.lutenglong.bean.ArticleMessage;
import com.lutenglong.bean.Category;
import com.lutenglong.bean.Channel;
import com.lutenglong.bean.Comment;
import com.lutenglong.bean.Picture;
import com.lutenglong.bean.User;
import com.lutenglong.commen.CmsContent;
import com.lutenglong.commen.MessageCommen;
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
	public Object getAllArticle(Model m,String id,@RequestParam(defaultValue = "1")Integer currentPage) {
		PageHelper.startPage(currentPage,6);
		List<Article> articles = channelService.getArticles(id);
		PageInfo<Article> page = new PageInfo<Article>(articles);
		m.addAttribute("page", page);
		m.addAttribute("articles", articles);
		return "user/allList";
	}
	
	@RequestMapping("getArticleOfCategory.do")
	public Object getArticleOfCategory(Model m,String id,@RequestParam(defaultValue = "1")Integer currentPage) {
		PageHelper.startPage(currentPage,6);
		List<Article> articles = channelService.getArticleOfCategory(id);
		PageInfo<Article> page = new PageInfo<Article>(articles);
		m.addAttribute("page", page);
		m.addAttribute("articles", articles);
		return "user/list";
	}
	@RequestMapping("getArticleOfChannel.do")
	public Object getArticleOfChannel(Model m,String id,@RequestParam(defaultValue = "1")Integer currentPage) {
		PageHelper.startPage(currentPage,6);
		List<Article> articles = channelService.getArticleOfChannel(id);
		PageInfo<Article> page = new PageInfo<Article>(articles);
		m.addAttribute("page", page);
		m.addAttribute("articles", articles);
		return "user/article/allList";
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
		if(id!=null&&!"".equals(id)) {
			User user =channelService.findUserOfHome(id);
			m.addAttribute("user", user);
		}
		List<Article> articles=channelService.getNewArticle();
		
		m.addAttribute("newArticles", articles);
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
	
	@RequestMapping("findAllArticle.do")
	public Object findAllArticle(Model m,@RequestParam(defaultValue = "1")Integer currentPage) {
		PageHelper.startPage(currentPage,8);
		List<Article> articles = channelService.getArticles();
		PageInfo<Article> page = new PageInfo<Article>(articles);
		m.addAttribute("articles", articles);
		m.addAttribute("page", page);
		return "root/article/myList";
	}
	
	@ResponseBody
	@RequestMapping("getArticle.do")
	public Object getArticle(Model m,String id) {
			Article article = channelService.getArticle(id);
			if(article!=null) {
				if(article.getChannel()==null) {
					Channel c=new Channel();
					c.setName("未选择");
					article.setChannel(c);
				}
				if(article.getCategory()==null) {
					Category c = new Category();
					c.setName("未选择");
					article.setCategory(c);
				}
				if(article.getUser()==null) {
					User user = new User();
					user.setUserName("匿名");
					article.setUser(user);
				}
				return new ArticleMessage(MessageCommen.Y,"正确",article);
			}
					
			return new ArticleMessage(MessageCommen.N,"文章不存在",null);
	}
	
	@ResponseBody
	@RequestMapping("setStatus.do")
	public Object setStatus(Model m,String id,Integer status) {
		Article article = channelService.getArticle(id);
		if(status==article.getStatus()) {
			return new ArticleMessage(MessageCommen.Q, "无需修改", null);
		}
		 try {
			channelService.setStatus(id,status);
			return new ArticleMessage(MessageCommen.Y, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return  new ArticleMessage(MessageCommen.N, "操作失败", null);
		}
		
	}
	@ResponseBody
	@RequestMapping("setHot.do")
	public Object setHot(Model m,String id,String hot) {
		Article article = channelService.getArticle(id);
		if(Integer.valueOf(hot)==article.getHot()) {
			return new ArticleMessage(MessageCommen.Q, "无需修改", null);
		}
		 try {
			channelService.setHot(id,hot);
			return new ArticleMessage(MessageCommen.Y, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return  new ArticleMessage(MessageCommen.N, "操作失败", null);
		}
	}
	@RequestMapping("getHotArticle.do")
	public String getHotArticle(Model m,@RequestParam(defaultValue = "1")Integer currentPage) {
		PageHelper.startPage(currentPage,4);
		List<Article> list = channelService.getHotArticle(currentPage);
		PageInfo<Article> page = new PageInfo<Article>(list);
		List<Picture> picture = channelService.findPicture();
		m.addAttribute("picture", picture);
		m.addAttribute("page", page);
		m.addAttribute("articles", list);
		return "user/article/hotList";
	}
	
	@RequestMapping("comments.do")
	public Object comments(Model m,@RequestParam(defaultValue = "1")Integer currentPage,String id) {
		PageInfo<Comment> commentPage =  channelService.getComments(id,currentPage);
		m.addAttribute("commentPage", commentPage);
		return "user/article/comments";
	}
	
	/**
	 * @param m
	 * @param id
	 * @return
	 */
	@RequestMapping("details.do")
	public Object details(Model m,String id,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(CmsContent.User_Key);
		Article article = channelService.getArticle(id);
		m.addAttribute("article", article);
		m.addAttribute("user", user);
		return "user/article/details";
	}
	
	
	@ResponseBody
	@RequestMapping("addComment.do")
	public Object addComment(Model m,Integer articleId,String content,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(CmsContent.User_Key);
		Article article = new Article();
		article.setId(articleId);
		
		Comment comment = new Comment();
		
		comment.setUser(user);
		comment.setArticle(article);
		comment.setContent(content);
		
		boolean flag = channelService.addComment(comment);
		
		if(flag==true) {
			return new ArticleMessage(MessageCommen.Y, "", comment);
		}
		return new ArticleMessage(MessageCommen.N, "评论失败", null);
	}
}
 