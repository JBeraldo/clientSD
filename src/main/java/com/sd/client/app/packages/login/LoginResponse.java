package com.sd.client.app.packages.login;

import com.sd.client.app.package_data.login.LoginResponseData;
import com.sd.client.app.packages.BaseResponse;
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
