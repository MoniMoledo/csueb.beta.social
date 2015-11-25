package com.springapp.mvc.services;

import com.springapp.mvc.enteties.Message;
import com.springapp.mvc.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository repository;

    public List<Message> findMessagesByReceiverId(Long id) { return repository.findByUserId(id); }

    public Message findMessageByMessageId(Long msgId) { return repository.findByMsgId(msgId); }

    public void save(Message message) { repository.save(message); }

    public void delete(Message message) { repository.delete(message); }
}
