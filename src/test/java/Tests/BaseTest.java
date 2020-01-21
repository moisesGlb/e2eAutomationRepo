package Tests;

import Utils.Log;
import Utils.Utilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static Utils.e2eConstants.BASE_URL;
import static Utils.e2eConstants.PROJECT_PATH;

public class BaseTest {
    private WebDriver driver;
    protected Properties properties;
    protected WebDriverWait wait;
    protected Utilities utils;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters({"browser"})
    public void classLevelSetup(String browser) throws Exception {
        utils = new Utilities();
        properties = utils.readFromProperties();
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", PROJECT_PATH + properties.getProperty("gecko.path"));
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", PROJECT_PATH + properties.getProperty("chrome.path"));
            driver = new ChromeDriver();
        } else {
            //If no browser passed throw exception
            Log.error("Browser is not correct");
            throw new Exception("Browser is not correct");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        driver.get(BASE_URL);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    protected boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }
}
