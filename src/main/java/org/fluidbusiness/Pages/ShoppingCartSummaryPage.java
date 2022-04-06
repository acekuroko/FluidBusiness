package org.fluidbusiness.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartSummaryPage extends BasePage{

    private By productQuantityLocator = By.id("summary_products_quantity");

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityLocator));
    }

    public int getQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityLocator));
        String numProductsLabelText = driver.findElement(productQuantityLocator).getText();
        int spaceLocation = numProductsLabelText.indexOf(" ");
        int numProducts = Integer.parseInt(numProductsLabelText.substring(0, spaceLocation));
        return numProducts;
    }
}
