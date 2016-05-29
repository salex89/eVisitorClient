package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.GetOperation;

/**
 * Created by aleksandar on 5/29/16.
 */
public class BorderCrossingLookup extends GetOperation {

    public BorderCrossingLookup(String cookies) {
        super(cookies);
    }

    public String url() {
        return "https://www.evisitor.hr/testApi/Rest/Htz/BorderCrossingHRlookup/";
    }
}
