package Tests;

import Utils.Data.DataProviderClass;
import io.qameta.allure.*;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utils.e2eConstants.INVALID_USER_OR_PASS_ALERT_MESSAGE;

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

    @Test(priority = 1, dataProvider = "loginTest", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.BLOCKER)
    @Description("We validate a successfull login with valid credentials")
    @Story("Login with valid credentials")
    public void JIRA6745_testLogin(String user, String pass){
        loginPage.LoginToHomeBanking(user,pass);
        Assert.assertTrue(homePage.getLoginTitle().toLowerCase().contains(user));
    }

    @Test(priority = 3)
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

    @Test(priority = 2, dataProvider = "loginTest", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.BLOCKER)
    @Description("We validate a error shown to the customers when they try to login with invalid credentials")
    @Story("Login with invalid credentials")
    public void JIRA6747_LoginWithInvalidCrendentials(String user, String pass){
        loginPage.LoginToHomeBanking(user,pass);
        Assert.assertEquals(super.getDriver().switchTo().alert().getText(),INVALID_USER_OR_PASS_ALERT_MESSAGE);
    }

}
