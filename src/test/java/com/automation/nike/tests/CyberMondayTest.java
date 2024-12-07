package com.automation.nike.tests;

import com.automation.nike.pages.CyberMondayPage;
import com.automation.nike.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CyberMondayTest  extends  BaseTest{

    HomePage homePage;
    CyberMondayPage cyberMondayPage;

    @Test
    public void cyberMondayMensProductsTests() throws InterruptedException {
        cyberMondayPage = new CyberMondayPage(driver);

        cyberMondayPage.clickOnCyberMondayLink();

        Thread.sleep(5000);
        cyberMondayPage.clickOnProduct(20); // Only put in 1 - 24

        if (cyberMondayPage.getPromoMessage().contains("30%")){
            Assert.assertEquals(cyberMondayPage.getPromoMessage(), "Use code CYBER for an extra 30% off." ,
                    "Cyber Monday promo message is not correct");
        }else {
            Assert.assertEquals(cyberMondayPage.getPromoMessage(), "See Price in Bag" ,
                    "Cyber Monday promo message is not correct");
        }

    }


}
