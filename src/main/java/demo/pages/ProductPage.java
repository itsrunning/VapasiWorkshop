package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    public void addProductToCart(WebDriver driver){
        driver.findElement(By.id("add-to-cart-button")).click();
    }
}