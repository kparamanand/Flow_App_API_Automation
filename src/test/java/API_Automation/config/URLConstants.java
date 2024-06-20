package API_Automation.config;

public class URLConstants {
    public static class FlowApp {
        public static final String BASE_URL = "https://vortex-api.rupeezy.in/v2";
    }

    public static class FlowApp_Endpoint {
        public static final String User_Login = "/aux/authentication/login";
        public static final String Send_TOTP = "/aux/authentication/sendTotpSms";
        public static final String Verify_MFA = "/aux/authentication/inhouse/verifyMfa";
        public static final String Validate_Sessions = "";
        public static final String User_Profile = "";
    }
}
