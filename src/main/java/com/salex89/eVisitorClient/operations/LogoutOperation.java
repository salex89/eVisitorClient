package com.salex89.eVisitorClient.operations;

/**
 * Created by aleksandar on 5/23/16.
 */
public class LogoutOperation extends AbstractPostOperation {

    public LogoutOperation(String cookies) {
        super("", cookies);

    }

    protected String url() {
        return "https://www.evisitor.hr/testApi/Resources/AspNetFormsAuth/Authentication/Logout";
    }
}
