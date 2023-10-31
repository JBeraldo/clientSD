package com.sd.client.app.packages;

import com.fasterxml.jackson.databind.JavaType;
import com.sd.client.app.base.ResponseData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)
public class BaseResponse<T> {

    private String action;

    private T data;

    private boolean error;

    private String message;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
    public BaseResponse(String action, T data, boolean error, String message) {
        this.action = action;
        this.data = data;
        this.error = error;
        this.message = message;
    }

    ObjectMapper jackson = new ObjectMapper();
    public String toJson() throws JsonProcessingException {
        return jackson.writeValueAsString(this);
    }
    public static <T> BaseResponse<T> fromJson(String json, Class<T> dataClass) throws JsonProcessingException {
        ObjectMapper jackson = new ObjectMapper();
        JavaType javaType = jackson.getTypeFactory().constructParametricType(BasePackage.class, dataClass);
        return jackson.readValue(json, javaType);
    }


}
