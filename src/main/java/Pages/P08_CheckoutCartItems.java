package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilsFiles.Utils;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class P08_CheckoutCartItems extends Utils {
    WebDriver driver;
    private final By cartbtn = new By.ByXPath("/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/a[1]");
    private final By cartbtn_ = new By.ByCssSelector(".action.showcart");

    private final By topcartcheckoutbutton = new By.ById("top-cart-btn-checkout");
    private final By nextbtn = new By.ByXPath("//button[@class='button action continue primary']");
    private final By placeorderbtn = new By.ByXPath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[3]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/button[1]/span[1]");
    private final By thankstatus = new By.ByXPath("//span[@class='base']");
    private final By purchasedSuccessfullyStatus = new By.ByXPath("/html[1]/body[1]/div[2]/main[1]/div[1]/h1[1]/span[1]");
    private final By counterCart = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]");

    public P08_CheckoutCartItems(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean validateIfCartContainProducts() {
        fluentWait(driver, counterCart);
        boolean status = false;
        String statusS = driver.findElement(counterCart).getText();


        if (!Objects.equals(statusS, "0"))
            status = true;
        return status;
    }

    public P08_CheckoutCartItems checkOutItemInCart() {

        fluentWait(driver, counterCart);
        System.out.println("number of PRODUCTS in Cart>>" + driver.findElement(counterCart).getText());

        Actions actions = new Actions(driver);
        fluentWait(driver, cartbtn_);
        actions.moveToElement(driver.findElement(cartbtn_)).perform();

        fluentWait(driver, cartbtn_);
        click(driver, cartbtn_);

        fluentWait(driver, topcartcheckoutbutton);
        click(driver, topcartcheckoutbutton);

        fluentWait(driver, nextbtn);
        click(driver, nextbtn);

        fluentWait(driver, placeorderbtn);
        actions.moveToElement(driver.findElement(placeorderbtn)).perform();

        click(driver, placeorderbtn);
        fluentWait(driver, thankstatus);
        return this;
    }

    public P08_CheckoutCartItems validateOrderPlacedSuccessfully() {
        fluentWait(driver, purchasedSuccessfullyStatus);

        boolean status = driver.findElement(purchasedSuccessfullyStatus).isDisplayed();
        assertTrue(status, "No items purchased");
        return this;
    }

}
