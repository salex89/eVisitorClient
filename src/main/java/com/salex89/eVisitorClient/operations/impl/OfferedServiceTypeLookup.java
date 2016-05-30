package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.GetOperation;

/**
 * Created by aleksandar on 5/30/16.
 */
public class OfferedServiceTypeLookup extends GetOperation {
    public OfferedServiceTypeLookup(String cookies, String resourceUrl) {
        super(cookies, resourceUrl);
    }

    public String path() {
        return "Htz/OfferedServiceTypeLookup/";
    }
}
