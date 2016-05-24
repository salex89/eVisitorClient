package com.salex89.eVisitorClient.handlers;

import com.salex89.eVisitorClient.OutputFileError;
import com.salex89.eVisitorClient.operations.ServerResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by aleksandar on 5/23/16.
 */
abstract class AbstractFileOutputHandler implements OutputHandler {
    private final String outputPath;

    public AbstractFileOutputHandler(String outputPath) {
        this.outputPath = outputPath;
    }

    public void handle(ServerResponse response) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(outputPath));
            printWriter.write(responseToString(response));
        } catch (IOException e) {
            throw new OutputFileError();
        }
        finally {
            if(printWriter != null)
                printWriter.close();
        }
    }
    protected abstract String responseToString(ServerResponse response);
}
