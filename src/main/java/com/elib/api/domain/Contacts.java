package com.elib.api.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contacts implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String contactUsername;

    public String getContactUsername() {
        return contactUsername;
    }

    public void setContactUsername(String contactUsername) {
        this.contactUsername = contactUsername;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contacts{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", contactUsername='").append(contactUsername).append('\'');
        sb.append('}');
        return sb.toString();
    }
}