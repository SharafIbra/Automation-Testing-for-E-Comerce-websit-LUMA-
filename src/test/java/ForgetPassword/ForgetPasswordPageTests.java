package ForgetPassword;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForgetPasswordPageTests extends BaseTests {



    @Test
    public void testForgetPassword(){
        var forget = homePage.clickForgetPasswordPage();
        forget.enterEmail(email);
        forget.clickResetMyPassword();
        forget.verifyResetPassword();
    }


}
