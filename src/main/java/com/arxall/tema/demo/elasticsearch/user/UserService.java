package com.arxall.tema.demo.elasticsearch.user;

public interface UserService {
    User createUser(User user);

    User updateUser(User user);

    Iterable<User> getAllUsers();

    User getUserById(long id);

    void deleteUser(long id);
}
