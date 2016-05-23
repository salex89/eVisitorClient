package com.salex89.eVisitorClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by aleksandar on 5/23/16.
 */
public class GetTouristsCommand implements Command {
    private final String cookies;
    private final String url = "https://www.evisitor.hr/testApi/Rest/Htz/Tourist/";

    public GetTouristsCommand(String cookies) {
        this.cookies = cookies;
    }

    public ServerResponse execute() {
        Response response;
        try {
            response = Request.Get(url).addHeader("Cookie", cookies).execute();
            HttpResponse httpResponse = response.returnResponse();
            String content = EntityUtils.toString(httpResponse.getEntity());
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            return new ServerResponseImpl(content, cookies, statusCode);
        } catch (IOException e) {
            throw new CommandException(e);
        }
    }
}
