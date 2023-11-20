package com.sd.client.app.repositories;

import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.exceptions.ResponseErrorException;
import com.sd.client.app.packages.BaseResponse;
import com.sd.client.app.packages.data.login.LoginRequestData;
import com.sd.client.app.packages.data.login.LoginPackageData;
import com.sd.client.app.packages.data.logout.LogoutRequestData;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.storage.LoggedUser;
import com.sd.client.view.validators.ValidationResponse;
import com.sd.client.view.validators.Validator;
import com.sd.client.view.validators.LoginValidator;

import java.io.IOException;

public class LoginRepository extends BaseRepository {

    public LoginRepository() {
        super();
    }

    public String login(String email, String password) {
        ValidationResponse validationResponse = LoginValidator.validate(password, email);
        if (validationResponse.isError()) {
            Validator.errorAlert(validationResponse);
            return "login/login.fxml";
        }
        PackageData data = new LoginRequestData(email, password);
        BasePackage request = new BasePackage("login", data);
        String json = request.toString();
        super.app.getOut().println(json);
        return waitLoginResponse(email);
    }


    private String waitLoginResponse(String email) {
        BaseResponse<LoginPackageData> response;
        String response_data;
        boolean isAdm;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, LoginPackageData.class);
            LoggedUser.save(response.getData().getToken());
            isAdm = AuthRepository.isAdmin(LoggedUser.token());
        } catch (IOException | ResponseErrorException e) {
            System.out.println(e.getMessage());
            return "login/login.fxml";
        }
        return isAdm ? "menu/menu_admin.fxml" : "menu/menu_user.fxml";
    }

    private boolean waitLogoutResponse() {
        try {
            app.read();
            LoggedUser.clear();
        } catch (IOException | ResponseErrorException e) {
            return false;
        }
        return true;
    }

    public boolean logout() {
        String token = LoggedUser.token();
        PackageData data = new LogoutRequestData(token);
        BasePackage request = new BasePackage("logout", data);
        super.app.getOut().println(request.toString());
        return waitLogoutResponse();
    }
}
