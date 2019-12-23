package com.lutenglong.service.imp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lutenglong.bean.Article;
import com.lutenglong.bean.Category;
import com.lutenglong.bean.Comment;
import com.lutenglong.bean.Complain;
import com.lutenglong.bean.Picture;
import com.lutenglong.bean.User;
import com.lutenglong.mapper.ChannelMapper;
import com.lutenglong.service.ChannelService;

@Service
public class ChannelServiceImp implements ChannelService {
		@Autowired
		private ChannelMapper channelMapper;

		@Override
		public List<Category> getCategorys(String id) {
			// TODO Auto-generated method stub
			return channelMapper.getCategorys(id);
		}

		@Override
		public List<Article> getArticles(String status) {
			// TODO Auto-generated method stub
			return channelMapper.getArticles(status);
		}

		@Override
		public List<Article> getArticleOfCategory(String id) {
			// TODO Auto-generated method stub
			return channelMapper.getArticleOfCategory(id);
		}

		@Override
		public List<Article> getArticleOfUser(String id,String status) {
			// TODO Auto-generated method stub
			return channelMapper.getArticleOfUser(id,status);
		}

		@Override
		public User findUserOfHome(String id) {
			// TODO Auto-generated method stub
			return channelMapper.findUserOfHome(id);
		}

		@Override
		public boolean delArticle(String id) {
			try {
				channelMapper.delArticle(id);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
		}

		@Override
		public int add(Article article) {
			return channelMapper.add(article);
		}

		@Override
		public Article toUpdateArticle(String id) {
			// TODO Auto-generated method stub
			return channelMapper.toUpdateArticle(id);
		}

		@Override
		public int update(Article article) {
			return channelMapper.update(article);
		}

		@Override
		public List<Article> getArticles() {
			// TODO Auto-generated method stub
			return channelMapper.getAllArticles();
		}

		/**
		 * 鲁
		 */
		@Override
		public Article getArticle(String id) {
			// TODO Auto-generated method stub
			return channelMapper.getArticle(id);
		}

		
		@Override
		public boolean setStatus(String id,Integer status) {
			// TODO Auto-generated method stub
			 try {
				channelMapper.setStatus(id,status);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
				
			}
		}

		@Override
		public List<Article> getHotArticle(Integer currentPage) {
			// TODO Auto-generated method stub
			return channelMapper.getHotArticle();
		}

		@Override
		public boolean setHot(String id, String hot) {
			return channelMapper.setHot(id,hot);
		}

		@Override
		public List<Article> getArticleOfChannel(String id) {
			// TODO Auto-generated method stub
			return channelMapper.getArticleOfChannel(id);
		}

		@Override
		public List<Picture> findPicture() {
			// TODO Auto-generated method stub
			return channelMapper.findPicture();
		}

		@Override
		public List<Article> getNewArticle() {
			// TODO Auto-generated method stub
			return channelMapper.getNewArticle();
		}

		@Override
		public PageInfo<Comment> getComments(String id, Integer currentPage) {
			// TODO Auto-generated method stub
			PageHelper.startPage(currentPage,8);
			
			PageInfo<Comment> page = new PageInfo<Comment>(channelMapper.getComments(id));
			return page ;
		}

		@Override
		public boolean addComment(Comment comment) {
			try {
				channelMapper.addComment(comment);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public List<Article> findAllArticle(String status) {
			// TODO Auto-generated method stub
			return channelMapper.findAllArticle(status);
		}

		@Override
		public void addComplian(@Valid Complain complain) {
			
			//添加投诉到数据库
			int result = channelMapper.addCoplain(complain);
			// 增加投诉的数量
			if(result>0)
				channelMapper.increaseComplainCnt(complain.getArticleId());
			

		}
}