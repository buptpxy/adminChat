package com.pxy.validator;

import java.util.ArrayList;
import java.util.List;

import com.pxy.entity.User;


public class UserValidator {
	/**
	 * �������û���������ĸ�ʽУ��
	 * @param user
	 * @return errors
	 */
	public List<String> validate(User user) {
		List<String> errors = new ArrayList<String>();
		String username = user.getUsername();
		String password = user.getPassword();
		if(username==null||username.trim().isEmpty()){
			errors.add("�û�������Ϊ��");
		}
		if (password==null||password.trim().isEmpty()) {
			errors.add("���벻��Ϊ��");
		}
		return errors;
	}
}
