package com.example.userdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    private String password; // plaintext per request

    @Column(name = "json_url")
    private String jsonUrl;

    public User() {}

    public User(String username, String password, String jsonUrl) {
        this.username = username;
        this.password = password;
        this.jsonUrl = jsonUrl;
    }

    // getters / setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJsonUrl() {
        return jsonUrl;
    }

    public void setJsonUrl(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }
}
