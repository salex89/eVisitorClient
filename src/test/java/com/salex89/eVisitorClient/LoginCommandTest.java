package com.salex89.eVisitorClient;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleksandar on 5/23/16.
 */
public class LoginCommandTest {
    @Test
    public void collapseCookieHeader() throws Exception {
        LoginCommand loginCommand = new LoginCommand("payload");
        Header[] headers = new Header[3];
        headers[0] = new BasicHeader("foo", "bar");
        headers[1] = new BasicHeader("baz", "earth");
        headers[2] = new BasicHeader("kung", "foo");
        String collapsed = loginCommand.collapseCookieHeader(headers);
        assertEquals("bar;earth;foo", collapsed);
    }

}