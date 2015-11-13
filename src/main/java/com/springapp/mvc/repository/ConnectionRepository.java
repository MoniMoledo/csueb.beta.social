package com.springapp.mvc.repository;


import com.springapp.mvc.enteties.Connection;
import com.springapp.mvc.enteties.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface ConnectionRepository<T, ID extends Serializable> extends CrudRepository<Connection, Long> {

    //public List<Connection> findConnectionByUserId(Long userId);

    @Query("select c from connection c where c.user_id = ?1 ")
    List<Connection> findById(Long user_id);
}
