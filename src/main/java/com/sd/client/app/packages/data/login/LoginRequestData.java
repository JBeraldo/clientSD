package com.sd.client.app.packages.data.login;

import com.sd.client.app.base.PackageData;
import org.apache.commons.codec.digest.DigestUtils;

public class LoginRequestData extends PackageData {
    private String email;
    private String password;

    public LoginRequestData(){
    }

    public LoginRequestData(String email, String password) {
        this.email = email;
        this.password = passwordMD5(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String passwordMD5(String password) {
        return DigestUtils.md5Hex(password).toUpperCase();
    }
}
