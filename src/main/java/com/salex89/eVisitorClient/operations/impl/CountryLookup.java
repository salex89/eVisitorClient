package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.GetOperation;

/**
 * Created by aleksandar on 5/25/16.
 */
public class CountryLookup extends GetOperation {


    public CountryLookup(String cookies, String baseUrl) {
        super(cookies, baseUrl);
    }

    public String path() {
        return "Htz/CountryLookup/";
    }
}
