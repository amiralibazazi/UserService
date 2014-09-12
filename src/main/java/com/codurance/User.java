package com.codurance;

import java.util.Calendar;

public class User {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String dateOfBirth;
    private Calendar now;
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
       String[] DdMmYy = dateOfBirth.split("/");
       return CURRENT_YEAR - Integer.parseInt(DdMmYy[2]);
    }

    public boolean isNew() {
        return getId() == 0;
    }
}
