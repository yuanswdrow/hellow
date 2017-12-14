package com.loyal.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loyal.common.entity.User;
import com.loyal.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String userList(Model model) {
		List<User> list = userService.selectAllUser();
		model.addAttribute("list", list);
		return "userlist";
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String find(String username, Model model) {
		Long start = System.currentTimeMillis();
		User user = userService.findByUsername(username);
		Long end = System.currentTimeMillis();
		Long time = end - start;
		System.out.println("普通查詢使用時間  : " + time);
		model.addAttribute("msg", "普通查詢使用時間  : ");
		model.addAttribute("time", time);
		model.addAttribute("user", user);
		return "findout";
	}

	@RequestMapping(value = "/redisfind", method = RequestMethod.POST)
	public String redisfind(String username, Model model) {
		Long start = System.currentTimeMillis();
		User user = userService.findByUsernameCache(username);
		Long end = System.currentTimeMillis();
		Long time = end - start;
		System.out.println("redis查詢使用時間  : " + time);
		model.addAttribute("msg", "redis查詢使用時間  : ");
		model.addAttribute("time", time);
		model.addAttribute("user", user);
		return "findout";
	}

}
