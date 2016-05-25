package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.GetOperation;

/**
 * Created by aleksandar on 5/25/16.
 */
public class CountryLookup extends GetOperation {
    public CountryLookup(String cookies) {
        super(cookies);
    }

    public String url() {
        return "https://www.evisitor.hr/testApi/Rest/Htz/CountryLookup/";
    }
}
