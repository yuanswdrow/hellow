package com.loyal.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loyal.common.entity.User;
import com.loyal.service.UserService;



@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, Model model) {

		if (username == null || password == null) {
			System.out.println("用户名或密码不能为空");
			return "erre";
		}
		
		User user = userService.login(username, password);
		if (user == null) {
			return "erre";
		} else {

			model.addAttribute("user", user);
			System.out.println(user);
			System.out.println("登陸成功！！");
			
			return "redirect:userlist";   //重定向到   userlist 到請求
		}
	}
	
}
