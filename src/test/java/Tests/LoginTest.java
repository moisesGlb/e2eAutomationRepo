package Tests;

import Utils.Data.DataProviderClass;
import io.qameta.allure.*;
import object.HomePage;
import object.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Epic("Login")
@Feature("Login Tests")
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void methodLevelSetup(){
        loginPage = new LoginPage(super.getDriver());
        homePage = new HomePage(super.getDriver());
    }

    /**
     * This test case will login in http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message
     */
    @Ignore
    @Test(priority = 2, dataProvider = "loginTest", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.BLOCKER)
    @Description("We validate a successfull login with valid credentials")
    @Story("Login with valid credentials")
    public void JIRA6745_testLogin(String user, String pass){
        loginPage.LoginToHomeBanking(user,pass);
        Assert.assertTrue(homePage.getLoginTitle().toLowerCase().contains(user));
    }

    @Ignore
    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we validate that when we left the input fields from pwd and user 2 warnings should show")
    @Story("Empty - blank fields must show warning")
    public void JIRA6746_testEmptyLabels(){
        loginPage.enterUserName("");
        loginPage.enterPasswrd("");
        loginPage.getPageTitle().click();
        Assert.assertTrue(loginPage.verifyEmptyUsernameLbl());
        Assert.assertTrue(loginPage.verifyEmptyPwdLbl());
    }

}
