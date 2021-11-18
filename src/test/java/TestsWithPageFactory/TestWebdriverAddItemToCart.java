package TestsWithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CategoryPage;
import pages.LoginPage;

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
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("test15nov11501@gmail.com","Password1");
        loginPage.verifyLandingPage();
        categoryPage.selectCategory();
        categoryPage.selectProduct();
        cartPage.addProductToCart();
        cartPage.validateCartPage();
    }


    @AfterMethod
    public void rampDown()
    {
        driver.close();
    }
}
