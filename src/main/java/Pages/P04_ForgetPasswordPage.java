package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class P04_ForgetPasswordPage extends basePage {
    WebDriver driver;

    private final By email = new By.ById("email_address");
    private final By resetmypassword = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private final By status = new By.ByXPath("//html/body/div[2]/main/div[2]/div[2]/div/div/div");

    public P04_ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String Email) {
        sendKeys(driver,email, Email);
    }

    public void clickResetMyPassword() {
        click(driver,resetmypassword);
    }

    public String getStatus() {
        return driver.findElement(status).getText();
    }

    public void verifyResetPassword() {
        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2luZGV4Lw%2C%2C/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
    }


}
