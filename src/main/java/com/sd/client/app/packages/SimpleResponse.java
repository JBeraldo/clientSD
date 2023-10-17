package com.sd.client.app.packages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.client.app.base.ResponseData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleResponse {

    private static final Logger logger = LogManager.getLogger(SimpleResponse.class);

    private String action;
    @JsonIgnore
    private ResponseData data;
    private boolean error;

    private String message;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public SimpleResponse() {
        // Default constructor
    }
    public SimpleResponse(String action, boolean error, String message) {
        this.action = action;
        this.error = error;
        this.message = message;
    }

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    ObjectMapper jackson = new ObjectMapper();
    public String toJson() throws JsonProcessingException {
        return jackson.writeValueAsString(this);
    }
    public static <T> T fromJson(String json, Class<T> generic_response) throws JsonProcessingException {
        ObjectMapper jackson = new ObjectMapper();
        logger.info("Recebido: "+json);
        return jackson.readValue(json, generic_response);
    }

}
