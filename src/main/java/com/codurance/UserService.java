package com.codurance;

public class UserService {

    private UserRepository userRepository;
    private UserValidation userValidation;

    public UserService(UserRepository userRepository, UserValidation userValidation) {
        this.userRepository = userRepository;
        this.userValidation = userValidation;
    }

    public void save(User user) {
        if(userValidation.checkValidityOf(user)) {
            if (user.getId() == 0) {
                userRepository.create(user);
            } else {
                userRepository.update(user);
            }
        }
    }
}