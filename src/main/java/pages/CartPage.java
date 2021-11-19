package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    public void validateCartPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,30000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("update-cart")));
    }
}
