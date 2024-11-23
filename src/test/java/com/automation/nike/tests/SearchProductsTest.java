package com.automation.nike.tests;

import com.automation.nike.pages.SearchProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductsTest extends BaseTest{

    SearchProductsPage searchProductsPage;

    @Test
    public void SearchProductsJordanTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Jordan");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue(results.contains("Jordan") , "Product: " + product + " does not contain Jordan");
            product++;
        }

    }

    @Test
    public void SearchProductsAirMaxTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Air Max");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Air Max") || results.contains("Air") || results.contains("Max")) , "Product: " + product + " does not contain Air Max");
            product++;
        }

    }

    @Test
    public void SearchProductsDunksTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Dunk");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue(results.contains("Dunk") , "Product: " + product + " does not contain Dunk");
            product++;
        }

    }

    @Test
    public void SearchProductsAirForceTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Air Force");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Air Force") || results.contains("Force")) , "Product: " + product + " does not contain Air Force");
            product++;
        }

    }

    @Test
    public void SearchProductsNikeJacketTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Nike Jacket");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Nike Jacket") || results.contains("Jacket") || results.contains("Top") || results.contains("Nike")) , "Product: " + product + " does not contain Nike Jacket");
            product++;
        }

    }

    @Test
    public void SearchProductsBackpackTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Backpack");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue(results.contains("Backpack") , "Product: " + product + " does not contain Backpack");
            product++;
        }

    }

    @Test
    public void SearchProductsCleatsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Cleats");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue(results.contains("Cleats") , "Product: " + product + " does not contain Backpack");
            product++;
        }

    }



}
