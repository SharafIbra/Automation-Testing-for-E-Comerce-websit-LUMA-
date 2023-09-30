package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

@SuppressWarnings("ALL")
public class EditAccountInformation extends basePage {
    private final By myacountdropdownbutton = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private final By myacount = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]");
    private final By changepassword = new By.ByXPath("//a[@class='action change-password']");
    private final By edit = new By.ByXPath("//span[normalize-space()='Edit']");
    private final By manageaddresses = new By.ByXPath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[4]/div[1]/a[1]/span[1]");
    private final By addnewaddresses = new By.ByXPath("//span[normalize-space()='Add New Address']");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

    public EditAccountInformation(WebDriver driver) {
        this.driver = driver;
    }

    public ChangePassword clickChangePassword() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(myacountdropdownbutton));
        click(myacountdropdownbutton);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(myacount);
        click(changepassword);
        return new ChangePassword(driver);
    }

    public ChangeEmail clickChangeEmail() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(myacountdropdownbutton));
        click(myacountdropdownbutton);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(myacount);
        click(edit);
        return new ChangeEmail(driver);
    }

    public AddDefaultAddresses clickAddDefaultAddresses() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(myacountdropdownbutton));
        click(myacountdropdownbutton);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(myacount);

        click(manageaddresses);
        return new AddDefaultAddresses(driver);
    }

    public AddNewAddresses clickAddNewAddresses() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(myacountdropdownbutton));
        click(myacountdropdownbutton);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myacount)));
        click(myacount);

        click(manageaddresses);

        click(addnewaddresses);
        return new AddNewAddresses(driver);
    }




}
