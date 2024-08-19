package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilsFiles.UtilsDriverMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utilsFiles.Cookies.storeCookiesToFile;


public class P02_createAccountPage extends UtilsDriverMethods {
    WebDriver driver;
    private final By firstname = new By.ById("firstname");
    private final By lastname = new By.ById("lastname");
    private final By email = new By.ById("email_address");
    private final By password = new By.ById("password");
    private final By confirm_password = new By.ById("password-confirmation");
    private final By create_account_button = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private final By clickherebtn = new By.ByXPath("//a[normalize-space()='click here']");


    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

    public P02_createAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Personal Information First Name: {0} & Last Name: {1}")
    public P02_createAccountPage setPersonalInformation(String firstName, String lastName) {
        sendKeys(driver, firstname, firstName);
        sendKeys(driver, lastname, lastName);
        return this;
    }

    @Step("Enter Account Information Email: {0} & Password: {1} & Confirm Password: {2}")
    public P02_createAccountPage setSignInInformation(String Email, String Password, String confirmPassword) {
        sendKeys(driver, email, Email);
        sendKeys(driver, password, Password);
        sendKeys(driver, confirm_password, confirmPassword);
        return this;
    }

    @Step("Click create account")
    public P02_createAccountPage create_account() {
        click(driver, create_account_button);
        return this;
    }

    @Step("Verify account is created successfully")
    public P02_createAccountPage verifyPageURL() {
        String expectedPageSource = "https://magento.softwaretestingboard.com/customer/account/";
        String actualPageSource = getCurrentURL(driver);
        assertEquals(actualPageSource, expectedPageSource, "account not created");
        return this;
    }

    /*@Step("Reset password and link of email: {0}")
    public void getResetLink_Password(String Email){

        sendKeys(emailtextboxresetpasswor,Email);
        click(clicktresetpasswordbtn);
    }*/
    @Step("Verify that there is already an account with this email address")
    public P02_createAccountPage verifyEmailIsRegisteredBefore() {
        fluentWait(driver, clickherebtn);

        String expectedStatus = "There is already an account with this email address";
        fluentWait(driver, status);


        String actualStatus = driver.findElement(status).getText();
        System.out.println(actualStatus);
        assertTrue(actualStatus.contains(expectedStatus), "account not created");
        return this;
    }

    public P02_createAccountPage getUserTokenAndCookies(){
        // Store cookies in a file
        storeCookiesToFile(driver, "LoginCookies" ,"D:\\St\\Testing\\Projects\\1-LUMA\\CookiesDataFiles\\");
        return this;
    }

}
