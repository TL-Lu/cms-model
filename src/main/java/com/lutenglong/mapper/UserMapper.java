package com.lutenglong.mapper;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.lutenglong.bean.User;

public interface UserMapper {

	@Insert("insert into cms_user values(null,#{userName},#{passWord},null,null,0,0,now(),null,null,0,0)")
	void add(User user);

	@Select("select id,username,password from cms_user where username=#{userName} limit 1")
	User checkName(@Valid String userName);

	
	@Select("select id,username,password passWord,nickname nickName,birthday,CONCAT(gender),locked,create_time createTime,update_time updateTime,url,score,role "
			+ "from cms_user where username=#{userName} and password=#{passWord}")
	User findAUser(User user);

}
