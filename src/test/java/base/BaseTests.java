package base;

import Pages.P01_HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTests extends testData {
    protected P01_HomePage p01HomePage;
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setBrowserDriver(@Optional("chrome")String browser) throws Exception {

        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //create chrome instance
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){
            //create Edge instance
            driver = new EdgeDriver();
        }
        else{
           //run on chrome
            driver = new ChromeDriver();
        }

        goHome();
    }


    public void goHome() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        p01HomePage = new P01_HomePage(driver);
    }

      private ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }





    @Step("Close the Application")
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
