package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OverviewPage extends BasePage{
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement buttonFinish = FindElement(By.cssSelector(".btn_action"));
    private final WebElement textFinal = FindElement(By.cssSelector(".complete-header"));

    public void ClickFinish(){
        Click(buttonFinish);
    }

    public void AssertFinalText() {
        String finalText = textFinal.getText();
        Assert.assertEquals(finalText, "THANK YOU FOR YOUR ORDER");
    }
}
