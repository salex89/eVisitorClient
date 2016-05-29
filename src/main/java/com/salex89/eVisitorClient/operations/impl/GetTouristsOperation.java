package com.salex89.eVisitorClient.operations.impl;


import com.salex89.eVisitorClient.operations.GetOperation;

/**
 * Created by aleksandar on 5/23/16.
 */
public class GetTouristsOperation extends GetOperation {


    public GetTouristsOperation(String cookies, String baseUrl) {
        super(cookies, baseUrl);
    }

    public String path() {
        return "Htz/ListOfTourists/";
    }


}
