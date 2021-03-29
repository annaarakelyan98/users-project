package com.users.file;

import com.users.model.User;
import java.util.List;

public interface Reader {
    List<User> read(String path);
}
