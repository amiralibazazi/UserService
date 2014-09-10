package com.codurance;

public interface UserRepository {

    void create(User user);

    void update(User existingUser);
}
