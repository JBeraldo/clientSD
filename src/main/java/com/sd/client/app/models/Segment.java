package com.sd.client.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sd.client.app.packages.data.segment.CreateSegmentRequestData;

public class Segment {
    private Long id;
    @JsonProperty("direcao")
    String direction;
    @JsonProperty("ponto_origem")
    Point origin;
    @JsonProperty("ponto_destino")

    Point destination;
    @JsonProperty("distancia")
    String distance;
    @JsonProperty("obs")
    String observation;

    public Segment(Long id, String direction, Point origin, Point destination, String distance, String observation) {
        this.id = id;
        this.direction = direction;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.observation = observation;
    }
    public Segment(String direction, Point origin, Point destination, String distance, String observation) {
        this.direction = direction;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.observation = observation;
    }

    public Segment(CreateSegmentRequestData data) {
        this.direction = data.getSegment().getDirection();
        this.origin = data.getSegment().getOrigin();
        this.destination = data.getSegment().getDestination();
        this.distance = data.getSegment().getDistance();
        this.observation = data.getSegment().getObservation();
    }

    public Segment() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    @Override
    public String toString() {
        return this.id + "   " + this.origin.name+ " -> "+this.destination.name;
    }
}