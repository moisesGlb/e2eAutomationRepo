package Utils.Data;

import Utils.FileHandler;
import Utils.Utilities;
import Utils.e2eConstants;
import entities.Customer;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class DataProviderClass {

    private static Utilities util = new Utilities();
    private static FileHandler fileHandler = new FileHandler();

    @DataProvider(name="newUsers")
    public static Object[][] getDataFromDataprovider(Method method)throws IOException {
        String ID = util.getJiraId(method.getName());
        return new Object[][]{ {new Customer(fileHandler.listReadExcel(e2eConstants.FILE_PATH,
                                                                       e2eConstants.FILE_NAME,
                                                                       e2eConstants.NEW_USERS_SHEET_NAME, ID))}};
    }

    @DataProvider(name="loginTest")
    public static Object[][] getDataFromDataProvider(Method method)throws IOException {
        String ID = util.getJiraId(method.getName());
        return fileHandler.readExcel(e2eConstants.FILE_PATH,
                                     e2eConstants.FILE_NAME,
                                     e2eConstants.LOGIN_SHEET_NAME, ID);
    }
}
