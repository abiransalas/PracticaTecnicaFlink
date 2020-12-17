package Configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver Browser(String browser, String url){
        try{
            WebDriver driver;
            switch(browser){
                case "Edge":
                    driver = EdgeDriver();
                    break;
                case "Chrome":
                    driver = ChromeDriver();
                    break;
                case "Firefox":
                    driver = FirefoxDriver();
                    break;
                default:
                    return null;
            }
            driver.get(url);
            return driver;
        }catch (Exception ex){
            return null;
        }
    }

    private static WebDriver EdgeDriver(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver ChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        return new ChromeDriver(options);
    }

    private static WebDriver FirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
