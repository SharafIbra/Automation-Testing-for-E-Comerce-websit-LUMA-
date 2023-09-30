package AddItemsToShoppingCart;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddItemsToShoppingCartTests extends BaseTests {


    @Test
    void test_AITSC_from_WhatIsNew() {
        var aitsc = homePage.clickAddItemsToShoppingCart();
        var aitsc_wn = aitsc.clickAddMultiItem_from_WomenStore_WhatIsNew();


        aitsc_wn.addMultiItem_Women_HoodiesSweatshirts(WomenProduct);
        aitsc_wn.selectQuantity("2");
        aitsc_wn.selectSize(1);
        aitsc_wn.selectColour("Green");

        String productname = aitsc_wn.submitProductToCart();
        String actualStatus = aitsc_wn.verifyItemAddedToCart();
        String expectedStatus = "You added " + productname + " to your shopping cart.";

        assertEquals(actualStatus, expectedStatus, "Item not added to shopping cart.");

    }


    @Test
    void test_AITSC_from_NavigationBar() {
        var aitsc = homePage.clickAddItemsToShoppingCart();
        var aitsc_wn = aitsc.clickAddItemsToShoppingCart_NavigationBar();

        aitsc_wn.addMultiItem_Men_Jackets(MenProduct);
        aitsc_wn.selectQuantity("2");
        aitsc_wn.selectSize(1);
        aitsc_wn.selectColour("Green");

        String productname = aitsc_wn.submitProductToCart();
        String actualStatus = aitsc_wn.verifyItemAddedToCart();
        String expectedStatus = "You added " + productname + " to your shopping cart.";

        assertEquals(actualStatus, expectedStatus, "Item not added to shopping cart.");

    }


}
