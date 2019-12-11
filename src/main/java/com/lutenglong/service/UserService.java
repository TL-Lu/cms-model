package com.lutenglong.service;

import javax.validation.Valid;

import com.lutenglong.bean.User;

public interface UserService {

	void add(User user);

	User checkName(@Valid String userName);

	User findAUser(User user);

}
