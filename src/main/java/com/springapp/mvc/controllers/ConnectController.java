package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.Connection;
import com.springapp.mvc.enteties.User;
import com.springapp.mvc.services.ConnectionService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ConnectController {

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    @ResponseBody
    public String connect(HttpServletRequest request){

        User userSource = userService.findUserByEmail(request.getParameter("src_email"));
        User userDestination = userService.findUserByEmail(request.getParameter("dst_email"));
        Connection connection = new Connection();
        connection.setUser_id(userSource.getId());
        connection.setConnected_user_id(userDestination.getId());
        connectionService.save(connection);
        /*User user = new User();
        user.setFirstName(request.getParameter("first_name"));
        user.setEmail(request.getParameter("email"));
        user.setLastName(request.getParameter("last_name"));
        user.setGender(request.getParameter("gender"));
        userService.save(user);*/
        return "You are successfully connected to";
    }

    @RequestMapping(value = "/connections", method = RequestMethod.GET)
    public ModelAndView getConnections(HttpServletRequest request){

        List<Connection> connection = connectionService.findById(Long.valueOf(request.getParameter("user_id")));
        ModelAndView model = new ModelAndView("profile");
        model.addObject("connections", connection != null ? connection : new ArrayList());
        return model;
    }

}
