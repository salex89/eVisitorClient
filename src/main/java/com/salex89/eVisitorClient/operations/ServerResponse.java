package com.salex89.eVisitorClient.operations;

/**
 * Created by aleksandar on 5/23/16.
 */
public interface ServerResponse {
    String getContents();

    String getCookies();

    int getStatus();
}
