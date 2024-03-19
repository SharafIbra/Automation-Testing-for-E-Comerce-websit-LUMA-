package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class P03_LoginPage extends basePage {

    private final By email = new By.ById("email");
    private final By password = new By.ById("pass");
    private final By signin = new By.ById("send2");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

    public P03_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login with email: {0} & password: {1}")
    public void setLoginCredentials(String Email, String Password) {
        sendKeys(email, Email);
        sendKeys(password, Password);
    }

    @Step("Click sign in ")
    public void signIn() {
        click(signin);
    }


    public void verifySignINIs_Ok() {
        String expectedURL = "https://magento.softwaretestingboard.com/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
    }

    public void VerifySignINIs_incorrect() {
        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
    }


}
