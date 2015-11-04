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
        return repository.findByLastName(lastName);
    }
    public List<User> findUsersByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    /*@Override
    public List<User> findUsersByEmail(String email) {
        return repository.findByEmail(email);
    }*/

    public List<User> findUsersByFirstNameOrLastName(String name) {
        return repository.findByFirstNameOrLastName(name);
    }

    public User findUserByEmail(String email) {
     User user = repository.findByEmail(email);
      return user;
    }
    public void save(User user){
        repository.save(user);
    };
}
