package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.ResponseData;
import com.sd.client.app.models.User;

public class FindUserResponseData extends ResponseData {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FindUserResponseData() {
    }

    public FindUserResponseData(User user) {
        this.user = user;
    }
}
