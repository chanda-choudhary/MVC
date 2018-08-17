package com.example.user.mvc.login;

public class LoginApi {
    private final String USER_NAME="chanda";
    private final String PASSWORD="123456";

    public boolean authenticate(String username,String password)
    {
        if (USER_NAME.equals(username) && PASSWORD.equals(password))
            return true;
        return false;
    }
}
