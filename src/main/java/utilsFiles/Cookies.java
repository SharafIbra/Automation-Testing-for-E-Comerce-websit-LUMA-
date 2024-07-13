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


    /*public static Set<Cookie> loadCookiesFromFile(WebDriver driver, String filename) {
        Set<Cookie> loadedCookies = readCookiesFromFile(filename);

        // Add the loaded cookies to the new browser session
        assert loadedCookies != null;
        for (Cookie cookie : loadedCookies) {
            driver.manage().addCookie(cookie);
        }

        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (Set<Cookie>) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static Set<Cookie> readCookiesFromFile(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (Set<Cookie>) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
