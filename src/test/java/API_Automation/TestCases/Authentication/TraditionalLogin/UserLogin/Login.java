package API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin;

import static API_Automation.Constants.LoginConstants.UserLoginConstant.*;
import static API_Automation.config.URLConstants.FlowApp.*;
import static API_Automation.config.URLConstants.FlowApp_Endpoint.*;
import static org.hamcrest.Matchers.equalTo;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Login {
    public String tempToken;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 0, description = "Verify Login API")
    @Description("Test Description : Verify the Login API of Login Page")
    @Story("Title of Login Page")
    public String Login_User() {
        RequestSpecification request = RestAssured.given();
        request.filter(new AllureRestAssured());
        request.baseUri(BASE_URL);
        request.basePath(User_Login);

        JSONObject requestParams = new JSONObject();
        requestParams.put("clientCode", CLIENT_CODE);
        requestParams.put("password", PASSWORD);
        requestParams.put("deviceId", DEVICE_ID);
        requestParams.put("applicationId", APPLICATION_ID);
        requestParams.put("platform", PLATFORM);

        // Add the Json to the body of the request
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        // Post the request and
        Response response = request.post();

        // Check the response
        response.then()
                .body("status", equalTo("success"))
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

        System.out.println(response.asString());

        // JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // JsonPath: tempToken
        tempToken = jsonPathEvaluator.get("tempToken");

        // tempToken return for Send TOTP Verify
        return tempToken;
    }
}
