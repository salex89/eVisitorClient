package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.GetOperation;

/**
 * Created by aleksandar on 5/30/16.
 */
public class VisaTypeLookup extends GetOperation {

    public VisaTypeLookup(String cookies, String baseUrl) {
        super(cookies, baseUrl);
    }

    public String path() {
        return "Htz/VisaTypeLookup/";
    }
}
