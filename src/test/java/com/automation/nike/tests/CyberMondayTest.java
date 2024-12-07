package com.automation.nike.tests;

import com.automation.nike.pages.HomePage;
import org.testng.annotations.Test;

public class CyberMondayTest  extends  BaseTest{

    HomePage homePage;

    @Test
    public void cyberMondayProductsTests(){
        homePage = new HomePage(driver);

        homePage.clickOnCyberMonday();
    }


}
