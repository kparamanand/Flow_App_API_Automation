import API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin.*;
import API_Automation.TestCases.Order.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class APITestRunner {
    String tempToken;
    String access_token;

    @Feature("Login API Tests")
    @Epic("Rupeezy Web Application API - Regression Testing")
    @Test
     public void Login_Test() {
        Login login = new Login();
        tempToken = login.Login_User();
    }

    @Feature("Login API Tests")
    @Epic("Rupeezy Web Application API - Regression Testing")
    @Test(dependsOnMethods = {"Login_Test"})
    public void SendTOTP_Test() {
        SendTOTP sendTotp = new SendTOTP();
        sendTotp.Send_TOTP(tempToken);
    }

    @Feature("Login API Tests")
    @Epic("Rupeezy Web Application API - Regression Testing")
    @Test(dependsOnMethods = {"Login_Test"})
    public void Validate_MFA() {
        VerifyMFA verifyMFA = new VerifyMFA();
        access_token = verifyMFA.Validate_MFA(tempToken);
    }

    @Feature("User API Tests")
    @Epic("Rupeezy Web Application API - Regression Testing")
    @Test(dependsOnMethods = {"Validate_MFA"})
    public void User_Funds() {
        UserFunds.User_Funds(access_token);
    }

    @Feature("User API Tests")
    @Epic("Rupeezy Web Application API - Regression Testing")
    @Test(dependsOnMethods = {"Validate_MFA"}, enabled = false)
    public void User_Preferences() {
        userPreferences_TestCase.User_Preferences(access_token);
    }
}
