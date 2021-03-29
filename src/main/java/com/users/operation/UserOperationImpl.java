package com.users.operation;

import com.users.file.Writer;
import com.users.model.User;
import com.users.service.UserStorageService;
import lombok.Data;

import java.util.List;
import java.util.Scanner;

@Data
public class UserOperationImpl implements UserOperation {

    private UserStorageService userStorageService;
    private Writer writer;

    public UserOperationImpl(UserStorageService userStorageService) {
        this.userStorageService = userStorageService;
    }

    public UserOperationImpl(UserStorageService userStorageService, Writer writer) {
        this.userStorageService = userStorageService;
        this.writer = writer;
    }

    @Override
    public void exit() {
        if (writer == null) {
            System.out.println("Operation EXIT completed successfully");
        } else {
            writer.write(userStorageService.getAll());
            System.out.println("File write EXIT completed successfully");
        }
    }

    @Override
    public void get(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        User user = userStorageService.get(username);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Username not found!");
        }
    }

    @Override
    public void add(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        User user = new User(name, username);
        boolean isAdd = userStorageService.add(user);
        if (isAdd) {
            System.out.println("User added completely");
        }
    }

    @Override
    public void getAll() {
        System.out.println("All users");
        List<User> users = userStorageService.getAll();
        System.out.println(users);
    }

    @Override
    public void remove(Scanner scanner) {
        System.out.print("Enter username: ");
        User user = userStorageService.get(scanner.nextLine());
        if (user != null) {
            userStorageService.remove(user);
            System.out.println("User removed");
        } else {
            System.out.println("Username not found!");
        }
    }

    @Override
    public void update(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        User user = userStorageService.get(username);
        if (user != null) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            user.setName(name);
        } else {
            System.out.println("Username not found!");
        }
    }
}
