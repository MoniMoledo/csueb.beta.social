package com.springapp.mvc.controllers;

import com.springapp.mvc.enteties.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import com.springapp.mvc.services.MessageService;

import java.util.ArrayList;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    private void SendMessage (HttpRequest request) {
        Message message = new Message();

        message.setId(request.getParameter("message_id"));
        message.setStatus(false);
        message.setUser(request.getParameter("user"));
        message.setSender_user_id(request.getParameter("sender_user_id"));
        message.setDate(request.getParameter("date"));
        message.setSubject(request.getParameter("subject"));
        message.setMessage(request.getParameter("message"));

        messageService.save(message);
    }

    public Message showMessage (HttpRequest request)
    {
        Message message = messageService.findById(request.getParameter("message_id"));
        message.setStatus(true);
        return message;
    }
}
