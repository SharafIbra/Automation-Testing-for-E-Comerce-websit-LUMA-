package test_7_AddItemsToShoppingCart;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddItemsToShoppingCartOptionsTests extends BaseTests {


    @Test (priority = 2)
    void test_AITSC_from_WhatIsNew() {
        var aitsc = p01HomePage.clickAddItemsToShoppingCart();
        var aitsc_wn = aitsc.clickWhatIsNew_NewInWomen_HoodiesSweatshirts_AddItem();


        aitsc_wn.WhatsNew_addMultiItem_Women_HoodiesSweatshirts(WomenProduct);

        aitsc_wn.selectQuantity("2");
        aitsc_wn.selectSize(1);
        aitsc_wn.selectColour("Green");

        aitsc_wn.submitProductToCart();
        String actualStatus = aitsc_wn.verifyItemAddedToCart();
        String expectedStatus = "You added " + WomenProduct + " to your shopping cart.";

        assertEquals(actualStatus, expectedStatus, "Item not added to shopping cart.");

    }


    @Test (priority = 1)
    void test_AITSC_from_NavigationBar() {
        var aitsc = p01HomePage.clickAddItemsToShoppingCart();
        var aitsc_wn = aitsc.clickNavigation_Men_Top_Jackets_AddItem();

        aitsc_wn.NavigationBar_addMultiItem_Men_Jackets(MenProduct);
        aitsc_wn.selectQuantity("2");
        aitsc_wn.selectSize(1);
        aitsc_wn.selectColour("Green");

        aitsc_wn.submitProductToCart();
        String actualStatus = aitsc_wn.verifyItemAddedToCart();
        String expectedStatus = "You added " + MenProduct + " to your shopping cart.";

        assertEquals(actualStatus, expectedStatus, "Item not added to shopping cart.");

    }


}
