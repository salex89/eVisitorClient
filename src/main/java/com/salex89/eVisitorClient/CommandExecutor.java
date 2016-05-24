package com.salex89.eVisitorClient;

import com.salex89.eVisitorClient.handlers.OutputHandler;
import com.salex89.eVisitorClient.operations.Operation;
import com.salex89.eVisitorClient.operations.ServerResponse;

/**
 * Created by aleksandar on 5/23/16.
 */
public class CommandExecutor {
    private final Operation operation;
    private final OutputHandler handler;

    public CommandExecutor(Operation operation, OutputHandler handler) {
        this.operation = operation;
        this.handler = handler;
    }

    public void execute() {
        ServerResponse response = operation.execute();
        handler.handle(response);
    }

}
