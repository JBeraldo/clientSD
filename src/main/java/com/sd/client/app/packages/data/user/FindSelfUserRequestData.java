package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.ResponseData;

public class FindSelfUserRequestData extends ResponseData {
    private String token;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public FindSelfUserRequestData(String token) {
        this.token = token;
    }

    public FindSelfUserRequestData() {
    }
}

