package com.automation.nike.tests;

import com.automation.nike.pages.SearchProductsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProductsTest extends BaseTest {

    private SearchProductsPage searchProductsPage;

    @DataProvider(name = "productSearches", parallel = false)
    public Object[][] productSearches() {
        return new Object[][]{
                // existing entries...
                {"Jordan", new String[]{"jordan"}, false},
                {"Air Max", new String[]{"air max", "air", "max"}, false},
                {"Dunk", new String[]{"dunk"}, false},
                {"Air Force", new String[]{"air force", "force"}, false},
                {"Nike Jacket", new String[]{"nike jacket", "jacket", "top", "nike"}, false},
                {"Backpack", new String[]{"backpack"}, false},
                {"Cleats", new String[]{"cleats"}, false},
                {"Blazer", new String[]{"blazer"}, false},
                {"Bags", new String[]{"bags", "backpack", "bag"}, false},
                {"Converse", new String[]{"converse", "chuck taylor", "converse chuck"}, false},
                {"Air Jordan 1", new String[]{"air jordan 1", "jordan 1"}, false},
                {"Towels", new String[]{"towel", "towels"}, false},
                {"Socks", new String[]{"socks", "sock"}, false},
                {"Hoodies", new String[]{"hoodie", "hoodies", "fleece", "jacket"}, false},
                {"Leggings", new String[]{"leggings", "flared", "paneled"}, false},
                {"Women Shorts", new String[]{"women's", "shorts"}, true},
                {"Men Shorts", new String[]{"men's", "shorts"}, true},
                {"Men T-Shirts", new String[]{"men's", "t-shirts", "vest", "sweater"}, false},
                {"Zoom", new String[]{"nike", "zoom"}, false},
                {"Nike Air Max 90", new String[]{"air", "max", "90", "air max"}, false},
                {"Hats", new String[]{"hat", "hats", "caps", "beanie"}, false},
                {"Running Shoes", new String[]{"running", "run", "shoe", "shoes"}, false},
                {"Slides", new String[]{"slide", "slides"}, false},
                {"React", new String[]{"react"}, false},
                {"Metcon", new String[]{"metcon"}, false},
                {"Golf Shoes", new String[]{"golf", "golf shoe", "golf shoes"}, false},
                {"Sandals", new String[]{"sandal", "sandals"}, false},
                {"Sports Bra", new String[]{"sports bra", "bra"}, false},
                {"Yoga Pants", new String[]{"yoga", "pants", "leggings"}, false},
                {"Kids Shoes", new String[]{"kids", "children", "grade school"}, false},

                // 10 new product searches added:
                {"Basketball Shoes", new String[]{"basketball", "basketball shoe", "basketball shoes"}, false},
                {"Trail Running Shoes", new String[]{"trail", "trail running", "trail shoe", "trail shoes"}, false},
                {"Windbreaker", new String[]{"windbreaker", "wind breaker", "shell"}, false},
                {"Base Layer", new String[]{"base layer", "thermal", "compression"}, false},
                {"Cross Trainers", new String[]{"cross trainer", "cross trainers", "training shoe"}, false},
                {"Compression Shorts", new String[]{"compression shorts", "compression"}, false},
                {"Swimwear", new String[]{"swimwear", "swim", "swimsuit", "swim shorts"}, false},
                {"Skate Shoes", new String[]{"skate", "skate shoe", "skate shoes"}, false},
                {"Workout Tops", new String[]{"workout top", "workout tops", "training top", "tank"}, false},
                {"Compression Tights", new String[]{"compression tights", "tights", "compression"}, false}
        };
    }

    @Test(dataProvider = "productSearches")
    public void searchProductsDataDrivenTest(String query, String[] expectedKeywords, boolean requireAll) throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);

        // perform the search:
        searchProductsPage.searchProducts(query);

        // preserve the same waiting style as other tests (your page object does not currently wait)
        Thread.sleep(5000);

        List<String> results = searchProductsPage.getSearchResults();

        // Fail fast if no results were returned
        Assert.assertFalse(results.isEmpty(), "Search for '" + query + "' returned no results.");

        // Validate each result text against expected keywords
        int idx = 1;
        for (String resultText : results) {
            String lower = (resultText == null) ? "" : resultText.toLowerCase();
            boolean matched;

            if (requireAll) {
                // every keyword must be present in the result
                matched = true;
                for (String kw : expectedKeywords) {
                    if (!lower.contains(kw.toLowerCase())) {
                        matched = false;
                        break;
                    }
                }
            } else {
                // at least one keyword must be present
                matched = false;
                for (String kw : expectedKeywords) {
                    if (lower.contains(kw.toLowerCase())) {
                        matched = true;
                        break;
                    }
                }
            }

            Assert.assertTrue(matched,
                    "Product #" + idx + " for query '" + query + "' did not match expected keywords. Result: '" + resultText + "'");
            idx++;
        }
    }
}