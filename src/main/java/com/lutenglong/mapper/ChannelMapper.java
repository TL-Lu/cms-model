package com.lutenglong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	@Select("SELECT * FROM cms_article WHERE user_id=#{id} and deleted ='0' ")
	List<Article> getArticleOfUser(String id);

	@Select("select username from cms_user where id=${value}")
	User findUserOfHome(String id);

	@Delete("update cms_article set deleted='1' where id=#{id}")
	void delArticle(String id);

	@Insert("INSERT INTO cms_article(title,content,picture,channel_id,category_id,user_id,hits,hot,status,deleted,created,updated,commentCnt,articleType)"
			+ " VALUES(#{title},#{content},#{picture},#{channel.id},#{category.id},#{user.id},0,0,0,0,now(),now(),0,#{articleType})")
	int add(Article article);

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	@Select("SELECT * FROM cms_article WHERE id =#{id}")
	Article toUpdateArticle(String id);

	@Update("update cms_article set title=#{title},content=#{content},picture=#{picture},channel_id=#{channel.id},"
			+ "category_id=#{category.id},user_id=#{user.id},updated=now() where id=#{id}")
	int update(Article article);
}
