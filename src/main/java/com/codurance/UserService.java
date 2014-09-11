package com.codurance;

public class UserService {

    private UserRepository userRepository;
    private UserValidation userValidation;

    public UserService(UserRepository userRepository, UserValidation userValidation) {
        this.userRepository = userRepository;
        this.userValidation = userValidation;
    }

    public void save(User user) {
        if(userValidation.returnValidityOf(user)) {
            if (user.getId() == 0) {  //way to remove this nested if statement
                userRepository.create(user);
            } else {
                userRepository.update(user);
            }
        } else throw new RuntimeException("user is not valid");
    }
}