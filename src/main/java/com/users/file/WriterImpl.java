package com.users.file;

import com.users.model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriterImpl implements Writer {
    private String path;

    public WriterImpl(String path) {
        this.path = path;
    }

    @Override
    public void write(List<User> list) {
        try {
            FileOutputStream f = new FileOutputStream(path);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(list);

            o.close();
            f.close();
            System.out.println("Users by size: " + list.size() + " saved in file: " + path);
        } catch (IOException ec) {
            ec.printStackTrace();
        }
    }
}
