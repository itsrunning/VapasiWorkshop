package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {
    public void selectCategory(WebDriver driver){
        driver.findElement(By.linkText("Bags")).click();
    }

    public void selectProduct(WebDriver driver){
        driver.findElement(By.xpath("//span[@title='Spree Bag']")).click();
    }
}
