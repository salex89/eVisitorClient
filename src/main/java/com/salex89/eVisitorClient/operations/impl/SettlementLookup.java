package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.GetOperation;

/**
 * Created by aleksandar on 5/29/16.
 */
public class SettlementLookup extends GetOperation {


    public SettlementLookup(String cookies, String baseUrl) {
        super(cookies, baseUrl);
    }

    public String path() {
        return "Htz/SettlementLookup/";
    }
}
