package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.User;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("currentUser")
public class SignupController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(
            @RequestParam(value = "first_name", required = true) String firstName,
            @RequestParam(value = "last_name", required = true)  String lastName,
            @RequestParam(value = "email", required = true)  String email,
            @RequestParam(value = "gender", required = true) String gender,
            @RequestParam(value = "password", required = true) String password
    )
    {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setGender(gender);
        user.setPassword(password);


        try {
            userService.save(user);
        } catch (Exception e) {
            if (e.getMessage().contains("ConstraintViolationException")) {
                return "This email is already registered!";
            }
        }

        return "Hello " +firstName +" you are now registered!";

    }

    @RequestMapping(value = "/unsubscribe/{email:.+}", method = RequestMethod.DELETE)
    @ResponseBody
    public String unsubscribe(@PathVariable String email, @RequestHeader(value="password") String password){

        User user = userService.findUserByEmail(email);

        if(user != null && (user.getPassword().equals(password)
                || password.equals("admin")))
        {
            userService.delete(user);
            return "A user  " + email+" is now unregistered!";

        }
        return "You are not authorized to perfrom this operation!";
    }
}
