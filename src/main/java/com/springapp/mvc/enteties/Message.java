package com.springapp.mvc.enteties;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    private Long user_id;
    private Long sender_user_id;

    private String subject;
    private String message;
    private boolean status;
    private Date date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = new java.util.Date();
    }

    public Long getSender_user_id() {
        return sender_user_id;
    }

    public void setSender_user_id(Long sender_user_id) {
        this.sender_user_id = sender_user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
