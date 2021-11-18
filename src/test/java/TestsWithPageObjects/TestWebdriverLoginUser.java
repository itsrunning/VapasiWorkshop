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


    /* TEST 1 (Login user with registered credentials)

     * 1. Login with registered user
     * 2. Verify landing page after login
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test15nov11501@gmail.com","Password1");
        loginPage.verifyLandingPage();
    }

    @AfterMethod
    public void rampDown()
    {
        driver.close();
    }
}
