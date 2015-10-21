package com.springapp.mvc.enteties;


import javax.persistence.*;

@Entity(name = "connection")
public class Connection {

    @Id
    @GeneratedValue
    private Long id;
    private Long user_id;
    private Long connected_user_id;

    @ManyToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    public Long getConnected_user_id() {
        return connected_user_id;
    }

    public void setConnected_user_id(Long connected_user_id) {
        this.connected_user_id = connected_user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

}
