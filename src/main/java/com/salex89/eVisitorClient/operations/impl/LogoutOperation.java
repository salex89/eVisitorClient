package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.PostOperation;

/**
 * Created by aleksandar on 5/23/16.
 */
public class LogoutOperation extends PostOperation {

    public LogoutOperation(String cookies) {
        super("", cookies);

    }

    protected String url() {
        return "https://www.evisitor.hr/testApi/Resources/AspNetFormsAuth/Authentication/Logout";
    }
}
