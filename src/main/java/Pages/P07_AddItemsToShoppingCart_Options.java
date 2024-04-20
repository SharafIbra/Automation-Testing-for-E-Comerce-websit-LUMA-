package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@SuppressWarnings("ALL")
public class P07_AddItemsToShoppingCart_Options extends basePage {
    WebDriver driver;
    private final By whatisnewbutton = new By.ByCssSelector("#ui-id-2 > li.level0.nav-1.category-item.first.level-top.ui-menu-item");

    private final By hoodiessweatshirts_women___whatsnew = new By.ByXPath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[1]/a");


    private final By mennavigation = new By.ById("ui-id-5");
    private final By mentops = new By.ById("ui-id-17");
    private final By mentopsjackets = new By.ById("ui-id-19");


    public P07_AddItemsToShoppingCart_Options(WebDriver driver) {
        this.driver = driver;
    }


    public P07_AddItemsToShoppingCart_Functions clickWhatIsNew_NewInWomen_HoodiesSweatshirts_AddItem() {

        fluentWait(driver,whatisnewbutton);

        click(driver,whatisnewbutton);

        click(driver,hoodiessweatshirts_women___whatsnew);
        return new P07_AddItemsToShoppingCart_Functions(driver);
    }


    public P07_AddItemsToShoppingCart_Functions clickWhatIsNew_NewInWomen_HoodiesSweatshirts_AddItem___modified() {

        fluentWait(driver,whatisnewbutton);

        click(driver,whatisnewbutton);

        click(driver,hoodiessweatshirts_women___whatsnew);
        return new P07_AddItemsToShoppingCart_Functions(driver);
    }


    public P07_AddItemsToShoppingCart_Functions clickNavigation_Men_Top_Jackets_AddItem() {

        Actions actions = new Actions(driver);

        fluentWait(driver,mennavigation);
        actions.moveToElement(driver.findElement(mennavigation)).perform();

        fluentWait(driver,mentops);
        actions.moveToElement(driver.findElement(mentops)).perform();

        fluentWait(driver,mentopsjackets);
        actions.moveToElement(driver.findElement(mentopsjackets)).perform();

        click(driver,mentopsjackets);

        return new P07_AddItemsToShoppingCart_Functions(driver);
    }


}
