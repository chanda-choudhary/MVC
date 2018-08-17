package com.example.user.mvc.login;

import com.example.user.mvc.R;

class LoginPresenter {
    private final LoginContract.View view;
    private final LoginApi loginApi;

    public LoginPresenter(LoginContract.View view, LoginApi loginApi) {
        this.view = view;
        this.loginApi = loginApi;
    }

    public void onLoginButtonClick() {
        String username=view.getUsername();
        if (username.isEmpty()){
            view.setEmptyUsernameErrorMessage(R.string.empty_username_error);
            return;
        }
        String password=view.getPassword();
        if (password.isEmpty()){
            view.setEmptyPasswordErrorMessage(R.string.empty_password_error);
            return;
        }
        if (loginApi.authenticate(username,password)){
            view.startMainActivity();
            return;
        }
        view.showUnsuccessfullLoginError();
    }
}
