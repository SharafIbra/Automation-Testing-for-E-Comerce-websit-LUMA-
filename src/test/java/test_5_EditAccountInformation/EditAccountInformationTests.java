package test_5_EditAccountInformation;

import base.BaseTests;
import org.testng.annotations.Test;

public class EditAccountInformationTests extends BaseTests {


    @Test(priority = 4)
    void testChangePassword() {
        var log = p01HomePage.clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var edit = p01HomePage.clickEditAccountPage();
        var change = edit.clickChangePassword();
        change.setCurrentPassword(password);
        //will work with the same password for no conflict
        change.setNewPassword(password);
        change.setConfirmNewPassword(confirm_password);
        change.save();
        change.verifyPasswordChanged();
    }


    @Test(priority = 3)
    void testChangeEmail() {
        var log = p01HomePage.clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var edit = p01HomePage.clickEditAccountPage();

        var change = edit.clickChangeEmail();
        change.setChangeEmail(email);
        change.setCurrentPassword(password);
        change.save();
        change.verifyEmailChanged();


    }

    @Test(priority = 1)
    void testAddNewAddress_DefaultAddress_FirstTime() {
        var log = p01HomePage.clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var edit = p01HomePage.clickEditAccountPage();

        var Daddress = edit.clickAddDefaultAddresses();
        Daddress.setContactInformation(firstname, lastname, company, phone_number);
        Daddress.setStreetAddress(address1, address2, address3);
        Daddress.setCity(city);
        Daddress.setCountrydropdown(country);
        Daddress.setState(state);
        Daddress.setPostalCode(postalcode);
        Daddress.saveAddress();
        Daddress.verifyAddressAdded();

    }


    @Test(priority = 2)
    void testAddNewAddress_IfCountryUSA() {
        var log = p01HomePage.clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var edit = p01HomePage.clickEditAccountPage();

        var Naddress = edit.clickAddNewAddresses();
        Naddress.setContactInformation(firstname, lastname, company, phone_number);
        Naddress.setStreetAddress(address1, address2, address3);
        Naddress.setCity(city);
        Naddress.setCountrydropdown("United States");
        Naddress.setState_DROPDOWN("Alaska");
        Naddress.setPostalCode(postalcode);
        Naddress.saveAddress();
        Naddress.verifyAddressAdded();

    }


}
