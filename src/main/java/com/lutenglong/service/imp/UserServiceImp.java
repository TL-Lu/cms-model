package com.lutenglong.service.imp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lutenglong.bean.Category;
import com.lutenglong.bean.Channel;
import com.lutenglong.bean.User;
import com.lutenglong.mapper.UserMapper;
import com.lutenglong.service.UserService;
import com.lutenglong.util.CmsUtils;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void add(User user) {
			String encry = CmsUtils.encry(user.getPassWord(), user.getUserName());
			user.setPassWord(encry);
			userMapper.add(user);
	}

	@Override
	public User checkName(@Valid String userName) {
		return userMapper.checkName(userName);
	}

	@Override
	public User findAUser(User user) {
		user.setPassWord(CmsUtils.encry(user.getPassWord(), user.getUserName()));
		return userMapper.findAUser(user);
	}

	@Override
	public List<Channel> getChannels() {
		// TODO Auto-generated method stub
		return userMapper.getChannels();
	}
}
