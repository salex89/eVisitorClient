package com.salex89.eVisitorClient.operations;


/**
 * Created by aleksandar on 5/23/16.
 */
public class GetTouristsOperation extends AbstractGetOperation {

    public GetTouristsOperation(String cookies) {
        super(cookies);
    }

    public String url() {
        return "https://www.evisitor.hr/testApi/Rest/Htz/Tourist/";
    }


}
