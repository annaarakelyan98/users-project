package com.users.service;

import com.users.model.User;

import java.util.List;

public interface UserStorageService {
    boolean add(User user);

    User get(String name);

    boolean remove(User user);

    List<User> getAll();
}
