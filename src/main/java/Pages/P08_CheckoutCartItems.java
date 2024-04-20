package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class P08_CheckoutCartItems extends basePage {
    WebDriver driver;
    private final By cartbtn = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]/a");
    private final By topcartcheckoutbutton = new By.ById("top-cart-btn-checkout");
    private final By nextbtn = new By.ByXPath("//button[@class='button action continue primary']");
    private final By placeorderbtn = new By.ByXPath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[3]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/button[1]/span[1]");
    private final By thankstatus = new By.ByXPath("//span[@class='base']");
    public P08_CheckoutCartItems(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOutItemInCart() {
        fluentWait(driver,cartbtn);
        click(driver,cartbtn);

        fluentWait(driver,topcartcheckoutbutton);
        click(driver,topcartcheckoutbutton);

        fluentWait(driver,nextbtn);
        click(driver,nextbtn);

        Actions actions = new Actions(driver);
        fluentWait(driver,placeorderbtn);
        actions.moveToElement(driver.findElement(placeorderbtn)).perform();

        click(driver,placeorderbtn);
        fluentWait(driver,thankstatus);

    }


}
