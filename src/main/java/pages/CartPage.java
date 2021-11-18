package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    @FindBy(id = "update-cart")
    private WebElement cartPage;

    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,30000);
    }

    public void addProductToCart(){
        addToCart.click();
    }

    public void validateCartPage() {
        wait.until(ExpectedConditions.visibilityOf(cartPage));
    }
}
