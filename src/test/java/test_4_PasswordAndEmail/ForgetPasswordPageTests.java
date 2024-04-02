package test_4_PasswordAndEmail;

import Pages.P01_HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

public class ForgetPasswordPageTests extends BaseTests {


    @Test
    public void testForgetPassword() {
        var forget = new P01_HomePage(driver).clickForgetPasswordPage();
        forget.enterEmail(email);
        forget.clickResetMyPassword();
        forget.verifyForgetPassword();
    }


}
