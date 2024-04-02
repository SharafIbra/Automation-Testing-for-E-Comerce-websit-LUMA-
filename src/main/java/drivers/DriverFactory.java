package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    public static WebDriver getNewInstance(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome-headless":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "firefox-headless":
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                firefoxBinary.addCommandLineOptions("--window-size=1280x720");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);

            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");

                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
        }
    }
}


