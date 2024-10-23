package test_5_EditAccountAddresses;

import Pages.P01_HomePage;
import Pages.P03_LoginPage;
import Pages.P04and5_EditAccountInformation___pages;
import Pages.P05_AddAddresses;
import base.BaseTests;
import org.testng.annotations.Test;

public class AddDefaultAddressesTests extends BaseTests {
    @Test(priority = 1)
    void testAddNewAddress_DefaultAddress_E2E() {
        new P01_HomePage(driver)
                .bypassLoginHomepage()
                .clickEditAccountPage();

        new P04and5_EditAccountInformation___pages(driver)
                .store_Cookies_MyAccount_Page()
                .clickAddDefaultAddress();
        new P05_AddAddresses(driver)
                .setContactInformation(firstname, lastname, company, phone_number)
                .setStreetAddress(address1, address2, address3)
                .setCity(city)
                .setCountrydropdown(country)
                .setState(state)
                .setPostalCode(postalcode)
                .saveAddress()
                .verifyAddressAdded();


    }

    @Test(priority = 1)
    void testAddNewAddress_AnotherAddress_BypassLogin() {
        new P01_HomePage(driver)
                .bypassLoginHomepage()
                .clickEditAccountPage();

        new P04and5_EditAccountInformation___pages(driver).clickAddNewAddress();
        new P05_AddAddresses(driver)
                .setContactInformation(firstname, lastname, company, phone_number)
                .setStreetAddress(address1, address2, address3)
                .setCity(city)
                .setCountrydropdown(country)
                .setState(state)
                .setPostalCode(postalcode)
                .saveAddress()
                .verifyAddressAdded();

    }
}
