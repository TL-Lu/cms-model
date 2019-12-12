package com.lutenglong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.lutenglong.bean.Article;
import com.lutenglong.bean.Category;
import com.lutenglong.bean.Channel;
import com.lutenglong.bean.User;

public interface ChannelMapper {

	@Select("select id,name,channel_id channelId from cms_category where channel_id=#{id}")
	List<Category> getCategorys(String id);

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	@Select("SELECT * FROM cms_article WHERE category_id IN(SELECT id FROM cms_category WHERE channel_id =#{id})")
	List<Article> getArticles(String id);

	@Select("select username userName from cms_user where id=#{id}")
	User findAUser(int id);
	
	@Select("select * from cms_channel where id=#{id}")
	Channel findAChannel(int id);
	
	@Select("select * from cms_category where id=#{id}")
	Category findACategory(int id);

	@Select("	SELECT * FROM cms_article WHERE category_id=#{id}")
	List<Article> getArticleOfCategory(String id);

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	@Select("SELECT * FROM cms_article WHERE user_id=#{id}")
	List<Article> getArticleOfUser(String id);

	@Select("select username from cms_user where id=${value}")
	User findUserOfHome(String id);
}
