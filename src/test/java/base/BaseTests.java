package base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests  extends testData{
    WebDriver driver;

    protected HomePage homePage;

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

    @AfterMethod
    public void tearDown() {driver.quit();}


}
