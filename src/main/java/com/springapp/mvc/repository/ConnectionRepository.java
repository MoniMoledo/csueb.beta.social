package com.springapp.mvc.repository;


import com.springapp.mvc.enteties.Connection;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ConnectionRepository<T, ID extends Serializable> extends CrudRepository<Connection, Long> {

    //public List<Connection> findConnectionByUserId(Long userId);
}
