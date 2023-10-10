package com.sd.client.app.repositories;

import com.sd.client.app.App;
import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.ResponseData;
import com.sd.client.app.package_data.user.CreateUserRequestData;
import com.sd.client.app.models.User;
import com.sd.client.app.packages.BasePackage;

public class UserRepository extends BaseRepository {
    public UserRepository(App app) {
        super(app);
    }

    public boolean create(User new_usr){
        ResponseData data = new CreateUserRequestData(new_usr,properties.getProperty("current_user_token"));
        BasePackage request = new BasePackage("criar-usuario",data);
        String json = request.toString();
        super.app.getOut().println(json);
        return true;
    }
}
