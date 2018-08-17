package com.example.user.mvc.login;

import android.support.annotation.StringRes;

public class LoginContract {
    public interface View{

        String getUsername();

        void setEmptyUsernameErrorMessage(@StringRes int resId);

        String getPassword();

        void setEmptyPasswordErrorMessage(@StringRes int resId);

        void startMainActivity();

        void showUnsuccessfullLoginError();
    }
}
