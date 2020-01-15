package Utils;

public final class e2eConstants {

    private e2eConstants(){}

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String FILE_PATH = PROJECT_PATH +"\\src\\test\\java\\TestData";
    public static final String FILE_NAME = "testData.xls";
    public static final String NEW_USERS_SHEET_NAME = "newUsers";
    public static final String LOGIN_SHEET_NAME = "LoginUsers";
    public static final String BASE_URL = "http://demo.guru99.com/v4/";
    public static final String INVALID_USER_OR_PASS_ALERT_MESSAGE = "User or Password is not valid";
}
