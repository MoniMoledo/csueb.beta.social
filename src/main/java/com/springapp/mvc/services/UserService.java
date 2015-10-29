package com.springapp.mvc.services;

import com.springapp.mvc.enteties.User;

import java.util.List;

public interface UserService {

    public List<User> findUsersByLastName(String lastName);
    public List<User> findUsersByFirstName(String firstName);
    public List<User> findUsersByEmail(String email);
    public List<User> findUsersByFirstNameOrLastName(String name);

    public void save(User user);
}
