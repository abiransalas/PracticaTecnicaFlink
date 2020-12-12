package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement inputUserName = FindElement(By.id("user-name"));
    private final WebElement inputPassword = FindElement(By.id("password"));
    private final WebElement buttonLogin = FindElement(By.id("login-button"));

    public void logIn(String user, String password){
        Type(inputUserName, user);
        Type(inputPassword, password);
        Click(buttonLogin);
    }

}
