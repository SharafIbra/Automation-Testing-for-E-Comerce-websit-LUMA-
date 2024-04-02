package test_1_HomePage;

import Pages.P01_HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTests {


    @Test
    public void testCreateAcount() {
        new P01_HomePage(driver).clickLoginPage();

    }

    @Test
    void testSignIn() {
        new P01_HomePage(driver).clickLoginPage();
    }
}
