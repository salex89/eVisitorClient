package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.Operation;
import com.salex89.eVisitorClient.operations.OperationException;
import com.salex89.eVisitorClient.operations.ServerResponse;
import com.salex89.eVisitorClient.operations.ServerResponseImpl;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by aleksandar on 5/23/16.
 */
public class LoginOperation implements Operation {

    private final String payload;
    private final String url = "https://www.evisitor.hr/testApi/Resources/AspNetFormsAuth/Authentication/Login";

    public LoginOperation(String payload) {
        this.payload = payload;
    }

    public ServerResponse execute() {
        Response response;
        try {
            response = Request.Post(url).
                    bodyString(payload, ContentType.APPLICATION_JSON)
                    .execute();
            HttpResponse httpResponse = response.returnResponse();
            String content = EntityUtils.toString(httpResponse.getEntity());
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String cookies = collapseCookieHeader(httpResponse.getHeaders("Set-Cookie"));
            return new ServerResponseImpl(content, cookies, statusCode);
        } catch (IOException e) {
            throw new OperationException(e);
        }
    }

    protected String collapseCookieHeader(Header[] headers) {
        StringBuilder cookies = new StringBuilder();
        for (int i = 0; i < headers.length; i++) {
            cookies.append(headers[i].getValue());
            if (i < headers.length - 1)
                cookies.append(';');
        }
        return cookies.toString();
    }
}
