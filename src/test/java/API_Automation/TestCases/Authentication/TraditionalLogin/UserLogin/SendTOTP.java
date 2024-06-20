package API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin;

import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static API_Automation.config.URLConstants.FlowApp.BASE_URL;
import static API_Automation.config.URLConstants.FlowApp_Endpoint.Send_TOTP;
import static org.hamcrest.Matchers.equalTo;

public class SendTOTP {
    @Test
    @Description("Test Case for User TOTP Verify API on Rupeezy Web App")
    public void Send_TOTP(String tempToken) {
        RequestSpecification request = RestAssured.given();
        request.filter(new AllureRestAssured());
        request.baseUri(BASE_URL);
        request.basePath(Send_TOTP);
        request.header("Authorization", "Bearer " + tempToken);

        Response response = request.post();
        response.then()
                .body("status", equalTo("success"))
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

        System.out.println(response.asString());
    }
}
