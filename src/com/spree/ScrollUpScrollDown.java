package com.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUpScrollDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://spree-vapasi-prod.herokuapp.com/");
//		Scroll down
		JavascriptExecutor je = (JavascriptExecutor) driver;
		String scrollDown = "window.scrollBy(0,1135)";
		je.executeScript(scrollDown);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
// Scroll up
		String scrollUp = "window.scrollBy(0,-1135)";
		je.executeScript(scrollUp);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
}
