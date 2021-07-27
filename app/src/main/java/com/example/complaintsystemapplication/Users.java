package com.example.complaintsystemapplication;

public class Users {
    public String name;
    public String number;
    public String email;
    public String password;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Users() {
    }

    public Users(String name, String number, String email, String password) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
    }
}
