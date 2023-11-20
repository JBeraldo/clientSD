package com.sd.client.app.packages.data.point;

import com.sd.client.app.base.PackageData;

public class GetPointRequestData extends PackageData {
    private String token;

    public GetPointRequestData(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
