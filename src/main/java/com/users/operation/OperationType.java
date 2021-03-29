package com.users.operation;

public enum OperationType {
    GET,
    GET_ALL,
    ADD,
    REMOVE,
    UPDATE,
    EXIT;

    public static OperationType findOperation(String operationName){
        for (OperationType o: values()){
            if (o.name().equals(operationName)){
                return o;
            }
        }
        return null;
    }
}
