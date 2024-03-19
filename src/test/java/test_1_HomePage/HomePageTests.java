package test_1_HomePage;

import base.BaseTests;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTests {


    @Test
    void testCreateAcount() {
        p01HomePage.clickCreateAccountPage();

    }

    @Test
    void testSignIn() {
        p01HomePage.clickLoginPage();
    }
}
