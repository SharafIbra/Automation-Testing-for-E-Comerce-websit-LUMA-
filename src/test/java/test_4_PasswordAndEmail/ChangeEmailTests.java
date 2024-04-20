package test_4_PasswordAndEmail;

import Pages.P01_HomePage;
import Pages.P03_LoginPage;
import Pages.P04_ChangeEmail;
import base.BaseTests;
import org.testng.annotations.Test;

public class ChangeEmailTests extends BaseTests {

    @Test
    void testChangeEmail() {
        new P01_HomePage(driver).clickLoginPage();
        new P03_LoginPage(driver)
                .setLoginCredentials(email, password)
                .signIn();

        new P01_HomePage(driver).clickEditAccountPage().clickChangeEmail();
        
        new P04_ChangeEmail(driver).setChangeEmail(email)
                .setCurrentPassword(password)
                .save()
                .verifyEmailChanged();


    }
}
