package com.sd.client.app.data.logout;

import com.sd.client.app.base.ResponseData;

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
