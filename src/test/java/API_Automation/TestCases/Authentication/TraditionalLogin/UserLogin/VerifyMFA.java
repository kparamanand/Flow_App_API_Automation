package API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static API_Automation.Constants.UserLoginConstant.DEVICE_ID;
import static API_Automation.Constants.VerifyMFAConstant.*;
import static API_Automation.Constants.VerifyMFAConstant.APP_VERSION;
import static API_Automation.config.URLConstants.FlowApp.*;
import static API_Automation.config.URLConstants.FlowApp_Endpoint.*;
import static org.hamcrest.Matchers.equalTo;

public class VerifyMFA {
    @Test
    public void Validate_MFA(String tempToken) {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL);
        request.basePath(Verify_MFA);
        request.header("Authorization", "Bearer " + tempToken);

        JSONObject requestParams = new JSONObject();
        requestParams.put("otp", OTP);
        requestParams.put("mfaType", MFA_TYPE);
        requestParams.put("deviceId", DEVICE_ID);
        requestParams.put("newPassword", NEW_PASSWORD);
        requestParams.put("os", OS);
        requestParams.put("deviceInfo", DEVICE_INFO);
        requestParams.put("appVersion", APP_VERSION);

        request.body(requestParams.toJSONString());

        Response response = request.post();
        response.then().body("status", equalTo("success"));

        System.out.println(response.asString());

    }
}