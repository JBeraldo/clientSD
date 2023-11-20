package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.PackageData;

public class DeleteUserRequestData extends PackageData {
    String token;
    Long user_id;

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

    public DeleteUserRequestData() {
    }

    public DeleteUserRequestData(String token, Long user_id) {
        this.token = token;
        this.user_id = user_id;
    }
}
