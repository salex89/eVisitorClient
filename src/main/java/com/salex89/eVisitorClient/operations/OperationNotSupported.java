package com.salex89.eVisitorClient.operations;

/**
 * Created by aleksandar on 5/23/16.
 */
public class OperationNotSupported extends RuntimeException {
    private final String operation;

    public OperationNotSupported(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
