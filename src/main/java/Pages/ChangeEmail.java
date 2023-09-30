package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeEmail extends basePage{
    public ChangeEmail(WebDriver driver)  {this.driver=driver;}

    private By changeemail = new By.ById("change-email");
    private By email = new By.ById("email");
    private By currentpassword = new By.ById("current-password");
    private By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

    public void setChangeEmail(String Email){
        click(changeemail);
        clear(email);
        sendKeys(email,Email);
    }
    public void setCurrentPassword(String Password){
        sendKeys(currentpassword,Password);
    }
    private By savebutton = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    public String getStatus(){
        return getText(status);
    }
    public void save(){click(savebutton);}
}