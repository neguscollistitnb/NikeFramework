package com.automation.nike.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        // increase timeout to 20 seconds for more reliability
        // If your project uses Selenium 3.x keep the old constructor style:
        // this.wait = new WebDriverWait(driver, 20);
        // If using Selenium 4.x you can use Duration.ofSeconds:
        // this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.wait = new WebDriverWait(driver, 20);
    }

    public void clickOnFirstProduct(){
        By firstProductBy = By.xpath("(//a[@data-testid='product-card__img-link-overlay'])[1]");
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(firstProductBy));
       firstProduct.click();

//        // Wait for results to load - wait for visibility of elements with class token 'details-text'
//        By detailsSelector = By.xpath("//div[@class='product_msg_info']");
//
//        // Wait until at least one visible element appears
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(detailsSelector));
    }

    public void clickOnShoeSize(){
        By shoeSizeBy = By.xpath("//label[@for='grid-selector-input-11']");
        WebElement shoeSize = wait.until(ExpectedConditions.elementToBeClickable(shoeSizeBy));
        shoeSize.click();
    }

    public void clickOnAddToBagButton(){
        By addToBagBy = By.xpath("//button[@aria-label='Add to Bag']");
        WebElement addToBag = wait.until(ExpectedConditions.elementToBeClickable(addToBagBy));
        addToBag.click();
    }


}
