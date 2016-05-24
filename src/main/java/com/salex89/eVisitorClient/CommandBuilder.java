package com.salex89.eVisitorClient;

import com.salex89.eVisitorClient.handlers.ContentResponseHandler;
import com.salex89.eVisitorClient.handlers.CookieResponseHandler;
import com.salex89.eVisitorClient.operations.GetTouristsOperation;
import com.salex89.eVisitorClient.operations.LoginOperation;
import com.salex89.eVisitorClient.operations.Operation;
import com.salex89.eVisitorClient.operations.OperationNotSupported;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.salex89.eVisitorClient.CommandStrings.GET_TOURISTS;
import static com.salex89.eVisitorClient.CommandStrings.LOGIN;

/**
 * Created by aleksandar on 5/23/16.
 */
public class CommandBuilder {

    public CommandExecutor buildCommand(JCommanderContainer container) {
        if (container.getOperation().contentEquals(LOGIN)) {
            String inputPayload = readFile(container.getInputFilePath());
            Operation loginOperation = new LoginOperation(inputPayload);
            return new CommandExecutor(loginOperation, new CookieResponseHandler(container.getOutputFilePath()));
        }
        if (container.getOperation().contentEquals(GET_TOURISTS)) {
            String cookies = readFile(container.getCookieFile());
            Operation getTouristsOperation = new GetTouristsOperation(cookies);
            return new CommandExecutor(getTouristsOperation, new ContentResponseHandler(container.getOutputFilePath()));
        }
        throw new OperationNotSupported(container.getOperation());
    }

    protected String readFile(String filePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            StringBuilder payloadBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                payloadBuilder.append(line);
            }
            return payloadBuilder.toString();
        } catch (IOException e) {
            throw new InputFileError();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
