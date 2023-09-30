package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword extends basePage {

    private final By currentpassword = new By.ById("current-password");
    private final By newpassword = new By.ById("password");
    private final By confirmnewpassword = new By.ById("password-confirmation");
    private final By savebutton = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    public ChangePassword(WebDriver driver) {
        this.driver = driver;
    }

    public void setCurrentPassword(String currentPassword) {
        sendKeys(currentpassword, currentPassword);
    }

    public void setNewPassword(String newPassword) {
        sendKeys(newpassword, newPassword);
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        sendKeys(confirmnewpassword, confirmNewPassword);
    }

    public void save() {
        click(savebutton);
    }
}
