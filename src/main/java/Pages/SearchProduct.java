package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProduct extends basePage {
    private final By searchtextfield = new By.ById("search");
    private final By searchButton = new By.ByXPath("//*[@id=\"search_mini_form\"]/div[2]/button");
    private final By searchresultsstatus = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/h1/span");

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
    }


    public void enterProductName(String productName) {
        /*FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchtextfield)));*/
        click(searchtextfield);
        sendKeys(searchtextfield, productName);
        click(searchButton);
    }

    public String getStatus() {
        return driver.findElement(searchresultsstatus).getText();
    }


}
