package com.example.user.mvc.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.mvc.R;
import com.example.user.mvc.home.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View{


    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private LoginPresenter mLoginPresenter;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login,container,false);
        mUsernameEditText=view.findViewById(R.id.FragmentLogin_username_edittext);
        mPasswordEditText=view.findViewById(R.id.FragmentLogin_password_edittext);
        mLoginButton=view.findViewById(R.id.FragmentLogin_login_button);
        mLoginButton.setOnClickListener(mLoginButtonClickListener);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoginPresenter=new LoginPresenter(this,new LoginApi());
    }

    private View.OnClickListener mLoginButtonClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mLoginPresenter.onLoginButtonClick();
        }
    };

    @Override
    public String getUsername() {
        return mUsernameEditText.getText().toString();
    }

    @Override
    public void setEmptyUsernameErrorMessage(int resId) {
        mUsernameEditText.setError(getString(resId));
    }

    @Override
    public String getPassword() {
        return mPasswordEditText.getText().toString();
    }

    @Override
    public void setEmptyPasswordErrorMessage(int resId) {
        mPasswordEditText.setError(getString(resId));
    }

    @Override
    public void startMainActivity() {
        Intent intent=new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void showUnsuccessfullLoginError() {
        Toast.makeText(getContext(), R.string.username_or_password_incorrect,Toast.LENGTH_LONG).show();
    }
}
