package test_4_PasswordAndEmail;

import Pages.P01_HomePage;
import Pages.P03_LoginPage;
import Pages.P04_ChangePassword;
import base.BaseTests;
import org.testng.annotations.Test;

public class ChangePasswordTests extends BaseTests {
    @Test(priority = 4)
    void testChangePassword() {
        new P01_HomePage(driver).clickLoginPage();
        new P03_LoginPage(driver)
                .setLoginCredentials(email, password)
                .signIn();

        new P01_HomePage(driver).clickEditAccountPage().clickChangePassword();
        new P04_ChangePassword(driver).setCurrentPassword(password)
        //will work with the same password for no conflict
                .setNewPassword(password)
                .setConfirmNewPassword(confirm_password)
                .save()
                .verifyPasswordChanged();
    }

}
