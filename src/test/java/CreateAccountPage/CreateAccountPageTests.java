package CreateAccountPage;

import base.BaseTests;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAccountPageTests extends BaseTests {









    @Test
    public void testCreateAccount(){
        var cap = homePage.clickCreateAcountPage();
        cap.setPersonalInformation(firstname,lastname);
        cap.setSignInInformation(email,password,confirm_password);
        cap.create_account();
        String expectedPageSource ="https://magento.softwaretestingboard.com/customer/account/";
        String actualPageSource = cap.getCurrentURL();
        assertEquals(actualPageSource,expectedPageSource,"account not created");

    }

    @Test
    public void test_There_is_already_an_account_with_this_email_address() {
        var cap = homePage.clickCreateAcountPage();
        cap.setPersonalInformation(firstname,lastname);
        cap.setSignInInformation(email,password,confirm_password);
        cap.create_account();
        String expectedStatus ="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        String actualStatus = cap.getStatus();
        System.out.println(actualStatus);
        assertEquals(actualStatus,expectedStatus,"account not created");
    }
}
