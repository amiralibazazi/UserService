package com.codurance;

public class User {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;

    public User(int id, String firstName, String lastName, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return emailAddress;
    }
}
