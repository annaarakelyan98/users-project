package com.users.storage;

import com.users.file.Reader;
import com.users.model.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    @Getter
    private List<User> userList;
    private Reader reader;

    public UserStorage() {
        userList = new ArrayList<>();
    }

    public UserStorage(String path, Reader reader) {
        this.reader = reader;
        userList = reader.read(path);
    }
}
