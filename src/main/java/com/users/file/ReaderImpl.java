package com.users.file;

import com.users.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<User> read(String path) {
        try {
            FileInputStream f = new FileInputStream(path);
            ObjectInputStream o = new ObjectInputStream(f);

            List<User> users = (List<User>) o.readObject();

            if (users == null) {
                users = new ArrayList<>();
            }

            o.close();
            f.close();
            return users;
        } catch (IOException | ClassNotFoundException exc) {
            exc.printStackTrace();
        }
        return new ArrayList<>();
    }
}
