package com.codurance;

public class UserService {

    private UserRepository userRepository;
    private UserValidator userValidator;

    public UserService(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public void save(User user) { //way to remove nested if statements?
        if(userValidator.isValid(user)) {
            if (user.isNew()) {
                userRepository.create(user);
            } else {
                userRepository.update(user);
            }
        } else throw new RuntimeException(("user is not valid"));
    }
}