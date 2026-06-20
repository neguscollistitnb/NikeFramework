package com.automation.nike.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class SearchProductsPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchProductsPage(WebDriver driver){
        this.driver = driver;
        // increase timeout to 20 seconds for more reliability
        // If your project uses Selenium 3.x keep the old constructor style:
        // this.wait = new WebDriverWait(driver, 20);
        // If using Selenium 4.x you can use Duration.ofSeconds:
        // this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.wait = new WebDriverWait(driver, 20);
    }

    public void searchProducts(String products){
        By searchBarBy = By.xpath("//input[@type='search']");
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(searchBarBy));
        searchBar.clear();
        searchBar.sendKeys(products);
        searchBar.sendKeys(Keys.ENTER);

        // Wait for results to load - wait for visibility of elements with class token 'details-text'
        By detailsSelector = By.xpath("//div[@class='product_msg_info']");

        // Wait until at least one visible element appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(detailsSelector));
    }

    public List<String> getSearchResults(){
        List<String> values = new LinkedList<>();
        // Use the same safer locator
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='product_msg_info']"));

        for (WebElement element : elements) {
            String text = element.getText();
            if (text != null && !text.isBlank()) {
                values.add(text);
            }
        }
        return values;
    }
}