package com.sd.client.app.packages.data.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Point;
import com.sd.client.app.models.Segment;

public class RequestRouteRequestData extends PackageData {
    @JsonProperty("ponto_origem")
    Point origin;

    @JsonProperty("ponto_destino")
    Point destiny;

    public RequestRouteRequestData() {
    }

    public RequestRouteRequestData(Point origin, Point destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Point getDestiny() {
        return destiny;
    }

    public void setDestiny(Point destiny) {
        this.destiny = destiny;
    }

}
