package com.sd.client.app.packages.data.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Segment;

public class EditSegmentRequestData extends PackageData {
    String token;
    @JsonProperty("segmento_id")
    Long segment_id;
    @JsonProperty("segmento")
    Segment segment;

    public EditSegmentRequestData() {
    }

    public EditSegmentRequestData(String token, Long segment_id, Segment segment) {
        this.token = token;
        this.segment_id = segment_id;
        this.segment = segment;
    }
    public EditSegmentRequestData(Segment segment,String token) {
        this.token = token;
        this.segment_id = segment.getId();
        this.segment = segment;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getSegment_id() {
        return segment_id;
    }

    public void setSegment_id(Long segment_id) {
        this.segment_id = segment_id;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }
}
