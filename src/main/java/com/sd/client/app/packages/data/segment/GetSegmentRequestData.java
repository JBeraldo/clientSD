package com.sd.client.app.packages.data.segment;

import com.sd.client.app.base.PackageData;

public class GetSegmentRequestData extends PackageData {
    private String token;
    public GetSegmentRequestData(){
    }

    public GetSegmentRequestData(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
