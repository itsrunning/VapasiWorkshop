package WebdriverWithoutPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestWebdriverWithUserJourney {

    /*TEST 1
     * 1. Launch Spree website
     * 2. click on login
     * 3. create new account for 3 different users
     * 4. Verify the email address on account page
     * */

    /* TEST 2

     * 1. Login with registered user
     * 2. go to hope page and check bags category
     * 3. go to "Spree Tote" item
     * 4. Add the item to the cart
     */

    WebDriver driver;
    @Test(dataProvider="testdata")
    public void testLoginWithdifferentUsers(String userEmail,String password)
    {

        String browser = System.getProperty("browser");
        System.out.println("Before Test setting up chrome Driver");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().window().maximize();

        // Register User
        registerUser(userEmail,password);

        String welcomeMessageAlert = driver.findElement(By.cssSelector("div.alert.alert-notice")).getText();
        Assert.assertTrue(welcomeMessageAlert.equals("Welcome! You have signed up successfully."));

        driver.findElement(By.linkText("My Account")).click();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"user-info\"]/dd[1]")).getText());

    }


    public void registerUser(String userEmail, String password)
    {
        driver.findElement((By.linkText("Login"))).click();
        WebElement createAccount = driver.findElement(By.partialLinkText("Create"));
        createAccount.click();
        //creating a new account, change email id everytime
        WebElement emailTextBox =  driver.findElement(By.id("spree_user_email"));
        emailTextBox.sendKeys(userEmail);
        WebElement passwordTextBox =  driver.findElement(By.name("spree_user[password]"));
        passwordTextBox.sendKeys(password);
        WebElement passwordConfirmationTextBox = driver.findElement(By.id("spree_user_password_confirmation"));
        passwordConfirmationTextBox.sendKeys(password);
        WebElement createAccountButton = driver.findElement(By.cssSelector("input[value='Create']"));
        //submit will work on any form element (within <form>)
        createAccountButton.submit();
    }


    @AfterMethod
    public void rampDown()
    {
        driver.close();
    }


    @DataProvider(name="testdata")
    public Object[][] TestDataFeed(){

        Object [][] loginUserInfo=new Object[3][2];

        loginUserInfo[0][0]="test15nov11501@gmail.com";
        loginUserInfo[0][1]="Password1";

        loginUserInfo[1][0]="test15nov11502@gmail.com";
        loginUserInfo[1][1]="Password2";


        loginUserInfo[2][0]="test15nov11443@gmail.com";
        loginUserInfo[2][1]="Password3";
        return loginUserInfo;
    }


}
