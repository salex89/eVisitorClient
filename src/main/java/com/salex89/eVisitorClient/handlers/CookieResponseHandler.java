package com.salex89.eVisitorClient.handlers;

import com.salex89.eVisitorClient.operations.ServerResponse;

/**
 * Created by aleksandar on 5/23/16.
 */
public class CookieResponseHandler extends AbstractFileOutputHandler {
    public CookieResponseHandler(String outputPath) {
        super(outputPath);
    }

    protected String responseToString(ServerResponse response) {
        return response.getCookies();
    }
}
