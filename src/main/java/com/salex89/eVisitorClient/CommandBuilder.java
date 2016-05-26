package com.salex89.eVisitorClient;

import com.salex89.eVisitorClient.handlers.ContentResponseHandler;
import com.salex89.eVisitorClient.handlers.CookieResponseHandler;
import com.salex89.eVisitorClient.operations.Operation;
import com.salex89.eVisitorClient.operations.OperationNotSupported;
import com.salex89.eVisitorClient.operations.impl.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.salex89.eVisitorClient.CommandStrings.*;

/**
 * Created by aleksandar on 5/23/16.
 */
public class CommandBuilder {

    public CommandExecutor buildCommand(JCommanderContainer container) {
        if (container.getOperation().contentEquals(LOGIN)) {
            String inputPayload = readFile(container.getInputFilePath());
            Operation loginOperation = new LoginOperation(inputPayload);
            return new CommandExecutor(loginOperation, new CookieResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(LOGOUT)) {
            String cookies = readFile(container.getCookieFile());
            Operation logoutOperation = new LogoutOperation(cookies);
            return new CommandExecutor(logoutOperation, new ContentResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(CHECKIN)) {
            String inputPayload = readFile(container.getInputFilePath());
            String cookies = readFile(container.getCookieFile());
            Operation logoutOperation = new CheckInOperation(inputPayload, cookies);
            return new CommandExecutor(logoutOperation, new ContentResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(CHECKOUT)) {
            String inputPayload = readFile(container.getInputFilePath());
            String cookies = readFile(container.getCookieFile());
            Operation logoutOperation = new CheckOutOperation(inputPayload, cookies);
            return new CommandExecutor(logoutOperation, new ContentResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(CANCEL_CHECKIN)) {
            String inputPayload = readFile(container.getInputFilePath());
            String cookies = readFile(container.getCookieFile());
            Operation logoutOperation = new CancelCheckInOperation(inputPayload, cookies);
            return new CommandExecutor(logoutOperation, new ContentResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(GET_TOURISTS)) {
            String cookies = readFile(container.getCookieFile());
            Operation getTouristsOperation = new GetTouristsOperation(cookies);
            return new CommandExecutor(getTouristsOperation, new ContentResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(DOCUMENT_TYPE_LOOKUP)) {
            String cookies = readFile(container.getCookieFile());
            Operation getTouristsOperation = new DocumentTypesLookup(cookies);
            return new CommandExecutor(getTouristsOperation, new ContentResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(COUNTRY_LOOKUP)) {
            String cookies = readFile(container.getCookieFile());
            Operation getTouristsOperation = new CountryLookup(cookies);
            return new CommandExecutor(getTouristsOperation, new ContentResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(PAYMENT_CATEGORY_LOOKUP)) {
            String cookies = readFile(container.getCookieFile());
            Operation getTouristsOperation = new PaymentCategoryLookup(cookies);
            return new CommandExecutor(getTouristsOperation, new ContentResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(ARRIVAL_ORGANIZATION_LOOKUP)) {
            String cookies = readFile(container.getCookieFile());
            Operation getTouristsOperation = new ArrivalOrganizationLookup(cookies);
            return new CommandExecutor(getTouristsOperation, new ContentResponseHandler(container.getOutputFilePath()));
        } else if (container.getOperation().contentEquals(GUID)) {
            Operation getTouristsOperation = new CreateGuidOperation();
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
