package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement buttonAddSuaceLabsBackpack = FindElement(By.xpath("(//button[contains(.,'ADD TO CART')])[1]"));
    private final WebElement buttonAddSauceLabsFleeceJacket = FindElement(By.xpath("(//button[contains(.,'ADD TO CART')])[4]"));
    private final WebElement buttonCart = FindElement(By.id("shopping_cart_container"));

    public void addProductToCart() throws InterruptedException {
        ExplicitTime();
        Click(buttonAddSuaceLabsBackpack);
        Click(buttonAddSauceLabsFleeceJacket);
    }

    public void clickCart(){
        Click(buttonCart);
    }
}
