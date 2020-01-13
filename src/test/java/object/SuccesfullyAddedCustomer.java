package object;

import Utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccesfullyAddedCustomer {

    private Utilities utils = new Utilities();
    private WebDriver driver;

    @FindBy(css = "p.heading3")
    public WebElement customerTitle;

    @FindBy(css = "tr:nth-child(4) td:nth-child(2)")
    public WebElement customerId;

    @FindBy(css = "tr:nth-child(5) td:nth-child(2)")
    public WebElement customerName;

    @FindBy(css = "td a")
    public WebElement continueButton;

    public SuccesfullyAddedCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCustomerTitle() {
        return customerTitle;
    }

    public WebElement getCustomerId() {
        return customerId;
    }

    public WebElement getCustomerName() {
        return customerName;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }
}
