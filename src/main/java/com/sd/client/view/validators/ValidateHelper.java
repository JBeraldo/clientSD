package com.sd.client.view.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHelper {
    public static boolean isValidEmail(String email) {
        // Basic email validation using regex
        String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
