package com.springapp.mvc.services;

import com.springapp.mvc.enteties.Connection;

public interface ConnectionService {

    //public List<Connection> findConnectionByUserId(Long userId);

    public void save(Connection connection);
}