package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilsFiles.UtilsDriverMethods;

@SuppressWarnings("ALL")
public class P07_AddItemsToShoppingCart_Functions extends UtilsDriverMethods {
    WebDriver driver;

    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    private final By quantity = new By.ById("qty");
    private final By addtocartbutton_f = new By.ById("product-addtocart-button");
    private final By nameofproduct = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1");

    public P07_AddItemsToShoppingCart_Functions(WebDriver driver) {
        this.driver = driver;
    }

    public P07_AddItemsToShoppingCart_Functions WhatsNew_addMultiItem_Women_HoodiesSweatshirts(String productName) {
        //a[normalize-space()='Circe Hooded Ice Fleece']
        String xpath_addtocartbutton = "//a[normalize-space()='" + productName + "']";
        By addtocartbutton = new By.ByXPath(xpath_addtocartbutton);


        fluentWait(driver, addtocartbutton);


        click(driver, addtocartbutton);
        return this;
    }

    public P07_AddItemsToShoppingCart_Functions NavigationBar_addMultiItem_Men_Jackets(String productName) {
        //a[normalize-space()='Circe Hooded Ice Fleece']
        String xpath_addtocartbutton = "//a[normalize-space()='" + productName + "']";
        By addtocartbutton = new By.ByXPath(xpath_addtocartbutton);


        fluentWait(driver, addtocartbutton);


        click(driver, addtocartbutton);
        return this;
    }


    /**
     * size docs
     * xs-> 0    s-> 1      m->2        l->3        xl->4
     */
    public P07_AddItemsToShoppingCart_Functions selectSize(int sizeNum) {
        String xpath_size = "option-label-size-143-item-" + (166 + sizeNum);
        By size = new By.ById(xpath_size);

        fluentWait(driver, size);
        click(driver, size);

        return this;
    }

    /**
     * colour starts with 1
     * first colour-> 1      second colour->2        third colour->3
     */
    public P07_AddItemsToShoppingCart_Functions selectColour(String colourName) {
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

        click(driver, colour);
        return this;
    }

    public P07_AddItemsToShoppingCart_Functions selectQuantity(String Quantity) {
        fluentWait(driver, quantity);
        clear(driver, quantity);
        sendKeys(driver, quantity, Quantity);
        return this;
    }

    public P07_AddItemsToShoppingCart_Functions submitProductToCart() {
        click(driver, addtocartbutton_f);
        /*return driver.findElement(nameofproduct).getText();*/
        return this;
    }

    public String verifyItemAddedToCart() {
        fluentWait(driver, status);

        return getText(driver, status);
    }


}
/*
//a[normalize-space()='Circe Hooded Ice Fleece']
//a[normalize-space()='Eos V-Neck Hoodie']

/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[4]/ol[1]/li[=====]/div[1]/div[1]/strong[1]/a[1]
/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[4]/ol[1]/li[2]/div[1]/div[1]/strong[1]/a[1]


* */

