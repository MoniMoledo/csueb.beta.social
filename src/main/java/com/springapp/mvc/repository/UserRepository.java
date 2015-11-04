package com.springapp.mvc.repository;

import com.springapp.mvc.enteties.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.io.Serializable;
import java.util.List;

public interface UserRepository<T, ID extends Serializable> extends CrudRepository<User, Long>{

    List<User> findByLastName(String lastName);

    List<User> findByFirstName(String firstName);

    //List<User> findByEmail(String email);

    @Query("select u from user u where u.firstName = ?1 or u.lastName =?1")
    List<User> findByFirstNameOrLastName(String name);


   @Query("select u from user u where u.email = ?1")
   User findByEmail(String email);

}
