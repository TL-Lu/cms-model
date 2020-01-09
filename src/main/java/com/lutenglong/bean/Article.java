package com.lutenglong.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Article {

	private Integer id;
	private String title;
	private String content;
	private String picture;
	private int hits;	//受欢迎程度
	private int hot;   //是否热门;
	private int status;//是否审核
	private int deleted; //是否删除
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date created;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date update;
	private int  commentCnt;	//评论数量
	private int articleType;
	
	
	private User user;
	private Channel channel;
	private Category category;

	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(Integer id, String title, String content, String picture, int hits, int hot, int status, int deleted,
			Date created, Date update, int commentCnt, int articleType, User user, Channel channel, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.update = update;
		this.commentCnt = commentCnt;
		this.articleType = articleType;
		this.user = user;
		this.channel = channel;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", picture=" + picture + ", hits="
				+ hits + ", hot=" + hot + ", status=" + status + ", deleted=" + deleted + ", created=" + created
				+ ", update=" + update + ", commentCnt=" + commentCnt + ", articleType=" + articleType + ", user="
				+ user + ", channel=" + channel + ", category=" + category + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public int getArticleType() {
		return articleType;
	}
	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
