package com.codurance;

public class UserValidation {

    private final String emailRegex = "\\w+" + "@" + "\\w+\\." + "com";

    boolean returnValidityOf(User user) {
        return nameValidityOf(user) && emailValidityOf(user) && ageValidityOf(user);
    }

    private boolean ageValidityOf(User user) {
        if(user.getAge() >= 18) {
            return true;
        } else {
            throw new RuntimeException("User is not of age, user's age is = " + user.getAge());
        }
    }

    private boolean emailValidityOf(User user) {
        if (user.getEmail().matches(emailRegex)) {
            return true;
        } else {
            throw new RuntimeException("User email was not valid");
        }
    }

    private boolean nameValidityOf(User user) {
        if (user.getFirstName() != "" && user.getLastName() != "") {
            return true;
        } else {
            throw new RuntimeException("User name was not valid");
        }
    }
}
