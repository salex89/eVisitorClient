package com.salex89.eVisitorClient;

/**
 * Created by aleksandar on 5/23/16.
 */
public class CommandExecutor {
    private final Command command;
    private final OutputHandler handler;

    public CommandExecutor(Command command, OutputHandler handler) {
        this.command = command;
        this.handler = handler;
    }

    public void execute() {
        ServerResponse response = command.execute();
        handler.handle(response);
    }

}
