package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.User;
import com.springapp.mvc.services.UserService;
import com.springapp.mvc.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest request)
    {
        List<User> users = userService.findUsersByFirstNameOrLastName(request.getParameter("name"));
        ModelAndView model = new ModelAndView("home");
        model.addObject("users", users != null ? users : new ArrayList());
        return model;
    }
}