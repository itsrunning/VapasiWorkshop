package WebdriverWithoutPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebdriverTestsWithTestNG {

    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        System.out.println("Before Test setting up chrome Driver");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testWebsiteTitle()
    {
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle,"Spree Demo Site");

    }


    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}