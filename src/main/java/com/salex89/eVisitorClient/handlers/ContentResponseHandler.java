package com.salex89.eVisitorClient.handlers;

import com.salex89.eVisitorClient.operations.ServerResponse;

/**
 * Created by aleksandar on 5/23/16.
 */
public class ContentResponseHandler extends AbstractFileOutputHandler {
    public ContentResponseHandler(String outputPath) {
        super(outputPath);
    }

    protected String responseToString(ServerResponse response) {
        return response.getContents();
    }
}
