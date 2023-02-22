package com.example.advance_registration_form_ch1;

import android.widget.Spinner;

public class User {
    private String Name;
    private String Email;
    private String Pass;
    private String Repass;

    public User() {
    }

    public User(String name, String email, String pass, String repass) {
        Name = name;
        Email = email;
        Pass = pass;
        Repass = repass;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getRepass() {
        return Repass;
    }

    public void setRepass(String repass) {
        Repass = repass;
    }

}
