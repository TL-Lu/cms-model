package com.lutenglong.service;

import java.util.List;

import com.lutenglong.bean.Article;
import com.lutenglong.bean.Category;
import com.lutenglong.bean.User;

public interface ChannelService {

	List<Category> getCategorys(String id);

	List<Article> getArticles(String id);

	List<Article> getArticleOfCategory(String id);

	List<Article> getArticleOfUser(String id);

	User findUserOfHome(String id);

	boolean delArticle(String id);

	int add(Article article);

	Article toUpdateArticle(String id);

	int update(Article article);
	
}
