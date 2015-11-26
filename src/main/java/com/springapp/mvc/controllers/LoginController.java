package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.User;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(HttpServletRequest request) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		if( !(email == null || email.isEmpty()) && !(password == null || password.isEmpty()))
		{
			User user = userService.findUserByEmail(email);
			if (user != null && user.getPassword().equals(password))
			{
				session.setAttribute("currentUser", user);
			}else{
				session.setAttribute("loginError", "Your credentials are not correct");
			}
		}
		return new ModelAndView("home");
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("home");
	}
}

