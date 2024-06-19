package API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static API_Automation.config.URLConstants.FlowApp.*;
import static API_Automation.config.URLConstants.FlowApp_Endpoint.*;

public class VerifyMFA {
    @Test
    public void Validate_MFA() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL);
        request.basePath(Verify_MFA);

    }
}