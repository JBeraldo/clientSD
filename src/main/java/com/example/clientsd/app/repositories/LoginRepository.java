package com.example.clientsd.app.repositories;

import com.example.clientsd.app.App;
import com.example.clientsd.app.base.ResponseData;
import com.example.clientsd.app.data.login.LoginRequestData;
import com.example.clientsd.app.data.logout.LogoutRequestData;
import com.example.clientsd.app.packages.BasePackage;
import com.example.clientsd.app.packages.login.LoginResponse;
import com.example.clientsd.app.packages.logout.LogoutResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginRepository {

    private App app;
    Properties properties = new Properties();
    public LoginRepository(App app) {
        this.app =  app;

    }

    public boolean login(String email, String password) {
        ResponseData data = new LoginRequestData(email,password);
        BasePackage request = new BasePackage("login",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitLoginResponse(email);
    }

    private boolean waitLoginResponse(String email){
        LoginResponse response;
        String response_data;
        while (true)
        {
            try {
                if ((response_data = app.getIn().readLine()) != null) {
                    response = LoginResponse.fromJson(response_data, LoginResponse.class);
                    if (response.isError()) return false;
                    properties.setProperty("current_user_token", response.getData().getToken());
                    properties.store(new FileOutputStream("tokens.properties"), null);
                    return true;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private boolean waitLogoutResponse(){
        LogoutResponse response;
        String response_data;
        while (true)
        {
            try {
                if ((response_data = app.getIn().readLine()) != null) {
                    response = LogoutResponse.fromJson(response_data, LogoutResponse.class);
                    if (response.isError()) return false;
                    properties.remove("current_user_token");
                    System.out.println("deslogou");
                    return true;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void logout(){
        String token =  properties.getProperty("current_user_token");
        ResponseData data = new LogoutRequestData(token);
        BasePackage request = new BasePackage("logout",data);
        app.getOut().println(request.toString());
        waitLogoutResponse();
    }
}
