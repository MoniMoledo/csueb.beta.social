package com.springapp.mvc.services;

import com.springapp.mvc.enteties.User;

import java.util.List;

public interface UserService {

    public List<User> findUsersByLastName(String lastName);
    public List<User> findUsersByFirstName(String firstName);
    public List<User> findUsersByFirstNameOrLastName(String name);
    public User findUserByEmail(String email);

    public void save(User user);
    public void delete(User user);

    public User findOne(Long id);
}
