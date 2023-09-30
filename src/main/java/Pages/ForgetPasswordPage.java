package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage extends basePage {

    public ForgetPasswordPage(WebDriver driver) {this.driver=driver;}

    private By email = new By.ById("email_address");
    private By resetmypassword = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private By status = new By.ByXPath("//html/body/div[2]/main/div[2]/div[2]/div/div/div");

    public void enterEmail(String Email){sendKeys(email,Email);}
    public void clickResetMyPassword(){click(resetmypassword);}
    public String getStatus(){
        return driver.findElement(status).getText();
    }



}
