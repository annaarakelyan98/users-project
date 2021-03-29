package com.users;

import com.users.file.Reader;
import com.users.file.ReaderImpl;
import com.users.file.Writer;
import com.users.file.WriterImpl;
import com.users.operation.OperationType;
import com.users.operation.UserOperation;
import com.users.operation.UserOperationImpl;
import com.users.service.UserStorageService;
import com.users.service.UserStorageServiceImpl;
import com.users.storage.UserStorage;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final String PATH = "/home/home/storage/users.txt";

    public static void main(String[] args) {
        file();
        /*console();*/
    }

    static void file() {

        Reader reader = new ReaderImpl();
        Writer writer = new WriterImpl(PATH);
        UserStorage userStorage = new UserStorage(PATH, reader);

        UserStorageService userStorageService = new UserStorageServiceImpl(userStorage);
        UserOperation operation = new UserOperationImpl(userStorageService, writer);

        operations(operation);
    }

    static void console() {
        UserStorage userStorage = new UserStorage();

        UserStorageService userStorageService = new UserStorageServiceImpl(userStorage);
        UserOperation operation = new UserOperationImpl(userStorageService);

        operations(operation);
    }

    static void operations(UserOperation operation) {
        Scanner scanner = new Scanner(System.in);
        OperationType operationType;
        do {
            System.out.println("Enter operation from list: " + Arrays.toString(OperationType.values()));
            String operationName = scanner.nextLine();
            operationType = OperationType.findOperation(operationName);
            if (operationType == null) {
                System.out.println("Unknown operation type");
                continue;
            }
            switch (operationType) {
                case GET:
                    operation.get(scanner);
                    break;
                case EXIT:
                    operation.exit();
                    break;
                case ADD:
                    operation.add(scanner);
                    break;
                case GET_ALL:
                    operation.getAll();
                    break;
                case REMOVE:
                    operation.remove(scanner);
                    break;
                case UPDATE:
                    operation.update(scanner);
                    break;
            }
        } while (operationType != OperationType.EXIT);
    }
}
