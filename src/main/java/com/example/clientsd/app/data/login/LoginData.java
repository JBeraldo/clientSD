package com.example.clientsd.app.data.login;

import com.example.clientsd.app.base.ResponseData;
import org.apache.commons.codec.digest.DigestUtils;


public class LoginData extends ResponseData {
    private String email;
    private String password;

    public LoginData(String email, String password) {
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
