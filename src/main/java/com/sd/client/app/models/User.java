package com.sd.client.app.models;

import org.apache.commons.codec.digest.DigestUtils;

public class User {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String type;
    public User() {

    }

    public User(Long id, String name, String password, String email, boolean admin) {
        this.id = id;
        this.name = name;
        this.password = passwordMD5(password);
        this.email = email;
        this.type = admin ? "admin" : "comum";
    }
    public User(String name, String password, String email, boolean admin) {
        this.name = name;
        this.password = passwordMD5(password);
        this.email = email;
        this.type = admin ? "admin" : "comum";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String passwordMD5(String password) {
        return DigestUtils.md5Hex(password).toUpperCase();
    }
}
