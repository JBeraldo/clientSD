package com.sd.client.app.storage;

import com.sd.client.app.repositories.AuthRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoggedUser {
    private static final java.util.Properties properties = new java.util.Properties();

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

    public static String token(){
        return properties.getProperty("current_user_token");
    }

    public static Long id() { return AuthRepository.getUserId(token());}

    public static void save(String token) throws IOException {
        properties.setProperty("current_user_token", token);
        properties.store(new FileOutputStream("tokens.properties"), null);

    }
    public static void clear() {
        properties.remove("current_user_token");

    }
}
