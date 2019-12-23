package com.lutenglong.service;

import java.util.List;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.lutenglong.bean.Article;
import com.lutenglong.bean.Category;
import com.lutenglong.bean.Comment;
import com.lutenglong.bean.Complain;
import com.lutenglong.bean.Picture;
import com.lutenglong.bean.User;

public interface ChannelService {

	List<Category> getCategorys(String id);

	List<Article> getArticles(String status);

	List<Article> getArticleOfCategory(String id);

	List<Article> getArticleOfUser(String id,String status);

	User findUserOfHome(String id);

	boolean delArticle(String id);

	int add(Article article);

	Article toUpdateArticle(String id);

	int update(Article article);

	List<Article> getArticles();

	Article getArticle(String id);

	boolean setStatus(String id,Integer status);

	List<Article> getHotArticle(Integer currentPage);

	boolean setHot(String id, String hot);

	List<Article> getArticleOfChannel(String id);

	List<Picture> findPicture();

	List<Article> getNewArticle();

	PageInfo<Comment> getComments(String id, Integer currentPage);

	boolean addComment(Comment comment);

	List<Article> findAllArticle(String status);

	void addComplian(@Valid Complain complain);
}
