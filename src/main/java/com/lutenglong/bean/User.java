package com.lutenglong.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.lutenglong.commen.Gender;

public class User implements Serializable {
		/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
		private Integer id;
		@NotBlank
		private String userName;
		@NotBlank
		private String passWord;
		private	String nickName;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date birthday;
		
		private Gender gender;
		private int loced;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
		private Date createTime;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
		private Date updateTime;
		
		private String url;
		private int score;
		private int role;
		
		
		
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(Integer id, String userName, String passWord, String nickName, Date birthday, Gender gender,
				int loced, Date createTime, Date updateTime, String url, int score, int role) {
			super();
			this.id = id;
			this.userName = userName;
			this.passWord = passWord;
			this.nickName = nickName;
			this.birthday = birthday;
			this.gender = gender;
			this.loced = loced;
			this.createTime = createTime;
			this.updateTime = updateTime;
			this.url = url;
			this.score = score;
			this.role = role;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", nickName=" + nickName
					+ ", birthday=" + birthday + ", gender=" + gender + ", loced=" + loced + ", createTime="
					+ createTime + ", updateTime=" + updateTime + ", url=" + url + ", score=" + score + ", role=" + role
					+ "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
			result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
			result = prime * result + ((gender == null) ? 0 : gender.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + loced;
			result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
			result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
			result = prime * result + role;
			result = prime * result + score;
			result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
			result = prime * result + ((url == null) ? 0 : url.hashCode());
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
			User other = (User) obj;
			if (birthday == null) {
				if (other.birthday != null)
					return false;
			} else if (!birthday.equals(other.birthday))
				return false;
			if (createTime == null) {
				if (other.createTime != null)
					return false;
			} else if (!createTime.equals(other.createTime))
				return false;
			if (gender != other.gender)
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (loced != other.loced)
				return false;
			if (nickName == null) {
				if (other.nickName != null)
					return false;
			} else if (!nickName.equals(other.nickName))
				return false;
			if (passWord == null) {
				if (other.passWord != null)
					return false;
			} else if (!passWord.equals(other.passWord))
				return false;
			if (role != other.role)
				return false;
			if (score != other.score)
				return false;
			if (updateTime == null) {
				if (other.updateTime != null)
					return false;
			} else if (!updateTime.equals(other.updateTime))
				return false;
			if (url == null) {
				if (other.url != null)
					return false;
			} else if (!url.equals(other.url))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public int getLoced() {
			return loced;
		}
		public void setLoced(int loced) {
			this.loced = loced;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public Date getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		
		
}
