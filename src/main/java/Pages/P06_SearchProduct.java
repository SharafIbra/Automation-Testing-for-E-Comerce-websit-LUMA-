package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilsFiles.UtilsDriverMethods;

public class P06_SearchProduct extends UtilsDriverMethods {
    WebDriver driver;
    private final By searchtextfield = new By.ById("search");
    private final By searchButton = new By.ByXPath("//*[@id=\"search_mini_form\"]/div[2]/button");
    private final By searchresultsstatus = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/h1/span");

    public P06_SearchProduct(WebDriver driver) {
        this.driver = driver;
    }


    public P06_SearchProduct enterProductName(String productName) {
        /*FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchtextfield)));*/
        click(driver, searchtextfield);
        sendKeys(driver, searchtextfield, productName);
        click(driver, searchButton);
        return this;
    }

    public String getStatus() {
        return driver.findElement(searchresultsstatus).getText();
    }


}
