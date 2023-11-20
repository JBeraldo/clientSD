package com.sd.client.app.packages.data.point;

import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Point;

public class CreatePointRequestData extends PackageData {

    String token;
    String name;
    String obs;

    public CreatePointRequestData(Point point, String token) {
        this.name = point.getName();
        this.obs = point.getObservation();
        this.token = token;
    }

    public CreatePointRequestData() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
