package com.lutenglong.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lutenglong.bean.Article;
import com.lutenglong.bean.Category;
import com.lutenglong.bean.Channel;
import com.lutenglong.bean.User;
import com.lutenglong.cms.util.FileUtil;
import com.lutenglong.commen.CmsContent;
import com.lutenglong.service.ChannelService;
import com.lutenglong.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Value("${upload.path}")
	String picRootPath;
	
	@Value("${pic.path}")
	String picUrl;
	
	@Autowired
	private UserService userService;
	@Autowired
	private ChannelService channelService;
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping("toLogin.do")
	public String toLogin(Model m ) {
		m.addAttribute("user", new User());
		return "user/login";
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping("toRegist.do")
	public String toRegist(Model m ) { 
		m.addAttribute("user", new User());
		return "user/regist";
	}
	
	
	/**
	 * 注册
	 * @param m
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping("regist.do")
	public String regist(Model m,@Valid @ModelAttribute("user")User user,BindingResult result) {
		if (result.hasErrors()) {
			return "user/regist";
		}
		userService.add(user);
		return "redirect:toLogin.do";
	}
	
	/**
	 * 根据用户名获取User
	 * @param m
	 * @param userName
	 * @return
	 */
	@RequestMapping("getAUser.do")
	public String getAUser(Model m,String userName) {
			User checkName = userService.checkName(userName);
			m.addAttribute("user", checkName);
		return "user/userHome";
	}
	
	
	@RequestMapping("logout.do")
	public String logout(Model m,HttpServletRequest request) {
		request.getSession().removeAttribute(CmsContent.User_Key);
		return "redirect:/channel/goHome.do";
	}
	

	/**
	 * 登录 判断是否用户或者管理员
	 * @param m
	 * @param user
	 * @param request
	 * @return
	 */
	
	@RequestMapping("login.do")
	public String login(Model m,User user,HttpServletRequest request,HttpServletResponse response) {
		String pwd1= user.getPassWord();
		User user2 = userService.findAUser(user);
		request.getSession().setAttribute(CmsContent.User_Key,user2);
		if(user2!=null) {
			if(user2.getRole()==0) {
				List<Channel> list = userService.getChannels();
				m.addAttribute("user", user2);
				m.addAttribute("list", list);
				
				Cookie userName = new Cookie("userName", user.getUserName());
				userName.setMaxAge(600);
				userName.setPath("/");
				response.addCookie(userName);
				
			
				Cookie pwd = new Cookie("pwd", pwd1);
				pwd.setMaxAge(600);
				pwd.setPath("/");
				response.addCookie(pwd);
				
				return "redirect:/channel/goHome.do?id="+user2.getId();
			}else {
				List<Channel> list = userService.getChannels();
				m.addAttribute("user", user2);
				m.addAttribute("list", list);
				return "redirect:/channel/goHome.do?id="+user2.getId();
			}
		}else {
			m.addAttribute("err", "账号或密码错误");
			return "user/login";
		}
	}
	
	/**
	 * 
	 * @param m
	 * @param id
	 * @return
	 */
	@RequestMapping("goRootHome.do")
	public String goRootHome(Model m,String id) {
		User user = channelService.findUserOfHome(id);
		List<Channel> list = userService.getChannels();
		m.addAttribute("user", user);
		m.addAttribute("list", list);
		if(user.getRole()==1) {
			return "root/rootHome";
		}
		return "redirect:/channel/goHome.do?id="+user.getId();
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
	
	
	
	
	@RequestMapping(value = "postArticle.do",method=RequestMethod.POST)
	@ResponseBody
	public boolean postArticle(HttpServletRequest request, Article article, MultipartFile file) {
		String picUrl;
		try {
			// 处理上传文件
			picUrl = processFile(file);
			article.setPicture(picUrl);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//当前用户是文章的作者
		User loginUser = (User)request.getSession().getAttribute(CmsContent.User_Key);
		article.setUser(loginUser);
		
		
		return channelService.add(article)>0;
	}
	
	@RequestMapping(value = "updateArticle.do",method=RequestMethod.POST)
	@ResponseBody
	public boolean updateArticle(HttpServletRequest request, Article article, MultipartFile file) {
		
		String picUrl;
		String originalFilename = file.getOriginalFilename();
			try {
				// 处理上传文件
				if(file.getOriginalFilename()==null||"".equals(file.getOriginalFilename())) {
					article.setPicture(ChannelController.picture);
				}else {
					picUrl = processFile(file);
					article.setPicture(picUrl);
				}
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		//当前用户是文章的作者
		User loginUser = (User)request.getSession().getAttribute(CmsContent.User_Key);
		article.setUser(loginUser);
		
		
		return channelService.update(article)>0;
	}
	
	
	private String processFile(MultipartFile file) throws IllegalStateException, IOException {
	
			// 判断目标目录时间否存在
			//picRootPath + ""
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String subPath = sdf.format(new Date());
			//图片存放的路径
			File path= new File(picRootPath+"/" + subPath);
			//路径不存在则创建
			if(!path.exists())
				path.mkdirs();
			
			//计算新的文件名称
			String suffixName = FileUtil.getSuffixName(file.getOriginalFilename());
			
			//随机生成文件名
			String fileName = UUID.randomUUID().toString() + suffixName;
			//文件另存
			file.transferTo(new File(picRootPath+"/" + subPath + "/" + fileName));
			return  subPath + "/" + fileName;
	
	}
	
	
}
