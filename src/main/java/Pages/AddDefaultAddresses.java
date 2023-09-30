package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddDefaultAddresses extends basePage{


    public AddDefaultAddresses(WebDriver driver) {this.driver=driver;}

    private By firstname = new By.ById("firstname");
    private By lastname = new By.ById("lastname");
    private By company = new By.ById("company");
    private By telephone = new By.ById("telephone");
    private By street_1 = new By.ById("street_1");
    private By street_2 = new By.ById("street_2");
    private By street_3 = new By.ById("street_3");
    private By city = new By.ById("city");
    private By state = new By.ById("region");
    private By statedropdown = new By.ById("region_id");
    private By postalcode = new By.ById("zip");
    private By countrydropdown = new By.ById("country");
    private By saveaddress = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    private By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

    public void setContactInformation(String FirstName,String LastName,String Company,String PhoneNumber){
        clear(firstname);
        sendKeys(firstname,FirstName);
        clear(lastname);
        sendKeys(lastname,LastName);
        sendKeys(company,Company);
        sendKeys(telephone,PhoneNumber);
    }
    public void setStreetAddress(String Address1,String Address2,String Address3){
        sendKeys(street_1,Address1);
        sendKeys(street_2,Address2);
        sendKeys(street_3,Address3);
    }
    public void setCity(String City){sendKeys(city,City);}
    public void setState_DROPDOWN(String State){
        Select select = new Select(driver.findElement(statedropdown));
        select.selectByVisibleText(State);
    }
    public void setState(String State){
        sendKeys(state,State);
    }
    public void setPostalCode(String PostalCode){sendKeys(postalcode,PostalCode);}

    public void setCountrydropdown(String Country){
        Select select = new Select(driver.findElement(countrydropdown));
        select.selectByVisibleText(Country);
    }
    public void saveAddress(){click(saveaddress);}

    public String getStatus(){
        return getText(status);
    }

}
