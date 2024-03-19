package test_2_CreateAccountPage;

import base.BaseTests;
import org.testng.annotations.Test;

public class CreateAccountPageTests extends BaseTests {
    @Test
    public void testCreateAccount() {
        var cap = p01HomePage.clickCreateAccountPage();
        cap.setPersonalInformation(firstname, lastname);
        cap.setSignInInformation(email, password, confirm_password);
        cap.create_account();
        cap.verifyPageURL();
    }

    @Test(description = "verify that there is already an account with this email address")
    public void test_There_is_already_an_account_with_this_email_address() {
        var cap = p01HomePage.clickCreateAccountPage();
        cap.setPersonalInformation(firstname, lastname);
        cap.setSignInInformation(email, password, confirm_password);
        cap.create_account();
        /*cap.getResetLink_Password(email);*/
        cap.verifyEmailIsRegisteredBefore();
    }
}
