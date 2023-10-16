package com.sd.client.app.repositories;

import com.sd.client.app.App;
import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.ResponseData;
import com.sd.client.app.exceptions.ResponseErroException;
import com.sd.client.app.package_data.user.CreateUserRequestData;
import com.sd.client.app.models.User;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.packages.login.LoginResponse;

import java.io.FileOutputStream;
import java.io.IOException;

public class UserRepository extends BaseRepository {
    public UserRepository(App app) {
        super(app);
    }

    public String create(User new_usr){
        ResponseData data = new CreateUserRequestData(new_usr,properties.getProperty("current_user_token"));
        BasePackage request = new BasePackage("cadastro-usuario",data);
        String json = request.toString();
        System.out.println(json);
        super.app.getOut().println(json);
        return waitCreateResponse();
    }

    private String waitCreateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErroException e) {
            return "user/create_user.fxml";
        }
        return "menu/menu.fxml";
    }
}
