package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By homePageUserName = By.xpath("//tr[@class='heading3']/td");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Obtain username from home page to validate it")
    public String getLoginTitle() {
        return driver.findElement(homePageUserName).getText();
    }
}
