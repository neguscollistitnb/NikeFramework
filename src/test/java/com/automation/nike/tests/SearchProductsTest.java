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
    public void SearchProductsNikeZoom () throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Zoom");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue((results.contains("Nike") || results.contains("Zoom")),
                    "Product: " + product + " does not contain Hats");
            product++;
        }


    }

    @Test
    public void SearchProductsNikeAirMax90Test() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Nike Air Max 90");

        // keep same wait style as other tests in this file
        Thread.sleep(5000);

        int product = 1;
        for (String results : searchProductsPage.getSearchResults()) {
            String lower = results.toLowerCase();
            // Accept results that reference Air, Max, the model number 90, or the combined phrase
            Assert.assertTrue(
                    lower.contains("air") || lower.contains("max") || lower.contains("90") || lower.contains("air max"),
                    "Product: " + product + " does not look related to 'Nike Air Max 90' -> '" + results + "'"
            );
            product++;
        }
    }
    @Test
    public void SearchProductsHatsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Hats");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue((lower.contains("hat") || lower.contains("hats") || lower.contains("caps") || lower.contains("beanie")),
                    "Product: " + product + " does not contain Hats");
            product++;
        }
    }
    @Test
    public void SearchProductsRunningShoeTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Running Shoes");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue((lower.contains("running") || lower.contains("run") || lower.contains("shoe") || lower.contains("shoes")),
                    "Product: " + product + " does not contain Running Shoes");
            product++;
        }
    }

    @Test
    public void SearchProductsSlidesTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Slides");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue((lower.contains("slide") || lower.contains("slides")),
                    "Product: " + product + " does not contain Slides");
            product++;
        }
    }

    @Test
    public void SearchProductsReactTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("React");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue(lower.contains("react"),
                    "Product: " + product + " does not contain React");
            product++;
        }
    }

    @Test
    public void SearchProductsMetconTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Metcon");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue(lower.contains("metcon"),
                    "Product: " + product + " does not contain Metcon");
            product++;
        }
    }

    @Test
    public void SearchProductsGolfShoesTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Golf Shoes");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue((lower.contains("golf") || lower.contains("golf shoe") || lower.contains("golf shoes")),
                    "Product: " + product + " does not contain Golf Shoes");
            product++;
        }
    }

    @Test
    public void SearchProductsSandalsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Sandals");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue((lower.contains("sandal") || lower.contains("sandals")),
                    "Product: " + product + " does not contain Sandals");
            product++;
        }
    }

    @Test
    public void SearchProductsSportsBraTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Sports Bra");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue((lower.contains("sports bra") || lower.contains("bra")),
                    "Product: " + product + " does not contain Sports Bra");
            product++;
        }
    }

    @Test
    public void SearchProductsYogaPantsTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Yoga Pants");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue((lower.contains("yoga") || lower.contains("pants") || lower.contains("leggings")),
                    "Product: " + product + " does not contain Yoga Pants");
            product++;
        }
    }

    @Test
    public void SearchProductsKidsShoesTest() throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts("Kids Shoes");

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            String lower = results.toLowerCase();
            Assert.assertTrue((lower.contains("kids") || lower.contains("children") || lower.contains("grade school")),
                    "Product: " + product + " does not contain Kids Shoes");
            product++;
        }
    }








}


