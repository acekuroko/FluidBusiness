package org.fluidbusiness.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage{
    private By addToCartButtonLocator = By.xpath("//p[@id='add_to_cart']/button");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
    }

    public AddToCartConfirmationPopup addProductToShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
        WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
        addToCartButton.click();
        return new AddToCartConfirmationPopup(driver);
    }
}
