package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.GetOperation;

/**
 * Created by aleksandar on 5/25/16.
 */
public class ArrivalOrganizationLookup extends GetOperation {


    public ArrivalOrganizationLookup(String cookies, String baseUrl) {
        super(cookies, baseUrl);
    }

    public String path() {
        return "Htz/ArrivalOrganisationLookup/";
    }
}
