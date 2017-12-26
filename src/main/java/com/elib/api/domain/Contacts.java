package com.elib.api.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Contacts implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;

    private String username;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> userSet = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contacts{");
        sb.append("contactId=").append(contactId);
        sb.append(", userName='").append(username).append('\'');
        sb.append(", userList=").append(userSet);
        sb.append('}');
        return sb.toString();
    }
}