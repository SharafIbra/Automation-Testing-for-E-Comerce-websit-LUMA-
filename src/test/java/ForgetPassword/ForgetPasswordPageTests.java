package ForgetPassword;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForgetPasswordPageTests extends BaseTests {



    @Test
    public void testForgetPassword(){
        var forget = homePage.clickForgetPasswordPage();
        forget.enterEmail(email);
        forget.clickResetMyPassword();
        forget.getStatus();
        String expectedStatus ="If there is an account associated with "+email+" you will receive an email with a link to reset your password.";
        String actualStatus = forget.getStatus();
        System.out.println(actualStatus);
        assertEquals(expectedStatus,actualStatus,"There is a Problem");
    }


}
