package TestsWithPageObjects;

import demo.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestWebdriverAddItemToCart {


    /* TEST 2 (Add Item to Cart)

     * 1. Login with registered user
     * 2. go to hope page and check bags category
     * 3. go to "Spree Tote" item
     * 4. Add the item to the cart
     */

    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        String browser = System.getProperty("browser");
        System.out.println("Before Test setting up chrome Driver");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void testItemAddedToCart()
    {
        demo.pages.LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        demo.pages.CategoryPage categoryPage = new CategoryPage();
        ProductPage productPage = new ProductPage();
        demo.pages.CartPage cartPage = new CartPage();

        loginPage.login(driver, "test15nov11501@gmail.com","Password1");
        homePage.verifyLandingPage(driver);
        categoryPage.selectCategory(driver);
        categoryPage.selectProduct(driver);
        productPage.addProductToCart(driver);
        cartPage.validateCartPage(driver);
    }


    @AfterMethod
    public void rampDown()
    {
        driver.close();
    }
}
