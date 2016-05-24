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
        StringBuilder builder = new StringBuilder();
        if (response.getStatus() != 200) {
            builder.append("ERROR");
            builder.append('\n');
            builder.append(response.getContents());
        }
        builder.append(response.getCookies());
        return builder.toString();
    }
}
