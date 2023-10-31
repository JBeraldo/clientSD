package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.ResponseData;

public class GetUserRequestData extends ResponseData {
    private String token;

    public GetUserRequestData(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
