package com.salex89.eVisitorClient.operations;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by aleksandar on 5/24/16.
 */
public abstract class PostOperation extends AbstractOperation {
    protected final String payload;

    public PostOperation(String payload, String cookies, String baseUrl) {
        super(cookies, baseUrl);
        this.payload = payload;
    }

    public ServerResponse execute() {
        Response response;
        try {
            response = Request.Post(url()).
                    bodyString(payload, ContentType.APPLICATION_JSON).addHeader("Cookie", cookies)
                    .execute();
            HttpResponse httpResponse = response.returnResponse();
            String content = EntityUtils.toString(httpResponse.getEntity());
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            return new ServerResponseImpl(content, cookies, statusCode);
        } catch (IOException e) {
            throw new OperationException(e);
        }
    }

}
