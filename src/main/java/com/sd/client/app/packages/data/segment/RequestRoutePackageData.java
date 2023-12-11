package com.sd.client.app.packages.data.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Segment;

import java.util.List;

public class RequestRoutePackageData extends PackageData {
    @JsonProperty("segmentos")
    public List<Segment> segments;

    public RequestRoutePackageData(List<Segment> segments) {
        this.segments = segments;
    }

    public RequestRoutePackageData() {
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }
}
