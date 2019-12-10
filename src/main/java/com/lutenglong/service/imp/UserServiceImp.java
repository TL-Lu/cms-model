package com.lutenglong.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lutenglong.mapper.UserMapper;
import com.lutenglong.service.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserMapper mapper;
}
