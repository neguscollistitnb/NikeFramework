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
        this.wait = new WebDriverWait(driver, 10);
    }

    public void searchProducts(String products){
        By searchBarBy = By.xpath("//input[@type='search']");
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(searchBarBy));
        searchBar.clear();
        searchBar.sendKeys(products);
        searchBar.sendKeys(Keys.ENTER);

        // Wait for results to load
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='details-text']")));
    }

    public List<String> getSearchResults(){
        List<String> values = new LinkedList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='details-text']"));

        for (WebElement element : elements) {
            String text = element.getText();
            if (text != null && !text.isBlank()) {
                values.add(text);
            }
        }
        return values;
    }
}