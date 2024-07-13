package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilsFiles.Utils;

import static org.testng.Assert.assertEquals;

public class P04_ChangePassword extends Utils {
    WebDriver driver;

    private final By currentpassword = new By.ById("current-password");
    private final By newpassword = new By.ById("password");
    private final By confirmnewpassword = new By.ById("password-confirmation");
    private final By savebutton = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    public P04_ChangePassword(WebDriver driver) {
        this.driver = driver;
    }

    public P04_ChangePassword setCurrentPassword(String currentPassword) {
        sendKeys(driver, currentpassword, currentPassword);
        return this;
    }

    public P04_ChangePassword setNewPassword(String newPassword) {
        sendKeys(driver, newpassword, newPassword);
        return this;
    }

    public P04_ChangePassword setConfirmNewPassword(String confirmNewPassword) {
        sendKeys(driver, confirmnewpassword, confirmNewPassword);
        return this;
    }

    public P04_ChangePassword save() {
        click(driver, savebutton);
        return this;
    }

    public P04_ChangePassword verifyPasswordChanged() {
        String expectedStatus = "https://magento.softwaretestingboard.com/customer/account/login/";
        String actualStatus = getCurrentURL(driver);
        assertEquals(actualStatus, expectedStatus, "Password not changed");
        return this;
    }
}
