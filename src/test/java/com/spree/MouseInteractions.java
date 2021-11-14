package com.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MouseInteractions {

    public static void main(String args[])
    {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        //Click
        action.click(driver.findElement(By.linkText("Login"))).perform();
        //Sendkeys using Actions class
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement userName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("spree_user_email")));
//        WebElement userName = driver.findElement(By.id("spree_user_email"));
        action.sendKeys(userName,"test@gmail.com").perform();
        action.sendKeys(driver.findElement(By.id("spree_user_password")),"12345678").perform();
        driver.close();

    }

}
