package com.springapp.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value = "authenticate", method = RequestMethod.GET)
	@ResponseBody
	public String authenticate(HttpServletRequest request) {
		return "Hi "+request.getParameter("email")+"!, You're now logged in!";
	}
}