package test_2_CreateAccountPage;

import Pages.P01_HomePage;
import Pages.P02_createAccountPage;
import base.BaseTests;
import org.testng.annotations.Test;

public class CreateAccountPageTests extends BaseTests {
    @Test
    public void testCreateAccount() {
        new P01_HomePage(driver).clickCreateAccountPage();
        new P02_createAccountPage(driver).setPersonalInformation(firstname, lastname)
                .setSignInInformation(email, password, confirm_password)
                .create_account()
                .verifyPageURL();
    }

    @Test(description = "verify that there is already an account with this email address")
    public void test_There_is_already_an_account_with_this_email_address() {
        new P01_HomePage(driver).clickCreateAccountPage();
        new P02_createAccountPage(driver).setPersonalInformation(firstname, lastname)
                .setSignInInformation(email, password, confirm_password)
                .create_account()
                .verifyEmailIsRegisteredBefore();
    }
}
