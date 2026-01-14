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
//Jamie
    @Test
    public void SearchProductsAirMaxTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Air Max");

        Thread.sleep(5000);//

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Air Max") || results.contains("Air") || results.contains("Max")) , "Product: " + product + " does not contain Air Max");
            product++;
        }

    } // DanagiwESFDSFEASZDSDF

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
//Juanita
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
            Assert.assertTrue(results.contains("Cleats") , "Product: " + product + " does not contain Cleats");
            product++;
        }

    }

    @Test
    public void SearchProductsBlazerTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Blazer");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue(results.contains("Blazer") , "Product: " + product + " does not contain Blazer");
            product++;
        }

    }

    @Test
    public void SearchProductsBagsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Bags");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Bags") || results.contains("Backpack") || results.contains("Bag")),
                    "Product: " + product + " does not contain Bags");
            product++;
        }

    }

    @Test
    public void SearchProductsConverseTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Converse");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Converse") || results.contains("Chuck Taylor") || results.contains("Converse Chuck")),
                    "Product: " + product + " does not contain Converse");
            product++;//
        }

    }


    @Test
    public void SearchProductsAirJordan1Test() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Air Jordan 1");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Air Jordan 1") ||results.contains("Jordan 1") ), "Product: " + product + " does not contain Air Jordan 1");
            product++;
        }

    }

    @Test
    public void SearchProductsTowelsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Towels");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Towels") ||results.contains("Towel") ), "Product: " + product + " does not contain Towels");
            product++;
        }

    }

    @Test
    public void SearchProductsSocksTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Socks");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Socks") ||results.contains("Sock") ), "Product: " + product + " does not contain Socks");
            product++;
        }

    }

    @Test
    public void SearchProductsHoodiesTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Hoodies");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Hoodie") || results.contains("Fleece") || results.contains("Jacket")  ),
                    "Product: " + product + " does not contain Hoodie");
            product++;
        }

    }

    @Test
    public void SearchProductsLeggingsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Leggings");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Leggings") || results.contains("Flared") || results.contains("Paneled")  ),
                    "Product: " + product + " does not contain Leggings");
            product++;
        }

    }

    @Test
    public void SearchProductsWomenShortsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Women Shorts");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Women's") && results.contains("Shorts")),
                    "Product: " + product + " does not contain WomenShorts");
            product++;
        }

    }

    @Test
    public void SearchProductsMenShortsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Men Shorts");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Men's") && results.contains("Shorts")),
                    "Product: " + product + " does not contain MenShorts");
            product++;
        }

    }

    @Test
    public void SearchProductsMensShirtsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Men T-Shirts");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Men's") || results.contains("T-Shirts") || results.contains("Vest") || results.contains("Sweater")),
                    "Product: " + product + " does not contain Men's T-Shirts");
            product++;
        }

    }

    @Test
    public void SearchProductsTowelsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Towels");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Towels") || results.contains("Towel")) , "Product: " + product + " does not contain Towels");
            product++;
        }

    }



}


