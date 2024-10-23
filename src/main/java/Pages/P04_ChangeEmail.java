package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilsFiles.UtilesHelper;

import static org.testng.Assert.assertEquals;

public class P04_ChangeEmail extends UtilesHelper {
    WebDriver driver;
    private final By changeemail = new By.ById("change-email");
    private final By email = new By.ById("email");
    private final By currentpassword = new By.ById("current-password");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    private final By savebutton = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    public P04_ChangeEmail(WebDriver driver) {
        this.driver = driver;
    }

    public P04_ChangeEmail setChangeEmail(String Email) {
        click(driver, changeemail);
        clear(driver, email);
        sendKeys(driver, email, Email);
        return this;
    }

    public P04_ChangeEmail setCurrentPassword(String Password) {
        sendKeys(driver, currentpassword, Password);
        return this;
    }

    public String getStatus() {
        return getText(driver, status);
    }

    public P04_ChangeEmail save() {
        click(driver, savebutton);
        return this;
    }

    public P04_ChangeEmail verifyEmailChanged() {
        String expectedStatus = "https://magento.softwaretestingboard.com/customer/account/login/";
        String actualStatus = getCurrentURL(driver);
        assertEquals(actualStatus, expectedStatus, "Password not changed");
        return this;
    }


}