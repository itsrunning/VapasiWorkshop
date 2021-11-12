package com.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TypesOfWaits {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,2);
        WebElement test = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Login"))));
        test.click();
    }
}
