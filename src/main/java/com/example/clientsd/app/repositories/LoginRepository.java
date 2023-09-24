package com.example.clientsd.app.repositories;

import com.example.clientsd.app.App;
import com.example.clientsd.app.data.login.LoginData;
import com.example.clientsd.app.packages.BasePackage;

public class LoginRepository {

    public void login(String email,String password) throws InterruptedException {
        LoginData data = new LoginData(email,password);
        BasePackage request = new BasePackage("login",data);
        App.sendPackage(request);
    }
    public void logout(){

    }
}
