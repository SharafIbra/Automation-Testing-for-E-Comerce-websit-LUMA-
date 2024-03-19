package test_4_ForgetPassword;

import base.BaseTests;
import org.testng.annotations.Test;

public class P05ForgetPasswordPageTests extends BaseTests {


    @Test
    public void testForgetPassword() {
        var forget = p01HomePage.clickForgetPasswordPage();
        forget.enterEmail(email);
        forget.clickResetMyPassword();
        forget.verifyResetPassword();
    }


}
