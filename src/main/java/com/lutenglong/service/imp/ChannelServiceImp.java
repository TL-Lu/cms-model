package com.lutenglong.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lutenglong.bean.Article;
import com.lutenglong.bean.Category;
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
		public List<Article> getArticles(String id) {
			// TODO Auto-generated method stub
			return channelMapper.getArticles(id);
		}

		@Override
		public List<Article> getArticleOfCategory(String id) {
			// TODO Auto-generated method stub
			return channelMapper.getArticleOfCategory(id);
		}

		@Override
		public List<Article> getArticleOfUser(String id) {
			// TODO Auto-generated method stub
			return channelMapper.getArticleOfUser(id);
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
}