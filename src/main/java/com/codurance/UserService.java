package com.codurance;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        if (user.getId()==0) {
            userRepository.create(user);
        } else {
            userRepository.update(user);
        }
    }
}