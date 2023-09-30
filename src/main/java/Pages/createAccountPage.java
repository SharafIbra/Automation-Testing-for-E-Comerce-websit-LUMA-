package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class createAccountPage extends basePage{
    public createAccountPage(WebDriver driver) {
        this.driver=driver;
    }

    private By firstname = new By.ById("firstname");
    private By lastname = new By.ById("lastname");
    private By email = new By.ById("email_address");
    private By password = new By.ById("password");
    private By confirmpassword = new By.ById("password-confirmation");

    private By createacountbutton = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    private By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");





    








    public void setPersonalInformation(String firstName,String lastName){
        sendKeys(firstname,firstName);
        sendKeys(lastname,lastName);
    }

    public void setSignInInformation(String Email,String Password,String confirmPassword){
        sendKeys(email,Email);
        sendKeys(password,Password);
        sendKeys(confirmpassword,confirmPassword);
    }
    public void create_account(){
        click(createacountbutton);
    }

    public String getStatus(){
        return driver.findElement(status).getText();
    }
}
