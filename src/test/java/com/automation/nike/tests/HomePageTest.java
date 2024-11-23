package com.automation.nike.tests;

import com.automation.nike.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    HomePage homePage;

    @Test
    public void jordanHeaderTest(){
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.headersJordan(), "No Jordan");
    }
}
