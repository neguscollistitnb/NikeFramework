package com.automation.nike.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackToSchoolPage {

    WebDriver driver;
    WebDriverWait wait;

    public BackToSchoolPage(WebDriver driver) {
        this.driver = driver;
        // Selenium 3.x compatible: WebDriverWait with timeout in seconds
        this.wait = new WebDriverWait(driver, 20);
    }

     public void clickOnBackToSchoolLink(){
         By backToSchoolLinkBy = By.xpath("//a[@class='menu-hover-trigger-link' and text()='Back to School']");
         driver.findElement(backToSchoolLinkBy).click();
         // Wait for the submenu to appear
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='First-Day Footwear']")));
     }

     public void clickOnFirstDayFootwearLink(){
         By firstDayFootwearLinkBy = By.xpath("//a[@aria-label='First-Day Footwear']");
         // Wait for the element to be clickable before finding and clicking
         wait.until(ExpectedConditions.elementToBeClickable(firstDayFootwearLinkBy));
         driver.findElement(firstDayFootwearLinkBy).click();
         // Wait for the page to load after navigation
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Back to School') or @id='Back-to-School-Shoes']")));
     }

     public String getHeaderText(){
         // Using a more flexible XPath that searches for h1 containing "Back to School" text
         By getHeaderTextBy = By.xpath("//h1[contains(text(), 'Back to School Shoes') or @id='Back-to-School-Shoes']");
         WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getHeaderTextBy));
         return headerElement.getText();
     }





    }
