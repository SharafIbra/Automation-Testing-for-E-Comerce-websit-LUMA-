package AddItemsToShoppingCart;

import Pages.AddMultiItem_from_WomenStore;
import base.BaseTests;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;

public class AddItemsToShoppingCartTests extends BaseTests {


    @Test
    void test_AITSC_from_WhatIsNew(){
        var aitsc = homePage.clickAddItemsToShoppingCart();
        var aitsc_wn = aitsc.clickAddItemsToShoppingCart_WhatIsNew();

        var addMIFWS =aitsc_wn.clickAddMultiItem__HoodiesSweatShirts_Women_whatisnew();

        addMIFWS.addMultiItem_Women_HoodiesSweatshirts(2);
        addMIFWS.selectQuantity("2");
        addMIFWS.selectSize(1);
        addMIFWS.selectColour("Blue");

        String productname = addMIFWS.submitProductToCart();
        String actualStatus = addMIFWS.verifyItemAddedToCart();
        String expectedStatus = "You added "+productname+" to your shopping cart.";

        assertEquals(actualStatus,expectedStatus,"Item not added to shopping cart.");



    }





}
