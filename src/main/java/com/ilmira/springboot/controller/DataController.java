package com.ilmira.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DataController {
	@RequestMapping(value = "/")
	public String getHomePage(Model model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC-SECURITY application");
		messages.add("This is Hello Page");
		model.addAttribute("messages", messages);
		return "hello";
	}

	@GetMapping(value = "login")
	public String getLoginPage() {
		return "login";
	}

	@GetMapping(value = "hello")
	public String getUserPage(Model model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC-SECURITY application");
		messages.add("This is User Page");
		model.addAttribute("messages", messages);
		return "userPage";
	}

}