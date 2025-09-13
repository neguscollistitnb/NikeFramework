package com.automation.nike.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public boolean headersJordan(){
        By jordanHeaderBy = By.xpath("//a[@aria-label='Jordan']");
        WebElement jordanHeader = driver.findElement(jordanHeaderBy);
        return jordanHeader.isDisplayed();
    }

    public void clickOnCyberMonday(){
        By cyberMondayLinkBy = By.xpath("//a[text()='Cyber Monday']");
        WebElement cyberMondayLink = driver.findElement(cyberMondayLinkBy);
        cyberMondayLink.click();
    }

    public void clickOnFindAStoreLink(){
        By findAStoreLinkBy = By.xpath("//a[@aria-label='Find a Store']");
        WebElement findAStoreLink = driver.findElement(findAStoreLinkBy);
        findAStoreLink.click();
    }

}
