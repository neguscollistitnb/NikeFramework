package com.automation.nike.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CyberMondayPage {

    WebDriver driver;
    Actions actions;


    public CyberMondayPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

   public void hoverOverCyberMonday(){
        By cyberMondayLinkBy = By.xpath("//a[ text() = 'Cyber Monday' ]");
       WebElement cyberMondayLink = driver.findElement(cyberMondayLinkBy);

       actions.moveToElement(cyberMondayLink).perform();

   }

   public void clickOnCyberMondayLink(){
        By cyberMondayMensLinkBy = By.xpath("//a[ text() = 'Cyber Monday' ]");
        WebElement cyberMondayMensLink = driver.findElement(cyberMondayMensLinkBy);
        cyberMondayMensLink.click();
   }

   public void clickOnProduct(int number){
        By firstProductBy = By.xpath("(//div[@class='product-card__body'])["+ number +"]");
        WebElement firstProduct = driver.findElement(firstProductBy);

        firstProduct.click();
   }

   public String getPromoMessage(){
        By promoMessageBy = By.xpath("//p[@data-testid='promo-message']");
        WebElement promoMessage = driver.findElement(promoMessageBy);

        return promoMessage.getText();
   }

}
