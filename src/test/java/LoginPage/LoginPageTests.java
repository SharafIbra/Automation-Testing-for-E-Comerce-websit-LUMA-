package LoginPage;

import base.BaseTests;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTests {

    @Test(priority = 1, description = "Valid Login Scenario with valid username and password")
    public void testLogin() {
        var log = homePage.clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();
        log.verifySignINIs_Ok();

    }

    @Test(priority = 2, description = "Invalid Login Scenario with wrong username and password")
    public void testLogin_invalidCredentials() {
        var log = homePage.clickLoginPage();
        String password = "__P@ssw0rd__";
        log.setLoginCredentials(email, password);
        log.signIn();
        log.VerifySignINIs_incorrect();
    }


}
