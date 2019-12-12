package com.lutenglong.bean;

public class Channel {
	private Integer id;
	private String name;
	private String description;
	private String icon;
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Channel(Integer id, String name, String description, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", description=" + description + ", icon=" + icon + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
