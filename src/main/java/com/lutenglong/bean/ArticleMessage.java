package com.lutenglong.bean;

import java.io.Serializable;

public class ArticleMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7635395769750770724L;
	
	
	private int core;
	private String message;
	private Object	article;
	public ArticleMessage(int core, String message, Object article) {
		super();
		this.core = core;
		this.message = message;
		this.article = article;
	}
	public ArticleMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ArticleMessage [core=" + core + ", message=" + message + ", article=" + article + "]";
	}
	public int getCore() {
		return core;
	}
	public void setCore(int core) {
		this.core = core;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getArticle() {
		return article;
	}
	public void setArticle(Object article) {
		this.article = article;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + core;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleMessage other = (ArticleMessage) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (core != other.core)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
	
	
}
