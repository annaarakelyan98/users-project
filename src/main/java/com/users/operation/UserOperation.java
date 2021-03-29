package com.users.operation;

import com.users.model.User;

import java.util.List;
import java.util.Scanner;

public interface UserOperation {
    void exit();

    void get(Scanner scanner);

    void add(Scanner scanner);

    void getAll();

    void remove(Scanner scanner);

    void update(Scanner scanner);
}
