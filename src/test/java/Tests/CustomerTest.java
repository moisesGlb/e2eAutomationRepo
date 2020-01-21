package Tests;


import Utils.Data.DataProviderClass;
import Utils.Data.DataUpdater;
import Utils.Log;
import entities.Customer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddNewCustomerPage;
import pages.LoginPage;
import pages.SideMenu;
import pages.SuccesfullyAddedCustomer;

import static Utils.e2eConstants.NEW_USERS_SHEET_NAME;

public class CustomerTest extends BaseTest {

    private LoginPage loginPage;
    private AddNewCustomerPage addNewCustomerPage;
    private SideMenu sideMenu;
    private SuccesfullyAddedCustomer succesCustomerPage;
    private DataUpdater dataUpdater;

    @BeforeMethod
    public void methodLevelSetup(){
        loginPage = new LoginPage(super.getDriver());
        addNewCustomerPage = new AddNewCustomerPage(super.getDriver());
        sideMenu = new SideMenu(super.getDriver());
        succesCustomerPage = new SuccesfullyAddedCustomer(super.getDriver());
        dataUpdater = new DataUpdater();
    }


    @Test(priority = 8, dataProvider = "newUsers", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("We validate that a new customer is successfully added")
    @Story("Add new Customer")
    public void JIRA7153_AddNewCustomer_ValidData(Customer customer) throws InterruptedException
    {

        loginPage.LoginToHomeBanking(properties.getProperty("mngr.user"),properties.getProperty("mngr.pass"));
        sideMenu.clicOnNewCustomer();
        wait.until(ExpectedConditions.visibilityOf(addNewCustomerPage.customerTitle));
        Log.info("the address obtained is: "+customer.getAddress());
        addNewCustomerPage.addNewCustomer(customer.getName(),customer.isGender(),customer.getBirthDate(),customer.getAddress(),customer.getCity(),customer.getState(),customer.getPhoneNumber(),customer.getPin());
        if (super.isAlertPresent(super.getDriver())){
            String error = "Failed Test, Unexpected alert shown: "+super.getDriver().switchTo().alert().getText();
            Assert.fail(error);
        }else {
            wait.until(ExpectedConditions.visibilityOf(succesCustomerPage.customerTitle));
            Assert.assertTrue(succesCustomerPage.customerTitle.getText().contains("successful"));
            Assert.assertEquals(succesCustomerPage.getCustomerName().getText(),customer.getName());
            dataUpdater.updateData(NEW_USERS_SHEET_NAME, succesCustomerPage.getCustomerId().getText(),"JIRA7153",9);
        }
    }
}
