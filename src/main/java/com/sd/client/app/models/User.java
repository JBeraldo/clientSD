package com.sd.client.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Objects;

public class User {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String password;
    @JsonProperty
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
    public User() {

    }

    public User(Long id, String name, String password, String email, boolean admin) {
        this.id = id;
        this.name = name;
        this.password = passwordMD5(password);
        this.email = email;
        this.type = admin ? "admin" : "user";
    }
    public User(String name, String password, String email, boolean admin) {
        this.name = name;
        this.password = passwordMD5(password);
        this.email = email;
        this.type = admin ? "admin" : "user";
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
    @JsonIgnore
    public boolean isAdm(){
        return Objects.equals(this.type, "admin");
    }

    @Override
    public String toString() {
        return this.id + "   " + this.name;
    }

    public static String passwordMD5(String password) {
        return !password.isEmpty() ? DigestUtils.md5Hex(password).toUpperCase() : null;
    }
}
