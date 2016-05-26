package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.Operation;
import com.salex89.eVisitorClient.operations.ServerResponse;
import com.salex89.eVisitorClient.operations.ServerResponseImpl;

import java.util.UUID;

/**
 * Created by aleksandar on 5/26/16.
 */
public class CreateGuidOperation implements Operation {
    public CreateGuidOperation() {
    }

    public ServerResponse execute() {
        String guid = UUID.randomUUID().toString();
        return new ServerResponseImpl(guid, null, 200);
    }
}
