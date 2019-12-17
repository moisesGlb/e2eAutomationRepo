package object;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(name="uid")
   private WebElement userName;

    @FindBy(name="password")
    private WebElement userPassword;

    @FindBy(name="btnLogin")
    private WebElement btnLogin;

    @FindBy(name="btnReset")
    private WebElement btnReset;

    @FindBy(id ="message23")
    private WebElement lblEmptyUsername;

    @FindBy(id = "message18")
    private WebElement lblEmptyPwd;

    @FindBy(xpath = "//h2[@class=\"barone\"]")
    WebElement pageTitle;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Set user name in textbox
    @Step("clear the text box and enter the username: {username}")
    public void enterUserName(String username){
        userName.clear();
        userName.sendKeys(username);
    }

    //Set user password in textbox
    @Step("clear the text box and enter the pwd: {password}")
    public void enterPasswrd(String password){
        userPassword.clear();
        userPassword.sendKeys(password);
    }

    //click en login
    @Step("Click login button")
    public void clickLoginBtn(){
        btnLogin.click();
    }

    //click reset button
    @Step("Click reset button")
    public  void clickResetBtn(){
        btnReset.click();
    }

    public void LoginToHomeBanking(String user, String pass){
        clickResetBtn();
        enterUserName(user);
        enterPasswrd(pass);
        clickLoginBtn();
    }
    @Step("verify the empty username label is shown")
    public boolean verifyEmptyUsernameLbl(){
        return lblEmptyUsername.isDisplayed();
    }

    @Step("verify the empty pwd label is shown")
    public boolean verifyEmptyPwdLbl(){
        return lblEmptyPwd.isDisplayed();
    }

    @Step("get the login page title")
    public WebElement getPageTitle() {
        return pageTitle;
    }
}
