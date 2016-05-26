package com.salex89.eVisitorClient;

import com.beust.jcommander.Parameter;

import static com.salex89.eVisitorClient.CommandStrings.*;

/**
 * Created by aleksandar on 5/23/16.
 */
public class JCommanderContainer {
    @Parameter(names = "--operation",
            description = "Operation to execute. Possible choices: \n\t" +
                    LOGIN + "\n\t" +
                    LOGOUT + "\n\t" +
                    CHECKIN + "\n\t" +
                    CHECKOUT + "\n\t" +
                    CANCEL_CHECKIN + "\n\t" +
                    GET_TOURISTS + "\n\t" +
                    DOCUMENT_TYPE_LOOKUP + "\n\t" +
                    COUNTRY_LOOKUP + "\n\t" +
                    PAYMENT_CATEGORY_LOOKUP + "\n\t" +
                    ARRIVAL_ORGANIZATION_LOOKUP + "\n\t" +
                    GUID,
            required = true,
            arity = 1
    )
    private String operation;

    @Parameter(names = "--input",
            description = "Input file. Content depends on the command.",
            arity = 1
    )
    private String inputFilePath = "";

    @Parameter(names = "--output",
            description = "Output file. Content depends on the command.",
            required = true,
            arity = 1
    )
    private String outputFilePath = "";

    @Parameter(names = "--cookieFile",
            description = "File with cookie content. Needed for every operation except login.",
            arity = 1
    )
    private String cookieFile = "";

    public String getOperation() {
        return operation;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public String getCookieFile() {
        return cookieFile;
    }
}
