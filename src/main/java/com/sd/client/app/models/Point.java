package com.sd.client.app.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Point {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Long id;
    String name;

    @JsonProperty("obs")
    String observation;

    public Point() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Point(Long id, String name, String observation) {
        this.id = id;
        this.name = name;
        this.observation = observation;
    }

    public Point(String name, String observation) {
        this.name = name;
        this.observation = observation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id + "   " + this.name;
    }
}
