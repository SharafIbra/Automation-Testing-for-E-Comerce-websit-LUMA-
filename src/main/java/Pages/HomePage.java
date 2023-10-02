package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends basePage {
    private final By createacount = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    private final By signin = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    private final By forgetpassword = new By.ByXPath("//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Create account button in home page to create new user account")
    public createAccountPage clickCreateAccountPage() {
        click(createacount);
        return new createAccountPage(driver);
    }


    @Step("Click Sign In button in home to login ")
    public LoginPage clickLoginPage() {
        click(signin);
        return new LoginPage(driver);
    }

    public ForgetPasswordPage clickForgetPasswordPage() {
        click(signin);
        click(forgetpassword);
        return new ForgetPasswordPage(driver);
    }

    public EditAccountInformation clickEditAccountPage() {
        return new EditAccountInformation(driver);
    }


    public AddItemsToShoppingCart clickAddItemsToShoppingCart() {
        return new AddItemsToShoppingCart(driver);
    }

    public SearchProduct clickSearchProduct() {
        return new SearchProduct(driver);
    }

    public CheckoutCartItems clickCheckoutCartItems() {
        return new CheckoutCartItems(driver);
    }


}
