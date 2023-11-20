package com.sd.client.app.packages.data.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.User;

public class EditUserRequestData extends PackageData {
    Long user_id;
    String name;
    String email;
    String password;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String type;
    String token;

    public EditUserRequestData() {
    }

    public EditUserRequestData(User user, String token) {
        user_id = user.getId();
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();
        type = user.getType();
        this.token = token;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
