package com.sd.client.app.base;

import com.sd.client.app.App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseRepository {
    protected App app;
    protected static Properties properties = new Properties();

    static {
        FileInputStream file = null;
        try {
            file = new FileInputStream("tokens.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BaseRepository(App app) {
        this.app =  app;
    }

}
