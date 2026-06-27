package com.automation.nike.tests;

import com.automation.nike.pages.ProductsPage;
import com.automation.nike.pages.SearchProductsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddToChartTests extends  BaseTest{
    private SearchProductsPage searchProductsPage;
    private ProductsPage productsPage;

    @Test
    public void addJordan4ToChartTest(){
        searchProductsPage = new SearchProductsPage(driver);
        productsPage = new ProductsPage(driver);

        //Step One
        searchProductsPage.searchProducts("Jordan 4");
        //Step Two
        productsPage.clickOnFirstProduct();
        //Choose shoe size
        productsPage.clickOnShoeSize();
        //Add To Bag
        productsPage.clickOnAddToBagButton();

    }



}
