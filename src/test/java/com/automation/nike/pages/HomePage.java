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
}
