package com.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindingElement {
    public static void main(String args[]){
        System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        //have less timeout , use explicit wait
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();
        //breakout room activity
        WebElement createAccount = driver.findElement(By.partialLinkText("Create"));
        createAccount.click();
        //creating a new account, change email id everytime
        WebElement emailTextBox =  driver.findElement(By.id("spree_user_email"));
        emailTextBox.sendKeys("te@gm.com");
        WebElement passwordTextBox =  driver.findElement(By.name("spree_user[password]"));
        passwordTextBox.sendKeys("Welcome");
        WebElement passwordConfirmationTextBox = driver.findElement(By.id("spree_user_password_confirmation"));
        passwordConfirmationTextBox.sendKeys("Welcome");
        WebElement createAccountButton = driver.findElement(By.cssSelector("input[value='Create']"));
        //submit will work on any form element (within <form>)
        createAccountButton.submit();
        String welcomeMessageAlert = driver.findElement(By.cssSelector("div.alert.alert-notice")).getText();
        if (welcomeMessageAlert.equals("Welcome! You have signed up successfully.")){
            System.out.println("Your account has been created");
        }
        //emailTextBox.clear();
        driver.close();
        //driver.quit();
    }
}
