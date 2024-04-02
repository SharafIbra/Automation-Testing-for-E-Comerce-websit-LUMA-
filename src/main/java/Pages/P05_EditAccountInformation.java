package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@SuppressWarnings("ALL")
public class P05_EditAccountInformation extends basePage {
    WebDriver driver;
    private final By myacountdropdownbutton = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private final By myacount = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]");
    private final By changepassword = new By.ByXPath("//a[@class='action change-password']");
    private final By edit = new By.ByXPath("//span[normalize-space()='Edit']");
    private final By manageaddresses = new By.ByXPath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[4]/div[1]/a[1]/span[1]");
    private final By addnewaddresses = new By.ByXPath("//span[normalize-space()='Add New Address']");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

    public P05_EditAccountInformation(WebDriver driver) {
        this.driver = driver;
    }

    public P05_ChangePassword clickChangePassword() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(myacountdropdownbutton));
        click(driver,myacountdropdownbutton);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(driver,myacount);
        click(driver,changepassword);
        return new P05_ChangePassword(driver);
    }

    public P05_ChangeEmail clickChangeEmail() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(myacountdropdownbutton));
        click(driver,myacountdropdownbutton);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(driver,myacount);
        click(driver,edit);
        return new P05_ChangeEmail(driver);
    }

    public P05_AddDefaultAddresses clickAddDefaultAddresses() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(myacountdropdownbutton));
        click(driver,myacountdropdownbutton);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(driver,myacount);

        click(driver,manageaddresses);
        return new P05_AddDefaultAddresses(driver);
    }

    public P05_AddNewAddresses clickAddNewAddresses() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(myacountdropdownbutton));
        click(driver,myacountdropdownbutton);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(driver,myacount);

        click(driver,manageaddresses);

        click(driver,addnewaddresses);
        return new P05_AddNewAddresses(driver);
    }


}
