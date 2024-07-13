package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilsFiles.Utils;

public class P01_HomePage extends Utils {
    WebDriver driver;
    private final By createAccount = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    private final By signIn = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    private final By forgetPassword = new By.ByXPath("//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a");

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_HomePage refreshHomePage(){
        refreshPage(driver);
        return new P01_HomePage(driver);
    }

    @Step("Click Create account button in home page to create new user account")
    public P02_createAccountPage clickCreateAccountPage() {
        click(driver, createAccount);
        return new P02_createAccountPage(driver);
    }


    @Step("Click Sign In button in home to login ")
    public P03_LoginPage clickLoginPage() {
        click(driver, signIn);
        return new P03_LoginPage(driver);
    }

    public P04_ResetPassword clickForgetPasswordPage() {
        click(driver, signIn);
        click(driver, forgetPassword);
        return new P04_ResetPassword(driver);
    }

    public P04and5_EditAccountInformation___pages clickEditAccountPage() {
        return new P04and5_EditAccountInformation___pages(driver);
    }


    public P07_AddItemsToShoppingCart_Options clickAddItemsToShoppingCart() {
        return new P07_AddItemsToShoppingCart_Options(driver);
    }

    public P06_SearchProduct clickSearchProduct() {
        return new P06_SearchProduct(driver);
    }

    public P08_CheckoutCartItems clickCheckoutCartItems() {
        return new P08_CheckoutCartItems(driver);
    }


}
