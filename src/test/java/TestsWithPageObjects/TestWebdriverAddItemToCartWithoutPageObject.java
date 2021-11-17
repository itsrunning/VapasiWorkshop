package TestsWithPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestWebdriverAddItemToCartWithoutPageObject {


    /* TEST 2 (Add Item to Cart)

     * 1. Login with registered user  // Login Page
     * 2. go to hope page and check bags category // Landing page
     * 3. go to "Spree Tote" item // Item Page
     * 4. Add the item to the cart // Cart Page
     */

    WebDriver driver;
    @Test
    public void testItemAddedToCart()
    {
        String browser = System.getProperty("browser");
        System.out.println("Before Test setting up chrome Driver");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30000);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().window().maximize();

        // Register User
        login("test15nov11501@gmail.com","Password1");

        String welcomeMessageAlert = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();
        Assert.assertTrue(welcomeMessageAlert.equals("Logged in successfully"));
        driver.findElement(By.linkText("Bags")).click();
        driver.findElement(By.xpath("//span[@title='Spree Bag']")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("update-cart")));
    }


    public void login(String userEmail, String password)
    {
        driver.findElement((By.linkText("Login"))).click();
        //creating a new account, change email id everytime
        WebElement emailTextBox =  driver.findElement(By.id("spree_user_email"));
        emailTextBox.sendKeys(userEmail);
        WebElement passwordTextBox =  driver.findElement(By.name("spree_user[password]"));
        passwordTextBox.sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }


    @AfterMethod
    public void rampDown()
    {
        driver.close();
    }
}
