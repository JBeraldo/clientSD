package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.User;

import java.util.ArrayList;

public class GetUserPackageData extends PackageData {
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public GetUserPackageData() {
    }

    public GetUserPackageData(ArrayList<User> users) {
        this.users = users;
    }
}
