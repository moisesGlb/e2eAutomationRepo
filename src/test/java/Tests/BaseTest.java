package Tests;

import Utils.Utilities;
import object.SideMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected Properties properties;
    protected final static String projectPath = System.getProperty("user.dir");
    protected WebDriverWait wait;
    public static final String baseUrl = "http://demo.guru99.com/v4/";
    protected Utilities utils;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters("browser")
    public void classLevelSetup(String browser) throws Exception{
        utils = new Utilities();
        properties = utils.readFromProperties();

        if (browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", projectPath + properties.getProperty("gecko.path"));
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver",  projectPath + properties.getProperty("chrome.path"));
            driver = new ChromeDriver();
        }
        else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,15);
        driver.get(baseUrl);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
