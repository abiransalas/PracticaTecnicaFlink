package Configurations;

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
        System.setProperty("webdriver.edge.driver", "Resources/Drivers/msedgedriver.exe");
        return new EdgeDriver();
    }

    private static WebDriver ChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        System.setProperty("webdriver.chrome.driver", "src/test/java/Resources/Drivers/chromedriver.exe");
        return new ChromeDriver(options);
    }

    private static WebDriver FirefoxDriver(){
        System.setProperty("webdriver.firefox.driver", "Resources/Drivers/geckodriver.exe");
        return new FirefoxDriver();
    }
}
