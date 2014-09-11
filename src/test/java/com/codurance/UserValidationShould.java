package com.codurance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserValidationShould {


    private static final User VALID_NEW_USER = new User(0, "sandro", "mancuso", "sandro@codurance.com");
    private static final User USER_WITH_INVALID_NAME = new User(1, "", "", "amir@codurance.com"); //too many parameters?
    private UserValidation userValidation = new UserValidation();

    @Test public void
    check_if_a_user_has_a_valid_name() {
        assertThat(userValidation.returnValidityOf(VALID_NEW_USER), is(true));
    }

    @Test public void
    check_if_a_user_has_an_invalid_name() {
        assertThat(userValidation.returnValidityOf(USER_WITH_INVALID_NAME), is(false));
    }
}
