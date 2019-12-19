package object;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenu {

    private WebDriver driver;

    @FindBy(css = "a[href*=\"Managerhomepage\"]")
    public WebElement managerPageOption;

    @FindBy(css = "a[href*=\"addcustomerpage\"]")
    public WebElement newCustomerOption;

    @FindBy(css = "a[href*=\"EditCustomer\"]")
    public WebElement editCustomerOption;

    @FindBy(css = "a[href*=\"DeleteCustomerInput\"]")
    public WebElement deleteCustomerOption;

    @FindBy(css = "a[href*=\"addAccount\"]")
    public WebElement newAccountOption;

    @FindBy(css = "a[href*=\"editAccount\"]")
    public WebElement editAccountOption;

    @FindBy(css = "a[href*=\"deleteAccountInput\"]")
    public WebElement deleteAccountOption;

    @FindBy(css = "a[href*=\"DepositInput\"]")
    public WebElement depositOption;

    @FindBy(css = "a[href*=\"WithdrawalInput\"]")
    public WebElement withdrawalOption;

    @FindBy(css = "a[href*=\"FundTransInput\"]")
    public WebElement fundTransferOption;

    @FindBy(css = "a[href*=\"PasswordInput\"]")
    public WebElement changePasswordOption;

    @FindBy(css = "a[href*=\"BalEnqInput\"]")
    public WebElement balanceEnquiryOption;

    @FindBy(css = "a[href*=\"MiniStatementInput\"]")
    public WebElement miniStatementOption;

    @FindBy(css = "a[href*=\"CustomisedStatementInput\"]")
    public WebElement customisedStatementOption;

    @FindBy(css = "a[href*=\"Logout\"]")
    public WebElement logOutOption;


    public SideMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("[SideMenu] Click on Home page option ")
    public void clicOnHomePage(){
        managerPageOption.click();
    }

    @Step("[SideMenu] Click on new Customer option ")
    public void clicOnNewCustomer(){
        newCustomerOption.click();
    }

    @Step("[SideMenu] Click on Edit Customer option ")
    public void clicOnEditCustomer(){
        editCustomerOption.click();
    }

    @Step("[SideMenu] Click on Delete Customer option ")
    public void clicOnDeleteCustomer(){
        deleteCustomerOption.click();
    }

    @Step("[SideMenu] Click on Add Account option ")
    public void clicOnAddAccount(){
        newAccountOption.click();
    }

    @Step("[SideMenu] Click on Edit Account option ")
    public void clicOnEditAccount(){
        editAccountOption.click();
    }

    @Step("[SideMenu] Click on Delete Account option ")
    public void clicOnDeleteAccount(){
        deleteAccountOption.click();
    }

    @Step("[SideMenu] Click on Deposit option ")
    public void clicOnDeposit(){
        depositOption.click();
    }

    @Step("[SideMenu] Click on Withdrawall option ")
    public void clicOnwithdraw(){
        withdrawalOption.click();
    }

    @Step("[SideMenu] Click on Fund Transfer option ")
    public void clicOnFundTransfer(){
        fundTransferOption.click();
    }

    @Step("[SideMenu] Click on Change Password option ")
    public void clicOnChangePassword(){
        changePasswordOption.click();
    }

    @Step("[SideMenu] Click on Balance Enquiry option ")
    public void clicOnBalanceEnquiry(){
        balanceEnquiryOption.click();
    }

    @Step("[SideMenu] Click on Mini Statement option ")
    public void clicOnMiniStatement(){
        miniStatementOption.click();
    }

    @Step("[SideMenu] Click on Customised Statement option ")
    public void clicOnCustomStatement(){
        customisedStatementOption.click();
    }

    @Step("[SideMenu] Click on Log Out option ")
    public void clicOnLogout(){
        logOutOption.click();
    }
}
