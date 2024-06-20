package TestRunner;

import API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin.Login;
import API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin.SendTOTP;
import API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin.VerifyMFA;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class APITestRunner {
    String tempToken;

    @Feature("Login API Tests")
    @Epic("Rupeezy Web Application API - Regression Testing")
    @Test
    void Login_Test() {
        Login login = new Login();
        tempToken = login.Login_User();
    }

    @Feature("Login API Tests")
    @Epic("Rupeezy Web Application API - Regression Testing")
    @Test(dependsOnMethods = {"Login_Test"})
    void SendTOTP_Test() {
        SendTOTP sendTotp = new SendTOTP();
        sendTotp.Send_TOTP(tempToken);
    }

    @Feature("Login API Tests")
    @Epic("Rupeezy Web Application API - Regression Testing")
    @Test(dependsOnMethods = {"Login_Test"})
    void Validate_MFA() {
        VerifyMFA verifyMFA = new VerifyMFA();
        verifyMFA.Validate_MFA(tempToken);
    }
}
