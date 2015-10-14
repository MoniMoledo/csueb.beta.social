package com.springapp.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SearchController {
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public String search(HttpServletRequest request){
        return "Found " +request.getParameter("name");
    }
}
