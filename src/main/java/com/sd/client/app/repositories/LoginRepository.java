package com.sd.client.app.repositories;

import com.sd.client.app.App;
import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.ResponseData;
import com.sd.client.app.data.login.LoginRequestData;
import com.sd.client.app.data.logout.LogoutRequestData;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.packages.login.LoginResponse;
import com.sd.client.app.packages.logout.LogoutResponse;
import com.sd.client.view.base.ValidationResponse;
import com.sd.client.view.base.Validator;
import com.sd.client.view.login.LoginValidator;

import java.io.FileOutputStream;
import java.io.IOException;

public class LoginRepository extends BaseRepository {

    public LoginRepository(App app) {
        super(app);
    }

    public boolean login(String email, String password) {
        ValidationResponse validationResponse = LoginValidator.validate(password,email);
        if (validationResponse.isError()){
            Validator.errorAlert(validationResponse);
            return false;
        }
        ResponseData data = new LoginRequestData(email,password);
        BasePackage request = new BasePackage("login",data);
        String json = request.toString();
        super.app.getOut().println(json);
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
                    super.properties.setProperty("current_user_token", response.getData().getToken());
                    super.properties.store(new FileOutputStream("tokens.properties"), null);
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
