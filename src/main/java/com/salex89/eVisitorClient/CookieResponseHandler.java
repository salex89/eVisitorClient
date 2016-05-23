package com.salex89.eVisitorClient;

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
