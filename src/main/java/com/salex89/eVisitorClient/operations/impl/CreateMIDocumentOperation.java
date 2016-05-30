package com.salex89.eVisitorClient.operations.impl;

import com.salex89.eVisitorClient.operations.GetOperation;
import com.salex89.eVisitorClient.operations.Operation;
import com.salex89.eVisitorClient.operations.PostOperation;
import com.salex89.eVisitorClient.operations.ServerResponse;
import org.json.JSONObject;


/**
 * Created by aleksandar on 5/30/16.
 */
public class CreateMIDocumentOperation implements Operation {
    private final CreateDocumentStep createDocumentStep;
    private final GetDocumentStep getDocumentStep;

    public CreateMIDocumentOperation(String payload, String cookies, String resourceUrl) {
        this.createDocumentStep = new CreateDocumentStep(payload, cookies, resourceUrl);
        JSONObject object = new JSONObject(payload);
        String id = object.getString("ID");
        this.getDocumentStep = new GetDocumentStep(cookies, resourceUrl, id);

    }

    public ServerResponse execute() {
        ServerResponse step1Res = createDocumentStep.execute();
        if (step2Possible(step1Res)) {
            ServerResponse step2Res = getDocumentStep.execute();
            return step2Res;
        } else {
            return step1Res;
        }
    }

    private boolean step2Possible(ServerResponse step1Res) {
        if (step1Res.getStatus() == 200) {
            return true;
        } else if (step1Res.getStatus() == 400) {
            try {
                JSONObject error = new JSONObject(step1Res.getContents());
                if (error.has("UserMessage")) {
                    if (error.getString("UserMessage").toLowerCase().contains("preuzeti su podaci"))
                        return true;
                }
            } catch (Exception ex) {
                return false;
            }
        }
        return false;
    }

    protected static class CreateDocumentStep extends PostOperation {

        public CreateDocumentStep(String payload, String cookies, String baseUrl) {
            super(payload, cookies, baseUrl);
        }

        public String path() {
            return "Htz/CreateFileForMI/";
        }
    }

    protected static class GetDocumentStep extends GetOperation {

        protected final String user;

        public GetDocumentStep(String cookies, String baseUrl, String user) {
            super(cookies, baseUrl);
            this.user = user;
        }

        public String path() {
            return "Htz/MITTPayerFiles/" + user;
        }
    }
}
