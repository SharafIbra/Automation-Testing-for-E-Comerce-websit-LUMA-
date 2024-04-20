package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("ALL")
public class P04and5_EditAccountInformation___pages extends basePage {
    WebDriver driver;
    private final By myacountdropdownbutton = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private final By myacount = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]");
    private final By changepassword = new By.ByXPath("//a[@class='action change-password']");
    private final By edit = new By.ByXPath("//span[normalize-space()='Edit']");
    private final By manageaddressesFirstaddesss = new By.ByXPath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[5]/div[1]/a[1]/span[1]");
    //

    private final By addnewaddresses = new By.ByXPath("//span[normalize-space()='Add New Address']");
    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

    public P04and5_EditAccountInformation___pages(WebDriver driver) {
        this.driver = driver;
    }

    public P04_ChangePassword clickChangePassword() {
        fluentWait(driver,myacountdropdownbutton);
        click(driver,myacountdropdownbutton);

        fluentWait(driver,myacount);
        click(driver,myacount);
        click(driver,changepassword);
        return new P04_ChangePassword(driver);
    }

    public P04_ChangeEmail clickChangeEmail() {
        fluentWait(driver,myacountdropdownbutton);
        click(driver,myacountdropdownbutton);

        fluentWait(driver,myacount);
        click(driver,myacount);
        click(driver,edit);
        return new P04_ChangeEmail(driver);
    }

    public P05_AddDefaultAddresses clickAddDefaultAddresses() {
        fluentWait(driver,myacountdropdownbutton);
        click(driver,myacountdropdownbutton);

        fluentWait(driver,myacount);
        click(driver,myacount);

        click(driver, manageaddressesFirstaddesss);
        return new P05_AddDefaultAddresses(driver);
    }




}
