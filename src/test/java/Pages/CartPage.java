package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement textSauceLabsBackpack = FindElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]"));
    private final WebElement textSauceLabsFleeceJacket = FindElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'Sauce Labs Fleece Jacket')]"));
    private final WebElement buttonRemoveSauceLabsFleeceJacker = FindElement(By.xpath("(//button[contains(.,'REMOVE')])[2]"));
    private final WebElement buttonCheckout = FindElement(By.xpath("//a[@href='./checkout-step-one.html']"));

    public void assertProducts(){
        String textProduct = textSauceLabsBackpack.getText();
        String textSecondProduct = textSauceLabsFleeceJacket.getText();
        Assert.assertEquals(textProduct,"Sauce Labs Backpack");
        Assert.assertEquals(textSecondProduct,"Sauce Labs Fleece Jacket");
    }

    public void removeLastProductAndClickCheckout(){
        Click(buttonRemoveSauceLabsFleeceJacker);
        Click(buttonCheckout);
    }
}
