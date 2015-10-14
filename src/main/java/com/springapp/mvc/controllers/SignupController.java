package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.Connection;
import com.springapp.mvc.enteties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SignupController {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public String register(HttpServletRequest request){
        return "Hello " +request.getParameter("first_name") +" you are now registered!";
    }
}
