package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.ResponseData;
import com.sd.client.app.models.User;

import java.util.ArrayList;

public class GetUserResponseData extends ResponseData {
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public GetUserResponseData() {
    }

    public GetUserResponseData(ArrayList<User> users) {
        this.users = users;
    }
}
