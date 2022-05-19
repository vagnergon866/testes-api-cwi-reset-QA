package br.com.restassuredapitest.tests.auth.requests.payloads;

import org.json.JSONException;
import org.json.JSONObject;

public class AuthPayloads {

    public JSONObject jsonAuthLogin() throws JSONException {
        JSONObject payloadLogin = new JSONObject();

        payloadLogin.put("username", "admin");
        payloadLogin.put("password", "password123");

        return payloadLogin;
    }

}
