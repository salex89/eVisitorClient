package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.PostOperation;

/**
 * Created by aleksandar on 5/23/16.
 */
public class CheckOutOperation extends PostOperation {

    public CheckOutOperation(String payload, String cookies) {
        super(payload, cookies);
    }

    protected String url() {
        return "https://www.evisitor.hr/testApi/Rest/Htz/CheckOutTourist/";
    }
}
