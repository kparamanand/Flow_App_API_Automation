package API_Automation.TestCases.TestRunner;

import API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin.Login;
import API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin.SendTOTP;
import API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin.VerifyMFA;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRunner {
    String tempToken;
    @Test
    void Login_Test() {
        Login login = new Login();
        tempToken = login.Login_User();
    }

    @Test
    void SendTOTP_Test() {
        SendTOTP sendTotp = new SendTOTP();
        sendTotp.Send_TOTP(tempToken);
    }

    @Test
    void Validate_MFA() {
        VerifyMFA verifyMFA = new VerifyMFA();
        verifyMFA.Validate_MFA(tempToken);
    }
}
