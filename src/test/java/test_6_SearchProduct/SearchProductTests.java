package test_6_SearchProduct;

import Pages.P01_HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchProductTests extends BaseTests {
    @Test(description = "")
    void testSearchProduct() {
        var searchproduct = new P01_HomePage(driver).clickSearchProduct();
        String product = "shirts";
        searchproduct.enterProductName(product);
        String actualstatus = searchproduct.getStatus();
        assertTrue(actualstatus.contains(product), "test False");
    }
}
