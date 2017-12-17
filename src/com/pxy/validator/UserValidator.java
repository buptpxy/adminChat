package com.pxy.validator;

import java.util.ArrayList;
import java.util.List;

import com.pxy.entity.User;


public class UserValidator {
	public List<String> validate(User user) {
		List<String> errors = new ArrayList<String>();
		String username = user.getUsername();
		String password = user.getPassword();
		if(username==null||username.trim().isEmpty()){
			errors.add("用户名不能为空");
		}
		if (password==null||password.trim().isEmpty()) {
			errors.add("密码不能为空");
		}
		return errors;
	}
}
