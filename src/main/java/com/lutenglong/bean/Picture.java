package com.lutenglong.bean;

public class Picture {
	private Integer id;
	private String title;
	private String picture;
	private String url;
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Picture(Integer id, String title, String picture, String url) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.url = url;
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", title=" + title + ", picture=" + picture + ", url=" + url + "]";
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
