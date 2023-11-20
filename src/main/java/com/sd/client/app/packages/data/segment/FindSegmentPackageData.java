package com.sd.client.app.packages.data.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Segment;

public class FindSegmentPackageData extends PackageData {
    @JsonProperty("segmento")
    Segment segment;

    public FindSegmentPackageData(Segment segment) {
        this.segment = segment;
    }

    public FindSegmentPackageData() {
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }
}
