package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement inputName = FindElement(By.id("first-name"));
    private final WebElement inputLastName = FindElement(By.id("last-name"));
    private final WebElement inputZipCode = FindElement(By.id("postal-code"));
    private final WebElement buttonContinue = FindElement(By.cssSelector(".btn_primary"));
    private final WebElement errorZipCode = FindElement(By.xpath("//h3[.='Error: Postal Code is required']"));

    public void inputTextWithoutZipCode(String name, String lastName) throws InterruptedException {
        Type(inputName, name);
        Type(inputLastName, lastName);
        ExplicitTime(3);
        Click(buttonContinue);
    }

    public void assertError() {
        String textError = errorZipCode.getText();
        Assert.assertEquals(textError,"Error: Postal Code is required");
    }

    public void inputZipCode() throws InterruptedException {
        Type(inputZipCode, "60010");
        ExplicitTime(3);
        Click(buttonContinue);
    }
}
