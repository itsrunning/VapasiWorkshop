package com.spree;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindingElements {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
//		WebDriver driver = new ChromeDriver();
		driver.get("https://spree-vapasi-prod.herokuapp.com/");
		List<WebElement> productsInFirstPage = driver.findElements(By.cssSelector("div[id='products']>div"));
		int noOfProductsInFirstPage=productsInFirstPage.size();
		System.out.println("No of products in the first page : "+noOfProductsInFirstPage);
		
//		ClassWork:
//		Find the number of titles and Print the all of the titles
		List<WebElement> producttitlesInFirstPage = driver.findElements(By.cssSelector("div[id='products'] span[class='info mt-3 d-block']"));
		int noOfProducttitlesInFirstPage=producttitlesInFirstPage.size();
		for (int i=0;i<noOfProducttitlesInFirstPage;i++)
		{
		WebElement title=producttitlesInFirstPage.get(i);
		String productTitle=title.getText();
		System.out.println(productTitle);
		}
		
//		isDisplayed
		int displayCount=0;
    	int notDisplayCount=0;
    	List<WebElement> links = driver.findElements(By.tagName("a"));
    	int noOfLinks = links.size();
    	for (int i=0;i<noOfLinks;i++)
    	{
    	WebElement link=links.get(i);
    	if (link.isDisplayed()){
    	displayCount++;
    	}else{
    	notDisplayCount++;
    	}
    	}
    	System.out.println("Display Count : " + displayCount);
    	System.out.println("Not Display Count : " + notDisplayCount);
    	driver.close();
	}
}
