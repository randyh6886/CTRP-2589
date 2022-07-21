package com.example.PageObjects;

import com.example.Base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class B_TrialsPage extends BaseClass {
    public static WebDriver weBdriver;

    public B_TrialsPage(WebDriver ldriver){
        this.weBdriver=ldriver;
        PageFactory.initElements(ldriver, this);
    }

    public void clickTrialsMenu(){
        WebElement trialsMenu=weBdriver.findElement(By.id("trialSearchMenuOption"));
        trialsMenu.click();
    }

    public void typeActiveInCurrentTrialStatus(){
        WebElement element=weBdriver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(4) .select2-search__field"));
        element.click();
        element.sendKeys("Active");
    }

    public void clickSearch(){
        WebElement element=weBdriver.findElement(By.cssSelector(".search"));
        element.click();
    }

    public void assertStep(){
        String assertText="Search Results!!!!";
        System.out.println(weBdriver.findElement(By.cssSelector("h2")).getText());
        Assert.assertTrue(assertText.equals(weBdriver.findElement(By.cssSelector("h2")).getText()));
    }
}