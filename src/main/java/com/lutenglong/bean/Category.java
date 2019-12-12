package com.lutenglong.bean;

public class Category {
		private Integer id;
		private String name;
		private int channelId;
		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Category(Integer id, String name, int channelId) {
			super();
			this.id = id;
			this.name = name;
			this.channelId = channelId;
		}
		@Override
		public String toString() {
			return "Categoty [id=" + id + ", name=" + name + ", channelId=" + channelId + "]";
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
		public int getChannelId() {
			return channelId;
		}
		public void setChannelId(int channelId) {
			this.channelId = channelId;
		}
		
}
