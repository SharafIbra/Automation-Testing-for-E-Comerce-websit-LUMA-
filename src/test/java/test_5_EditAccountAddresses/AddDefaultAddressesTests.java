package test_5_EditAccountAddresses;

import Pages.P01_HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

public class AddDefaultAddressesTests extends BaseTests {
    @Test(priority = 1)
    void testAddNewAddress_DefaultAddress() {
        var log = new P01_HomePage(driver).clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var edit = new P01_HomePage(driver).clickEditAccountPage();

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
}
