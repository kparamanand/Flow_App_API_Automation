package API_Automation.Constants;

import API_Automation.TestCases.Authentication.TraditionalLogin.UserLogin.Login;

public class VerifyMFAConstant {
    static Login login = new Login();
    public static String OTP = "123456";
    public static String MFA_TYPE= "totp";
    public static String NEW_PASSWORD = "";
    public static String OS = "android";
    public static String DEVICE_INFO = "AAA";
    public static String APP_VERSION = "112";
}
