package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.Connection;
import com.springapp.mvc.enteties.User;
import com.springapp.mvc.services.ConnectionService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private UserService userService;
        @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView find(HttpServletRequest request)
    {
        User dstUser = userService.findUserByEmail(request.getParameter("e"));
        User srcUser = (User) request.getSession().getAttribute("currentUser");
        ModelAndView model = new ModelAndView("profile");
        model.addObject("user", dstUser);

        if (srcUser != null && dstUser != null) {
            if (connectionService.areConnected(srcUser.getId(), dstUser.getId())) {
                model.addObject("isConnected", true);
            } else {
                model.addObject("isConnected", false);
            }
        }

        return model;
    }

    /*private ArrayList<User> getConnections(HttpServletRequest request, User user){

        List<Connection> connection = connectionService.findById(user.getId());
        ArrayList<User> connectedUser = new ArrayList<User>();
        for (Connection c : connection) {
            connectedUser.add(userService.findOne(c.getConnected_user_id()));
        }
        return connectedUser;
    }*/

}
