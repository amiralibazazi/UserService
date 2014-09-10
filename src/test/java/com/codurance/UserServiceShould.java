package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceShould {
    private static final User VALID_NEW_USER = new User(0, "sandro", "mancuso", "sandro@codurance.com");
    private static final User VALID_EXISTING_USER = new User(1, "amir", "bazazi", "amir@codurance.com"); //too many parameters?
    private static final User USER_WITH_INVALID_NAME = new User(1, "", "", "amir@codurance.com"); //too many parameters?
    private static final User USER_WITH_INVALID_EMAIL = new User(1, "toby", "retalick", "tobycodurance"); //too many parameters?
    private UserRepository userRepository;
    private UserService userService;
    private UserValidation userValidation;

    @Before
    public void initialise() {
        userRepository = mock(UserRepository.class);
        userValidation = mock(UserValidation.class);
        userService = new UserService(userRepository, userValidation);
        when(userValidation.checkValidityOf(VALID_EXISTING_USER)).thenReturn(true);
        when(userValidation.checkValidityOf(VALID_NEW_USER)).thenReturn(true);
    }

    @Test public void
    create_a_user() {
        userService.save(VALID_NEW_USER);
        verify(userRepository).create(VALID_NEW_USER);
    }

    @Test public void
    update_a_user_if_it_already_exists() {
        userService.save(VALID_EXISTING_USER);
        verify(userRepository).update(VALID_EXISTING_USER);
    }

    @Test public void
    create_a_user_if_valid() {  //should we name this something different?
//        when(userValidation.checkValidityOf(USER_WITH_INVALID_NAME)).thenReturn(false);
//        when(userValidation.checkValidityOf(USER_WITH_INVALID_EMAIL)).thenReturn(false);
        userService.save(VALID_EXISTING_USER);
        verify(userRepository).update(VALID_EXISTING_USER);
    }
}