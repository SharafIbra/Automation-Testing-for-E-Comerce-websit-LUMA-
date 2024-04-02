package test_5_EditAccountAddresses;

import Pages.P01_HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

public class AddNewTests extends BaseTests {

    @Test(priority = 2)
    void testAddNewAddress_IfCountryUSA() {
        var log = new P01_HomePage(driver).clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var edit = new P01_HomePage(driver).clickEditAccountPage();

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
