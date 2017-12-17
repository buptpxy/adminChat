package com.pxy.service;

import com.pxy.entity.User;

public interface UserService {
	/**
	 * 判断用户名密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean checkUser(String username,String password);
	
	/**
	 * 判断用户名是否已被注册
	 * @param username
	 * @return
	 */
	public boolean hasSameName(String username);
	
	/**
	 * 增加新用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
}
