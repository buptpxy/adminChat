package com.pxy.service;

import com.pxy.entity.User;

public interface UserService {
	/**
	 * �ж��û��������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean checkUser(String username,String password);
	
	/**
	 * �ж��û����Ƿ��ѱ�ע��
	 * @param username
	 * @return
	 */
	public boolean hasSameName(String username);
	
	/**
	 * �������û�
	 * @param user
	 * @return
	 */
	public int addUser(User user);
}
