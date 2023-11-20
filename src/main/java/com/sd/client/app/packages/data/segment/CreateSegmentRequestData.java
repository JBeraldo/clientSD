package com.sd.client.app.packages.data.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Segment;

public class CreateSegmentRequestData extends PackageData {
    String token;

    @JsonProperty("segmento")
    Segment segment;

    public CreateSegmentRequestData() {
    }
    public CreateSegmentRequestData(Segment segment,String token) {
        this.segment = segment;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

}
