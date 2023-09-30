package base;

import Pages.HomePage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
