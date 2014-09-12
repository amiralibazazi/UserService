package com.codurance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserValidationShould {
    private static final User VALID_NEW_USER = new User(0, "sandro", "mancuso", "sandro@codurance.com", "24/06/1956");
    private static final User USER_WITH_INVALID_EMAIL = new User(1, "amir", "bazazi", "amir.com", "24/06/1956"); //too many parameters?
    private static final User USER_WITH_INVALID_NAME = new User(1, "", "", "amir@codurance.com", "24/06/1956"); //too many parameters?
    private static final User USER_UNDERAGE = new User(1, "sandro", "mancuso", "sandro@sandro.com", "24/06/2010");
    private UserValidator userValidation = new UserValidator();

    @Test(expected=RuntimeException.class) public void
    throw_an_exception_if_user_name_is_invalid() {
        userValidation.isValid(USER_WITH_INVALID_NAME);
    }

    @Test(expected = RuntimeException.class) public void
    throw_an_exception_if_user_email_invalid() {
        userValidation.isValid(USER_WITH_INVALID_EMAIL);
    }

    @Test public void
    check_if_a_user_is_completely_valid() {
        assertThat(userValidation.isValid(VALID_NEW_USER), is(true));
    }

    @Test(expected=RuntimeException.class) public void
    throws_an_exception_if_user_under_18_years_old() {
        userValidation.isValid(USER_UNDERAGE);
    }
}
