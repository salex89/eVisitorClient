package com.salex89.eVisitorClient.operations;

/**
 * Created by aleksandar on 5/23/16.
 */
public class ServerResponseImpl implements ServerResponse {

    private final String contents;
    private final String cookies;
    private final int status;

    public ServerResponseImpl(String contents, String cookies, int status) {
        this.contents = contents;
        this.cookies = cookies;
        this.status = status;
    }

    public String getContents() {
        return contents;
    }

    public String getCookies() {
        return cookies;
    }

    public int getStatus() {
        return status;
    }
}
