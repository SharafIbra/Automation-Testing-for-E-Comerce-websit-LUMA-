package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddItemsToShoppingCart_WhatIsNew extends basePage{
    public AddItemsToShoppingCart_WhatIsNew(WebDriver driver) {this.driver=driver;}

    private By hoodiessweatshirts_women___whatsnew = new By.ByXPath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[1]/a");
    private By hoodiessweatshirts_men = new By.ByXPath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[2]/li[1]/a");

    private By hoodiessweatshirts_women___womenpage = new By.ByXPath("//*[@id=\"maincontent\"]/div[4]/div[2]/div[2]/div/ul[1]/li[1]/a");

    public AddMultiItem_from_WomenStore clickAddMultiItem__HoodiesSweatShirts_Women_whatisnew(){
        click(hoodiessweatshirts_women___whatsnew);
        return new AddMultiItem_from_WomenStore(driver);
    }

    public AddMultiItem_from_WomenStore clickAddMultiItem__HoodiesSweatShirts_Women_store(){
        click(hoodiessweatshirts_women___womenpage);
        return new AddMultiItem_from_WomenStore(driver);
    }




    public void addMultiItem_from_NewInMEN(){
        click(hoodiessweatshirts_men);
   }



}
