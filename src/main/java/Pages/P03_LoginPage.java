package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilsFiles.Cookies;
import utilsFiles.UtilsDriverMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class P03_LoginPage extends UtilsDriverMethods {
    WebDriver driver;

    private final By email = new By.ById("email");
    private final By password = new By.ById("pass");
    private final By signin = new By.ById("send2");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    private final By invalidLoginStatus = new By.ByXPath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]");

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


    public P03_LoginPage verifySignINIs_Ok() {
        String expectedURL = "https://magento.softwaretestingboard.com/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
        return this;
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

    public void store_Cookies_Login_Page() {

        Cookies.storeCookiesToFile(driver,"LoginCookies.txt");
        System.out.println("Cookies stored: LoginCookies");

    }

    public P03_LoginPage load_Cookies_Login_Page() {

        Cookies.loadCookiesFromFile(driver,"LoginCookies.txt");
        System.out.println("Cookies loaded: LoginCookies");

        refreshPage(driver);
        //refreshPage(driver);

        return this;
    }

}
