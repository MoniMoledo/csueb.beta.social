package com.springapp.mvc.services;

import com.springapp.mvc.enteties.Connection;
import com.springapp.mvc.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ConnectionServiceImpl implements ConnectionService{

    @Autowired
    private ConnectionRepository repository;

    @Override
    public List<Connection> findById(Long userId) {
        return repository.findById(userId);
        }

    @Override
    public void save(Connection connection) {
        repository.save(connection);
    }

    @Override
    public boolean areConnected(Long srcUserId, Long dstUserId) {
        List<Connection> connections = repository.findById(srcUserId);
        for(int i = 0; i < connections.size(); i++){
            Connection connection = connections.get(i);
            if(connection.getConnected_user_id().equals(dstUserId))
            {
                return true;
            }
        }
        return false;
    }
}
