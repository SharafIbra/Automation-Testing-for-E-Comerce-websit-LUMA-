package test_4_PasswordAndEmail;

import Pages.P01_HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

public class ChangeEmailTests extends BaseTests {

    @Test
    void testChangeEmail() {
        var log = new P01_HomePage(driver).clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var change = new P01_HomePage(driver).clickEditAccountPage().clickChangeEmail();
        
        change.setChangeEmail(email);
        change.setCurrentPassword(password);
        change.save();
        change.verifyEmailChanged();


    }
}
