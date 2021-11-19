package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(linkText = "Login")
    private WebElement login;

    @FindBy(id = "spree_user_email")
    private WebElement emailTextBox;

    @FindBy(name = "spree_user[password]")
    private WebElement passwordTextBox;

    @FindBy(name = "commit")
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String userEmail, String password)
    {
        login.click();
        emailTextBox.sendKeys(userEmail);
        passwordTextBox.sendKeys(password);
        submit.click();
    }
}
