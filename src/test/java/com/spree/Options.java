package com.spree;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Options {

    public static void main(String[] args){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        options.addArguments("incognito");

        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.close();
    }
}
