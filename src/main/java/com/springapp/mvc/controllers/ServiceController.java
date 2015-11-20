package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.User;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/delete")
public class ServiceController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public void delete(HttpServletRequest request)
    {
        User user = null;
        String password = request.getHeader("Authorization");
        if(password.equals("secret")) {
                user = userService.findUserByEmail(request.getParameter("email"));
        }
        else{
                throw new RuntimeException("Authenticatoin failed!");
        }
        userService.delete(user);
    }
}

