package com.springapp.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {
	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
}