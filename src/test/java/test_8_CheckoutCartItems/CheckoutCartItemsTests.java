package test_8_CheckoutCartItems;

import Pages.P01_HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class CheckoutCartItemsTests extends BaseTests {

    @Test
    void testCheckoutCartItems() {
        var log = new P01_HomePage(driver).clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var aitsc_wn = new P01_HomePage(driver).clickAddItemsToShoppingCart().clickNavigation_Men_Top_Jackets_AddItem();

        aitsc_wn.NavigationBar_addMultiItem_Men_Jackets(MenProduct);
        aitsc_wn.selectQuantity("2");
        aitsc_wn.selectSize(1);
        aitsc_wn.selectColour("Green");
        aitsc_wn.submitProductToCart();

        var checkout = new P01_HomePage(driver).clickCheckoutCartItems();
        checkout.checkOutItemInCart();
        String actualStatus = checkout.getCurrentURL(driver);
        /*String expectedStatus = "Thank you for your purchase!";*/

        assertTrue(actualStatus.contains("success"), "No item is purchased");

    }

}
