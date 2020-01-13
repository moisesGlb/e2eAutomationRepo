package Tests;


import Utils.Data.DataProviderClass;
import Utils.Data.DataUpdater;
import Utils.e2eConstants;
import entities.Customer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import object.AddNewCustomerPage;
import object.LoginPage;
import object.SideMenu;
import object.SuccesfullyAddedCustomer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    private LoginPage loginPage;
    private AddNewCustomerPage addNewCustomerPage;
    private SideMenu sideMenu;
    private SuccesfullyAddedCustomer succesCustomer;
    private DataUpdater dataUpdater;

    @BeforeMethod
    public void methodLevelSetup(){
        loginPage = new LoginPage(super.getDriver());
        addNewCustomerPage = new AddNewCustomerPage(super.getDriver());
        sideMenu = new SideMenu(super.getDriver());
        succesCustomer = new SuccesfullyAddedCustomer(super.getDriver());
        dataUpdater = new DataUpdater();
    }


    @Test(priority = 1, dataProvider = "newUsers", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("We validate that a new customer is successfully added")
    @Story("Add new Customer")
    public void JIRA7153_AddNewCustomer_ValidData(Customer customer) throws InterruptedException
    {
        loginPage.LoginToHomeBanking(properties.getProperty("mngr.user"),properties.getProperty("mngr.pass"));
        sideMenu.clicOnNewCustomer();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.heading3")));
        addNewCustomerPage.addNewCustomer(customer.getName(),customer.isGender(),customer.getBirthDate(),customer.getAddress(),customer.getCity(),customer.getState(),customer.getPhoneNumber(),customer.getPin());
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.heading3")));
        //Assert.assertTrue(succesCustomer.customerTitle.getText().contains("sccuesfull"));
        Assert.assertEquals(succesCustomer.getCustomerName().getText(),customer.getName());
        dataUpdater.updateData(e2eConstants.NEW_USERS_SHEET_NAME,succesCustomer.getCustomerId().getText(),"JIRA7153",9);
    }
}
