package com.springapp.mvc.services;

import com.springapp.mvc.enteties.User;
import com.springapp.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    public List<User> findUsersByLastName(String lastName){
        List<User> users = repository.findByLastName(lastName);
        return users;
    }
    public List<User> findUsersByFirstName(String firstName) {
        List<User> users = repository.findByFirstName(firstName);
        return users;
    }

    public List<User> findUsersByFirstNameOrLastName(String name) {
        List<User> users = repository.findByFirstNameOrLastName(name);
        return users;
    }

    public void save(User user){
        repository.save(user);
    };
}
