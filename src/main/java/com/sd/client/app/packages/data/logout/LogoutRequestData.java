package com.sd.client.app.packages.data.logout;

import com.sd.client.app.base.PackageData;

public class LogoutRequestData extends PackageData {
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
