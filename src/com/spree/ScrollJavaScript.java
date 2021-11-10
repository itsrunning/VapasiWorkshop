package com.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollJavaScript {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://spree-vapasi-prod.herokuapp.com/");
//		Scroll into view
		JavascriptExecutor je = (JavascriptExecutor) driver;
		String jsCode = "arguments[0].scrollIntoView(true)";
		String locator = "li[class='last next page-item']";
		je.executeScript(jsCode,driver.findElement(By.cssSelector(locator)));
		driver.close();
	}

}
