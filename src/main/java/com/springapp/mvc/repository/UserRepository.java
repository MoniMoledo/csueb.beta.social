package com.springapp.mvc.repository;

import com.springapp.mvc.enteties.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.io.Serializable;
import java.util.List;

public interface UserRepository<T, ID extends Serializable> extends CrudRepository<User, Long>{

    List<User> findByLastName(String lastName);

    List<User> findByFirstName(String firstName);

    @Query("select u from user u where u.firstName = ?1 or u.lastName =?1 order by u.firstName")
    List<User> findByFirstNameOrLastName(String name);

}
