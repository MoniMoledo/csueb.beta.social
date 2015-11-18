package com.springapp.mvc.services;

import com.springapp.mvc.enteties.Connection;

import java.util.List;

public interface ConnectionService {

    public List<Connection> findById(Long userId);

    public void save(Connection connection);

    public boolean areConnected(Long srcUserId, Long dstUserId);
}