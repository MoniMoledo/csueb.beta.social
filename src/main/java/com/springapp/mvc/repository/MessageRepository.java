package com.springapp.mvc.repository;

import com.springapp.mvc.enteties.Connection;
import com.springapp.mvc.enteties.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Monique on 11/19/2015.
 */
public interface MessageRepository <T, ID extends Serializable> extends CrudRepository<Connection, Long> {

    @Query("select m from messages m where m.user_id = ?1 and m.status=false")
    List<Message> findByUserId(Long userId);

    @Query("select m from messages m where m.id = ?1 and m.status=false")
    Message findByMsgId(Long userId);
}
