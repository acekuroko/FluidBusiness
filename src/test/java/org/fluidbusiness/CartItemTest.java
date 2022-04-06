package org.fluidbusiness;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fluidbusiness.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartItemTest {

    @Test
    public void AddToCartTest(){

        // Fluid syntax - dot notation
        // Business Methods

        // Inicializamos el driver
        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        // Vamos al website
        browser.get("http://automationpractice.com/");

        // navigate to login page
        HomePage homePage = HomePage.getInstanceOfHomePage(browser);
        homePage.navigateToLoginPage()
                .login("petejenkins@test.com", "Password1234")
                .navigateBackToHomePage()
                .selectFirstProduct()
                .addProductToShoppingCart()
                .proceedToCheckout();

        // verify we have 1 item in the shopping cart
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(browser);
        int numProducts = shoppingCartSummaryPage.getQuantity();
        assertEquals(numProducts, 1, "Expected number of products in shopping cart was 1 but actual value was: " + Integer.toString(numProducts));

        browser.close();

    }
}
