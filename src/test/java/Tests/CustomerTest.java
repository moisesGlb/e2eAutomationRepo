package Tests;


import Utils.Data.DataProviderClass;
import entities.Customer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import object.AddNewCustomerPage;
import object.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    private LoginPage loginPage;
    private AddNewCustomerPage addNewCustomerPage;

    @BeforeMethod
    public void methodLevelSetup(){
        loginPage = new LoginPage(super.getDriver());
        addNewCustomerPage = new AddNewCustomerPage(super.getDriver());
    }


    @Test(priority = 1, dataProvider = "newUsers", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("We validate that a new customer is successfully added")
    @Story("Add new Customer")
    public void JIRA7153_AddNewCustomer_ValidData(String user, String pass, Customer customer) throws InterruptedException
    {
        loginPage.LoginToHomeBanking(user,pass);
        addNewCustomerPage.addNewCustomer(customer.getName(),customer.isGender(),customer.getBirthDate(),customer.getAddress(),customer.getCity(),customer.getState(),customer.getPhoneNumber(),customer.getPin());
    }
}
