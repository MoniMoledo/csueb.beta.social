package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.User;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;
        @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView find(HttpServletRequest request)
    {
        User user = userService.findUserByEmail(request.getParameter("e"));
        ModelAndView model = new ModelAndView("profile");
        model.addObject("user", user);
        return model;
    }

}
