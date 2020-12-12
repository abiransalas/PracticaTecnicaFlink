package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement FindElement(By locator, int time ){
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return driver.findElement(locator);
        }
        catch (Exception ex){
            //System.out.println("No se encontró el WebElement");
            //System.out.println(ex.getMessage());
            return null;
        }
    }

    public WebElement FindElement(By locator){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return driver.findElement(locator);
        }
        catch (Exception ex){
            //System.out.println("No se encontró el WebElement");
            //System.out.println(ex.getMessage());
            return null;
        }
    }

    public void Type(WebElement element, String text){
        try{
            //element.clear();
            element.sendKeys(text);
        }
        catch (Exception ex){
            System.out.println("No se relizó la captura del texto " + text);
            System.out.println(ex.getMessage());
        }
    }

    public void Click(WebElement element){
        try{
            element.click();
        }
        catch (Exception ex){
            System.out.println("No se relizó el clic en el elemento");
            System.out.println(ex.getMessage());
        }
    }

    public void SelectOption(WebElement element, String option){
        try{
            Select select = new Select(element);
            select.deselectByVisibleText(option);
        }
        catch (Exception ex){
            System.out.print("No se seleccionó la opción " + option);
            System.out.print(ex.getMessage());
        }
    }

    public void ExplicitTime() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    public void ExplicitTime(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
    }
}
