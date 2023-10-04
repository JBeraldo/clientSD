package com.example.clientsd.app.packages.login;

import com.example.clientsd.app.data.login.LoginRequestData;
import com.example.clientsd.app.data.login.LoginResponseData;
import com.example.clientsd.app.packages.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(Include.NON_NULL)
public class LoginResponse extends BaseResponse {
    public LoginResponse(
            @JsonProperty("action") String action,
            @JsonProperty("data") LoginResponseData data,
            @JsonProperty("error") boolean error,
            @JsonProperty("message") String message) {
        super(action, data, error, message);
    }

    @Override
    public LoginResponseData getData() {
        return (LoginResponseData) super.getData();
    }


}
