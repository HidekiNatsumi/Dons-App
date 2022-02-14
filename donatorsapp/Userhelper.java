package com.example.donatorsapp;

public class Userhelper {
    String username, name, password, email, phoneNr;
    public Userhelper() {
    }

    public Userhelper(String username, String name, String password, String email, String phoneNr) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNr = phoneNr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }


}