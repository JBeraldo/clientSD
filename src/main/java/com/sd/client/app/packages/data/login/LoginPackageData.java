package com.sd.client.app.packages.data.login;

import com.sd.client.app.base.PackageData;

public class LoginPackageData extends PackageData {
    private String token;

    public LoginPackageData(String token) {
        this.token = token;
    }

    public LoginPackageData() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
