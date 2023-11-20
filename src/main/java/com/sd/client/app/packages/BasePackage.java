package com.sd.client.app.packages;


import com.sd.client.app.base.PackageData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasePackage {

    private static final Logger logger = LogManager.getLogger(BasePackage.class);

    private String action;
    private PackageData data;

    private final ObjectMapper jackson = new ObjectMapper();

    public BasePackage(String action, PackageData data) {
        this.action = action;
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public PackageData getData() {
        return data;
    }

    public void setData(PackageData data) {
        this.data = data;
    }
    public String toJson() throws JsonProcessingException {
        String json = jackson.writeValueAsString(this);
        logger.info("Enviado: "+json);
        return json;
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
