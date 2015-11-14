package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.Connection;
import com.springapp.mvc.enteties.User;
import com.springapp.mvc.repository.UserRepository;
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

        User currentUser = (User) request.getSession().getAttribute("currentUser");
        User userDestination = userService.findUserByEmail(request.getParameter("destEmail"));
        Connection connection_src = new Connection();
        connection_src.setUser_id(currentUser.getId());
        connection_src.setConnected_user_id(userDestination.getId());

        Connection connection_dest = new Connection();
        connection_dest.setUser_id(userDestination.getId());
        connection_dest.setConnected_user_id(currentUser.getId());

        try {
            connectionService.save(connection_src);
            connectionService.save(connection_dest);
        } catch (Exception e) {
            if(e.getMessage().contains("org.hibernate.exception.ConstraintViolationException")){
                return "You already connected to this user";
            }else{
             return "Failed to create connection due to " + e.getMessage();
            }
        }
        return "You are successfully connected";
    }

   /** @RequestMapping(value = "/connections", method = RequestMethod.GET)
    public ModelAndView getConnections(HttpServletRequest request){
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        List<Connection> connection = connectionService.findById(currentUser.getId());
        ModelAndView model = new ModelAndView("profile");
        List<User> connectedUser = new ArrayList<User>();
        for (Connection c : connection) {
            connectedUser.add(userService.findOne(c.getConnected_user_id()));
        }

        model.addObject("connectedUser", connectedUser != null ? connectedUser: new ArrayList());
        return model;
    }
**/
}
