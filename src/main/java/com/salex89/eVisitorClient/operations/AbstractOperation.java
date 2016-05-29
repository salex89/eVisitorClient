package com.salex89.eVisitorClient.operations;

/**
 * Created by aleksandar on 5/29/16.
 */
public abstract class AbstractOperation implements Operation {
    protected final String cookies;
    protected final String baseUrl;

    protected AbstractOperation(String cookies, String baseUrl) {
        this.cookies = cookies;
        this.baseUrl = baseUrl;
    }

    protected String url() {
        return this.baseUrl + path();
    }

    public String getCookies() {
        return cookies;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public abstract String path();
}
