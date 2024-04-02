package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage extends basePage {
    WebDriver driver;
    private final By createacount = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    private final By signin = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    private final By forgetpassword = new By.ByXPath("//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a");

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Create account button in home page to create new user account")
    public P02_createAccountPage clickCreateAccountPage() {
        click(driver,createacount);
        return new P02_createAccountPage(driver);
    }


    @Step("Click Sign In button in home to login ")
    public P03_LoginPage clickLoginPage() {
        click(driver,signin);
        return new P03_LoginPage(driver);
    }

    public P04_ForgetPasswordPage clickForgetPasswordPage() {
        click(driver,signin);
        click(driver,forgetpassword);
        return new P04_ForgetPasswordPage(driver);
    }

    public P05_EditAccountInformation clickEditAccountPage() {
        return new P05_EditAccountInformation(driver);
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
