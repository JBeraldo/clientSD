package com.sd.client.app.repositories;

import com.sd.client.app.App;

public class AppRepository {
    private static App app;

    public static App getApp() {
        return app;
    }

    public static void setApp(App newApp) {
        app = newApp;
    }
}