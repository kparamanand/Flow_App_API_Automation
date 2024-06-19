package API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static API_Automation.Constants.UserLoginConstant.DEVICE_ID;
import static API_Automation.Constants.VerifyMFAConstant.*;
import static API_Automation.Constants.VerifyMFAConstant.APP_VERSION;
import static API_Automation.config.URLConstants.FlowApp.BASE_URL;
import static API_Automation.config.URLConstants.FlowApp_Endpoint.Send_TOTP;
import static org.hamcrest.Matchers.equalTo;

public class SendTOTP {
    @Test
    public void Send_TOTP() {
        Login login = new Login();
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL);
        request.basePath(Send_TOTP);
        request.header("Authorization", "Bearer " + login.tempToken);

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
        Assert.assertEquals(true , response.then().body("status", equalTo("success")));
//        Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine(), "Status");

//        Assert.assertEquals(200, response.getStatusCode());
        System.out.println(response.asString());
    }
}
