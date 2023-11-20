package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.User;

public class FindUserPackageData extends PackageData {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FindUserPackageData() {
    }

    public FindUserPackageData(User user) {
        this.user = user;
    }
}
