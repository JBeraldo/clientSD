package com.example.clientsd.app.data.login;

import com.example.clientsd.app.base.ResponseData;

public class LoginResponseData extends ResponseData {
    private String token;

    public LoginResponseData(String token) {
        this.token = token;
    }

    public LoginResponseData() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
