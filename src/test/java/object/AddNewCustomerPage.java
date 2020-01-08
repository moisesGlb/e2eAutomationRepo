package object;

import Utils.Utilities;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
    private WebDriver driver;
    private Utilities.Utilidades utilidades;

    @FindBy(css = "p.heading3")
    public WebElement newCustomerTitle;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement customerName;

    @FindBy(id = "message")
    public WebElement lblEmptyName;

    @FindBy(id = "dob")
    public WebElement birthDate;

    @FindBy(id = "message24")
    public WebElement lblEmptyBirthDate;

    @FindBy(xpath = "//textarea[@name='addr']")
    public WebElement addres;

    @FindBy(id = "message3")
    public WebElement lblEmptyAddress;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;

    @FindBy(id = "message4")
    public WebElement lblEmptyCity;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;

    @FindBy(id = "message5")
    public WebElement lblEmptyState;

    @FindBy(xpath = "//input[@name='pinno']")
    public WebElement PIN;

    @FindBy(id = "message6")
    public WebElement lblEmptyPIN;

    @FindBy(xpath = "//input[@name='telephoneno']")
    public WebElement telephone;

    @FindBy(id = "message7")
    public WebElement lblEmptyPhone;

    @FindBy(xpath = "//input[@name='emailid']")
    public WebElement email;

    @FindBy(id = "message9")
    public WebElement lblEmptyEmail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(id = "message18")
    public WebElement lblEmptyPassword;

    @FindBy(xpath = "//input[@value='m']")
    public WebElement radioButtonMale;

    @FindBy(xpath = "//input[@value='f']")
    public WebElement radioButtonFemale;

    @FindBy(xpath = "//input[@name='sub']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@name='res']")
    public WebElement resetButton;

    public AddNewCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Enter the customer name: {name}")
    public void enterCustomerName(String name){
        customerName.sendKeys(name);
    }

    @Step("select customer gender: true male, false female {gender}")
    public void selectGender(boolean gender){
        if (gender) radioButtonMale.click();
        else radioButtonFemale.click();
    }

    @Step("Select the birthdate")
    public void selectBirthDate(String date){
        birthDate.sendKeys(date);
    }

    @Step("Enter the customer address: {Address}")
    public void enterCustomerAddress(String Address){
        addres.sendKeys(Address);
    }

    @Step("Enter the customer city: {City}")
    public void enterCustomerCity(String City){
        this.city.sendKeys(City);
    }

    @Step("Enter the customer state: {State}")
    public void enterCustomerState(String State){
        this.state.sendKeys(State);
    }

    @Step("Enter the customer pin: {pin}")
    public void enterCustomerPin(String pin){
        this.PIN.sendKeys(pin);
    }

    @Step("Enter the customer Phone: {Phone}")
    public void enterCustomerPhone(String Phone){
        this.telephone.sendKeys(Phone);
    }

    @Step("Enter the customer Email: {Email}")
    public void enterCustomerEmail(String Email){
        this.email.sendKeys(Email);
    }

    @Step("Enter the customer Password: {Password}")
    public void enterCustomerPassword(String Password){
        this.password.sendKeys(Password);
    }

    @Step("Click on Submit button")
    public void clickSubmit(){
        submitButton.click();
    }

    @Step("Click on Reset button")
    public void clickReset(){
        resetButton.click();
    }


    public void addNewCustomer(String name, boolean gender, String birthDate, String address, String city, String state,String phoneNumber, String pin){
        clickReset();
        enterCustomerName(name);
        selectGender(gender);
        selectBirthDate(birthDate);
        enterCustomerAddress(address);
        enterCustomerCity(city);
        enterCustomerState(state);
        enterCustomerPin(pin);
        enterCustomerPhone(phoneNumber);
        enterCustomerEmail(utilidades.generateEmail(name));
        enterCustomerPassword("Test1234");
        clickSubmit();
    }


}
