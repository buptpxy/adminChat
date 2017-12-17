package com.pxy.service;

import com.pxy.entity.User;

public interface UserService {
	public boolean checkUser(String username,String password);
	public boolean hasSameName(String username);
	public int addUser(User user);
}
