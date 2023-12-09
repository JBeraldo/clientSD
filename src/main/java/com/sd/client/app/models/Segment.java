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
    int distance;
    @JsonProperty("obs")
    String observation;
    @JsonProperty("bloqueado")
    boolean blocked;

    public Segment(Long id, String direction, Point origin, Point destination, int distance, String observation, boolean blocked) {
        this.id = id;
        this.direction = direction;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.observation = observation;
        this.blocked = blocked;
    }
    public Segment(String direction, Point origin, Point destination, int distance, String observation,boolean blocked) {
        this.direction = direction;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.observation = observation;
        this.blocked = blocked;
    }

    public Segment(CreateSegmentRequestData data) {
        this.direction = data.getSegment().getDirection();
        this.origin = data.getSegment().getOrigin();
        this.destination = data.getSegment().getDestination();
        this.distance = data.getSegment().getDistance();
        this.observation = data.getSegment().getObservation();
        this.blocked = data.getSegment().isBlocked();
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return this.id + "   " + this.origin.name+ " -> "+this.destination.name;
    }
}
