package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    public static final String baseUrl = "http://demo.guru99.com/v4/";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters("browser")
    public void classLevelSetup(String browser) throws Exception{
        if (browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
