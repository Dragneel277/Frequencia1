package com.example.frequencia1;

public class User {
    private String username;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String birthdate;
    private String gender;

    public User(String username, String password, String name, String phoneNumber, String email, String birthdate, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }
}
