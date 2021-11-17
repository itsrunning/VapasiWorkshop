package TestsWithPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestWebdriverLoginUser {


    /* TEST 2 (Add Item to Cart)

     * 1. Login with registered user  // Login Page
     * 2. go to hope page and check bags category // Landing page
     * 3. go to "Spree Tote" item // Item Page
     * 4. Add the item to the cart // Cart Page
     */

    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        String browser = System.getProperty("browser");
        System.out.println("Before Test setting up chrome Driver");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginToApplication()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver, "test15nov11501@gmail.com","Password1");
        loginPage.verifyLandingPage(driver);
    }

    @AfterMethod
    public void rampDown()
    {
        driver.close();
    }
}
