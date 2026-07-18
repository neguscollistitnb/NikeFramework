package com.automation.nike.tests;

import com.automation.nike.pages.CyberMondayPage;
import com.automation.nike.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    HomePage homePage;

    @Test
    public void jordanHeaderTest() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.headersJordan(), "No Jordan header displayed");
    }

    @Test
    public void jordanHeaderClickableTest() throws InterruptedException {
        homePage = new HomePage(driver);

        // Ensure the element is present before clicking (keeps style similar to other tests)
        Assert.assertTrue(homePage.headersJordan(), "Jordan header should be present and visible");

        // Click the Jordan header and assert we navigated away or page changed
        driver.findElement(org.openqa.selenium.By.xpath("//a[@aria-label='Jordan']")).click();

        // give the page a moment to load / navigate
        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl().toLowerCase();
        String pageTitle = driver.getTitle().toLowerCase();

        // Accept either the URL or the title mentioning 'jordan' as a sign of correct navigation
        Assert.assertTrue(currentUrl.contains("jordan") || pageTitle.contains("jordan"),
                "Clicking Jordan header did not navigate to a Jordan page. URL: " + currentUrl + " Title: " + pageTitle);
    }

    @Test
    public void cyberMondayNavigationTest() throws InterruptedException {
        homePage = new HomePage(driver);

        // Click Cyber Monday link from the homepage
        homePage.clickOnCyberMonday();

        // Allow navigation to occur
        Thread.sleep(3000);

        // Use the page object for CyberMondayPage to assert page content
        CyberMondayPage cyberPage = new CyberMondayPage(driver);
        String promo = cyberPage.getPromoMessage(); // may throw if element not found; that's OK - test will fail clearly

        // Basic sanity check: promo message should be non-empty and likely mention "Cyber" or "Promo" (case-insensitive)
        Assert.assertNotNull(promo, "Promo message returned null");
        Assert.assertFalse(promo.trim().isEmpty(), "Promo message is empty");
        Assert.assertTrue(promo.toLowerCase().contains("cyber") || promo.toLowerCase().contains("promo") || promo.length() > 5,
                "Promo message doesn't look correct: '" + promo + "'");
    }

    @Test
    public void findAStoreNavigationTest() throws InterruptedException {
        homePage = new HomePage(driver);

        // Click Find a Store link
        homePage.clickOnFindAStoreLink();

        // Wait a bit for navigation or modal to appear
        Thread.sleep(3000);

        // Heuristic checks: URL changed or page contains "store" or "find a store"
        String url = driver.getCurrentUrl().toLowerCase();
        String pageSource = driver.getPageSource().toLowerCase();

        boolean urlHasStore = url.contains("store") || url.contains("find-a-store");
        boolean bodyHasStore = pageSource.contains("find a store") || pageSource.contains("store locator") || pageSource.contains("stores");

        Assert.assertTrue(urlHasStore || bodyHasStore,
                "Clicking Find a Store did not navigate to an expected store page. URL: " + url);
    }

    @Test
    public void multipleHeadersPresenceTest() {
        homePage = new HomePage(driver);

        // Check Jordan header exists (method already provided)
        Assert.assertTrue(homePage.headersJordan(), "Jordan header missing");

        // Check the presence of other common header links by aria-label — adjust labels if your site differs
        Assert.assertTrue(driver.findElement(org.openqa.selenium.By.xpath("//a[@aria-label='Find a Store']")).isDisplayed(),
                "Find a Store header missing");

        // Example of checking header 'New & Featured' — adjust the xpath/label if your site uses different text
        boolean hasNewAndFeatured = !driver.findElements(org.openqa.selenium.By.xpath("//a[contains(text(),'New & Featured') or @aria-label='New & Featured']")).isEmpty();
        Assert.assertTrue(hasNewAndFeatured, "New & Featured header not found (adjust locator if site changed)");
    }
}