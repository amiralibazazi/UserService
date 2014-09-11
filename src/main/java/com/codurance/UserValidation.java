package com.codurance;

public class UserValidation {
    boolean returnValidityOf(User user) {
        return (user.getFirstName() != "" && user.getLastName() != "");
    }
}
