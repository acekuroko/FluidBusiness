package org.fluidbusiness;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fluidbusiness.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartItemTest {

    @Test
    public void AddToCartTest(){

        // Inicializamos el driver
        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        browser
                .manage()
                .window()
                .maximize();

        // Vamos al website
        browser.get("http://automationpractice.com/");


        // navigate to login page
        HomePage homePage = new HomePage(browser);
        homePage.clickSignInButton();

        // log in
        LoginPage loginPage = new LoginPage(browser);
        loginPage.setEmailAddress("petejenkins@test.com");
        loginPage.setPassword("Password1234");
        loginPage.clickSignInButton();

        // navigate back to home page
        UserAccountPage userAccountPage = new UserAccountPage(browser);
        userAccountPage.navigateToHomePage();

        // select the first product
        List<WebElement> productNameLinks = homePage.getProductNameLinks();
        productNameLinks.get(0).click();

        // add 1 item to the shopping cart
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(browser);
        productDetailsPage.clickAddToCartButton();

        // proceed to checkout
        AddToCartConfirmationPopup confirmPopup = new AddToCartConfirmationPopup(browser);
        confirmPopup.clickProceedToCheckoutButton();

        // verify we have 1 item in the shopping cart
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(browser);
        int numProducts = shoppingCartSummaryPage.getQuantity();
        assertEquals(numProducts, 1, "Expected number of products in shopping cart was 1 but actual value was: " + Integer.toString(numProducts));

        browser.close();

    }
}
