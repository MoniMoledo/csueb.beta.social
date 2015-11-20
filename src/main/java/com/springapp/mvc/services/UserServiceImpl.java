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
    public User findOne(Long id){
        return (User) repository.findOne(id);
    };

    public void delete(User user){
        repository.delete(user);
    }
}
