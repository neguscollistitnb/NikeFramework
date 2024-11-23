package com.automation.nike.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class SearchProductsPage {
    WebDriver driver;

    public SearchProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchProducts(String products){
        By searchBarBy = By.xpath("//input[@type='search']");
        WebElement searchBar = driver.findElement(searchBarBy);
        searchBar.sendKeys(products);

    }

    public List<String> getSearchResults(){
        List<String> values = new LinkedList<>();

        for (int i = 1; i<=5; i++){
            By searchResultsBy = By.xpath("(//*[@class='details-text'])[" + i +"]");
            WebElement searchResults = driver.findElement(searchResultsBy);
            values.add(searchResults.getText());
        }

        return values;
    }
}
