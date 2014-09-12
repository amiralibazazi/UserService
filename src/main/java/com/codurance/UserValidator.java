package com.codurance;

public class UserValidator {

    private final String emailRegex = "\\w+" + "@" + "\\w+\\." + "com";

    public boolean isValid(User user) {
        return hasValidName(user) && hasValidEmail(user) && hasValidAge(user);
    }

    private boolean hasValidAge(User user) {  //avoid repetition with lambda functions?
        if(user.getAge() >= 18) {
            return true;
        } else {
            throw new RuntimeException("User is not of age, user's age is = " + user.getAge());
        }
    }

    private boolean hasValidEmail(User user) {
        if (user.getEmail().matches(emailRegex)) {
            return true;
        } else {
            throw new RuntimeException("User email was not valid");
        }
    }

    private boolean hasValidName(User user) {
        if (user.getFirstName() != "" && user.getLastName() != "") {
            return true;
        } else {
            throw new RuntimeException("User name was not valid");
        }
    }
}
