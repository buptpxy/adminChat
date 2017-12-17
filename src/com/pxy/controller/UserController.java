package com.pxy.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pxy.chat.H5ServletServerSocket;
import com.pxy.entity.User;
import com.pxy.service.UserService;

@Controller
public class UserController {
	@Resource
	UserService userService;
	
	@RequestMapping("/register")
	public String register(Model model){
		model.addAttribute("user", new User());
		return "Register";
	}
	
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("user", new User());
		return "Login";
	}
	
	@RequestMapping("/save_user")// ��ǰ̨ҳ�洫��ֵ����model��
	public String saveUser(Model model,@ModelAttribute("user") User user){
		String username = user.getUsername();
		String password = user.getPassword();
		user.setUsername(username);
		user.setPassword(password);
		if (userService.addUser(user)!=0) {
			model.addAttribute("user", user);
			return "redirect:/login";
		}else {
			String error = "�û����ѱ�ע�ᣡ";
			model.addAttribute("error", error);
			return "Register";
		}
		
	}
	
	@RequestMapping("/check_user")
	public String checkUser(Model model,@ModelAttribute("user") User user){
		boolean check = userService.checkUser(user.getUsername(), user.getPassword());
		
		if(check){
			model.addAttribute("user", user);
			int onlineCount = H5ServletServerSocket.getOnlineCount();
			
			model.addAttribute("onlineCount", onlineCount);
			
			return "Chat";
		}else {
			String error = "�û������������";
			model.addAttribute("error",error);
			return "Login";
		}
		
	}
	
	/*@RequestMapping("/chat")
	public String chat(Model model,@ModelAttribute("user") User user){
		//H5ServletServerSocket h5ServletServerSocket = new H5ServletServerSocket();
		int onlineCount = H5ServletServerSocket.getOnlineCount();
		String messages = H5ServletServerSocket.getMessage(user.getUsername());
		model.addAttribute("onlineCount", onlineCount);
		model.addAttribute("messages", messages);
		return "Chat";
	}
	*/
}
