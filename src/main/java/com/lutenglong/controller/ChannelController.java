package com.lutenglong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lutenglong.bean.Article;
import com.lutenglong.bean.ArticleMessage;
import com.lutenglong.bean.Category;
import com.lutenglong.bean.Channel;
import com.lutenglong.bean.Comment;
import com.lutenglong.bean.Complain;
import com.lutenglong.bean.Picture;
import com.lutenglong.bean.User;
import com.lutenglong.cms.util.StringUtil;
import com.lutenglong.commen.CmsContent;
import com.lutenglong.commen.MessageCommen;
import com.lutenglong.service.ChannelService;
import com.lutenglong.service.UserService;

@Controller
@RequestMapping("channel")
public class ChannelController  extends BaseController{
	
	@Value("${upload.path}")
	String picRoot;
	
	@Value("${pic.path}")
	String picUrl;
	
	
	@Autowired
	ChannelService channelService;
	@Autowired
	UserService userService;
	@Autowired
	RedisTemplate template;
	
	
	public static String picture;
	
	/**
	 *		返回某个栏目的分类
	 *
	 * @param m
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("category.do")
	public Object category(Model m,String id) {
		List<Category> categorys = channelService.getCategorys(id);
		return categorys;
	}

	
	/**
	 * 		获取栏目下的所有文章
	 * @param m
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("getAllArticle.do")
	public Object getAllArticle(Model m,String id,@RequestParam(defaultValue = "1")Integer currentPage) {
		PageHelper.startPage(currentPage,6);
		List<Article> articles = channelService.getArticles(id);
		PageInfo<Article> page = new PageInfo<Article>(articles);
		m.addAttribute("page", page);
		m.addAttribute("articles", articles);
		return "user/allList";
	}
	
	/**
	 * 
	 * 获取分类下的所有文章
	 * @param m
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("getArticleOfCategory.do")
	public Object getArticleOfCategory(Model m,String id,@RequestParam(defaultValue = "1")Integer currentPage) {
		PageHelper.startPage(currentPage,6);
		List<Article> articles = channelService.getArticleOfCategory(id);
		PageInfo<Article> page = new PageInfo<Article>(articles);
		m.addAttribute("page", page);
		m.addAttribute("articles", articles);
		return "user/list";
	}
	
	/**
	 * 根据栏目获取文章
	 * @param m
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("getArticleOfChannel.do")
	public Object getArticleOfChannel(Model m,String id,@RequestParam(defaultValue = "1")Integer currentPage) {
		PageHelper.startPage(currentPage,6);
		List<Article> articles = channelService.getArticleOfChannel(id);
		PageInfo<Article> page = new PageInfo<Article>(articles);
		m.addAttribute("page", page);
		m.addAttribute("articles", articles);
		return "user/article/allList";
	}
	
	/**
	 *  获取用户发布的文章
	 * @param m
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("getArticleOfUser.do")
	public Object getArticleOfUser(Model m,String id,@RequestParam(defaultValue = "1")Integer currentPage,String status) {
		PageHelper.startPage(currentPage,8);
		List<Article> articles = channelService.getArticleOfUser(id,status);
		PageInfo<Article> page = new PageInfo<Article>(articles);
		m.addAttribute("page", page);
		m.addAttribute("articles", articles);
		m.addAttribute("userId", id);
		m.addAttribute("status", status);
		
		return "user/article/myList";
	}
	
	/**
	 * 跳转到主页
	 * @param m
	 * @param id
	 * @return
	 */
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
	
	/**
	 * 添加文章
	 * @param m
	 * @return
	 */
	@RequestMapping("toAddArticle.do")
	public Object toAddArticle(Model m) {
		List<Channel> list = userService.getChannels();
		m.addAttribute("list", list);
		return "user/article/addArticle";
	}
	
	/**
	 * 跳转到修改文章界面
	 * @param m
	 * @param id
	 * @param request
	 * @return
	 */
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
	
	
	/**
	 *  删除文章
	 * @param m
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delArticle.do")
	public Object delArticle(Model m,String id) {
			boolean flag=channelService.delArticle(id);
		return flag;
	}
	
	
	
	/**
	 * 查询所有文章
	 * @param m
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("findAllArticle.do")
	public Object findAllArticle(Model m,@RequestParam(defaultValue = "1")Integer currentPage,String status) {
		PageHelper.startPage(currentPage,8);
		List<Article> articles = channelService.findAllArticle(status);
		PageInfo<Article> page = new PageInfo<Article>(articles);//
		m.addAttribute("articles", articles);
		m.addAttribute("page", page);
		m.addAttribute("status", status);
		return "root/article/myList";
	}
	
	
	
	/**
	 *  根据主键获取一篇文章
	 * @param m
	 * @param id
	 * @return
	 */
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
	
	
	
	/**
	 * 设置审核状态
	 * @param m
	 * @param id
	 * @param status
	 * @return
	 */
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
	
	/**
	 * 设置是否热门
	 * @param m
	 * @param id
	 * @param hot
	 * @return
	 */
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
	
	
	
	/**
	 * 获取热门文章
	 * @param m
	 * @param currentPage
	 * @return
	 */
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
	
	
	
	/**
	 * 获取评论
	 * @param m
	 * @param currentPage
	 * @param id
	 * @return
	 */
	@RequestMapping("comments.do")
	public Object comments(Model m,@RequestParam(defaultValue = "1")Integer currentPage,String id) {
		PageInfo<Comment> commentPage =  channelService.getComments(id,currentPage);
		m.addAttribute("commentPage", commentPage);
		return "user/article/comments";
	}
	
	/**
	 * 
	 * 文章详情
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
	
	
	
	/**
	 * 添加评论
	 * @param m
	 * @param articleId
	 * @param content
	 * @param request
	 * @return
	 */
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
	
	
	
	@RequestMapping("complain.do")
	public Object complain(Model m,String id) {
		Article article = channelService.getArticle(id);
		System.out.println(id);
		m.addAttribute("article", article);
		m.addAttribute("complain", new Complain());
		return "user/article/complain";
	}
	
	
	@RequestMapping(value="addComplain.do",method=RequestMethod.POST)
	public String addComplain(HttpServletRequest request,@ModelAttribute("complain") @Valid Complain complain,MultipartFile file,BindingResult result) throws IllegalStateException, IOException {
			System.out.println(1123213);
		if(!StringUtil.isHttpUrl(complain.getSrcUrl())) {
			result.rejectValue("srcUrl", "", "不是合法的url地址");
			System.out.println(2);
		}

		if(result.hasErrors()) {
			System.out.println(3);
			return "user/article/complain";
		}

		User loginUser  =  (User)request.getSession().getAttribute(CmsContent.User_Key);

		String picUrl = this.processFile(file);
		complain.setPicture(picUrl);

		//投诉人

		if(loginUser!=null) {
			complain.setUserId(loginUser.getId());
		}else {
			complain.setUserId(0);
		}
			
			
		
		channelService.addComplian(complain);
		return "redirect:/channel/details.do?id="+complain.getArticleId();

				

	}
}
 