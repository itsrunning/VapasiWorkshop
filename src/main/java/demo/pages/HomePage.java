package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    public void verifyLandingPage(WebDriver driver){
        String welcomeMessageAlert = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();
        Assert.assertEquals(welcomeMessageAlert, "Logged in successfully");
    }

}
