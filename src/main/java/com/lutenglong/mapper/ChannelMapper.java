package com.lutenglong.mapper;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lutenglong.bean.Article;
import com.lutenglong.bean.Category;
import com.lutenglong.bean.Channel;
import com.lutenglong.bean.Comment;
import com.lutenglong.bean.Complain;
import com.lutenglong.bean.Picture;
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
	@Select("SELECT * FROM cms_article WHERE category_id IN(SELECT id FROM cms_category WHERE channel_id =#{id}) ORDER BY hits DESC ")
	List<Article> getArticles(String id);

	@Select("select username userName,url from cms_user where id=#{id}")
	User findAUser(int id);
	
	@Select("select * from cms_channel where id=#{id}")
	Channel findAChannel(int id);
	
	@Select("select * from cms_category where id=#{id}")
	Category findACategory(int id);

	@Select("	SELECT * FROM cms_article WHERE category_id=#{id} and deleted='0' ORDER BY hits DESC ")
	List<Article> getArticleOfCategory(String id);

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	@Select("<script>SELECT * FROM cms_article WHERE user_id=#{id} and deleted ='0'  "
			+ "<if test=\"status!=null and status!='' and status!=-1\">and status=#{status}</if>"
			+ "ORDER BY hits DESC"
			+ "</script>")
	List<Article> getArticleOfUser(@Param("id")String id,@Param("status")String status);

	@Select("select  id,username,password passWord,nickname nickName,birthday,CONCAT(gender),locked,create_time createTime,update_time updateTime,url,score,role from cms_user where id=${value}")
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

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	@Select("SELECT * FROM cms_article where deleted ='0' ORDER BY hits DESC ")
	List<Article> getAllArticles();
	
	
	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	
	
	@Select("SELECT * FROM cms_article WHERE id =#{id}")
	Article getArticle(String id);

	@Update("update cms_article set status=#{status} where id=#{id}")
	boolean setStatus(@Param("id")String id, @Param("status")Integer status);

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	@Select("select * from cms_article where hot ='1' ORDER BY hits DESC ")
	List<Article> getHotArticle();

	@Update("update cms_article set hot =#{hot} where id=#{id}")
	boolean setHot(@Param("id")String id,@Param("hot") String hot);

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	@Select("SELECT * FROM cms_article where deleted ='0' and channel_id=#{id} ORDER BY hits DESC ")
	List<Article> getArticleOfChannel(String id);

	@Select("SELECT * FROM cms_slide")
	List<Picture> findPicture();

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	@Select("SELECT * FROM cms_article ORDER BY created DESC LIMIT 5")
	List<Article> getNewArticle();

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "user",column = "userId",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser")),
		@Result(property = "article",column = "articleId",one =@One(select = "com.lutenglong.mapper.ChannelMapper.getArticle"))
		
 	})
	@Select("SELECT * FROM cms_comment WHERE articleId = #{id} order by created desc")
	List<Comment> getComments(String id);

	@Insert("INSERT INTO cms_comment VALUES(NULL,#{article.id},#{user.id},#{content},now())")
	boolean addComment(Comment comment);

	@Results({
		@Result(id = true,column = "id",property = "id"),
		@Result(property = "category",column = "category_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findACategory")),
		@Result(property = "channel",column = "channel_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAChannel")),
		@Result(property = "user",column = "user_id",one =@One(select = "com.lutenglong.mapper.ChannelMapper.findAUser"))
	})
	@Select("<script>SELECT * FROM cms_article WHERE 1=1"
			+ "<if test=\"status!=null and status!='' and status!=-1\"> and status=#{status}</if>"
			+ "ORDER BY hits DESC"
			+ "</script>")
	List<Article> findAllArticle(@Param("status")String status);

	@Insert("INSERT INTO cms_complain(article_id,user_id,complain_type,"
			+ "compain_option,src_url,picture,content,email,mobile,created)"
			+ "   VALUES(#{articleId},#{userId},"
			+ "#{complainType},#{compainOption},#{srcUrl},#{picture},#{content},#{email},#{mobile},now())")
	int addCoplain(@Valid Complain complain);

	@Update("UPDATE cms_article SET complainCnt=complainCnt+1,status=if(complainCnt>10,2,status)  "
			+ " WHERE id=#{value}")
	void increaseComplainCnt(Integer articleId);
}
