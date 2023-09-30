package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends basePage {

    public LoginPage(WebDriver driver) {
    this.driver=driver;
    }

    private By email = new By.ById("email");
    private By password = new By.ById("pass");
    private By signin = new By.ById("send2");
    private By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

    public void setLoginCredentials(String Email, String Password){
        sendKeys(email,Email);
        sendKeys(password,Password);
    }
    public void signIn(){
        click(signin);
    }

    public String getURL(){return driver.getCurrentUrl();}
    public String getStatus(){
        return driver.findElement(status).getText();
    }


}
