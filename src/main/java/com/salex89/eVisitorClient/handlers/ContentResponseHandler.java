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
        StringBuilder builder = new StringBuilder();
        if (response.getStatus() == 200) {
            if (response.getContents().contentEquals("")) {
                builder.append("OK");
            }
        } else {
            builder.append("ERROR");
            builder.append('\n');
        }
        builder.append(response.getContents());
        return builder.toString();
    }
}
