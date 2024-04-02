package base;

import Pages.P01_HomePage;
import drivers.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static drivers.DriverHolder.setDriver;

public class BaseTests extends testData {
    private static String PROJECT_NAME = null;
    private static String PROJECT_URL = null;
    static Properties prop;
    static FileInputStream readProperty;

    protected WebDriver driver;

    @BeforeSuite
    public void defineSuite() throws Exception {
        setProjectDetails();

    }

    private void setProjectDetails() throws IOException, IOException {
        // TODO: Step1: define object of properties file
        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/resources/properties/env.properties");
        prop = new Properties();
        prop.load(readProperty);

        // define project name from properties file
        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");
    }


    @Parameters("browser")
    @BeforeTest
    public void setupDriver(@Optional("chrome")String browser) {
        driver = DriverFactory.getNewInstance(browser);
        setDriver(driver);
        driver.get(PROJECT_URL);
        /*driver.get("https://magento.softwaretestingboard.com/");*/
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        Thread.currentThread().interrupt(); // after driver close , close opened thread which open in each run
    }









}
   /* protected P01_HomePage p01HomePage;
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setBrowserDriver(@Optional("chrome") String browser) throws Exception {

        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //create chrome instance
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("Edge")) {
            //create Edge instance
            driver = new EdgeDriver();
        } else {
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

    private ChromeOptions chromeOptions() {
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
*/