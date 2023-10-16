package com.sd.client.app.repositories;

import com.sd.client.app.App;
import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.ResponseData;
import com.sd.client.app.exceptions.ResponseErroException;
import com.sd.client.app.package_data.login.LoginRequestData;
import com.sd.client.app.package_data.logout.LogoutRequestData;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.packages.login.LoginResponse;
import com.sd.client.view.base.ValidationResponse;
import com.sd.client.view.base.Validator;
import com.sd.client.view.login.LoginValidator;

import java.io.FileOutputStream;
import java.io.IOException;

public class LoginRepository extends BaseRepository {

    public LoginRepository(App app) {
        super(app);
    }

    public String login(String email, String password) {
        ValidationResponse validationResponse = LoginValidator.validate(password, email);
        if (validationResponse.isError()) {
            Validator.errorAlert(validationResponse);
            return "login/login.fxml";
        }
        ResponseData data = new LoginRequestData(email, password);
        BasePackage request = new BasePackage("login", data);
        String json = request.toString();
        super.app.getOut().println(json);
        return waitLoginResponse(email);
    }


    private String waitLoginResponse(String email) {
        LoginResponse response;
        String response_data;
        boolean isAdm;
        try {
            response_data = app.read();
            response = LoginResponse.fromJson(response_data, LoginResponse.class);
            properties.setProperty("current_user_token", response.getData().getToken());
            properties.store(new FileOutputStream("tokens.properties"), null);
            isAdm = AuthRepository.isAdmin(response.getData().getToken());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "login/login.fxml";
        } catch (ResponseErroException e) {
            System.out.println(e.getMessage());
            return "login/login.fxml";
        }
        return isAdm ? "menu/menu.fxml" : "menu/menu_user.fxml";
    }

    private boolean waitLogoutResponse() {
        try {
            app.read();
            properties.remove("current_user_token");
        } catch (IOException | ResponseErroException e) {
            return false;
        }
        return true;
    }

    public boolean logout() {
        String token = properties.getProperty("current_user_token");
        ResponseData data = new LogoutRequestData(token);
        BasePackage request = new BasePackage("logout", data);
        app.getOut().println(request.toString());
        return waitLogoutResponse();
    }
}
