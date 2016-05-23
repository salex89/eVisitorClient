package com.salex89.eVisitorClient;

import com.beust.jcommander.Parameter;

/**
 * Created by aleksandar on 5/23/16.
 */
public class JCommanderContainer {
    @Parameter(names = "--operation",
            description = "Operation to execute. Possible choices: login, logout, checkin, checkout, cancel, remove, getTourists.",
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
            description = "Output file. Content depends on the command.",
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
