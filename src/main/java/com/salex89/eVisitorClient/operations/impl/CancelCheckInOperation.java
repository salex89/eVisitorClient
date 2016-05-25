package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.PostOperation;

/**
 * Created by aleksandar on 5/25/16.
 */
public class CancelCheckInOperation extends PostOperation {
    public CancelCheckInOperation(String payload, String cookies) {
        super(payload, cookies);
    }

    protected String url() {
        return "https://www.evisitor.hr/testApi/Rest/Htz/CancelTouristCheckIn/";
    }
}
