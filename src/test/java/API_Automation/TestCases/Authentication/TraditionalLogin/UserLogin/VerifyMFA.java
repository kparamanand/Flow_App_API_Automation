package API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static API_Automation.Constants.LoginConstants.UserLoginConstant.DEVICE_ID;
import static API_Automation.Constants.LoginConstants.VerifyMFAConstant.*;
import static API_Automation.Constants.LoginConstants.VerifyMFAConstant.APP_VERSION;
import static API_Automation.config.URLConstants.FlowApp.*;
import static API_Automation.config.URLConstants.FlowApp_Endpoint.*;
import static org.hamcrest.Matchers.equalTo;

public class VerifyMFA {
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2, description = "Verify Login API")
    @Description("Test Description : Verify the Login API of Login Page")
    @Story("")
    public String Validate_MFA(String tempToken) {
        RequestSpecification request = RestAssured.given();
        request.filter(new AllureRestAssured());
        request.baseUri(BASE_URL);
        request.basePath(Verify_MFA);
        request.given().header("Authorization", "Bearer " + tempToken);

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
        response.then()
                .body("status", equalTo("success"))
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");


        System.out.println(response.asString());

        JsonPath jsonPathEvaluator = response.jsonPath();

        return jsonPathEvaluator.getString("data.access_token");
    }
}