package com.springapp.mvc.services;
import com.springapp.mvc.enteties.Message;
import com.springapp.mvc.enteties.User;

import java.util.List;

public interface MessageService {
    public List<Message> findMessagesByReceiverId(Long id);
    public Message findMessageByMessageId(Long msgId);
    public void save(Message message);
    public void delete(Message message);

}
