package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class P03_LoginPage extends basePage {
    WebDriver driver;

    private final By email = new By.ById("email");
    private final By password = new By.ById("pass");
    private final By signin = new By.ById("send2");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

    public P03_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login with email: {0} & password: {1}")
    public P03_LoginPage setLoginCredentials(String Email, String Password) {
        sendKeys(driver,email, Email);
        sendKeys(driver,password, Password);
        return this;
    }

    @Step("Click sign in ")
    public P03_LoginPage signIn() {
        click(driver,signin);
        return this;
    }


    public P03_LoginPage verifySignINIs_Ok() {
        String expectedURL = "https://magento.softwaretestingboard.com/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
        return this;
    }

    public P03_LoginPage VerifySignINIs_incorrect() {
        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
        return this;
    }


}
