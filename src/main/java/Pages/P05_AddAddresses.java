package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilsFiles.UtilesHelper;

import static org.testng.Assert.assertEquals;

public class P05_AddAddresses extends UtilesHelper {
    WebDriver driver;


    private final By firstname = new By.ById("firstname");
    private final By lastname = new By.ById("lastname");
    private final By company = new By.ById("company");
    private final By telephone = new By.ById("telephone");
    private final By street_1 = new By.ById("street_1");
    private final By street_2 = new By.ById("street_2");
    private final By street_3 = new By.ById("street_3");
    private final By city = new By.ById("city");
    private final By state = new By.ById("region");
    private final By statedropdown = new By.ById("region_id");
    private final By postalcode = new By.ById("zip");
    private final By countrydropdown = new By.ById("country");
    private final By saveaddress = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    private final By addnewaddresses = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[6]/div[1]/button");

    public P05_AddAddresses(WebDriver driver) {
        this.driver = driver;
    }

    public P05_AddAddresses setContactInformation(String FirstName, String LastName, String Company, String PhoneNumber) {
        clear(driver, firstname);
        sendKeys(driver, firstname, FirstName);
        clear(driver, lastname);
        sendKeys(driver, lastname, LastName);
        sendKeys(driver, company, Company);
        sendKeys(driver, telephone, PhoneNumber);
        return this;
    }

    public P05_AddAddresses setStreetAddress(String Address1, String Address2, String Address3) {
        sendKeys(driver, street_1, Address1);
        sendKeys(driver, street_2, Address2);
        sendKeys(driver, street_3, Address3);
        return this;
    }

    public P05_AddAddresses setCity(String City) {
        sendKeys(driver, city, City);
        return this;
    }

    public P05_AddAddresses setState_DROPDOWN(String State) {
        Select select = new Select(driver.findElement(statedropdown));
        select.selectByVisibleText(State);
        return this;
    }

    public P05_AddAddresses setState(String State) {
        sendKeys(driver, state, State);
        return this;
    }

    public P05_AddAddresses setPostalCode(String PostalCode) {
        sendKeys(driver, postalcode, PostalCode);
        return this;
    }

    public P05_AddAddresses setCountrydropdown(String Country) {
        Select select = new Select(driver.findElement(countrydropdown));
        select.selectByVisibleText(Country);
        return this;
    }

    public P05_AddAddresses saveAddress() {
        click(driver, saveaddress);
        return this;
    }

    public P05_AddAddresses verifyAddressAdded() {
        //fluentWait(driver, status);


        String expectedStatus = "https://magento.softwaretestingboard.com/customer/address/index/";
        String actualStatus = getCurrentURL(driver);
        assertEquals(actualStatus, expectedStatus, "Address not saved");
        return this;
    }








}
