package com.salex89.eVisitorClient.handlers;

import com.salex89.eVisitorClient.operations.ServerResponse;

/**
 * Created by aleksandar on 5/23/16.
 */
public interface OutputHandler {
    void handle(ServerResponse response);
}
