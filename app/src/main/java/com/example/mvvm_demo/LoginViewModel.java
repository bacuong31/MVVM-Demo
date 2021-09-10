package com.example.mvvm_demo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.example.mvvm_demo.BR;
import com.example.mvvm_demo.Model.User;

public class LoginViewModel extends BaseObservable {
    private String email;
    private String password;
    public ObservableField<String> messageLogin = new ObservableField<>();
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
    public void onClickLogin(){
        User user = new User(getEmail(),getPassword());
        if(user.isValidEmail() && user.isValidPassword()){
            messageLogin.set("Login success!");
        } else {
            messageLogin.set("Email or Password is invalid!");
        }
    }
}
