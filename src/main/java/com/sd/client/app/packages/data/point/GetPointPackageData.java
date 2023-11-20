package com.sd.client.app.packages.data.point;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Point;

import java.util.ArrayList;

public class GetPointPackageData extends PackageData {
    @JsonProperty("pontos")
    private ArrayList<Point> points;

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public GetPointPackageData() {
    }

    public GetPointPackageData(ArrayList<Point> points) {
        this.points = points;
    }
}
