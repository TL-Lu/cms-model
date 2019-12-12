package com.lutenglong.service;

import java.util.List;

import javax.validation.Valid;

import com.lutenglong.bean.Category;
import com.lutenglong.bean.Channel;
import com.lutenglong.bean.User;

public interface UserService {

	void add(User user);

	User checkName(@Valid String userName);

	User findAUser(User user);

	List<Channel> getChannels();


}
