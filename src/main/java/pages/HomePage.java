package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    @FindBy(css = "div.alert.alert-success")
    private WebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void verifyLandingPage(){
        Assert.assertEquals(welcomeMessage.getText(), "Logged in successfully");
    }
}
