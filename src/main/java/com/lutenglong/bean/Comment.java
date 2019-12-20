package com.lutenglong.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Comment {
	private Integer id;
	private Article article;
	private User user;
	private String content;
	
	@DateTimeFormat(pattern = "yyyy-DD-mm hh:mm:ss")
	private Date created;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Integer id, Article article, User user, String content, Date created) {
		super();
		this.id = id;
		this.article = article;
		this.user = user;
		this.content = content;
		this.created = created;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", article=" + article + ", user=" + user + ", content=" + content + ", created="
				+ created + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
