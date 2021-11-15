package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestWithMultipleBrowser {

    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        String browser = System.getProperty("browser");
        System.out.println("Before Test setting driver for" + browser +" browser");
        switch(browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default: driver = new ChromeDriver();

        }
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
