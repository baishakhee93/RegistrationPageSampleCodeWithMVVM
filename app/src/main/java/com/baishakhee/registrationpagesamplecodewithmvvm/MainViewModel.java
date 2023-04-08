package com.baishakhee.registrationpagesamplecodewithmvvm;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class MainViewModel extends BaseObservable {

    public final MainModel model;

    // toast messages
    private String successMessage = "Registred successful";
    private String errorMessage = "Email or password is not valid";
    private String toastMessage = null;

    // constructor of ViewModel class

    @Bindable
    public String getToastMessage() {
        return toastMessage;
    }
    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    private String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    private String getEmail() {
        return model.getEmail();
    }

    public void setEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    private String getPhone() {
        return model.getPhone();
    }

    public void setPhone(String phone) {
        model.setPhone(phone);
        notifyPropertyChanged(BR.phone);
    }

    @Bindable
    private String getPassword() {
        return model.getPassword();
    }

    public void setPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.password);
    }
    public MainViewModel( ){

        // instantiating object of
        // model class
        model = new MainModel("","","","");
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(getEmail()) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
                && getPassword().length() > 5;
    }

    public void onButtonClicked() {
        if (isValid()) {
            setToastMessage(successMessage);

        }
        else {
            setToastMessage(errorMessage);
        }
    }
}
