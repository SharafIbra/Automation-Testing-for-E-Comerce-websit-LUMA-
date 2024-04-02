package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basePage {



    protected void sendKeys(WebDriver driver,By byObject, String data) {
        driver.findElement(byObject).sendKeys(data);
    }

    protected void click(WebDriver driver,By byObject) {
        driver.findElement(byObject).click();
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getText(WebDriver driver,By byObject) {
        return driver.findElement(byObject).getText();
    }

    protected void clear(WebDriver driver,By byObject) {
        driver.findElement(byObject).clear();
    }


}
