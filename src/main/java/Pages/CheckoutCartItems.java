package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CheckoutCartItems extends basePage {
    private final By cartbtn = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]/a");
    private final By topcartcheckoutbutton = new By.ById("top-cart-btn-checkout");
    private final By nextbtn = new By.ByXPath("//button[@class='button action continue primary']");
    private final By placeorderbtn = new By.ByXPath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[3]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/button[1]/span[1]");
    private final By thankstatus = new By.ByXPath("//span[@class='base']");
    public CheckoutCartItems(WebDriver driver) {
        this.driver = driver;
    }

    public void checkoutItemInCart() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(cartbtn));
        click(cartbtn);

        wait.until(ExpectedConditions.presenceOfElementLocated(topcartcheckoutbutton));
        click(topcartcheckoutbutton);

        wait.until(ExpectedConditions.presenceOfElementLocated(nextbtn));
        click(nextbtn);

        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(placeorderbtn));
        actions.moveToElement(driver.findElement(placeorderbtn)).perform();
        click(placeorderbtn);
        wait.until((ExpectedConditions.presenceOfElementLocated(thankstatus)));

    }


}
