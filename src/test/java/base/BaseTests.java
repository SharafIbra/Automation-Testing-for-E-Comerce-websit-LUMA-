package base;

import Pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests  extends testData{
    WebDriver driver;

    protected HomePage homePage;

    @Step("Open the Application")
    @BeforeMethod
        public void setUpChromeDriver() {
        driver = new ChromeDriver();
        goHome();
    }


    public void goHome(){
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Step("Close the Application")
    @AfterMethod
    public void tearDown() {driver.quit();}


}
