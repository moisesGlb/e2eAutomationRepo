package Utils.Data;

import Utils.FileHandler;
import Utils.Utilities;
import entities.Customer;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class DataProviderClass {

    private static final String mngrUser = "mngr239975";
    private static final String mngrPass = "AhUsYde";
    private static  Utilities.Utilidades util = new Utilities.Utilidades();
    private static FileHandler fileHandler = new FileHandler();

    @DataProvider(name="newUsers")
    public static Object[][] getDataFromDataprovider(Method method)throws IOException {
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\TestData";
        String ID = util.getJiraId(method.getName());
        ArrayList<String> list = fileHandler.listReadExcel(filePath,"testData.xls","newUsers",ID);
        //separo la pass y el usuario que vienen en la lista y los elimino
        String pass = list.get((list.size()-1));
        String user = list.get((list.size()-2));
        //se eliminan los usuarios porque no son necesarios
        list.remove((list.size()-1));
        list.remove((list.size()-1));
        return new Object[][]{ {user, pass, new Customer(list)}};
    }

    @DataProvider(name="loginTest")
    public static Object[][] getDataFromDataProvider(Method method)throws IOException {
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\TestData";
        String ID = util.getJiraId(method.getName());
        return fileHandler.readExcel(filePath,"testData.xls","LoginUsers",ID);
    }
}
