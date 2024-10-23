package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilsFiles.Cookies;
import utilsFiles.UtilesHelper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class P03_LoginPage extends UtilesHelper {
    WebDriver driver;

    private final By email = new By.ById("email");
    private final By password = new By.ById("pass");
    private final By signin = new By.ById("send2");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    private final By invalidLoginStatus = new By.ByXPath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]");
    private final By welcome_username = new By.ByXPath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[1]/span[1]");
    private final By myacountdropdownbutton = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private final By myacount = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]");
    private final By username = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]");



    public P03_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login with email: {0} & password: {1}")
    public P03_LoginPage setLoginCredentials(String Email, String Password) {
        sendKeys(driver, email, Email);
        sendKeys(driver, password, Password);
        return this;
    }

    @Step("Click sign in ")
    public P03_LoginPage signIn() {
        click(driver, signin);
        return this;
    }

    @Step("Verify Login successfully")
    public P03_LoginPage verifySignINIs_Ok() {
        fluentWait(driver, myacountdropdownbutton);
        click(driver, myacountdropdownbutton);
        fluentWait(driver, myacount);
        click(driver, myacountdropdownbutton);
        System.out.println("Logged In Successfully");



        return this;
    }

    public void verifySignIN__Successfully_validateUserName(String UserNameAndLastName) {
        fluentWait(driver, myacountdropdownbutton);
        click(driver, myacountdropdownbutton);
        fluentWait(driver, myacount);
        click(driver, myacount);


        String actualUserName = driver.findElement(username).getText();
        System.out.println("Logged In Successfully with UserName: "+actualUserName);

        assertTrue( actualUserName.contains(UserNameAndLastName));

    }



    public P03_LoginPage verifySignINIs_InValid() {
        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
        String actualURL = driver.getCurrentUrl();


        assertEquals(actualURL, expectedURL);
        return this;
    }

    public P03_LoginPage verifySignIs_InValid() {

        fluentWait(driver, invalidLoginStatus);
        boolean status = driver.findElement(invalidLoginStatus).isDisplayed();

        assertTrue(status, "No user found with this email");
        return this;
    }


    /*
     *
     * Use Cookies
     *
     * */
    @Step("Save Cookies")
    public void store_Cookies_Login_Page() {

        Cookies.storeCookiesToFile(driver, "LoginCookies" ,"D:\\St\\Testing\\Projects\\1-LUMA\\CookiesDataFiles\\");;
        System.out.println("Cookies stored: LoginCookies");
        verifySignINIs_Ok();

    }

    public P03_LoginPage load_Cookies_Login_Page() {

        Cookies.loadCookiesFromFile(driver,"LoginCookies","D:\\St\\Testing\\Projects\\1-LUMA\\CookiesDataFiles\\");
        System.out.println("Cookies loaded: LoginCookies");

        refreshPage(driver);

        //refreshPage(driver);

        return this;
    }

}
