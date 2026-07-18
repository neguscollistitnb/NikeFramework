package com.automation.nike.tests;

import com.automation.nike.pages.BackToSchoolPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BackToSchoolTest extends BaseTest{

BackToSchoolPage  backToSchoolPage;

@Test
    public void backToSchoolTest() throws InterruptedException {
    backToSchoolPage = new BackToSchoolPage(driver);

    backToSchoolPage.clickOnBackToSchoolLink();
    backToSchoolPage.clickOnFirstDayFootwearLink();

    String excepted = "Back to School Shoes";
    String actual = backToSchoolPage.getHeaderText();
    Assert.assertEquals(actual, excepted, "Header text does not match expected value.");

    }

}
