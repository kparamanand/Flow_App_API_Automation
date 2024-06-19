package API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin;

import static API_Automation.Constants.UserLoginConstant.*;
import static API_Automation.config.URLConstants.FlowApp.*;
import static API_Automation.config.URLConstants.FlowApp_Endpoint.*;
import static org.hamcrest.Matchers.equalTo;

import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Login {
    public String tempToken;
    @Test
    @Description("Test Case for User Login API on Rupeezy Web App")
    public String Login_User() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL);
        request.basePath(User_Login);

        JSONObject requestParams = new JSONObject();
        requestParams.put("clientCode", CLIENT_CODE);
        requestParams.put("password", PASSWORD);
        requestParams.put("deviceId", DEVICE_ID);
        requestParams.put("applicationId", APPLICATION_ID);
        requestParams.put("platform", PLATFORM);

        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
        request.body(requestParams.toJSONString()); // Post the request and check the response

        Response response = request.post();

        response.then().body("status", equalTo("success"));

        System.out.println(response.asString());

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: tempToken (Note: You should not put $. in the Java code)
        tempToken = jsonPathEvaluator.get("tempToken");
        return tempToken;
    }
}
