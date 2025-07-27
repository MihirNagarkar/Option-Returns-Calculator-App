package com.example.api;

public class User {
    public String email;
    public String username;
    public String firstName;
    public String lastName;
    public String age;
    public String birthDate;

    // Constructor
    public User(String email, String username, String firstName, String lastName, String age, String birthDate) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }
}
