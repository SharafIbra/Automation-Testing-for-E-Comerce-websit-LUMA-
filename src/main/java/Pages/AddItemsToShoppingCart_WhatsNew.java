package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@SuppressWarnings("ALL")
public class AddItemsToShoppingCart_WhatsNew extends basePage {

    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    private final By quantity = new By.ById("qty");
    private final By addtocartbutton_f = new By.ById("product-addtocart-button");
    private final By nameofproduct = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1");

    public AddItemsToShoppingCart_WhatsNew(WebDriver driver) {
        this.driver = driver;
    }

    public void addMultiItem_Women_HoodiesSweatshirts(String productName) {
        //a[normalize-space()='Circe Hooded Ice Fleece']
        String xpath_addtocartbutton = "//a[normalize-space()='"+productName+"']";
        By addtocartbutton = new By.ByXPath(xpath_addtocartbutton);


        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addtocartbutton)));


        click(addtocartbutton);

        }

    /**
     * size docs
     * xs-> 0    s-> 1      m->2        l->3        xl->4
     */
    public void selectSize(int sizeNum) {
        String xpath_size = "option-label-size-143-item-" + (166 + sizeNum);
        By size = new By.ById(xpath_size);

        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(size));
        click(size);

    }

    /**
     * colour starts with 1
     * first colour-> 1      second colour->2        third colour->3
     */
    public void selectColour(String colourName) {
        String xpath_colour = switch (colourName) {
            case "Pink" -> xpath_colour = "option-label-color-93-item-57";
            case "White" -> xpath_colour = "option-label-color-93-item-59";
            case "Yellow" -> xpath_colour = "option-label-color-93-item-60";
            case "Gray" -> xpath_colour = "option-label-color-93-item-52";
            case "Green" -> xpath_colour = "option-label-color-93-item-53";
            case "Orange" -> xpath_colour = "option-label-color-93-item-56";
            case "Black" -> xpath_colour = "option-label-color-93-item-49";
            case "Red" -> xpath_colour = "option-label-color-93-item-58";
            case "Blue" -> xpath_colour = "option-label-color-93-item-50";
            default -> throw new IllegalStateException("Unexpected value: " + colourName);
        };

        By colour = new By.ById(xpath_colour);

        click(colour);
    }

    public void selectQuantity(String Quantity) {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(quantity));
        clear(quantity);
        sendKeys(quantity, Quantity);
    }

    public String submitProductToCart() {
        click(addtocartbutton_f);
        return driver.findElement(nameofproduct).getText();
    }

    public String verifyItemAddedToCart() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(status));

        return getText(status);
    }


}
/*
//a[normalize-space()='Circe Hooded Ice Fleece']
//a[normalize-space()='Eos V-Neck Hoodie']

/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[4]/ol[1]/li[=====]/div[1]/div[1]/strong[1]/a[1]
/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[4]/ol[1]/li[2]/div[1]/div[1]/strong[1]/a[1]


* */

