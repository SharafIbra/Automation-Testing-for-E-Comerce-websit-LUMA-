package test_4_PasswordAndEmail;

import Pages.P01_HomePage;
import Pages.P04_ResetPassword;
import base.BaseTests;
import org.testng.annotations.Test;

public class ForgetPasswordPageTests extends BaseTests {


    @Test
    public void testForgetPassword() {
        new P01_HomePage(driver).clickForgetPasswordPage();
        new P04_ResetPassword(driver).enterEmail(email)
                .clickResetMyPassword()
                .verifyForgetPassword();
    }


}
