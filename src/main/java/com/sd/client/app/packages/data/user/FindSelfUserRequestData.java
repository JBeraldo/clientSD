package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.PackageData;

public class FindSelfUserRequestData extends PackageData {
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

