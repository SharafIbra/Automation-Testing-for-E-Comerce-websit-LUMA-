package HomePage;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HomePageTests extends BaseTests {



    @Test
    void testCreateAcount(){
        homePage.clickCreateAcountPage();

    }
    @Test
    void testSignIn(){
        homePage.clickLoginPage();
    }
}
