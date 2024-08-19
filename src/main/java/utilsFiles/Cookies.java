package utilsFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cookies {

    private static final Logger LOGGER = Logger.getLogger(Cookies.class.getName());

    public static void storeCookiesToFile(WebDriver driver, String filename, String path) {
        if (driver == null || filename == null || path == null) {
            throw new IllegalArgumentException("Driver, filename, and path must not be null.");
        }

        Set<Cookie> cookies = driver.manage().getCookies();
        Path filePath = Paths.get(path, filename);

        try (FileOutputStream fileOut = new FileOutputStream(filePath.toFile());
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(cookies);
            LOGGER.log(Level.INFO, "Cookies stored successfully at {0}", filePath.toString());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to store cookies to file", e);
        }
    }

    public static Set<Cookie> loadCookiesFromFile(WebDriver driver, String filename, String path) {
        if (driver == null || filename == null || path == null) {
            throw new IllegalArgumentException("Driver, filename, and path must not be null.");
        }

        Path filePath = Paths.get(path, filename);

        if (!Files.exists(filePath)) {
            LOGGER.log(Level.WARNING, "Cookie file not found: {0}", filePath.toString());
            return null;
        }

        try (FileInputStream fileIn = new FileInputStream(filePath.toFile());
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            Set<Cookie> loadedCookies = (Set<Cookie>) objectIn.readObject();

            if (loadedCookies != null) {
                for (Cookie cookie : loadedCookies) {
                    driver.manage().addCookie(cookie);
                }
                LOGGER.log(Level.INFO, "Cookies loaded successfully from {0}", filePath.toString());
            } else {
                LOGGER.log(Level.WARNING, "No cookies found in the file: {0}", filePath.toString());
            }

            return loadedCookies;
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Failed to load cookies from file", e);
            return null;
        }
    }

    // Optional overloaded method using default path
    public static Set<Cookie> loadCookiesFromFile(WebDriver driver, String filename) {
        return loadCookiesFromFile(driver, filename, "default/cookie/path/");
    }



    // Method to validate if the session is active after loading cookies
    public static boolean isSessionActive(WebDriver driver) {
        // Implement a check to verify session status, e.g., checking for a specific element
        try {
            driver.navigate().refresh();
            return driver.findElement(By.id("logoutButton")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Session is not active", e);
            return false;
        }
    }
}























































/*


package utilsFiles;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Set;

public class Cookies {




    public static void storeCookiesToFile(WebDriver driver, String filename) {
        Set<Cookie> cookies = driver.manage().getCookies();

        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(cookies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<Cookie> loadCookiesFromFile(WebDriver driver, String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Set<Cookie> loadedCookies = (Set<Cookie>) objectIn.readObject();

            // Add the loaded cookies to the new browser session
            assert loadedCookies != null;
            for (Cookie cookie : loadedCookies) {
                driver.manage().addCookie(cookie);
            }

            return loadedCookies;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
*/
