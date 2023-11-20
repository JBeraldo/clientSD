package com.sd.client.app.packages.data.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sd.client.app.base.PackageData;

public class DeleteSegmentRequestData extends PackageData {
    String token;
    @JsonProperty("segmento_id")
    Long segment_id;

    public DeleteSegmentRequestData() {
    }

    public DeleteSegmentRequestData(String token, Long segment_id) {
        this.token = token;
        this.segment_id = segment_id;
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
}
