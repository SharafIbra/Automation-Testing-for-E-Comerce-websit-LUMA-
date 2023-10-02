package CheckoutCartItems;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class CheckoutCartItemsTests extends BaseTests {

    @Test
    void testCheckoutCartItems() {
        var log = homePage.clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var aitsc = homePage.clickAddItemsToShoppingCart();
        var aitsc_wn = aitsc.clickAddItemsToShoppingCart_NavigationBar();

        aitsc_wn.addMultiItem_Men_Jackets(MenProduct);
        aitsc_wn.selectQuantity("2");
        aitsc_wn.selectSize(1);
        aitsc_wn.selectColour("Green");
        aitsc_wn.submitProductToCart();

        var checkout = homePage.clickCheckoutCartItems();
        checkout.checkoutItemInCart();
        String actualStatus = checkout.getCurrentURL();
        /*String expectedStatus = "Thank you for your purchase!";*/

        assertTrue(actualStatus.contains("success"), "No item is purchased");

    }

}
