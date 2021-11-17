package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    public void login(WebDriver driver, String userEmail, String password)
    {
        driver.findElement((By.linkText("Login"))).click();
        //creating a new account, change email id everytime
        WebElement emailTextBox =  driver.findElement(By.id("spree_user_email"));
        emailTextBox.sendKeys(userEmail);
        WebElement passwordTextBox =  driver.findElement(By.name("spree_user[password]"));
        passwordTextBox.sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

    public void verifyLandingPage(WebDriver driver){
        String welcomeMessageAlert = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();
        Assert.assertEquals(welcomeMessageAlert, "Logged in successfully");
    }

}
