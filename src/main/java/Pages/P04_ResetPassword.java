package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class P04_ResetPassword extends basePage {
    WebDriver driver;

    private final By email = new By.ById("email_address");
    private final By resetmypassword = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private final By status = new By.ByXPath("//html/body/div[2]/main/div[2]/div[2]/div/div/div");

    public P04_ResetPassword(WebDriver driver) {
        this.driver = driver;
    }

    public P04_ResetPassword enterEmail(String Email) {
        sendKeys(driver,email, Email);
        return this;
    }

    public P04_ResetPassword clickResetMyPassword() {
        click(driver,resetmypassword);
        return this;
    }

    public String getStatus() {
        return driver.findElement(status).getText();
    }

    public P04_ResetPassword verifyForgetPassword() {
        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2luZGV4Lw%2C%2C/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
        return this;
    }


}
