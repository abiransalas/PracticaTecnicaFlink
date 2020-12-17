package Steps;

import Configurations.WebDriverFactory;
import Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class PruebaTecnicaSteps {
    private WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;

    @Given("the user login in (.*) with the (.*) and (.*) on (.*)")
    public void userLoginInPageWithTheUserAndPassword(String page, String user, String password, String navigator){
        driver = WebDriverFactory.Browser(navigator, page);
        loginPage = new LoginPage(driver);
        loginPage.logIn(user, password);
    }

    @When("the user add product to cart Suace Labs Backpack y Sauce Labs Fleece Jacket")
    public void userAddProductToCart() throws InterruptedException {
        inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart();
    }

    @And("go to cart")
    public void ClickToCart(){
        inventoryPage = new InventoryPage(driver);
        inventoryPage.clickCart();
    }

    @And("validate the products")
    public void ValidateProducts(){
        cartPage = new CartPage(driver);
        cartPage.assertProducts();
    }

    @And("remove the last product and click on the button checkout")
    public void RemoveProductAndClickCheckout(){
        cartPage = new CartPage(driver);
        cartPage.removeLastProductAndClickCheckout();
    }

    @Then("the user types (.*) and (.*) and clicks continue")
    public void UserTypesNameAndLastnameAndClicksContinue(String name, String lastname) throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputTextWithoutZipCode(name, lastname);
    }

    @And("assert the error message")
    public void AssertErrorMessage() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.assertError();
    }

    @And("types postal code and click continue")
    public void TypePostalCodeAndClickContinue() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputZipCode();
    }

    @And("the user clicks finish")
    public void UserClicksFinish(){
        overviewPage = new OverviewPage(driver);
        overviewPage.ClickFinish();
    }

    @And("assert the message")
    public void AssertMessage() {
        overviewPage = new OverviewPage(driver);
        overviewPage.AssertFinalText();
        driver.quit();
    }

}