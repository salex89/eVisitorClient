package com.salex89.eVisitorClient.operations.impl;


import com.salex89.eVisitorClient.operations.GetOperation;

/**
 * Created by aleksandar on 5/23/16.
 */
public class GetTouristsOperation extends GetOperation {

    public GetTouristsOperation(String cookies) {
        super(cookies);
    }

    public String url() {
        return "https://www.evisitor.hr/testApi/Rest/Htz/ListOfTourists/";
    }


}
