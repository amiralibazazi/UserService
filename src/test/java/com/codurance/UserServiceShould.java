package com.codurance;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceShould {
    private static final User NEW_USER = new User(0);
    private static final User EXISTING_USER = new User(1);
    private UserRepository userRepository;
    private UserService userService;

    @Before
    public void initialise() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test public void
    create_a_user() {
        userService.save(NEW_USER);
        verify(userRepository).create(NEW_USER);
    }

    @Test public void
    update_a_user_if_it_already_exists() {
        userService.save(EXISTING_USER);
        verify(userRepository).update(EXISTING_USER);
    }
}