package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String driverPath = "C:\\Users\\moises.salas\\IdeaProjects\\PageObjectModelPractice\\src\\test\\resources\\chromedriver.exe";
    public WebDriver driver;
    public static final String baseUrl = "http://demo.guru99.com/v4/";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
