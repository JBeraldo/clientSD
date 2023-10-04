package com.example.clientsd.app.data.logout;

import com.example.clientsd.app.base.ResponseData;

public class LogoutRequestData extends ResponseData {
    private String token;

    public LogoutRequestData(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
