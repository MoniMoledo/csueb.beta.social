package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.Message;
import com.springapp.mvc.enteties.User;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import com.springapp.mvc.services.MessageService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public String sendMessage (HttpServletRequest request) {

        Message message = new Message();
        message.setStatus(false);
        message.setUser_id(Long.valueOf(request.getParameter("receiver_user_id")));
        message.setSender_user_id(Long.valueOf(request.getParameter("sender_user_id")));
        message.setDate(new Date());
        message.setSubject(request.getParameter("subject"));
        message.setMessage(request.getParameter("message"));
        messageService.save(message);
        return "The message has been sent!";
    }

    @RequestMapping(value = "/message/{message_id}", method = RequestMethod.GET)
    public ModelAndView showMessage (@PathVariable(value = "message_id") Long messageId)
    {
        Message message = messageService.findMessageByMessageId(messageId);
        message.setStatus(true);
        ModelAndView model = new ModelAndView("message");
        model.addObject("message", message);
        messageService.save(message);
        return model;
    }

    @RequestMapping(value = "/messages/{receiver_user_id:[0-9]+}", method = RequestMethod.GET)
    public ModelAndView showMessages (@PathVariable(value = "receiver_user_id") Long receiverUserId)
    {
        List<Message> messageList = messageService.findMessagesByReceiverId(receiverUserId);
        ModelAndView model = new ModelAndView("messages");
        model.addObject("messageList", messageList);
        return model;
    }

    @RequestMapping(value = "send_message", method = RequestMethod.GET)
    public String send_message(ModelMap model) {
        return "send_message";
    }
}
