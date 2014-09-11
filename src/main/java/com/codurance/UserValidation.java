package com.codurance;

public class UserValidation {
    boolean returnValidityOf(User user) {
        return nameValidityOf(user) && emailValidityOf(user);
    }

    private boolean emailValidityOf(User user) {
        if(user.getEmail().contains("@")) {
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
