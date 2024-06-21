package API_Automation.TestCases.Order;

import API_Automation.Constants.UserConstants.UserFundsConstant;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static API_Automation.config.URLConstants.FlowApp.BASE_URL;
import static API_Automation.config.URLConstants.FlowApp_Endpoint.User_Preferences;

public class userPreferences_TestCase {
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4, description = "Verify Login API")
    @Description("Test Description : Verify the Login API of Login Page")
    @Story("")
    public static void User_Preferences(String access_token) {
        UserFundsConstant user_Funds = new UserFundsConstant();
        RequestSpecification request = RestAssured.given();
        request.filter(new AllureRestAssured());
        request.baseUri(BASE_URL);
        request.basePath(User_Preferences);
        request.given()
                .header("Authorization", "Bearer " + access_token);
//                .header("x-api-key", user_Funds.X_API_KEY)
//                .header("Content-Type" , "application/json");

        Response response = request.get();
        response.then()
//                .body("status", equalTo("success"))
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

        System.out.println(response.asString());
    }
}
