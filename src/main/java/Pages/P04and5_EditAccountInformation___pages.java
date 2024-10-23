package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilsFiles.Cookies;
import utilsFiles.UtilesHelper;

@SuppressWarnings("ALL")
public class P04and5_EditAccountInformation___pages extends UtilesHelper {
    WebDriver driver;
    private final By myacountdropdownbutton = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private final By myacount = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]");
    private final By changepassword = new By.ByXPath("//a[@class='action change-password']");
    private final By edit = new By.ByXPath("//span[normalize-space()='Edit']");
    private final By manageaddresses = new By.ByXPath("/html/body/div[2]/main/div[2]/div[1]/div[4]/div[1]/a/span");
    private final By addnewaddress = new By.ByXPath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[5]/div[1]/button[1]/span[1]");

    ///html/body/div[2]/main/div[2]/div[1]/div[4]/div[1]/a/span


    private final By status = new By.ByXPath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

    public P04and5_EditAccountInformation___pages(WebDriver driver) {
        this.driver = driver;
    }

    public P04_ChangePassword clickChangePassword() {
        fluentWait(driver, myacountdropdownbutton);
        click(driver, myacountdropdownbutton);

        fluentWait(driver, myacount);
        click(driver, myacount);
        click(driver, changepassword);
        return new P04_ChangePassword(driver);
    }

    public P04_ChangeEmail clickChangeEmail() {
        fluentWait(driver, myacountdropdownbutton);
        click(driver, myacountdropdownbutton);

        fluentWait(driver, myacount);
        click(driver, myacount);
        click(driver, edit);
        return new P04_ChangeEmail(driver);
    }

    /*
    *
    * Add First Address (Default address)
    * this can be used only one time for same user
    * */
    public P05_AddAddresses clickAddDefaultAddress() {
        fluentWait(driver, myacountdropdownbutton);
        click(driver, myacountdropdownbutton);

        fluentWait(driver, myacount);
        click(driver, myacount);

        click(driver, manageaddresses);
        return new P05_AddAddresses(driver);
    }


    /*
     *
     * Add New Address
     * this can be used many times for same user
     * */

    public P05_AddAddresses clickAddNewAddress() {
        fluentWait(driver, myacountdropdownbutton);
        click(driver, myacountdropdownbutton);

        fluentWait(driver, myacount);
        click(driver, myacount);
        click(driver, manageaddresses);
        click(driver, addnewaddress);
        return new P05_AddAddresses(driver);
    }




    /*
     *
     * Use Cookies
     *
     * */

    public P04and5_EditAccountInformation___pages store_Cookies_MyAccount_Page() {

        Cookies.storeCookiesToFile(driver, "MyAccountCookies" ,"D:\\St\\Testing\\Projects\\1-LUMA\\CookiesDataFiles\\");
        System.out.println("Cookies stored: MyAccountCookies");

        return this;
    }



}
