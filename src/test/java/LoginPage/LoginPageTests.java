package LoginPage;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTests extends BaseTests {

    @Test
    public void testLogin(){
        var log =homePage.clickLoginPage();
        log.setLoginCredentials(email,password);
        log.signIn();
        String expectedURL ="https://magento.softwaretestingboard.com/";
        String actualURL = log.getURL();
        assertEquals(actualURL,expectedURL);
    }

    @Test
    public void testLogin_invalidCredentials(){
        var log =homePage.clickLoginPage();
        String password = "__P@ssw0rd__";
        log.setLoginCredentials(email,password);
        log.signIn();
        String expectedStatus ="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualStatus = log.getStatus();
        System.out.println(actualStatus);
        assertEquals(expectedStatus,actualStatus,"There is a Problem");
    }


}
