package test_6_SearchProduct;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchProductTests extends BaseTests {
    @Test(description = "")
    void testSearchProduct() {
        var searchproduct = p01HomePage.clickSearchProduct();
        String product = "shirts";
        searchproduct.enterProductName(product);
        String actualstatus = searchproduct.getStatus();
        assertTrue(actualstatus.contains(product), "test False");
    }
}
