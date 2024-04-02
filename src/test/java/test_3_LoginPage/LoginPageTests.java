package test_3_LoginPage;

import Pages.P01_HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTests {

    @Test(priority = 1, description = "Valid Login Scenario with valid username and password")
    public void testLoginValidCredentials() {
        var log = new P01_HomePage(driver).clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();
        log.verifySignINIs_Ok();

    }

    @Test(priority = 2, description = "Invalid Login Scenario with wrong username and password")
    public void testLoginInValidCredentials() {
        var log = new P01_HomePage(driver).clickLoginPage();
        String password = "__P@ssw0rd__";
        log.setLoginCredentials(email, password);
        log.signIn();
        log.VerifySignINIs_incorrect();
    }


}
