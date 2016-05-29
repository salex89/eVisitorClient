package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.PostOperation;

/**
 * Created by aleksandar on 5/25/16.
 */
public class CancelCheckInOperation extends PostOperation {


    public CancelCheckInOperation(String payload, String cookies, String baseUrl) {
        super(payload, cookies, baseUrl);
    }

    public String path() {
        return "Htz/CancelTouristCheckIn/";
    }

}
