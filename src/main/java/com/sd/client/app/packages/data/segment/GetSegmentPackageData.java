package com.sd.client.app.packages.data.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Segment;

import java.util.List;

public class GetSegmentPackageData extends PackageData {
    @JsonProperty("segmentos")
    private List<Segment> segments;

    public GetSegmentPackageData() {
    }

    public GetSegmentPackageData(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }
}
