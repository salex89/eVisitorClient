package com.salex89.eVisitorClient;

/**
 * Created by aleksandar on 5/23/16.
 */
public class CallNotSupportedOperation extends RuntimeException {
    private final String operation;

    public CallNotSupportedOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
