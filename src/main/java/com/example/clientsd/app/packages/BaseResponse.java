package com.example.clientsd.app.packages;

import com.example.clientsd.app.base.ResponseData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)
public class BaseResponse {

    private String action;

    private ResponseData data;

    private boolean error;

    private String message;

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

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseResponse() {
        // Default constructor
    }
    public BaseResponse(String action, ResponseData data, boolean error, String message) {
        this.action = action;
        this.data = data;
        this.error = error;
        this.message = message;
    }

    ObjectMapper jackson = new ObjectMapper();
    public String toJson() throws JsonProcessingException {
        return jackson.writeValueAsString(this);
    }
    public static <T> T fromJson(String json, Class<T> generic_response) throws JsonProcessingException {
        ObjectMapper jackson = new ObjectMapper();
        return jackson.readValue(json, generic_response);
    }


}
