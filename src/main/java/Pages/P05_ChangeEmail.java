package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class P05_ChangeEmail extends basePage {
    private final By changeemail = new By.ById("change-email");
    private final By email = new By.ById("email");
    private final By currentpassword = new By.ById("current-password");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    private final By savebutton = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    public P05_ChangeEmail(WebDriver driver) {
        this.driver = driver;
    }

    public void setChangeEmail(String Email) {
        click(changeemail);
        clear(email);
        sendKeys(email, Email);
    }

    public void setCurrentPassword(String Password) {
        sendKeys(currentpassword, Password);
    }

    public String getStatus() {
        return getText(status);
    }

    public void save() {
        click(savebutton);
    }


    public void verifyEmailChanged() {
        String expectedStatus = "https://magento.softwaretestingboard.com/customer/account/login/";
        String actualStatus = getCurrentURL();
        assertEquals(actualStatus, expectedStatus, "Password not changed");
    }
}