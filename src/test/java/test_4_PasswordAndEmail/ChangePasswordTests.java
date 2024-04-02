package test_4_PasswordAndEmail;

import Pages.P01_HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

public class ChangePasswordTests extends BaseTests {
    @Test(priority = 4)
    void testChangePassword() {
        var log = new P01_HomePage(driver).clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var change = new P01_HomePage(driver).clickEditAccountPage().clickChangePassword();
        change.setCurrentPassword(password);
        //will work with the same password for no conflict
        change.setNewPassword(password);
        change.setConfirmNewPassword(confirm_password);
        change.save();
        change.verifyPasswordChanged();
    }


    @Test(priority = 3)
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
