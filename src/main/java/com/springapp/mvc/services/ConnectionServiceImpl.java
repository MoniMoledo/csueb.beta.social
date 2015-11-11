package com.springapp.mvc.services;

import com.springapp.mvc.enteties.Connection;
import com.springapp.mvc.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ConnectionServiceImpl implements ConnectionService{

    @Autowired
    private ConnectionRepository repository;

//    @Override
//    public List<Connection> findConnectionByUserId(Long userId) {
//        return repository.findConnectionByUserId(userId);
//        }

    @Override
    public void save(Connection connection) {
        repository.save(connection);
    }
}
