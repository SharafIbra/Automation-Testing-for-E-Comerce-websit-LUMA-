package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditAccountInformation extends basePage {
    private final By myacountdropdownbutton = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private final By myacount = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]");
    private final By changepassword = new By.ByXPath("//a[@class='action change-password']");
    private final By edit = new By.ByXPath("//span[normalize-space()='Edit']");
    private final By manageaddresses = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[1]/a");
    private final By addnewaddresses = new By.ByXPath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[6]/div[1]/button");

    public EditAccountInformation(WebDriver driver) {
        this.driver = driver;
    }

    public ChangePassword clickChangePassword() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(myacountdropdownbutton)));
        click(myacountdropdownbutton);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(myacount);
        click(changepassword);
        return new ChangePassword(driver);
    }

    public ChangeEmail clickChangeEmail() {
        click(myacountdropdownbutton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(myacount);
        click(edit);
        return new ChangeEmail(driver);
    }

    public AddDefaultAddresses clickAddDefaultAddresses() {
        click(myacountdropdownbutton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(myacount);
        click(manageaddresses);
        return new AddDefaultAddresses(driver);
    }

    public AddNewAddresses clickAddNewAddresses() {
        click(myacountdropdownbutton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(myacount);
        click(manageaddresses);
        click(addnewaddresses);
        return new AddNewAddresses(driver);
    }


}
