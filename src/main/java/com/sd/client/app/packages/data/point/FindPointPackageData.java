package com.sd.client.app.packages.data.point;

import com.sd.client.app.models.Point;

public class FindPointPackageData {
    Point ponto;

    public FindPointPackageData() {
    }

    public FindPointPackageData(Point ponto) {
        this.ponto = ponto;
    }

    public Point getPonto() {
        return ponto;
    }

    public void setPonto(Point ponto) {
        this.ponto = ponto;
    }
}
