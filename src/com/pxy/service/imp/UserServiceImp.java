package com.pxy.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pxy.dao.UserMapper;
import com.pxy.entity.User;
import com.pxy.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Resource
	UserMapper userMapper;
	
	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByName(username);
		if (user != null && password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasSameName(String username) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByName(username);
		if (user==null) {
			return true;
		}
		return false;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		if (hasSameName(user.getUsername())) {
			return userMapper.insert(user);
		}
		return 0;		
	}

}
