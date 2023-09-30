package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class AddItemsToShoppingCart extends basePage {
    private final By whatisnewbutton = new By.ByCssSelector("#ui-id-2 > li.level0.nav-1.category-item.first.level-top.ui-menu-item");

    public AddItemsToShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public AddItemsToShoppingCart_WhatIsNew clickAddItemsToShoppingCart_WhatIsNew() {

        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(whatisnewbutton));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(whatisnewbutton)).perform();


        click(whatisnewbutton);
        return new AddItemsToShoppingCart_WhatIsNew(driver);
    }


}
