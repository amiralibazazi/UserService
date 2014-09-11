package com.codurance;

import java.util.Calendar;

public class User {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String dateOfBirth;
    Calendar now;
    private final int CURRENT_YEAR = now.getInstance().get(Calendar.YEAR);

    public User(int id, String firstName, String lastName, String emailAddress, String dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;

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

    public int getAge() {
       String[] ddMMyy = dateOfBirth.split("/");
       return CURRENT_YEAR - Integer.parseInt(ddMMyy[2]);
    }
}
