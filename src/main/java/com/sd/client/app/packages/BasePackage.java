package com.sd.client.app.packages;


import com.sd.client.app.base.ResponseData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasePackage {

    private String action;
    private ResponseData data;

    private final ObjectMapper jackson = new ObjectMapper();

    public BasePackage(String action, ResponseData data) {
        this.action = action;
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }
    public String toJson() throws JsonProcessingException {
        return jackson.writeValueAsString(this);
    }
    public static <T> T fromJson(String json, Class<T> generic_response) throws JsonProcessingException {
        ObjectMapper jackson = new ObjectMapper();
        return jackson.readValue(json, generic_response);
    }

    public static BaseResponse simpleFromJson(String json) {
        ObjectMapper jackson = new ObjectMapper();
        jackson.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return jackson.readValue(json, BaseResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        try {
            return this.toJson();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
