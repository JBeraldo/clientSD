package com.sd.client.app.packages.data.point;

import com.sd.client.app.base.PackageData;

public class DeletePointRequestData extends PackageData {
    String token;
    Long ponto_id;

    public DeletePointRequestData() {
    }

    public DeletePointRequestData(String token, Long ponto_id) {
        this.token = token;
        this.ponto_id = ponto_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getPonto_id() {
        return ponto_id;
    }

    public void setPonto_id(Long ponto_id) {
        this.ponto_id = ponto_id;
    }
}
