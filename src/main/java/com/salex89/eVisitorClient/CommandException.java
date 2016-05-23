package com.salex89.eVisitorClient;

import java.io.IOException;

/**
 * Created by aleksandar on 5/23/16.
 */
public class CommandException extends RuntimeException {
    public CommandException(Throwable e) {
        super(e);
    }
}
